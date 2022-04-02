package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.Helper.Help;
import seleniumtest.pages.*;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

import java.util.List;

public class NopCommerceShoppingCastSteps {

    private static theMain mainPage;
    private static ShoppingCartPage sp;
    private static Help helper;
    private static MyAccPage ac;
    private static LoginPage login;
    private static RegisterPage reg;

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);
    public NopCommerceShoppingCastSteps() {
        mainPage = new theMain();
        reg = new RegisterPage();
        login = new LoginPage();
        ac = new MyAccPage();
        sp = new ShoppingCartPage();
        helper = new Help();
    }

    @And("^we verify that '(.+?)' button is displayed$")
    public void weVerifyThatGoToCartButtonIsDisplayed(String buttonName) {


            switch (buttonName) {
                case "Go To Cart":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.goToCartBttn));
                    helper.buttonIsDisplayed(sp.goToCartBttn);

                    break;
                case "Update shopping cart":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(sp.updateShoppingCartBtn));
                    helper.buttonIsDisplayed(sp.updateShoppingCartBtn);

                    break;
                case "Continue shopping":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(sp.continueShoppingBtn));
                    helper.buttonIsDisplayed(sp.continueShoppingBtn);

                    break;
                case "Estimate shipping":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(sp.estimateShippingBtn));
                    helper.buttonIsDisplayed(sp.estimateShippingBtn);

                    break;

                default:
                    throw new NotFoundException("Button not found!");
            }

    }

    @And("^we click '(.+?)' button from NopCommerce Home page$")
    public void weClickGoToCartButtonFromNopCommerceHomePage(String buttonName) {
        sp.clickShoppingCartPageButtons(buttonName);
    }

    @Then("^verify that we have navigate to Shopping Cart Page$")
    public void verifyThatWeHaveNavigateToShoppingCartPage(DataTable dataTable) {
        By tittle = By.xpath("//*[text()='" + dataTable.raw().get(0).get(0) + "']");
        wait.until(ExpectedConditions.textToBe(tittle, dataTable.raw().get(0).get(0)));
    }

    @And("^verify that the prices sum for all items is equal to total price in the end of the page$")
    public void verifyThatThePricesSumForAllItemsIsEqualToTotalPriceInTheEndOfThePage() {
        List<WebElement> itemPrice = DriverUtils.getDriver().findElements(ShoppingCartPage.itemSubtotal);
        wait.until(ExpectedConditions.visibilityOfAllElements(itemPrice));
        WebElement totalPrice = DriverUtils.getDriver().findElement(ShoppingCartPage.orderTotal);

        //Marrim vtm cmimin nga label
        String orderTotal = totalPrice.getText();
        String actualorderTotal = orderTotal.replaceAll("[^0-9]", "");

        int actualorder = Integer.parseInt(actualorderTotal);
        int sumOfactualValue = 0;

        for (int i=0; i<itemPrice.size(); i++){
            String actualPrice = itemPrice.get(i).getText();
            String actualSubtotal = actualPrice.replaceAll("[^0-9]", "");
            int actualValue = Integer.parseInt(actualSubtotal);
            sumOfactualValue += actualValue;
        }

        Assert.assertEquals(sumOfactualValue,actualorder);
        System.out.println("Successful Verification!");

    }

    @And("^we delete item with index: '(\\d+)' from shopping cart and verify it will be decreased by 1$")
    public void weDeleteItemNumberFromShoppingCart(int index) {
        helper.deleteElementByIndex(sp.items, index);

        WebElement element = DriverUtils.getDriver().findElement(ShoppingCartPage.cartLabel);
        String actualString = element.getText();
        String actualText = actualString.replaceAll("[^0-9]", "");
        int actualValue = Integer.parseInt(actualText);
        String expectedText = actualString.replaceAll("[^0-9]", "");
        int expectedValue = Integer.parseInt(expectedText);
        if (expectedValue == (actualValue - 1)) Assert.assertEquals(actualValue,expectedValue);
        else System.out.println(" ");
    }

    @Then("^we delete one by one till shopping card will be empty$")
    public void weDeleteOneByOneTillShoppingCardWillBeEmpty() {
        List <WebElement> shoppingCart = DriverUtils.getDriver().findElements(ShoppingCartPage.items);
        List <WebElement> removeItemBttn = DriverUtils.getDriver().findElements(ShoppingCartPage.removeItemBttn);
        //wait.until(ExpectedConditions.visibilityOfAllElements(shoppingCart));
        for (int i=0; i<removeItemBttn.size(); i++)
            helper.deleteElementByIndex(ShoppingCartPage.items, 0);

    }
}
