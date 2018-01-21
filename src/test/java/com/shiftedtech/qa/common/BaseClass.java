package com.shiftedtech.qa.common;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * ./
 .//
 //input[@id = 'radio-group-1']
 /html/body/div/div/div/div/div/div/form
 /div/div/label/input[@id = 'radio-group-1']

 //form/div[1]/button[@class = 'btn btn-primary clicked']

 text()

 //*[text() = 'Primary']
 //*[@id ='basic-button-01' and text() = 'Primary']

 contains()
 //*[@id='basic-button-01' and contains(text(),  'imary')]

 //*[ @id = 'basic-button-01']/../preceding-sibling::label
 */
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
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");

        driver = new ChromeDriver();
       // FirefoxDriverManager.firefoxdriver().setup();
       // driver = new FirefoxDriver();

       // driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        driver.get("http://shifttest.shiftedtech.com/components/text_box");
        //driver.navigate().to("http://shifttest.shiftedtech.com/components/text_box");
//        try {
//            driver.navigate().to(new URL("http://shifttest.shiftedtech.com/components/text_box"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
}
