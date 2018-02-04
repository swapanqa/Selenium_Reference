package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ExplicitWaitUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

public class ExpicitWaitTest extends BaseClass{

    ExplicitWaitUtils wait = new ExplicitWaitUtils(driver);

    @Test
    public void test1(){

        driver.navigate().to("https://www.barnesandnoble.com/b/books/_/N-29Z8q8");
        //WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement sinin = driver.findElement(By.xpath(".//*[@id='signInLink']"));
       // wait.until(ExpectedConditions.visibilityOf(sinin));
        sinin.click();

      /*

        By signInLink = By.xpath(".//*[@id='signInLink']");
        wait.waitForElement(signInLink, 5);
        signInLink.hashCode()*/
    }
}
