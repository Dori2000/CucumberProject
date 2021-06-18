package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.WebDriverFactory;

import java.util.List;

public class NopHomePage {

    public NopHomePage(){
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(css = ".header-links ul li a")
    public static List<WebElement> navigationLinks;

    @FindBy(css = ".ico-login")
    public static WebElement logInButton;

    @FindBy(css = ".login-button")
    public static WebElement logInUserButton;

    @FindBy(css = "#register-button")
    public static WebElement registerUserButton;

    @FindBy(css = ".register-button")
    public static WebElement registerButton;

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Log in":
                wait.until(ExpectedConditions.visibilityOf(logInButton));
                logInButton.click();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }
    }

    public void clickLogInPageButtons(String buttonName) {
        switch (buttonName) {
            case "Register User":
                wait.until(ExpectedConditions.visibilityOf(registerUserButton));
                registerUserButton.click();
                break;
            case "Register":
                wait.until(ExpectedConditions.visibilityOf(registerButton));
                registerButton.click();
                break;
            case "Log in":
                wait.until(ExpectedConditions.visibilityOf(logInUserButton));
                logInUserButton.click();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }
    }
}
