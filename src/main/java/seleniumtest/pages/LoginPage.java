package seleniumtest.pages;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.WebDriverFactory;


public class LoginPage {

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);
    public LoginPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(css = ".ico-login")
    public static WebElement loginButton;


    @FindBy(xpath = "//button[@class='button-1 register-button']")
    public static WebElement registerButton;

    @FindBy(css = ".topic-block-title")
    public static WebElement welcomeLabel2;

    @FindBy(className = "password")
    public static WebElement password;

    @FindBy(className = "email")
    public static WebElement email;


    public void clickLogInPageButtons(String buttonName) {
        switch (buttonName) {
            case "User Log in":
                wait.until(ExpectedConditions.visibilityOf(loginButton));
                loginButton.click();
                break;
            case "User Register":
                wait.until(ExpectedConditions.visibilityOf(registerButton));
                registerButton.click();
                break;


            default:
                throw new NotFoundException("Button not found!");
        }
    }


}
