package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.Helper.Help;
import seleniumtest.pages.*;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class NopCommerceDashboardSteps {
    private static Help helper;
    private static theMain mainPage;
    private static ShoppingCartPage sp;
    private static MyAccPage ac;
    private static LoginPage login;
    private static RegisterPage reg;
    private static NotebookPage notebookPage;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);

    public NopCommerceDashboardSteps() {
        mainPage = new theMain();
        reg = new RegisterPage();
        login = new LoginPage();
        ac = new MyAccPage();
        notebookPage = new NotebookPage();
        helper = new Help();
        sp = new ShoppingCartPage();
    }


    @And("^we hover over '(.+?)' menu on NopCommerce Main page$")
    public void mouseHover(String buttonName) {
        wait.until(ExpectedConditions.visibilityOf(mainPage.computeHoverBtn));
        Actions action = new Actions(DriverUtils.getDriver());
        if (buttonName.equals("Computers"))
            action.moveToElement(mainPage.computeHoverBtn).perform();
        else if (buttonName.equals("Shopping Cart")){
            WebElement buttonShoppingCart = DriverUtils.getDriver().findElement(sp.shoppinCartButton);
            action.moveToElement(buttonShoppingCart).perform();
        }

    }

    @And("^choose '(.+?)' on Display dropdown$")
    public void chooseOnDisplayDropdown(String alternative) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(notebookPage.display));
        helper.selectDropdown(notebookPage.display, alternative);

    }

    @Then("^verify that only '(\\d+)' items are displayed$")
    public void verifyThatOnlyItemsAreDisplayed(int number)  {
        wait.until(ExpectedConditions.numberOfElementsToBe(notebookPage.displayedElements,number));

//        List<WebElement> elements = DriverUtils.getDriver().findElements(notebookPage.displayedElements);
//        //wait.until(ExpectedConditions.visibilityOfAllElements(elements));
//        int totalLinkSize = elements.size();
//        Assert.assertEquals(totalLinkSize, number);

    }

    @And("^we check '(.+?)' on filter by attributes$")
    public void weCheckGBOnFilterByAttributes(String checkBoxAlternative) {
        WebElement element = DriverUtils.getDriver().findElement(notebookPage.attributes_check_16GB);
        wait.until(ExpectedConditions.visibilityOfElementLocated(notebookPage.attributes_check_16GB));
        Actions actions = new Actions(DriverUtils.getDriver());
        if (checkBoxAlternative.equals("16GB")){
            actions.moveToElement(element);
            actions.click();
            actions.build().perform();
        }
    }

    @And("^we uncheck '(.+?)' on filter by attributes$")
    public void weUncheckGBOnFilterByAttributes(String checkBoxAlternative) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(notebookPage.attributes_check_16GB));
        helper.deSelect(notebookPage.attributes_check_16GB);
    }

    @And("^we click '(.+?)' button from Notebook$")
    public void weClickAddToWishListButtonFromNotebookInWishlisht(String buttonName)  {
//        JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
//        js.executeScript("window.scrollBy(10,360)", "");

        notebookPage.clickNotebookPageButtons(buttonName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(notebookPage.content));
        helper.elementNotVisible(notebookPage.content);
    }

    @And("^verify that '(.+?)' on Menu bar displays '(.+?)'$")
    public void verifyThatWishlistOnMenuBarDisplays(String iconName, String displayedNumber) {


        String actualText ;
        String expectedText;
        switch (iconName) {
            case "Wishlist":
                WebElement element1 = DriverUtils.getDriver().findElement(notebookPage.wishListLable);
                 actualText = element1.getText();
                 expectedText = actualText.replaceAll("[^0-9]", "");
                break;
            case "Shopping Cart":
                WebElement element2 = DriverUtils.getDriver().findElement(notebookPage.cartLable);
                actualText = element2.getText();
                expectedText = actualText.replaceAll("[^0-9]", "");
                break;

            default:
                throw new NotFoundException("Button not found!");
        }

        Assert.assertEquals(expectedText,displayedNumber);

    }

    @Then("^we verify the notification is displayed$")
    public void weVerifyTheNotificationIsDisplayed(DataTable dataTable) {
        wait.until(ExpectedConditions.presenceOfElementLocated(notebookPage.content));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notebookPage.content));
        helper.elementIsDisplayed(notebookPage.content, dataTable.raw().get(0).get(0));
    }

    @And("^wait for notification to be invisible$")
    public void waitForNotificationToBeInvisible() {
        WebElement element = DriverUtils.getDriver().findElement(notebookPage.content);
        wait.until(ExpectedConditions.visibilityOfElementLocated(notebookPage.content));
        //wait.until(ExpectedConditions.stalenessOf(element));
        helper.elementNotVisible(notebookPage.content);
    }
}
