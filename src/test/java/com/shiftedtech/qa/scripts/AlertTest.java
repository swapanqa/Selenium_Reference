package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ElementUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertTest extends BaseClass {

    ElementUtils utils;

    public void setUp() {
        super.setUp();
        driver.navigate().to("http://shifttest.shiftedtech.com/components/alert");
        utils = new ElementUtils(driver);
    }

    @Test
    public void alertPopupTest() {
        WebElement element = driver.findElement(By.id("alert-01"));
        element.click();
        utils.delayFor(5000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void alertConfirmTest() {
        WebElement element = driver.findElement(By.id("alert-02"));
        element.click();
        utils.delayFor(5000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void alertDialogTest() {
        WebElement element = driver.findElement(By.id("alert-03"));
        element.click();
        utils.delayFor(5000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("iivaan");
        utils.delayFor(5000);
        driver.switchTo().alert().accept();
    }
}
