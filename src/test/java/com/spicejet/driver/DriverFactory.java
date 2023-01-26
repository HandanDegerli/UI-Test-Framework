package com.spicejet.driver;

import com.spicejet.core.PropertyReader;
import com.spicejet.utils.SystemPropertyHelper;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver = null;
    public static PropertyReader prop;

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() throws IOException{
        if(driver == null) {
                driverThreadLocal.set(getBrowser().getWebDriver());
            }
        driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

    private static BrowserType getBrowser() throws IOException {

        BrowserType browserType = SystemPropertyHelper.getBrowserFromSystemVariable();

        if (browserType != null) {
            return browserType;
        }else {
            return BrowserType.CHROME;
        }
    }
}