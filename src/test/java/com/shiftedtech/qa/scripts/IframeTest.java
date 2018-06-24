package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ElementUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IframeTest extends BaseClass{

    private ElementUtils elementUtils;
    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to("http://toolsqa.com/iframe-practice-page/");
        elementUtils = new ElementUtils(driver);
    }

    @Test
    public void selectByNameTest() {
        driver.switchTo().frame("iframe1");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("iivaan");
        driver.switchTo().defaultContent();
    }

    @Test
    public void selectByIndexTest() {
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//a[contains(@href, '/components/text_box')]")).click();
    }

    @Test
    public void selectByWebElementTest() {
        List<WebElement> iFrameList = driver.findElements(By.xpath("//iframe"));
        for(WebElement iframe: iFrameList) {
             if(iframe.getAttribute("src").contains("components")) {
                 driver.switchTo().frame(iframe);
                 break;
             }
        }
        driver.findElement(By.xpath("//a[contains(@href, '/components/text_box')]")).click();
    }


}
