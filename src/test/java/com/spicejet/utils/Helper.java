package com.spicejet.utils;

import com.spicejet.core.PropertyReader;
import com.spicejet.core.PropKey;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Helper {
    public static String getBrowserPath() throws IOException {
        //  System.getProperty("os.name");
        return PropertyReader.getInstance().getProp(PropKey.CHROME_DRIVER_PATH_OSX.getPropVal());
    }

    public static synchronized  boolean takeScreenShot(WebDriver driver, String name) throws IOException {
        boolean isScreenShot = PropertyReader.getInstance()
                .getProp(PropKey.SCREENSHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if(isScreenShot){
            attachScreenShot(driver,name);
            return true;
        }
        return false;
    }

    @Attachment(value = "{name}" , type = "image/png")
    private static synchronized byte[] attachScreenShot(WebDriver driver,
                                                        String name){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
