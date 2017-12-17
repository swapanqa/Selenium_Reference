package com.shiftedtech.qa.scripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ButtonTest {


    WebDriver driver;
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
        driver.navigate().to("http://shifttest.shiftedtech.com/components/button");
//        try {
//            driver.navigate().to(new URL("http://shifttest.shiftedtech.com/components/text_box"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void buttonTest1() {
        WebElement element = driver.findElement(By.id("basic-button-01"));
        element.click();
    }

    @Test
    public void buttonTestJSClick() {
        WebElement element = driver.findElement(By.id("basic-button-01"));
        WebElement element1 = driver.findElement(By.id("basic-button-02"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }



}
