package seleniumtest.utils;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverUtils {

    private static final WebDriver driver = WebDriverFactory.getInstance().getDriver();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void navigate(String relPath) throws MalformedURLException {
        WebDriverFactory.getInstance().getDriver().navigate().to(relPath);
    }
}
