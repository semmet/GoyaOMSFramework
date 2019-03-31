package com.triveniit.goya.qa.framework.pages;

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


    public void verifyCustomersPageUrl() throws Throwable{

    delayFor(2000);
    String title = driver.getCurrentUrl();
    Assert.assertEquals("https://portal.goya.com/omsdev/#/customer-details",title);
   }

   public void selectCustomer(){

       WebElement element = driver.findElement(By.xpath("//*[@class='fixed_headers table tclass']/tbody/tr[1]/td[1]"));
       element.click();
   }

    public void getCustInfo() {
        WebElement element = driver.findElement(By.xpath("//*[@class='fixed_headers table tclass']/tbody/tr[1]/td[2]"));
        String custInfo = element.getText();

    }


    public void selectButton() {
       selectButton.click();
       }


   public void alertConfirm(){
       ((JavascriptExecutor)driver).executeScript("arguments[0].click();", alertProceed);

    }



}
