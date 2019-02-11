package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class CreditAppTestNG extends ScriptBase {

    @BeforeMethod
    public void navigateToCreditAppPage() {
        homePage.navigateToCreditAppPage();
    }


    @Test
    public void submitCreditApp() throws Throwable {

        creditAppPage.enterCorpName();
        creditAppPage.enterStoreName();
        creditAppPage.enterTaxId();
        creditAppPage.enterTelNo();
        creditAppPage.email();
        creditAppPage.yearsAtLocation();
        creditAppPage.yearsInBusiness();
        creditAppPage.yearInc();
        creditAppPage.insuranceCo();
        creditAppPage.policyName();
        creditAppPage.streetAddress();
        creditAppPage.coCity();
        creditAppPage.coState();
        creditAppPage.coZip();
        creditAppPage.billingSame();
        creditAppPage.deliverySame();
        creditAppPage.ownership();
        creditAppPage.creditManager();
        creditAppPage.corpName();
        creditAppPage.guarantor();
        creditAppPage.ownerName();
        creditAppPage.guarantorName();
        creditAppPage.salesBroker();

    }

    @Test
    public void scrollTest() throws Throwable {
        creditAppPage.termsScroll();


    }


    @Test
    public void datePickTest () throws InterruptedException {
        creditAppPage.submitDate();
    }


    @Test
    public void elementTest() throws  Throwable{
        driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']")).click();
        Thread.sleep(3000);

    }
}