package com.triveniit.goya.qa.framework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CreditAppPage extends PageBase {

    @FindBy(xpath = "//*[@name='corprateName']")
    private WebElement corporateName;
    @FindBy(xpath = "//*[@name='tradeStoreName']")
    private WebElement storeName;
    @FindBy(xpath = "//*[@name='federalTaxIdNo']")
    private WebElement taxIdNo;
    @FindBy(xpath = "//*[@name='storeTelephone']")
    private WebElement storeTelNo;
    @FindBy(xpath = "//*[@ng-model='deliveryEmail']")
    private WebElement email;
    @FindBy(xpath = "//*[@name='periodAtLocation']")
    private WebElement yearsAtLocation;
    @FindBy(xpath = "//*[@name='periodInBusiness']")
    private WebElement yearsInBusiness;
    @FindBy(xpath = "//*[@name='corporationYear']")
    private WebElement yearInc;
    @FindBy(xpath = "//*[@name='insuranceCompanyName']")
    private WebElement insuranceCo;
    @FindBy(xpath = "//*[@name='policy']")
    private WebElement policyName;
    @FindBy(xpath = "//*[@name='companySreetAddress']")
    private WebElement streetAddress;
    @FindBy(xpath = "//*[@name='companyCity']")
    private WebElement coCity;
    @FindBy(xpath = "//*[@name='companyState']")
    private WebElement coState;
    @FindBy(xpath = "//*[@name='companyZip']")
    private WebElement coZip;
    @FindBy(xpath = "//*[@ng-model='CreditManeger']")
    private WebElement creditManager;
    @FindBy(xpath = "//*[@ng-model='CorporationName']")
    private WebElement corpName;
    @FindBy(xpath = "//*[@ng-model='SignatureFirst']")
    private WebElement guarantor;
    @FindBy(xpath = "//*[@ng-model='SignatureSecond']")
    private WebElement ownerName;
    @FindBy(xpath = "//*[@ng-model='Witnessname']")
    private WebElement guarantorName;
    @FindBy(xpath = "//*[@ng-model='SalesBroker']")
    private WebElement brokerName;
    @FindBy(xpath = "//*[@id='Terms']")
    private WebElement terms;
    @FindBy(xpath = "//*[@id='Personal']")
    private WebElement guarantee;
    @FindBy(xpath = "//*[@id='agree']")
    private WebElement termsAgree;
    @FindBy(id = "personalchk")
    private WebElement personalAgree;
    @FindBy(xpath = "//*[@ng-model='companyAddSame']")
    private WebElement billingAddress;
    @FindBy(xpath = "//*[@ng-model='deleveryAddSame']")
    private WebElement deliveryAddress;
    @FindBy(xpath = "//*[@ng-model='second']")
    private WebElement individOwner;
    @FindBy(xpath = "//*[@id='dp1549649073675']")
    private WebElement dateSelect;
    @FindBy(id = "submitbutton")
    private WebElement submitApp;


    public CreditAppPage() {
        super();
        PageFactory.initElements(driver,this);
    }


    public void enterCorpName(){typeText(corporateName,"Bobs Burgers");}
    public void enterStoreName() {typeText(storeName,"Bobs Burgers");}
    public void enterTaxId(){typeText(taxIdNo,"123456789");}
    public void enterTelNo() {typeText(storeTelNo,"2121231234");}
    public void email() {typeText(email, "bobsburgers@gmail.com");}
    public void yearsAtLocation(){typeText(yearsAtLocation,"5 years");}
    public void yearsInBusiness(){typeText(yearsInBusiness,"5 years");}
    public void yearInc(){typeText(yearInc,"N/A");}
    public void insuranceCo(){typeText(insuranceCo,"Best Insurance");}
    public void policyName(){typeText(policyName,"Best Policy");}
    public void streetAddress(){typeText(streetAddress,"71 Union Ave.");}
    public void coCity(){typeText(coCity,"Rutherford");}
    public void coState(){typeText(coState,"New Jersey");}
    public void coZip(){typeText(coZip,"07070");}
    public void creditManager(){typeText(creditManager,"Manager");}
    public void corpName(){typeText(corpName,"Bobs Burgers");}
    public void guarantor(){typeText(guarantor,"Guarantor");}
    public void ownerName(){typeText(ownerName,"Owner");}
    public void guarantorName(){typeText(guarantorName,"Guarantor");}
    public void salesBroker(){typeText(brokerName,"Sales Broker");}


    public void termsScroll() throws Throwable {

            WebElement element = driver.findElement(By.xpath("//*[@id='Terms']"));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", element);

            Thread.sleep(2000);

            driver.findElement(By.id("agree")).click();

        }


    public void guaranteeScroll()throws Throwable {
        WebElement element = driver.findElement(By.xpath("//*[@id='Terms']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", element);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='agree']")).click();
    }

    public void billingSame(){
        billingAddress.click();
    }

    public void deliverySame(){
        deliveryAddress.click();
    }

    public void ownership(){
        individOwner.click();
    }

    public void submitDate()throws InterruptedException{

        /*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String date = dateFormat.format(today);

        WebElement dateWidget = driver.findElement(By.xpath("//*[@class='group']"));

        Thread.sleep(3000);
        List<WebElement> columns = dateWidget.findElements(By.tagName("div"));
        Thread.sleep(3000);

        for (WebElement cell : columns) {
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
    }*/
        /*driver.findElement(By.xpath("//*[@ng-model='vm.signdate']")).click();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        String date1= dateFormat.format(date);
        d = datetime.date.fromordinal(datetime.date.today().toordinal()-7).strftime("%m/%d/%Y");
        date1.send_keys(d) */

        Actions actions = new Actions(driver);
        actions.moveToElement(dateSelect);
        actions.click();
        actions.sendKeys("02/08/2019");
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();

    }

    public void submitApp(){
        submitApp.click();
    }
}









