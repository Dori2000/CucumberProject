package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumtest.utils.DriverUtils;

public class OneAlHomePage {
    public OneAlHomePage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(DriverUtils.getDriver()), this);
    }

    @FindBy(id = "navigationMenuLogin")
    public static WebElement llogariaImeButton;

    @FindBy(css = "#form-login > fieldset > div.form-actions > a")
    public static WebElement hyrButton;

    @FindBy(css = "#be-messenger > span > div > div > div")
    public static WebElement kerkoNdihmeButton;

    @FindBy(css = "#be-messenger > span > div > div.Window_Body__2VgEC > form > div.StartSession_Footer__2KJ8F > button > div")
    public static WebElement filloKomunikiminButton;

    @FindBy(id = "username")
    public static WebElement emailInputField;

    @FindBy(id = "passwordLogin")
    public static WebElement passwordInputField;

    @FindBy(id = "bandaClose")
    public static WebElement pranoButton;
}
