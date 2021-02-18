package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.page.HomePage;
import seleniumtest.utils.DriverUtils;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

public class HomePageSteps {

    private static HomePage homePage;
    private static final WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 4);

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Given("^the main page is opened$")
    public void openMainPage() throws MalformedURLException {
        DriverUtils.navigate("https://www.seleniumeasy.com/test/");
    }


    @Then("^make sure ad pop-up is closed$")
    public void closePopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOf(homePage.popUp));
            homePage.closePopUp.click();
        } catch (TimeoutException ex) {
            System.out.println("Pop up is not shown!");
        }
    }

    @And("^check the following categories are shown under menu list$")
    public void checkMenuListElements(DataTable dataTable) {
        wait.until(ExpectedConditions.visibilityOf(homePage.menuList));

        List<String> expectedList = dataTable.asList(String.class);
        List<String> actualList = DriverUtils.getDriver().findElements(By.cssSelector("li[style='display: list-item;']")).stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertEquals(expectedList, actualList);

    }

    @Then("^click on '(.+?)' list sub-element$")
    public void clickMenuListItems(String menuListItem) {
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].scrollIntoView(true);", homePage.menuList);
        wait.until(ExpectedConditions.visibilityOf(homePage.menuList));
        DriverUtils.getDriver().findElement(By.id("treemenu")).findElement(By.linkText(menuListItem)).click();
    }

    @And("^check the following sub categories are shown under '(.+?)'$")
    public void checkSubItems(String menuListItem, DataTable dataTable) {
        By subItemsBy = By.xpath("//ul[@id='treemenu']//li[@class='tree-branch']/a[contains(text(), '" + menuListItem + "')]/../ul/li");
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].scrollIntoView(true);", homePage.menuList);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(homePage.menuList));

        List<String> expectedList = dataTable.asList(String.class);
        List<String> actualList = DriverUtils.getDriver().findElements(subItemsBy).stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertEquals(expectedList, actualList);
    }

    @And("^click on '(.+?)' sub-item of '(.+?)' item$")
    public void clickOnSimpleFormDemoSubItemOfInputFormsItem(String subItem, String menuListItem) {
        By subItemsBy = By.xpath("//ul[@id='treemenu']//li[@class='tree-branch']/a[contains(text(), '" + menuListItem + "')]/../ul/li/a[contains(text(), '" + subItem + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(subItemsBy));
        DriverUtils.getDriver().findElement(subItemsBy).click();
    }

    @Then("^type '(.+?)' on '(.+?)' input text form$")
    public void typeOnEnterAInputTextForm(String value, String inputField) {
        WebElement el = null;

        switch (inputField) {
            case "Enter a":
                el = homePage.enterAInputField;
                break;
            case "Enter b":
                el = homePage.enterBInputField;
                break;
            case "Enter message":
                el = homePage.enterMessageInputField;
                break;
            default:
                throw new NotFoundException("Input field not found!");
        }

        el.clear();
        el.sendKeys(value);
    }

    @And("^click the '(.+?)' button$")
    public void clickButton(String btnName) {
        By buttonBy = By.xpath("//button[contains(text() , '" + btnName + "')]  | //input[@class='btn btn-primary']");
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].scrollIntoView(true);", DriverUtils.getDriver().findElement(buttonBy));

        wait.until(ExpectedConditions.elementToBeClickable(buttonBy));
        DriverUtils.getDriver().findElement(buttonBy).click();
    }

    @And("^check the following result is shown under '(.+?)' panel$")
    public void checkMessage(String panelName, DataTable dataTable) {
        By resultBy = By.xpath("//div[@class = 'panel-heading' and contains(text(),'" + panelName + "')]/../div/div");

        if (panelName.equals("Radio Button Demo")) {
            resultBy = By.cssSelector("p.radiobutton");
        } else if (panelName.equals("Java Script Alert Box")) {
            resultBy = By.cssSelector("#prompt-demo");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(resultBy));
        WebElement actualResult = DriverUtils.getDriver().findElement(resultBy);

        Assert.assertEquals(dataTable.raw().get(0).get(0), actualResult.getText());
    }

    @Then("^make sure all options are '(.+?)'$")
    public void checkOptionStatus(String status) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div > label > input")));
        List<WebElement> list = DriverUtils.getDriver().findElements(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div > label > input"));

        if (status.equals("checked")) {
            list.forEach(el -> Assert.assertTrue(el.isSelected()));
        } else list.forEach(el -> Assert.assertFalse(el.isSelected()));
    }

    @And("^click the '(.+?)' radio button$")
    public void clickTheMaleRadioButton(String radioBtn) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='radio']")));
        if (radioBtn.equals("Male")) {
            DriverUtils.getDriver().findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > label:nth-child(2) > input[type=radio]")).click();
        } else throw new NotFoundException("Not found!");

    }

    @Then("^check alert has the following text$")
    public void checkAlertHasTheFollowingText(DataTable dataTable) {
        Assert.assertEquals(dataTable.raw().get(0).get(0), DriverUtils.getDriver().switchTo().alert().getText());
    }

    @Then("^'(.+?)' the alert$")
    public void acceptTheAlert(String action) {
        if (action.equals("accept")) {
            DriverUtils.getDriver().switchTo().alert().accept();
        } else DriverUtils.getDriver().switchTo().alert().dismiss();
    }

    @Then("^enter '(.+?)' on alter input field$")
    public void typeOnAlert(String text) {
        DriverUtils.getDriver().switchTo().alert().sendKeys(text);
    }
}
