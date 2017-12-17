package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxTest extends BaseClass{

    public void setUp() {
        super.setUp();
        driver.navigate().to("http://shifttest.shiftedtech.com/components/check_box");
    }

    @Test
    public void checkBoxTest1() {
        WebElement element = driver.findElement(By.id("css-chk-box-01"));
        if(element.getAttribute("checked") == null || element.getAttribute("checked").equals("false")) {
            element.click();
        }
    }

}
