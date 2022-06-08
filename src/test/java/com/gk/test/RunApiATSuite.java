package com.gk.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "target/test-classes", tags = "@api", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runapiat",
        "json:target/cucumber-report/runapiat/cucumber.json",
        "rerun:target/cucumber-report/runapiat/rerun.txt"},
        glue = "com.gk.test")
public class RunApiATSuite extends AbstractTestNGCucumberTests {
}
