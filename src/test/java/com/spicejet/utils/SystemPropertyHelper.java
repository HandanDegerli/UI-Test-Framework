package com.spicejet.utils;

import com.spicejet.core.PropertyReader;
import com.spicejet.core.PropKey;
import com.spicejet.driver.BrowserType;

import java.io.IOException;

public class SystemPropertyHelper {
    public static BrowserType getBrowserFromSystemVariable() throws IOException {

        String browser = System.getProperty(PropKey.BROWSER.getPropVal());

        if(browser == null || browser.length() == 0){
            browser = PropertyReader.getInstance().getProp(PropKey.BROWSER.getPropVal());
        }

        if(browser.equalsIgnoreCase("CHROME")){
            return BrowserType.CHROME;
        }
        else {
            return null;
        }
    }

}
