package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest extends BaseClass {

    @Test
    public void test1(){
        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
        WebElement from = driver.findElement(By.xpath(".//*[@id='credit2']/a"));
        WebElement to = driver.findElement(By.xpath(".//*[@id='bank']/li"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).build().perform();
    }

    @Test
    public void test2(){
        driver.navigate().to("https://jqueryui.com/slider/");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement slideBar = driver.findElement(By.xpath(".//*[@id='slider']"));
        int width = slideBar.getSize().width;
        System.out.println("Width: " + width);

        WebElement slider = driver.findElement(By.xpath(".//*[@id='slider']/span"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider)
                .moveByOffset(220, 0)
                .build()
                .perform();
    }

    @Test
    public void test3(){
        driver.navigate().to("https://jqueryui.com/slider/");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement slideBar = driver.findElement(By.xpath(".//*[@id='slider']"));
        int width = slideBar.getSize().width;
        System.out.println("Width: " + width);

        WebElement slider = driver.findElement(By.xpath(".//*[@id='slider']/span"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 100, 0)
                .build().perform();

    }
}
