package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import com.shiftedtech.qa.utils.ElementUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownButtonTest extends BaseClass{

    private ElementUtils elementUtils;
    @Override
    public void setUp() {
        super.setUp();
        driver.navigate().to("http://shifttest.shiftedtech.com/components/dropdown_menu");
        elementUtils = new ElementUtils(driver);
    }

    @Test
    public void selectByVisibleTextTest1() {
        WebElement element = driver.findElement(By.xpath("//div[@id='html-select-01']/select"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 2");
    }

    @Test
    public void selectByValueTest1() {
        WebElement element = driver.findElement(By.xpath("//div[@id='html-select-01']/select"));
        Select select = new Select(element);
        select.selectByValue("Option 4");
    }

    @Test
    public void selectByIndexTest1() {
        WebElement element = driver.findElement(By.xpath("//div[@id='html-select-01']/select"));
        Select select = new Select(element);
        select.selectByIndex(2);
    }

    @Test
    public void dropdownTest1() {
        driver.findElement(By.xpath("//button[@id='dropdown-menu-basic']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.xpath("//button[@id='dropdown-menu-basic']/following-sibling::ul/li/a"));
        selectDropDown(elements, "Action");
    }
    @Test
    public void multiSelectDropdownTest1() {
        elementUtils.scrollByPixel(350);
        driver.findElement(By.xpath("//*[@class='form-group']//button[@title='Nothing selected']/span[1]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='form-group']//button[@title='Nothing selected']/following-sibling::div//li/a/span[@class = 'text']"));
        selectDropDown(elements, "Mustard", "Ketchup", "Relish");
    }

    /**
     * select menu item from modern bootstrap dropdown
     * @param elements
     * @param text
     */
    private void selectDropDown(List<WebElement> elements, String... text) {
        List<String> elementTexts = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < elements.size(); i++) {
            String s = elements.get(i).getText();
            elementTexts.add(s);
            if(j == text.length) {
                break;
            }else {
                if (text[j].equals(elementTexts.get(i))) {
                    elements.get(i).click();
                    j++;
                }
            }
//            if(j == text.length) {
//                break;
//            }else {
//                if (text[j].equals(elements.get(i).getText())) {
//                    elements.get(i).click();
//                    j++;
//                }
//            }
        }
    }

    private void simpleSelectFromDropDown() {

    }

}
