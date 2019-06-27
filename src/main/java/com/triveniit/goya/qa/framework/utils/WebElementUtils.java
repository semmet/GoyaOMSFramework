package com.triveniit.goya.qa.framework.utils;

import com.paxovision.execution.annotations.LogReport;
import cucumber.api.java.eo.Se;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WebElementUtils extends SeleniumUtils {

       public WebElementUtils(){super();}

       public By getFindBy(String by, String using) {

           if (by.trim().toUpperCase().contentEquals("ID")) {
               return By.id(using);
           } else if (by.trim().toUpperCase().contentEquals("NAME")){
               return By.name(using);
           } else if (by.trim().toUpperCase().contentEquals("XPATH")){
               return By.xpath(using);
           } else if (by.trim().toUpperCase().contentEquals("CSS")){
               return By.cssSelector(using);
           } else if (by.trim().toUpperCase().contentEquals("CLASS_NAME")){
               return By.className(using);
           } else if (by.trim().toUpperCase().contentEquals("TAG_NAME")){
               return By.tagName(using);
           } else if (by.trim().toUpperCase().contentEquals("LINK_TEXT")){
               return By.linkText(using);
           } else if (by.trim().toUpperCase().contentEquals("PARTIAL_LINK_TEXT")){
               return By.partialLinkText(using);
           } else{
               return null;
           }
       }

       public void typeText (By by, String text){
           WebElement element = waitForElementDisplayed(by, SeleniumUtils.DEFAULT_WAIT_TIME);
           typeText(element, text);
       }

       public void typeText(WebElement element, String text){
           highlight(element);
           element.clear();
           element.sendKeys(text);
       }

       public void click(By by){
           WebElement element = waitForElementDisplayed(by, SeleniumUtils.DEFAULT_WAIT_TIME);
           click(element);
       }

       public void click(WebElement element){
           highlight(element);
           element.click();
       }

       public void verifyText(By by, String textToVerify){
           WebElement element = waitForElementDisplayed(by, 10);
           String actualText = element.getText();
           assertThat(actualText,equalTo(textToVerify));
       }

       public void verifyItemQty(By by, String textToVerify){
           WebElement element = waitForElementDisplayed(by, 10);
           String actualText = element.getText();
           assertThat(actualText, CoreMatchers.containsString(textToVerify));
    }

       @LogReport(name = "verifyAlertMessage", description = "Confirm correct alert message is displayed")
       public void verifyAlertMessage(String alertMessage){
           delayFor(2000);
           Alert alert = driver.switchTo().alert();
           String alertText = alert.getText();
           assertThat(alertText,CoreMatchers.containsString(alertMessage));
           delayFor(2000);
           alert.accept();
    }


    public String[][] getCellTextArray(WebElement table){
           String[][] tableText = null;
           List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
           tableText = new String[rows.size()][];
           for(int i = 0 ; i < rows.size(); i++){
               WebElement row = rows.get(i);
               List<WebElement> cols = row.findElements(By.tagName("td"));
               tableText[i] = new String[cols.size()];
               for(int j = 0; j < cols.size(); j++){
                   WebElement col = cols.get(j);
                   String text = col.getText();
                   tableText[i][j]=text;
                //System.out.println("Cell text [" + i + "," + j + "]: " + text);
            }
        }

           return  tableText;
    }


}
