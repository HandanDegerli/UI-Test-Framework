package com.spicejet;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com/spicejet/steps",
        plugin = { "pretty", "html:target/test-output",
        "json:target/cucumber-report/cucumber.json",
        "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"
},
        monochrome = true)
public class TestRunner {
}

