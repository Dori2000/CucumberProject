package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.Helper.Help;
import seleniumtest.pages.*;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class NopCommerceMyAccountSteps {
    private static theMain mainPage;
    private static ShoppingCartPage sp;
    private static Help helper;
    private static MyAccPage ac;
    private static LoginPage login;
    private static RegisterPage reg;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);
    public NopCommerceMyAccountSteps() {
        mainPage = new theMain();
        reg = new RegisterPage();
        login = new LoginPage();
        ac = new MyAccPage();
        sp = new ShoppingCartPage();
        helper = new Help();


    }



    @Then("^verify that all fields contain the values added from Register test$")
    public void verifyThatAllFieldsContainTheValuesAddedFromRegisterTest(DataTable dataTable) {
        //*[contains(@value,' "+ ACCESS DATA TABLE +" ')]

        Assert.assertEquals(dataTable.raw().get(0).get(0), helper.actualText(ac.gender));
        Assert.assertEquals(dataTable.raw().get(1).get(0), DriverUtils.getDriver().findElement(ac.name).getAttribute("value"));
        Assert.assertEquals(dataTable.raw().get(2).get(0), DriverUtils.getDriver().findElement(ac.surname).getAttribute("value"));
        Assert.assertEquals(dataTable.raw().get(3).get(0), DriverUtils.getDriver().findElement(ac.dayOfBirth).getAttribute("value"));
        Assert.assertEquals(dataTable.raw().get(4).get(0), DriverUtils.getDriver().findElement(ac.monthOfBirth).getAttribute("value"));
        Assert.assertEquals(dataTable.raw().get(5).get(0), DriverUtils.getDriver().findElement(ac.yearOfBirth).getAttribute("value"));
        Assert.assertEquals(dataTable.raw().get(6).get(0), DriverUtils.getDriver().findElement(ac.mail).getAttribute("value"));
        Assert.assertEquals(dataTable.raw().get(7).get(0), DriverUtils.getDriver().findElement(ac.details).getAttribute("value"));



//
//        By name = By.xpath("//*[contains(@value,'"+ dataTable.raw().get(1).get(0) + "')]");
//       String text =  DriverUtils.getDriver().findElement(name).getAttribute("value");
//        System.out.println(text);
//
//        wait.until(ExpectedConditions.textToBe(name, dataTable.raw().get(1).get(0)));
//        By surname = By.xpath("//*[contains(@value,'"+ dataTable.raw().get(2).get(0) + "')]");
//        wait.until(ExpectedConditions.textToBe(surname, dataTable.raw().get(2).get(0)));
//        By email = By.xpath("//*[contains(@value,'"+ dataTable.raw().get(6).get(0) + "')]");
//        wait.until(ExpectedConditions.textToBe(email, dataTable.raw().get(6).get(0)));
//        By company = By.xpath("//*[contains(@value,'"+ dataTable.raw().get(7).get(0) + "')]");
//        wait.until(ExpectedConditions.textToBe(company, dataTable.raw().get(7).get(0)));
//
//        By birthDate = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthDay']/option[contains(text(),'"+ dataTable.raw().get(3).get(0) +"')]");
//        wait.until(ExpectedConditions.textToBe(birthDate, dataTable.raw().get(3).get(0)));
//        By birthMonth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthMonth']/option[contains(text(),'"+ dataTable.raw().get(4).get(0) +"')]");
//        wait.until(ExpectedConditions.textToBe(birthMonth, dataTable.raw().get(4).get(0)));
//        By birthYear = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthYear']/option[contains(text(),'"+ dataTable.raw().get(5).get(0) +"')]");
//        wait.until(ExpectedConditions.textToBe(birthYear, dataTable.raw().get(5).get(0)));
//

    }

    @Then("^close the browser$")
    public void close_the_browser() throws Throwable {
        DriverUtils.getDriver().close();
    }

}
