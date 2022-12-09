package seleniumtest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.Helper.Help;
import seleniumtest.pages.*;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class Hooks {

    private static Help helper;
    public Hooks() {
        helper = new Help();
    }


    @Before
    public void before(Scenario scenario){
        System.out.println("-------------------------------\nStarting: " + "\u001B[33m" + scenario.getName() + "\u001B[0m");
    }


    @After
    public void after(Scenario scenario) throws Exception {
        if(scenario.getStatus().equals("failed")){
            System.out.println("Ending: " + "\u001B[33m" + scenario.getName() + "\u001B[0m" + " with Status: " +
                    "\u001B[31m" + scenario.getStatus() +"\u001B[0m");

            //SCREENSHOT
            helper.captureScreenshot(DriverUtils.getDriver(),scenario.getName());
        } else {
            System.out.println("Ending: " + "\u001B[33m" + scenario.getName() + "\u001B[0m" + " with Status: " +
                    "\u001B[32m" + scenario.getStatus() + "\u001B[0m");
        }
    }
}