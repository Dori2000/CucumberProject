package seleniumtest.pages;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class theMain {

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);
    public theMain() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }


    @FindBy(css = ".ico-login")
    public static WebElement login;

    @FindBy(css = ".ico-logout")
    public static WebElement logout;

    @FindBy(css = ".login-button")
    public static WebElement logInUserButton;

    @FindBy(css = "#register-button")
    public static WebElement registerUserButton;

    @FindBy(css = ".register-button")
    public static WebElement register;

    @FindBy(css = ".topic-block-tittle")
    public static WebElement tittle;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(@href,'/computers') and text()='Computers ']")
    public static WebElement computeHoverBtn;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(@href,'/notebooks') and  text()='Notebooks ']")
    public static WebElement notebookButton;

    @FindBy(xpath = "//div[@class='header-links']//a[@class='ico-account']")
    public static WebElement myAccButton;


    public void clickMainPageButtons(String buttonName) {
        switch (buttonName) {
            case "Log in":
                wait.until(ExpectedConditions.visibilityOf(login));
                login.click();
                break;
            case "Log out":
                wait.until(ExpectedConditions.visibilityOf(logout));
                logout.click();
                break;
            case "User Log in":
                wait.until(ExpectedConditions.visibilityOf(logInUserButton));
                logInUserButton.click();
                break;
            case "User Registration":
                wait.until(ExpectedConditions.visibilityOf(registerUserButton));
                registerUserButton.click();
                break;
            case "Register":
                wait.until(ExpectedConditions.visibilityOf(register));
                register.click();
                break;
            case "Notebook":
                wait.until(ExpectedConditions.visibilityOf(notebookButton));
                notebookButton.click();
                break;
            case "My Account":
                wait.until(ExpectedConditions.visibilityOf(myAccButton));
                myAccButton.click();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }
    }

    public void mouseHoverOnMainPageButtons(String buttonName){
        switch (buttonName) {
            case "Computers":
                wait.until(ExpectedConditions.visibilityOf(computeHoverBtn));
                Actions actions = new Actions(DriverUtils.getDriver());
                actions.moveToElement(computeHoverBtn).perform();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }

    }
}
