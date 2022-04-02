package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.pages.LoginPage;
import seleniumtest.pages.MyAccPage;
import seleniumtest.pages.RegisterPage;
import seleniumtest.pages.theMain;
import seleniumtest.utils.WebDriverFactory;

public class NopCommerceUserRegistrationSteps {

    private static theMain mainPage;
    private static MyAccPage ac;
    private static LoginPage login;
    private static RegisterPage reg;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);
    public NopCommerceUserRegistrationSteps() {
        mainPage = new theMain();
        reg = new RegisterPage();
        login = new LoginPage();
        ac = new MyAccPage();
    }


    @Given("^the given page with '(.+?)' is opened$")
    public void theGivenPageIsOpened(String url) {
        WebDriverFactory.getInstance().getDriver().navigate().to(url);
    }

    @And("^we choose '(.+?)' gender from radio button on NopCommerce Login page$")
    public void weChooseMaleGenderFromRadioButtonOnNopCommerceLoginPage(String gender) {
        if (gender.equals("male")) reg.male.click();
        else if (gender.equals("female")) reg.female.click();
    }

    @And("^we enter '(.+?)' in the '(.+?)' input field NopCommerce Login page$")
    public void enterTextInTheInputFieldNopCommerceLoginPage(String text, String field) {
        By inputXpath = By.xpath("//div[@class='inputs']//label[text()='" + field + "']/../input");
        wait.until(ExpectedConditions.presenceOfElementLocated(inputXpath));
        WebDriverFactory.getInstance().getDriver().findElement(inputXpath).sendKeys(text);
    }

    @And("^we select '(.+?)' in the '(.+?)' dropdown in NopCommerce Login page$")
    public void selectDropdownInNopCommerceLoginPage(String text, String dropDown) {
        //WebElement element = DriverUtils.getDriver().findElement(By.name("DateOfBirth'"+dropDown+"'"));

        switch (dropDown) {
            case "Day of Birth":
                wait.until(ExpectedConditions.visibilityOf(reg.dayBirth));
                Select selectDay = new Select(reg.dayBirth);
                selectDay.selectByVisibleText(text);
                break;
            case "Month of Birth":
                wait.until(ExpectedConditions.visibilityOf(reg.monthBirth));
                Select selectMonth = new Select(reg.monthBirth);
                selectMonth.selectByVisibleText(text);
                break;
            case "Year of Birth":
                wait.until(ExpectedConditions.visibilityOf(reg.yearBirth));
                Select selectYear = new Select(reg.yearBirth);
                selectYear.selectByVisibleText(text);
                break;

            default:
                throw new NotFoundException("Element not found!");
        }

//        wait.until(ExpectedConditions.visibilityOf(element));
//        Select select = new Select(element);
//        select.selectByVisibleText(text);

    }

    @Then("^check if the login was successful$")
    public void checkIfTheLoginWasSuccessful(DataTable dataTable) {
        By result = By.xpath("//*[text()='" + dataTable.raw().get(0).get(0) + "']");
        wait.until(ExpectedConditions.textToBe(result, dataTable.raw().get(0).get(0)));

//        String actualText = mainPage.tittle.getText();
//        Assert.assertEquals(dataTable.raw().get(0).get(0),actualText);
    }

    @And("^we enter '(.+?)' in the Company input field NopCommerce Login page$")
    public void setCompanyName(String company) {
        wait.until(ExpectedConditions.visibilityOf(reg.company));
        reg.company.sendKeys(company);
    }

    @And("^we click '(.+?)' button from NopCommerce Login page$")
    public void weClickUserRegistrationButtonFromNopCommerceLoginPage(String buttonName) {
        mainPage.clickMainPageButtons(buttonName);
    }

    @And("^we click '(.+?)' button from NopCommerce Main page$")
    public void weClickLogInButtonFromNopCommerceMainPage(String buttonName) {
        mainPage.clickMainPageButtons(buttonName);
    }




}
