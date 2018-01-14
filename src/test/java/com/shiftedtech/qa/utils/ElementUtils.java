package com.shiftedtech.qa.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
    private WebDriver driver;
    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void highlight(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
            delayFor(200);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(2000);
        }
    }
    public static void delayFor(int timeinMili) {
        try {
            Thread.sleep(timeinMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollByPixel(int pixel) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"+pixel+")", "");
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        delayFor(3000);
    }
}
