package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ElementUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

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
        WebElement element = driver.findElement(By.xpath(".//*[@id='hover-02']//a[@id='dropdown-menu-hover-01']"));
        hoverLocatable(element);
    }

    /**
     * Mouse Hover element with Action class
     * @param element
     */
    private void hoverAction(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Mouse Hover element with Locatable and Mouse class
     * @param element
     */
    private void hoverLocatable(WebElement element){
        Locatable hoverItem = (Locatable) element;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
    }
}
