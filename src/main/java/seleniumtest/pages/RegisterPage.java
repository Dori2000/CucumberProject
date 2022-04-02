package seleniumtest.pages;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.WebDriverFactory;

public class RegisterPage {
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);
    public RegisterPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(css = "span.male > label")
    public static WebElement male;
    @FindBy(css = "span.female > label")
    public static WebElement female;
    @FindBy(css = "#FirstName")
    public static WebElement firstname;
    @FindBy(css = "#LastName")
    public static WebElement lastname;
    @FindBy(css = "#Email")
    public static WebElement email;
    @FindBy(css = "#Company")
    public static WebElement company;
    @FindBy(css = ".ico-logout")
    public static WebElement logout;
    @FindBy(name = "DateOfBirthDay")
    public static WebElement dayBirth;
    @FindBy(name = "DateOfBirthMonth")
    public static WebElement monthBirth;
    @FindBy(name = "DateOfBirthYear")
    public static WebElement yearBirth;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    public static WebElement pass;
    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    public static WebElement confirmPass;
    @FindBy(xpath = "//*[@id=\"register-button\"]")
    public static WebElement finalRegistration;
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    public static WebElement registerLabel;


}















