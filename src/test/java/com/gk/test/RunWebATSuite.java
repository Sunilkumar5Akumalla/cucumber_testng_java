package com.gk.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", tags = "@gui", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runwebat.html",
        "json:target/cucumber-report/runwebat/cucumber.json",
        "rerun:target/cucumber-report/runwebat/rerun.txt"},
        glue = "com.gk.test")
public class RunWebATSuite extends AbstractTestNGCucumberTests {
}
