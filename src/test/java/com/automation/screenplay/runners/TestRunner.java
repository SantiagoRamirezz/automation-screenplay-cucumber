package com.automation.screenplay.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.screenplay.stepdefinitions",
        tags = "@EMP001",
        plugin = {"pretty"}
)
public class TestRunner {
}
