package com.ctillnow.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import java.io.IOException;
import java.net.URL;
import java.util.List;


import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



/**
 * Created by author on 2018/1/9.
 */
public class CalculaterTest2 {
    private AppiumDriver driver;


    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "HKL4ZEL3"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "8.1");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.tencent.mm");
        cap.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");

        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity", "com.tencent.mm.ui.LauncherUI");
        cap.setCapability("unicodeKeyboard", "True");
        cap.setCapability("resetKeyboard", "True");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);


    }


    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }


    public void apiDemo() throws InterruptedException, IOException {
        Thread.sleep(5000);
        List<WebElement> list = driver.findElementsById("com.tencent.mm:id/apt");
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (; ; ) {
            WebElement target = getTarget(list);
            if (target != null) {
                target.click();
                Thread.sleep(500);
                driver.findElementById("com.tencent.mm:id/aae").click();
                driver.findElementById("com.tencent.mm:id/aaf").sendKeys("11");
                Thread.sleep(100);
                driver.findElementById("com.tencent.mm:id/aal").click();
                break;
            } else {
                driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 800);
                Thread.sleep(100);
                list = driver.findElementsById("com.tencent.mm:id/apt");
            }
        }
    }

    WebElement getTarget(List<WebElement> list) throws InterruptedException {
        for (WebElement w : list) {
            if (w.getText().contains("双双")) {
                return w;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        CalculaterTest2 calculaterTest2 = new CalculaterTest2();
        calculaterTest2.setUp();
        calculaterTest2.apiDemo();
        calculaterTest2.tearDown();

    }

}
