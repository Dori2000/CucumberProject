package seleniumtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class NotebookPage {
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public static By attributes_check_16GB = By.id("attribute-option-10");
    public static By displayedElements = By.xpath("//div[@class='products-wrapper']//div[@class='item-box']");
    public static By tittle = By.xpath("//div[@class='page-title']/h1");
    public static By display = By.xpath("//select[@id=\"products-pagesize\"]");
    public static By wishListBtn2 = By.xpath("//div[@data-productid='5']//div[@class='buttons']/button[contains(text(),'Add to wishlist')]");
    public static By wishListBtn3 = By.xpath("//div[@data-productid='8']//div[@class='buttons']/button[contains(text(),'Add to wishlist')]");
    public static By addToCartBtn4 = By.xpath("//div[@data-productid='7']//div[@class='buttons']/button[contains(text(),'Add to cart')]");
    public static By addToCartBtn5 = By.xpath("//div[@data-productid='9']//div[@class='buttons']/button[contains(text(),'Add to cart')]");
    public static By addToCartBtn6 = By.xpath("//div[@data-productid='6']//div[@class='buttons']/button[contains(text(),'Add to cart')]");
    public static By addToCartBtnss = By.xpath("//div[@class='buttons']/button[@class='button-2 product-box-add-to-cart-button']");
    public static By wishListBtnss = By.xpath("//div[@class='buttons']/button[@class='button-2 add-to-wishlist-button']");
    public static By content = By.xpath("//div[@class='bar-notification success']");
    public static By cartLable = By.xpath("//a[@class='ico-cart']/span[@class='cart-qty']");
    public static By wishListLable = By.xpath("//a[@class='ico-wishlist']/span[@class='wishlist-qty']");

    public void clickNotebookPageButtons(String buttonName) {
        switch (buttonName) {
            case "Add to Wish List 2":
                wait.until(ExpectedConditions.elementToBeClickable(wishListBtn2));
                WebElement wishlist2 = DriverUtils.getDriver().findElement(wishListBtn2);
                wishlist2.click();
                break;
            case "Add to Wish List 3":
                wait.until(ExpectedConditions.elementToBeClickable(wishListBtn3));
                WebElement wishlist3 = DriverUtils.getDriver().findElement(wishListBtn3);
                wishlist3.click();
                break;
            case "Add to Shopping Cart 4":
                wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn4));
                WebElement addToCart4 = DriverUtils.getDriver().findElement(addToCartBtn4);
                addToCart4.click();
                break;
            case "Add to Shopping Cart 5":
                wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn5));
                WebElement addToCart5 = DriverUtils.getDriver().findElement(addToCartBtn5);
                addToCart5.click();
                break;
            case "Add to shopping Cart 6":
                wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn6));
                WebElement addToCart6 = DriverUtils.getDriver().findElement(addToCartBtn6);
                addToCart6.click();
                break;

            default:
                throw new NotFoundException("Button not found!");
        }
    }


}
