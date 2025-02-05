package com.gk.test.framework.helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

//unused
public class AndroidHelper {
    private static final Logger LOG = LoggerFactory
            .getLogger(AndroidHelper.class);
    private static final String RUN_CONFIG_PROPERTIES = "/environment.properties";
    private static AndroidDriver ANDROID_DRIVER;
    private static final Thread CLOSE_THREAD = new Thread(() -> ANDROID_DRIVER.quit());

    static {
        Props.loadRunConfigProps(RUN_CONFIG_PROPERTIES);
        ANDROID_DRIVER = startAppiumDriver();
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    private AndroidHelper() {
    }


    private static AndroidDriver startAppiumDriver() {
        DesiredCapabilities capabilities = getAppiumDesiredCapabilities();
        try {
            ANDROID_DRIVER = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ANDROID_DRIVER;
    }


    private static DesiredCapabilities getAppiumDesiredCapabilities() {
        File app = new File("D:\\projects\\master_cucumber_testng\\tools\\ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.contactmanager");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ContactManager");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        //capabilities.setCapability("deviceName", "42f7ab1fb7b59fab");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        return capabilities;
    }

    public static AndroidDriver getAndroidWebDriver() {
        return ANDROID_DRIVER;
    }

    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        ANDROID_DRIVER.close();
    }
}
