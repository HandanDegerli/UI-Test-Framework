package com.spicejet.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface DriverSetup {

    Capabilities getBrowserCapabilities();

    Object getBrowserOptions();

    WebDriver getWebDriver() throws IOException;
}
