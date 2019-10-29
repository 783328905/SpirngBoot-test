package com.ctillnow.appium;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class CalculatorTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "HKL4ZEL3");
        //capabilities.setCapability("automationName", "Appium");
        //capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("sessionOverride", true);
        capabilities.setCapability("appPackage", "com.zui.calculator");
        capabilities.setCapability("appActivity", ".Calculator");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElementById("com.zui.calculator:id/digit_1").click();
        driver.findElementByXPath("//android.widget.Button[contains(@text,'7')]").click();
        driver.findElementByXPath("//android.widget.Button[contains(@text,'+')]").click();
        driver.findElementByXPath("//android.widget.Button[contains(@text,'5')]").click();
        driver.findElementByXPath("//android.widget.Button[contains(@text,'=')]").click();
        //driver.findElement(By.id("com.zui.calculator:id/digit_1")).click();

        //driver.findElement(By.name("=")).click();

        String ca = driver.currentActivity();
        System.out.println(ca);
        Thread.sleep(5000);
        String result = driver.findElement(By.id("com.zui.calculator:id/formula_or_result")).getText();
        System.out.println(result);






        driver.quit();
    }

}