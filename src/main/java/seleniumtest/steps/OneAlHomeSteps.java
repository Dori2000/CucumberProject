package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.page.OneAlHomePage;
import seleniumtest.utils.DriverUtils;

import java.net.MalformedURLException;

public class OneAlHomeSteps {

    private static OneAlHomePage oneAlHomePage;
    private static final WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 10
    );

    public OneAlHomeSteps() {

        oneAlHomePage = new OneAlHomePage();
    }

    @Given("^one al home page is opened$")
    public void openMainPage() throws MalformedURLException {
        DriverUtils.navigate("https://www.one.al/");
    }

    @Then("^click on '(.+?)' button$")
    public void clickButton(String btnName) {
        switch (btnName) {
            case "Llogaria ime":
                wait.until(ExpectedConditions.elementToBeClickable(OneAlHomePage.llogariaImeButton));
                OneAlHomePage.llogariaImeButton.click();
                break;
            case "Hyr":
                wait.until(ExpectedConditions.elementToBeClickable(OneAlHomePage.hyrButton));
                OneAlHomePage.hyrButton.click();
                break;
            case "Kerko Ndihme":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Widget_Icon')]")));
                OneAlHomePage.kerkoNdihmeButton.click();
                break;
            case "Prano":
                wait.until(ExpectedConditions.elementToBeClickable(OneAlHomePage.pranoButton));
                OneAlHomePage.pranoButton.click();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }
    }

    @And("^type '(.+?)' on '(.+?)' pop-up input text form$")
    public void typeOnInputField(String value, String inputField) {
        WebElement el = null;

        switch (inputField) {
            case "E-Mail":
                el = OneAlHomePage.emailInputField;
                break;
            case "Password":
                el = OneAlHomePage.passwordInputField;
                break;
            default:
                throw new NotFoundException("Input field not found!");
        }

        wait.until(ExpectedConditions.visibilityOf(el));
        el.clear();
        el.sendKeys(value);
    }

    @And("^check the following error message is shown$")
    public void checkErrorMsg(DataTable dataTable) {
        By errorMessageBy = By.cssSelector("#form-login > fieldset > div.control-group.error > div > span");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessageBy));

        Assert.assertEquals(dataTable.raw().get(0).get(0), DriverUtils.getDriver().findElement(errorMessageBy).getText());
    }

    @And("^check the following terms & conditions info is shown$")
    public void checkTerms(DataTable dataTable) {
        By termsBy = By.cssSelector("#adv > div > p");
        wait.until(ExpectedConditions.presenceOfElementLocated(termsBy));

        Assert.assertEquals(dataTable.raw().get(0).get(0), DriverUtils.getDriver().findElement(termsBy).getText());
    }

    @And("^check error message under input number field$")
    public void checkError(DataTable dataTable) {
        By errorMessageBy = By.cssSelector("#be-messenger > span > div > div.Window_Body__2VgEC > form > div.StartSession_Main__odfZK > div > div > div:nth-child(1) > div > div > div.Input_Error__dVPQ1 > span");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessageBy));

        Assert.assertEquals(dataTable.raw().get(0).get(0), DriverUtils.getDriver().findElement(errorMessageBy).getText());
    }

    @And("^check terms & conditions info is not shown anymore$")
    public void checkTermsInfoIsNotShownAnymore() {
        By termsBy = By.cssSelector("#adv > div > p");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(termsBy));
        Assert.assertFalse(DriverUtils.getDriver().findElement(termsBy).isDisplayed());
    }
}
