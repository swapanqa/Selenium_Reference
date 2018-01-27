package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinksTest extends BaseClass {

    public static List<WebElement> findAllLinks(WebDriver driver)

    {
        List<WebElement> elementList = new ArrayList<>();
        elementList = driver.findElements(By.tagName("a"));
        elementList.addAll(driver.findElements(By.tagName("img")));
        List finalList = new ArrayList(); ;
        for (WebElement element : elementList)
        {
            if(element.getAttribute("href") != null)
            {
                finalList.add(element);
            }
        }
        return finalList;
    }

    public static String isLinkBroken(URL url)
    {
        String response = "";

        try
        {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            response = connection.getResponseMessage();
            connection.disconnect();
            return response;
        }
        catch(IOException exp)
        {
            return exp.getMessage();
        }
    }

    public static void main(String[] args) throws Exception {

        // FOR WINDOWS USERS
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
        // FOR MAC USERS
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        //ff.get("http://www.yahoo.com/");

        List<WebElement> allImages = findAllLinks(driver);

        System.out.println("Total number of elements found " + allImages.size());

        for( WebElement element : allImages){
            try
            {
                System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
                //System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
            }
            catch(Exception exp)
            {
                System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());
            }
        }
    }
}
