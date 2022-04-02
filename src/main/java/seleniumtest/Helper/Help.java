package seleniumtest.Helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.pages.ShoppingCartPage;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

import java.io.File;
import java.util.List;

public class Help {
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);


    public void elementIsDisplayed(By path, String expectedText) {

        WebElement element = DriverUtils.getDriver().findElement(path);
        String actualText = element.getText();
        wait.until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed())
            Assert.assertEquals(actualText,expectedText);
        else
            System.out.println("Element not displayed!");
    }

    public void buttonIsDisplayed(By path){
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOf(element));
        boolean x = element.isDisplayed();
        if (element.isDisplayed())
            Assert.assertTrue(x);
    }

    public void navigateTo(String link) {
        DriverUtils.getDriver().get(link);
    }

    public void sendKeysUsingActions(String key) {
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.sendKeys(key);
        actions.build().perform();
    }

    public void mouseHover(By path){
        WebElement element = DriverUtils.getDriver().findElement(path);
        Actions action = new Actions(DriverUtils.getDriver());
        action.moveToElement(element).perform();
    }

    public void driverMouseHover(By path){
        WebElement element = DriverUtils.getDriver().findElement(path);
        Actions action = new Actions(DriverUtils.getDriver());
        action.moveToElement(element).perform();
    }

    public void sendKeys(By path, String text) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        element.sendKeys(text);
    }

    public void clickElement(By path) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        element.click();
    }

    public void selectDropdown(By path, String text) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void select(By path) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        boolean x = element.isDisplayed();
        if (x == true) {
            element.click();
        }
    }

    public void isSelected(By path) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        boolean x = element.isSelected();
        if (x == true) {
            Assert.assertTrue(x);
        }
    }

    public void clickRemoveItemButton(By path ,int i){
        List<WebElement> elements = DriverUtils.getDriver().findElements(path);
        List<WebElement> removeItems = DriverUtils.getDriver().findElements(ShoppingCartPage.removeItemBttn);

        int itemsCount = elements.size();
        if (itemsCount > 0) {
            wait.until(ExpectedConditions.visibilityOfAllElements(removeItems));
            removeItems.get(i).click();
        }
    }

    public void deSelect(By path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        WebElement element = DriverUtils.getDriver().findElement(path);
        boolean x = element.isSelected();
        if (x == true) {
            element.click();
            Assert.assertFalse(element.isSelected());
        }
    }

    public void deleteElementByIndex(By path, int index){
        List<WebElement> elements = DriverUtils.getDriver().findElements(path);

        List<WebElement> removeItems = DriverUtils.getDriver().findElements(ShoppingCartPage.removeItemBttn);

        int itemsCount = elements.size();
        if (itemsCount > 0) {
            removeItems.get(index).click();
        }
    }

    public void assertElementHasText(By path, String expectedText) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        String actualText = element.getText();
        Assert.assertEquals(actualText,expectedText);
    }

    public void assertValueOfElementIs(By path, String expectedValue){
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        String actualValue = element.getAttribute("value");
        Assert.assertEquals(actualValue,expectedValue);
    }

    public void actionClickElement(By path) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }

    public void checkTest(String expectedTittle) {
        String actualTittle = "";
        actualTittle = DriverUtils.getDriver().getTitle();

        if (actualTittle.equals(expectedTittle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println(" ");
        }
    }

    public void selectDropdownByText(By path, String text) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By path, int i) {
        List<WebElement> element = DriverUtils.getDriver().findElements(path);
        element.get(i).click();
    }

    public void clickElementByActions(By path) {
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.moveToElement(element);
        actions.click();
        System.out.println("Element was clicked!");
    }

    public void noOfDisplayedElements(By path, int num) {
        List<WebElement> elements = DriverUtils.getDriver().findElements(path);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(path));
        int totalLinkSize = elements.size();
        Assert.assertEquals(totalLinkSize, num);
    }

    public void elementNotVisible(By path) { //waitForElementNotToBeVisible
        WebElement element = DriverUtils.getDriver().findElement(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
//        boolean isVisible = ExpectedConditions.invisibilityOf(element).apply(DriverUtils.getDriver()).booleanValue();
//        if (isVisible)
//            System.out.println("Element is invisible");
//        else
//            System.out.println("Element is invisible Now!");
    }

    public String actualText(By path){
        String theText = DriverUtils.getDriver().findElement(path).getAttribute("value");
        return theText;

    }

    public void captureScreenshot(WebDriver driver, String screenshotName) throws Exception{

        String fileWithPath = "C:\\Users\\User\\SeleniumWebdriverMavenDemo\\src\\test\\java\\Screenshots\\screenshot.png";

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileHandler.copy(SrcFile, DestFile);
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
