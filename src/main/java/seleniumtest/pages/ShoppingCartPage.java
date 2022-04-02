package seleniumtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class ShoppingCartPage {
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);


    public static By table = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table");
    public static By shoppinCartButton = By.cssSelector(".ico-cart");
    public static By removeItemBttn = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td/button");
    public static By cartLabel = By.xpath("//a[@class='ico-cart']/span[@class='cart-qty']");
    public static By noData = By.cssSelector(".no-data");
    public static By items = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table//tbody/tr");
    public static By goToCartBttn = By.xpath("//button[contains(text(),'Go to cart')]");
    public static By shoppingCartTittle = By.xpath("//div[@class='page-title']");
    public static By updateShoppingCartBtn = By.xpath("//button[@class='button-2 update-cart-button']");
    public static By continueShoppingBtn = By.xpath("//button[@class='button-2 continue-shopping-button']");
    public static By estimateShippingBtn = By.xpath("//a[@href='#estimate-shipping-popup']");
    public static By itemSubtotal = By.xpath("//td[@class='subtotal']");
    public static By orderTotal = By.xpath("//tr[@class='order-total']");


    public void clickShoppingCartPageButtons(String buttonName) {
        switch (buttonName) {
            case "Go To Cart":
                wait.until(ExpectedConditions.elementToBeClickable(goToCartBttn));
                WebElement gotoCartBtn = DriverUtils.getDriver().findElement(goToCartBttn);
                gotoCartBtn.click();
                break;

            default:
                throw new NotFoundException("Button not found!");
        }
    }





}
