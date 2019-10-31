package com.ctillnow.appium;

import com.ctillnow.util.AppiumUtil;
import com.sun.deploy.association.utility.AppUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import java.io.IOException;
import java.net.URL;
import java.util.List;


import io.appium.java_client.android.AndroidKeyCode;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



/**
 * Created by author on 2018/1/9.
 */
public class CalculaterTest2 {
    private AndroidDriver driver;


    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "5JP0218313002673"); //指定测试机的ID,通过adb命令`adb devices`获取
        //cap.setCapability("deviceName", "HKL4ZEL3"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "9.1");

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

    public void addAddressBook() throws InterruptedException {
        Thread.sleep(10000);
        List<WebElement> list = driver.findElements(By.xpath("//android.view.View"));
        getTarget(list,"测试").click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@content-desc, '聊天信息')]")).click();
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 800);
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 800);
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@content-desc, '已关闭')]"));
            elements.get(2).click();

        }catch (Exception e){
            System.out.println("已保存到通讯录");
        }
    }


    public void addUsers(int maxCount) throws Exception {
        Thread.sleep(10000);
        List<WebElement> list = AppiumUtil.findElementsWait(driver,By.xpath("//android.view.View"),1);
        getTarget(list,"品牌仓库").click();
        Thread.sleep(3000);
        AppiumUtil.findElement(driver,By.xpath("//*[contains(@content-desc, '聊天信息')]")).click();
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        AppiumUtil.swipeUpHalf(driver);
        //driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 800);
        Thread.sleep(2000);
        WebElement element = AppiumUtil.findElementWait(driver,By.xpath("//android.widget.TextView[@text='查看全部群成员']"),1);
        element.click();
        Thread.sleep(2000);

        AppiumUtil.swipeUp(driver);
       // driver.swipe(width / 2, height / 4, width / 2, height* 3 / 4, 800);
        //Thread.sleep(3000);
        List<WebElement> elements = AppiumUtil.findElementsWait(driver,By.xpath("//android.widget.ImageView"),1);

        /**
         *
         * 几种点击情况
         *    已经添加过  *
         * 1. 点击添加出现 对方账号异常，无法添加朋友
         *    点击添加，直接加上好友无需发送消息 *
         * 2. 点击添加对方设置权限，弹出无法添加 *
         * 3.
         * 4.点击添加，点击发送报 异常
         * 5.点击添加，点击发送通过
         * 6.
         *
         */
        int i=0;
        for(WebElement element1 :elements){
            if(i>5&&(i-6)<maxCount){
                element1.click();
                Thread.sleep(2000);
                if(AppiumUtil.findElement(driver,By.xpath("//android.widget.TextView[@text='发消息']"))!=null){
                    driver.pressKeyCode(AndroidKeyCode.BACK);
                    i++;
                    continue;

                }
                driver.findElement(By.xpath("//android.widget.TextView[@text='添加到通讯录']")).click();
                Thread.sleep(2000);
                if(AppiumUtil.findElement(driver,By.xpath("//android.widget.TextView[@text='发消息']"))!=null){
                    driver.pressKeyCode(AndroidKeyCode.BACK);


                }else if(AppiumUtil.findElement(driver,By.xpath("//android.widget.Button[@text='确定']"))!=null){
                    driver.pressKeyCode(AndroidKeyCode.BACK);
                    Thread.sleep(2000);
                    driver.pressKeyCode(AndroidKeyCode.BACK);

                }else if( AppiumUtil.findElement(driver,By.xpath("//android.widget.TextView[@text='添加到通讯录']"))!=null){
                    driver.pressKeyCode(AndroidKeyCode.BACK);
                } else {
                    WebElement button;
                    if( ( button=   AppiumUtil.findElement(driver,By.xpath("//android.widget.Button[@text='发送']")))!=null){
                        button.click();
                        if(AppiumUtil.findElement(driver,By.xpath("//android.widget.TextView[@text='添加到通讯录']"))==null)
                            driver.pressKeyCode(AndroidKeyCode.BACK);

                        }
                    driver.pressKeyCode(AndroidKeyCode.BACK);
                }

                }
                 i++;
            }


        }




    public void apiDemo() throws InterruptedException, IOException {
        Thread.sleep(5000);
        List<WebElement> list = driver.findElements(By.xpath("//*[@resource-id='com.tencent.mm:id/b9i']"));
        if(list == null)
            return;
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (; ; ) {
            WebElement target = getTarget(list,"测试");
            if (target != null) {
                target.click();
                Thread.sleep(500);
                driver.findElement(By.xpath("//android.widget.EditText")).click();
                driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("测试消息朱炎是条dog");
                Thread.sleep(100);
                driver.findElement(By.xpath("//android.widget.Button[@text='发送']")).click();
                break;
            } else {
                System.out.println("出错了----------------");
                driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 800);
                Thread.sleep(100);
                list = driver.findElementsById("com.tencent.mm:id/apt");
            }
        }
    }


    WebElement getTarget(List<WebElement> list,String keyword) throws InterruptedException {
        for (WebElement w : list) {
            boolean b =  w.getText().contains(keyword);
            if (b) {
                return w;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        CalculaterTest2 calculaterTest2 = new CalculaterTest2();
        calculaterTest2.setUp();
        //calculaterTest2.apiDemo();
        //calculaterTest2.addAddressBook();
        calculaterTest2.addUsers(20);
        calculaterTest2.tearDown();

    }

}
