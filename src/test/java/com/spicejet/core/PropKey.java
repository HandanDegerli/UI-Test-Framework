package com.spicejet.core;

public enum PropKey {

    URL("url"),
    BROWSER("browser"),

    //DRIVER PATHS
    CHROME_DRIVER_PATH_OSX("driverPath"),

    //Timeouts
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait"),

    //Allure
    ALLURE_REPORT_STEP_LOG("allureReportStepLog"),
    SCREENSHOT("screenshot");

    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
