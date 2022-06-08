package com.gk.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "target/test-classes", tags = "@gui,@api", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runjenkins",
        "json:target/cucumber-report/runjenkins/cucumber.json",
        "rerun:target/cucumber-report/runjenkins/rerun.txt"},
        glue = "com.gk.test")
public class RunJenkinsSuite extends AbstractTestNGCucumberTests {
}
