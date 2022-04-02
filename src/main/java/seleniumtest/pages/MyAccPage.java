package seleniumtest.pages;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.WebDriverFactory;

public class MyAccPage {
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);
    public MyAccPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(xpath = "//h1[contains(text(),'My account - Customer info')]")
    public static WebElement MyAccPageLabel;
    @FindBy(xpath = "//div[@class='header-links']//a[@class='ico-account']")
    public static WebElement myAccButton;
//    @FindBy(xpath = "//div[@class='inputs date-of-birth']//select[@name='DateOfBirthDay']")
//    public static WebElement dayOfBirth;
//    @FindBy(xpath = "//div[@class='inputs date-of-birth']//select[@name='DateOfBirthMonth']")
//    public static WebElement monthOfBirth;
//    @FindBy(xpath = "//div[@class='inputs date-of-birth']//select[@name='DateOfBirthYear']")
//    public static WebElement yearOfBirth;
//    @FindBy(css = "#gender-male")
//    public static WebElement GenderMale;
//    @FindBy(css = "#FirstName")
//    public static WebElement name;
//    @FindBy(css = "#LastName")
//    public static WebElement surname;
//    @FindBy(css = "#Email")
//    public static WebElement mail;
//    @FindBy(css = "#Company")
//    public static WebElement details;
    @FindBy(css = ".ico-logout")
    public static WebElement logoutButton;
    @FindBy(css = ".ico-account")
    public static WebElement registerButton;



    public static By gender = By.cssSelector("#gender-male");
    public static By name = By.cssSelector("#FirstName");
    public static By surname = By.cssSelector("#LastName");
    public static By dayOfBirth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthDay']");
    public static By monthOfBirth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthMonth']");
    public static By yearOfBirth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthYear']");
    public static By mail = By.cssSelector("#Email");
    public static By details = By.cssSelector("#Company");

}
