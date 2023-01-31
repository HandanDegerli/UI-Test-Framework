package com.spicejet.steps;

import com.spicejet.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class StepHooks {
    private static Logger logger;
    protected static WebDriver driver;

    @Before
    public void initialize() throws IOException {
        driver = DriverFactory.getDriver();
        logger = Logger.getLogger("RESULT");
    }

    @After
    public static void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            logger.error("Test case has been FAILED");
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);

        }else logger.info("Test case has been SUCCESSFUL");
/*
        if (driver != null) {
            driver.quit();
            driver = null;
        }

 */


    }

}
