package com.gk.test.framework.helpers.screenshot_helper;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import lombok.Getter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ScreenshotHook {
    private static final Logger LOG = LoggerFactory.getLogger(ScreenshotHook.class);
    @Getter
    protected WebDriver webDriver;

    @After
    public void embedScreenshot(Scenario scenario) {
        if (getWebDriver() != null) {
            try {
                Map<String, Object> screenShots = ScreenshotHelper.getScreenShotsForCurrentTest();
                for (Map.Entry<String, Object> screenShot : screenShots.entrySet()) {
                    scenario.attach((byte[]) screenShot.getValue(), "image/png", screenShot.getKey());
                }

                ScreenshotHelper.tidyUpAfterTestRun();

                if (scenario.isFailed()) {
                    byte[] screenShot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenShot, "image/png", getWebDriver().getCurrentUrl());
                }

            } catch (WebDriverException | ClassCastException wde) {
                LOG.error(wde.getMessage());
            } finally {
                getWebDriver().switchTo().defaultContent();
            }
        }
    }
}
