package seleniumtest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void before(Scenario scenario){
        System.out.println("-------------------------------\nStarting: " + "\u001B[33m" + scenario.getName() + "\u001B[0m");
    }

    @After
    public void after(Scenario scenario){
        if(scenario.getStatus().equals("failed")){
            System.out.println("Ending: " + "\u001B[33m" + scenario.getName() + "\u001B[0m" + " with Status: " +
                    "\u001B[31m" + scenario.getStatus() +"\u001B[0m");
        } else {
            System.out.println("Ending: " + "\u001B[33m" + scenario.getName() + "\u001B[0m" + " with Status: " +
                    "\u001B[32m" + scenario.getStatus() + "\u001B[0m");
        }
    }
}