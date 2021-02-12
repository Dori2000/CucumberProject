package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumtest.utils.WebDriverFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(id = "image-darkener")
    public static WebElement popUp;

    @FindBy(id = "at-cv-lightbox-close")
    public static WebElement closePopUp;

    @FindBy(css = "li[style='display: list-item;']")
    public static WebElement menuList;

    @FindBy(id = "sum1")
    public static WebElement enterAInputField;

    @FindBy(id = "sum2")
    public static WebElement enterBInputField;

    @FindBy(id = "user-message")
    public static WebElement enterMessageInputField;

}
