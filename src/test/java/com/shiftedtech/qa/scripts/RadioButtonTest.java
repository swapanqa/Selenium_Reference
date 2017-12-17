package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButtonTest extends BaseClass {

    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to("http://shifttest.shiftedtech.com/components/radio_button");
    }

    @Test
    public void radioButtonTest1() {
        WebElement element = driver.findElement(By.id("radio-group-1"));
        element.click();
    }
}
