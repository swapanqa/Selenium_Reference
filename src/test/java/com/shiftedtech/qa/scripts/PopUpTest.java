package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ElementUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PopUpTest extends BaseClass{

    public void setUp(){
        super.setUp();
        //driver.navigate().to("http://www.saksoff5th.com/Entry.jsp");
    }

  //  @Test
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

  //  @Test
    public void test3(){

        driver.navigate().to("https://www.barnesandnoble.com/b/books/_/N-29Z8q8");
        ElementUtils.delayFor(5000);;

        WebElement signinLink = driver.findElement(By.id("signInLink"));
        signinLink.click();

        switchToIfrmae("loginFrame");
        WebElement createAccount = driver.findElement(By.xpath(".//*[@id='createAccountBtn']"));
        createAccount.click();

    }

    public void switchToIfrmae(String str) {
        if (str.contentEquals("loginFrame")) {
            List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
            System.out.println("Number of Iframe: " + iframeList.size());

            for (WebElement ifamre : iframeList) {
                String src = ifamre.getAttribute("src");
                System.out.println("Src" + src);
                if (src.contains("/www.barnesandnoble.com/account/login-frame-ra")) {
                    System.out.println("Iframe Found");
                    driver.switchTo().frame(ifamre);
                    break;
                }
            }
        }

        if (str.contentEquals("registerFrame")){
            List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
            System.out.println("Number of Iframe: " + iframeList.size());

            for(WebElement ifamre : iframeList){
                String src = ifamre.getAttribute("src");
                System.out.println("Src" + src);
                if(src.contains("/www.barnesandnoble.com/account/register-frame-ra")){
                    System.out.println("Iframe Found");
                    driver.switchTo().frame(ifamre);
                    break;
                }
            }
        }
    }




}
