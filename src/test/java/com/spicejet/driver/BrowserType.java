package com.spicejet.driver;

import com.spicejet.utils.Helper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;

public enum BrowserType implements DriverSetup{
    CHROME {
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOptions();
            return capabilities;
        }

        @Override
        public ChromeOptions getBrowserOptions() {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--incognito");
            //chromeOptions.addArguments("--window-size=1920,1080");
            //chromeOptions.addArguments("--headless");
            chromeOptions.setAcceptInsecureCerts(true);

            return chromeOptions;
        }

        @Override
        public WebDriver getWebDriver() throws IOException {
            String browserPath = Helper.getBrowserPath();
            System.setProperty("webdriver.chrome.driver", browserPath);
            ChromeOptions chromeOptions = getBrowserOptions();
            return new ChromeDriver(chromeOptions);
        }
    };
}
