package com.ctillnow.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

/**
 * Created by xiezongyu on 2017/11/16.
 */
public class AppiumUtil {

    //屏幕向下移动
    public static void swipeUp(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 2;
        int starY = height * 9 / 10;

        int endX = width * 1 / 2;
        int endY = height * 1 / 100;

        driver.swipe(statX, starY, endX, endY, 400);
    }

    //屏幕向上移动
    public static void swipeDown(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 2;
        int starY = height * 1 / 10;

        int endX = width * 1 / 2;
        int endY = height * 9 / 10;

        driver.swipe(statX, starY, endX, endY, 400);
    }

    //屏幕向下移动1/2
    public static void swipeUpHalf(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 2;
        int starY = height * 3 / 4;

        int endX = width * 1 / 2;
        int endY = height / 4;

        driver.swipe(statX, starY, endX, endY, 400);
    }

    //屏幕向上移动1/2
    public static void swipeDownHalf(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 2;
        int starY = height  / 4;

        int endX = width * 1 / 2;
        int endY = height * 3 / 4;

        driver.swipe(statX, starY, endX, endY, 400);
    }

    public static void swipeDownFast(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 2;
        int starY = height * 3 / 10;

        int endX = width * 1 / 2;
        int endY = height * 9 / 10;

        driver.swipe(statX, starY, endX, endY, 400);
    }

    public static void swipeUpFast(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 2;
        int starY = height - 1;

        int endX = width * 1 / 2;
        int endY = 1;

        driver.swipe(statX, starY, endX, endY, 150);
    }


    public static void swipeUpSlowly(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 2;
        int starY = height * 7 / 10;

        int endX = width * 1 / 2;
        int endY = height * 3 / 10;

        driver.swipe(statX, starY, endX, endY, 2500);
    }

    //
    public static void swipeRight(AndroidDriver driver) throws Exception {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        int statX = width * 1 / 100;
        int starY = height * 1 / 2;

        int endX = width * 99 / 100;
        int endY = height * 1 / 2;

        driver.swipe(statX, starY, endX, endY, 2000);
    }


    public static WebElement findElementWait(AndroidDriver driver, final By by, int clock) {
        try {
            ExpectedCondition<WebElement> searchBoxCondition = ExpectedConditions.presenceOfElementLocated(by);
            return new WebDriverWait(driver, clock).until(searchBoxCondition);
        } catch (Exception e) {
            return null;
        }
    }


    public static WebElement findElement(AndroidDriver driver, By by) {
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            return null;
        }
    }

    public static void longPress(AndroidDriver driver, WebElement webElement, int timeMillis) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(webElement, timeMillis).release().perform();
    }

    public static void press(AndroidDriver driver, WebElement webElement) {
        TouchAction touchAction = new TouchAction(driver);
        int x = webElement.getSize().getWidth() / 2;
        int y = webElement.getSize().getHeight() / 2;
        touchAction.press(webElement, x, y).release().perform();
    }

    public static void main(String[] args) {
        System.out.println(Base64Util.encode("15901879723@163.com"));
        System.out.println();
        System.out.println(Base64Util.encode(""));
    }

    public static WebElement scrollToByTextContains(AndroidDriver driver, String text) {
        String uiScrollables = UiScrollable("new UiSelector().textContains(\"" + text + "\")");
        return driver.findElementByAndroidUIAutomator(uiScrollables);
    }

    public static WebElement scrollToByDescContains(AndroidDriver driver, String text) {
        String uiScrollables = UiScrollable("new UiSelector().descriptionContains(\"" + text + "\")");
        return driver.findElementByAndroidUIAutomator(uiScrollables);
    }

    public static WebElement scrollToByText(AndroidDriver driver, String text) {
        String uiScrollables = UiScrollable("new UiSelector().text(\"" + text + "\")");
        return driver.findElementByAndroidUIAutomator(uiScrollables);
    }

//    public static WebElement scrollToByDescription(AndroidDriver driver, String text) {
//        String uiScrollables = UiScrollable("new UiSelector().description(\"" + text + "\")");
//        return driver.findElementByAndroidUIAutomator(uiScrollables);
//    }

    public static String UiScrollable(String uiSelector) {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ".instance(0));";
    }


    public static List<WebElement> findElementsWait(AndroidDriver driver, By by, Integer clock) {
        WebElement element = AppiumUtil.findElementWait(driver, by, clock);
        if (element != null) {
            try {
                return driver.findElements(by);
            } catch (Exception e) {
                return Collections.EMPTY_LIST;
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static WebElement findLastElementWait(AndroidDriver driver, By by, Integer clock) {
        List<WebElement> webElements = findElementsWait(driver, by, clock);
        if (webElements.isEmpty()) {
            return null;
        } else {
            return webElements.get(webElements.size() - 1);
        }
    }

    public static WebElement findFirstElementWait(AndroidDriver driver, By by, Integer clock) {
        List<WebElement> webElements = findElementsWait(driver, by, clock);
        if (webElements.isEmpty()) {
            return null;
        } else {
            return webElements.get(0);
        }
    }

    public static WebElement findElementCustomWait(AndroidDriver driver, By xpath, Integer index, Integer clock) {
        List<WebElement> webElements = findElementsWait(driver, xpath, clock);
        if (webElements.isEmpty() || index >= webElements.size()) {
            return null;
        } else {
            return webElements.get(index);
        }
    }
}
