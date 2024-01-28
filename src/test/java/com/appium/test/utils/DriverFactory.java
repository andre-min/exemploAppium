package com.appium.test.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    @After
    public void tearDown(){killDriver();}

    private  static AndroidDriver<MobileElement> driver;

    public  static AndroidDriver<MobileElement> getDriver (){
        if (driver == null) {
            createDriver();

        }

        return driver;


    }
        private static void createDriver() {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "MOTO G5s");
            desiredCapabilities.setCapability("platformVersion", "8.1.0");
            desiredCapabilities.setCapability("automationName", "uiautomator2");
            desiredCapabilities.setCapability("appPackage", "com.example.agendaqui");
            desiredCapabilities.setCapability("appActivity", "com.example.agendaqui.MainActivity");
            desiredCapabilities.setCapability("skipDeviceInitialization", "true");
            desiredCapabilities.setCapability("appium:noReset", "true");

            try {
                driver = new  AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        }

        public static void killDriver(){
            if(driver != null){
                driver.quit();
                driver = null;
            }
        }

}

