package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpTest extends BaseClass{

    public void setUp(){
        super.setUp();
        //driver.navigate().to("http://www.saksoff5th.com/Entry.jsp");
    }

    @Test
    public void test1(){
        driver.navigate().to("https://www.barnesandnoble.com/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement popupDialogue = null;
        try {
            popupDialogue = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='generic-modal']")));

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Continue Script... ... ...");
        }

        if(popupDialogue != null){
            WebElement closeButton = popupDialogue.findElement(By.xpath(".//a[@class='icon-close-modal']"));
            closeButton.click();
        }

    }

    @Test
    public void test2(){
        driver.navigate().to("http://www.saksoff5th.com/Entry.jsp");

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement popupDialogue = null;
        try {
            popupDialogue = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='generic-modal']")));

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Continue Script... ... ...");
        }

        if(popupDialogue != null){
            WebElement iframe = popupDialogue.findElement(By.xpath("./iframe"));
            driver.switchTo().frame(iframe);

            WebElement closeButton = driver.findElement(By.xpath(".//*[@id='close-button']"));
            closeButton.click();
        }


    }





}
