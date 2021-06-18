package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.page.NopHomePage;
import seleniumtest.utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

public class NopHomePageSteps {
    private static NopHomePage nopHomePage;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);

    public NopHomePageSteps() {
        nopHomePage = new NopHomePage();
    }

    @Given("^the page with '(.+?)' is opened$")
    public void thePageWithUrlIsOpened(String url) {
        WebDriverFactory.getInstance().getDriver().navigate().to(url);
    }

    @Then("^check that the following links are shown$")
    public void checkThatTheFollowingLinksAreShown(DataTable dataTable) {
        List<String> expectedResults = dataTable.asList(String.class);

        List<String> actualResults = new ArrayList<>();

        wait.until(ExpectedConditions.visibilityOfAllElements(NopHomePage.navigationLinks));
        List<WebElement> list = NopHomePage.navigationLinks;

        for (int i = 0; i < list.size(); i++) {
            actualResults.add(list.get(i).getText());
        }

        System.out.println(actualResults);
        System.out.println(expectedResults);

        for (int i = 0; i < expectedResults.size(); i++) {
            Assert.assertEquals(expectedResults.get(i), actualResults.get(i));
        }

        Assert.assertEquals(expectedResults.size(), actualResults.size());


    }

    @When("^we click '(.+?)' button from home page$")
    public void weClickLogInButtonFromHomePage(String buttonName) {
        nopHomePage.clickButton(buttonName);
    }


    @And("^we click '(.+?)' button from login page$")
    public void weClickLogInButtonFromLoginPage(String buttonName) {
        nopHomePage.clickLogInPageButtons(buttonName);
    }

    @And("^we type '(.+?)' in the '(.+?)' input field$")
    public void typeInTheFirstNameInputField(String text, String label) {
        By inputXpath = By.xpath("//div[@class='inputs']//label[text()='" + label + "']/../input");
        wait.until(ExpectedConditions.presenceOfElementLocated(inputXpath));
        WebDriverFactory.getInstance().getDriver().findElement(inputXpath).sendKeys(text);

    }

    @Then("^check the following message is shown on login page$")
    public void checkMessage(DataTable dataTable) {
        By result = By.xpath("//*[text()='" + dataTable.raw().get(0).get(0) + "']");
        wait.until(ExpectedConditions.textToBe(result, dataTable.raw().get(0).get(0)));
    }
}
