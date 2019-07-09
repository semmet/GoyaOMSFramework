package com.triveniit.goya.qa.framework.pages;

import com.paxovision.execution.annotations.LogReport;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomersPage extends PageBase{

    @FindBy(xpath ="//*[@id='tabBtnHide']/button[1]")
    private WebElement selectButton;
    @FindBy(xpath ="//*[@class='orangeBtn add-crt-btn1 ng-scope']")
    private WebElement alertProceed;



    public CustomersPage() {
        super();
        PageFactory.initElements(driver,this);
    }

    @LogReport(name = "verifyURL",description = "Customer Page URL should display")
    public void verifyCustomersPageUrl() {

    delayFor(2000);
    String title = driver.getCurrentUrl();
    Assert.assertEquals("https://portal.goya.com/omsdev/#/customer-details",title);
   }


    @LogReport(name = "selectCustomer",description = "Select customer from list")
   public void selectCustomer(){
        WebElement element = driver.findElement(By.xpath("(//*[@type='radio'][@name='1'])[4]"));
       element.click();
   }

    public void getCustInfo() {
        WebElement element = driver.findElement(By.xpath("//*[@class='fixed_headers table tclass']/tbody/tr[1]/td[2]"));
        String custInfo = element.getText();

    }

    @LogReport(name = "clickSelect",description = "Click on Select button")
    public void selectButton() {
       selectButton.click();
       }


    @LogReport(name = "confirmCustomer",description = "Click on alert to confirm customer selection")
    public void alertConfirm(){
       ((JavascriptExecutor)driver).executeScript("arguments[0].click();", alertProceed);

    }



}
