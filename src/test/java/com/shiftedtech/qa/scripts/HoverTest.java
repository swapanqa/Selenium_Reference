package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ElementUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverTest extends BaseClass {


    ElementUtils utils;

    public void setUp() {
        super.setUp();
        driver.navigate().to("http://shifttest.shiftedtech.com/components/hover");
        utils = new ElementUtils(driver);
    }

    @Test
    public void hoverTest() {
        Actions action = new Actions(driver);
        utils.delayFor(5000);
        WebElement element = driver.findElement(By.xpath("//*[@id='hover-01']//button"));
        action.moveToElement(element).perform();
    }

    @Test
    public void hoverJSTest() {
        WebElement element = driver.findElement(By.xpath("//*[@id='hover-01']//button"));
        String mouseOverScript = "if(document.createEvent){" +
                                    "var evObj = document.createEvent('MouseEvents');"
                                    +"evObj.initEvent('mouseover', true, false);"
                                    +"arguments[0].dispatchEvent(evObj);" +
                                "} else if(document.createEventObject) { " +
                                        "arguments[0].fireEvent('onmouseover');" +
                                "}";
        ((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
    }


}
