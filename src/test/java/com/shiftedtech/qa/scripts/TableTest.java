package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.common.BaseClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class TableTest extends BaseClass{

    @Before
    public void setUpLocalPage(){
        String url = "http://shifttest.shiftedtech.com/components/table";
        driver.navigate().to(url);
    }

    @Test
    public void test(){
        WebElement table = driver.findElement(By.xpath(".//*[@id='html-table']/table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells){
                String cellText = cell.getText();
                System.out.println("Text: " + cellText);
            }
        }
    }

    @Test
    public void test2() {
        WebElement table = driver.findElement(By.xpath(".//*[@id='html-table']/table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(int i = 0; i <rows.size();i++){
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(int j = 0; j < cells.size(); j++){
                WebElement cell = cells.get(j);
                String cellText = cell.getText();
                if(cellText.equals("Mary")) {
                    System.out.println("Text: " + cellText);
                    System.out.println("Row Number: " + i + " ,Cell number: " + j);
                    break;
                }
            }
        }
    }

    @Test
    public void testDup() {
        WebElement table = driver.findElement(By.xpath(".//*[@id='html-table']/table"));
        getTableCellByIndex(table, "Mary");
    }

    @Test
    public void test3(){
        WebElement table = driver.findElement(By.xpath(".//*[@id='html-table']/table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement row = rows.get(2);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        WebElement cell = cells.get(1);
        String cellText = cell.getText();
        System.out.println("Text: " + cellText);
    }

    @Test
    public void test4() {
        WebElement table = driver.findElement(By.xpath(".//*[@id='html-table']/table"));
        getTableCellByIndex(table, 1, 1);
        System.out.println();
    }

    @Test
    public void test5() {
        WebElement table = driver.findElement(By.xpath(".//*[@id='html-table']/table"));
        getTableCellByColumnName(table, 2, "Email");
        System.out.println();
    }

    private WebElement getTableCellByIndex(WebElement table, int rowIndex, int columnIndex) {
        WebElement tableReturnCell = null;
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        WebElement row = rows.get(rowIndex);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if(cells != null && cells.size()> 0) {
            tableReturnCell = cells.get(columnIndex);
            String cellText = tableReturnCell.getText();
            System.out.println(cellText);
        }
        System.out.println(tableReturnCell);
        return tableReturnCell;
    }

    private WebElement getTableCellByIndex(WebElement table, String string) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement cell = null;
        for(int i = 0; i <rows.size();i++){
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(int j = 0; j < cells.size(); j++){
                cell = cells.get(j);
                String cellText = cell.getText();
                if(cellText.equals("Mary")) {
                    System.out.println("Text: " + cellText);
                    System.out.println("Row Number: " + i + " ,Cell number: " + j);
                    break;
                }
            }
        }
        return cell;
    }

    private WebElement getTableCellByColumnName(WebElement table, int rowIndex, String columnName) {
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        List<WebElement> columnHeaders = table.findElements(By.tagName("th"));
        HashMap<String, Integer> columnIndex = new HashMap<>();
        for(int i = 0; i < columnHeaders.size(); i++){
            String headerText = columnHeaders.get(i).getText().toUpperCase();
            columnIndex.put(headerText, i);
        }
        System.out.println(columnIndex);
        return getTableCellByIndex(table, rowIndex, columnIndex.get(columnName.toUpperCase()));
    }

    private WebElement getTableCellByColumnNameDup(WebElement table, int rowIndex, String columnName) {
        WebElement tableReturnCell = null;
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        WebElement row = rows.get(rowIndex);
        List<WebElement> columnHeaders = table.findElements(By.tagName("th"));
        HashMap<String, Integer> columnIndex = new HashMap<>();
        for(int i = 0; i < columnHeaders.size(); i++){
            String headerText = columnHeaders.get(i).getText().toUpperCase();
            columnIndex.put(headerText, i);
        }
        System.out.println(columnIndex);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if(cells != null && cells.size()> 0) {
            tableReturnCell = cells.get(columnIndex.get(columnName.toUpperCase()));
            String cellText = tableReturnCell.getText();
            System.out.println(cellText);
        }
        System.out.println(tableReturnCell);
        return tableReturnCell;
    }

}
