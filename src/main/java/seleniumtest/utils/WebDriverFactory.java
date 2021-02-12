package seleniumtest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

public class WebDriverFactory {

    private static final XLogger LOGGER = XLoggerFactory.getXLogger(WebDriverFactory.class.getName());
    private static WebDriverFactory instance = new WebDriverFactory();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal();

    private WebDriverFactory() {
    }

    public static WebDriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        WebDriver drv = (WebDriver) driver.get();
        if (null == drv) {
            driver.set(this.getBrowser());
        }

        return (WebDriver) driver.get();
    }

    public void quit() {
        WebDriver drv = (WebDriver) driver.get();
        if (null != drv) {
            drv.quit();
        }

        driver.remove();
    }

    public void closeWindow() {
        WebDriver drv = (WebDriver) driver.get();
        if (null != drv) {
            drv.close();
        }

    }

    private WebDriver getBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/windowsOS/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
        driver.manage().window().maximize();

        return driver;
    }
}
