package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ElementUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowHandleTest extends BaseClass{
    ElementUtils utils;

    public void setUp() {
        super.setUp();
        driver.navigate().to("http://shifttest.shiftedtech.com/components/windows");
        utils = new ElementUtils(driver);
    }

    @Test
    public void windowHandleTest() {
        WebElement element = driver.findElement(By.xpath("//*[@id='window-01']/button"));
        element.click();

        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());
        for(String s: windows) {
            if(!s.equals(currentWindow)) {
                driver.switchTo().window(s);
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(currentWindow);
        System.out.println(driver.getCurrentUrl());
    }
}
