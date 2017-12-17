package com.shiftedtech.qa.common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver = null;
    @After
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }
    @Before
    public void setUp() {
        // FOR WINDOWS USERS
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
        // FOR MAC USERS
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.get("http://shifttest.shiftedtech.com/components/text_box");
        //driver.navigate().to("http://shifttest.shiftedtech.com/components/text_box");
//        try {
//            driver.navigate().to(new URL("http://shifttest.shiftedtech.com/components/text_box"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
}
