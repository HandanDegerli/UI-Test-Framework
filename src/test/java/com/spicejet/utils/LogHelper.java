package com.spicejet.utils;

import com.spicejet.core.PropertyReader;
import com.spicejet.core.PropKey;
import io.qameta.allure.Step;

import java.io.IOException;

public class LogHelper {
    public static synchronized boolean logToReport(String meesage) throws IOException {

        boolean isLogEnabled = PropertyReader.getInstance()
                .getProp(PropKey.ALLURE_REPORT_STEP_LOG
                        .getPropVal()).equalsIgnoreCase("ENABLE");

        if(isLogEnabled){
            logToAllureReport(meesage);
            return true;
        }
        return false;
    }

    @Step("{0}")
    private static synchronized void logToAllureReport(String message){

    }
}
