package com.gk.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "target/test-classes", monochrome = true, tags = "@findWord", plugin = {
        "pretty", "html:target/cucumber-report/single",
        "json:target/cucumber-report/single/cucumber.json",
        "rerun:target/cucumber-report/single/rerun.txt"},
        glue = "com.gk.test")
public class RunSingleSuite extends AbstractTestNGCucumberTests {
}
