package com.shiftedtech.qa.scripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TextBoxTest {

    WebDriver driver;
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
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
        driver.navigate().to("http://shifttest.shiftedtech.com/components/text_box");
//        try {
//            driver.navigate().to(new URL("http://shifttest.shiftedtech.com/components/text_box"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void test() {
        WebElement element = driver.findElement(By.id("plain-text"));
        element.sendKeys("hello selenium");
    }

    @Test
    public void test2() {
        WebElement element = driver.findElement(By.id("password"));
        element.sendKeys("hello selenium");
    }

    @Test
    public void testDataBox() {
        WebElement element = driver.findElement(By.xpath("//*[@class='form-group']//input[@type='date']"));
        element.sendKeys("12102017");
    }

    @Test
    public void testDataBoxComplex() {
        WebElement element = driver.findElement(By.xpath("//*[@class='form-group']//input[@type='date']"));
        element.click();
        // month
        for(int i = 0; i < 12; i++) {
            element.sendKeys(Keys.ARROW_UP);
        }
        element.sendKeys(Keys.TAB);
        // day
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.TAB);
        // year
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.TAB);
    }

    @Test
    public void testDataTimeBox() {
        WebElement element = driver.findElement(By.xpath("//*[@class='form-group']//input[@type='datetime-local']"));
        element.sendKeys("12102017\t1200PM");
    }

}
