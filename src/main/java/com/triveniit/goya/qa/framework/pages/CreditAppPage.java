package com.triveniit.goya.qa.framework.pages;



import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;
import java.util.List;




public class CreditAppPage extends PageBase {

    @FindBy(xpath = "//*[@name='corprateName']")
    private WebElement corporateName;
    @FindBy(xpath = "//*[@name='tradeStoreName']")
    private WebElement tradeStoreName;
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
    private WebElement corpName2;
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
    @FindBy(xpath = "//*[@id='personalchk']")
    private WebElement personalAgree;
    @FindBy(xpath = "//*[@ng-model='companyAddSame']")
    private WebElement billingAddress;
    @FindBy(xpath = "//*[@ng-model='deleveryAddSame']")
    private WebElement deliveryAddress;
    @FindBy(xpath = "//*[@ng-model='second']")
    private WebElement individOwner;
    @FindBy(xpath = "//*[@id='btncredit']")
    private WebElement creditFormButton;
    @FindBy(xpath = "//*[@id='submitbutton']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id='submitbutton1']")
    private WebElement alertConfirmSubmit;




    public CreditAppPage() {
        super();
        PageFactory.initElements(driver, this);
    }


    public void enterCorpName() {
        typeText(corporateName, "Auto Test");
    }

    public void enterStoreName() {
        typeText(tradeStoreName, "Auto Test");
    }

    public void enterTaxId() {
        typeText(taxIdNo, "123456789");
    }

    public void enterTelNo() {
        typeText(storeTelNo, "2121231234");
    }

    public void email() {
        typeText(email, "autotest@gmail.com");
    }

    public void yearsAtLocation() {
        typeText(yearsAtLocation, "5 years");
    }

    public void yearsInBusiness() {
        typeText(yearsInBusiness, "5 years");
    }

    public void yearInc() {
        typeText(yearInc, "2014");
    }

    public void insuranceCo() {
        typeText(insuranceCo, "Best Insurance");
    }

    public void policyName() {
        typeText(policyName, "Best Policy");
    }

    public void streetAddress() {
        typeText(streetAddress, "71 Union Ave.");
    }

    public void coCity() {
        typeText(coCity, "Rutherford");
    }

    public void coState() {
        typeText(coState, "New Jersey");
    }

    public void coZip() {
        typeText(coZip, "07070");
    }

    public void creditManager() {
        typeText(creditManager, "Manager");
    }

    public void corpName() {
        typeText(corpName2, "Auto Test");
    }

    public void guarantor() {
        typeText(guarantor, "Guarantor");
    }

    public void ownerName() {
        typeText(ownerName, "Owner");
    }

    public void guarantorName() {
        typeText(guarantorName, "Guarantor");
    }

    public void salesBroker() {
        typeText(brokerName, "Sales Broker");
    }


    public void termsScroll() {

        WebElement element = driver.findElement(By.xpath("//*[@id='Terms']"));
        scrollToElement(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", element);
        termsAgree.click();

    }

    public void guaranteeScroll() {

        WebElement element = driver.findElement(By.xpath("//*[@id='Personal']"));
        scrollToElement(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", element);
        personalAgree.click();
    }

    public void guaranteeClick(){
        WebElement element = driver.findElement(By.xpath("//*[@id='personalchk']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void billingSame() { billingAddress.click(); }

    public void deliverySame() { deliveryAddress.click(); }

    public void businessType() { individOwner.click(); }

    public void clickCreditFormButton() { creditFormButton.click(); }

    public void submitDate() {

        String todayDate = String.valueOf((Calendar.getInstance()).get(Calendar.DAY_OF_MONTH));

        driver.findElement(By.xpath("//*[@class='datepicker hasDatepicker ng-pristine ng-invalid ng-invalid-required']")).click();

        List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//td"));
        for (WebElement ele : allDates) {
            String date = ele.getText();
            if (date.equals(todayDate)) {
                ele.click();
                System.out.println(" Today's date was " + todayDate);
                break;

            }

        }

    }

    public void submitApp() { saveButton.click(); }

    public void acceptAlert() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertConfirmSubmit);
    }

    public void creditExcelData(String corpName, String storeName, String taxID, String telNo, String yearsLoc, String yearsBus,
                                String inc, String insCo, String policy, String address, String city, String state,
                                String zip) {
        typeText(corporateName, corpName);
        typeText(tradeStoreName, storeName);
        typeText(taxIdNo, taxID);
        typeText(storeTelNo, telNo);
        typeText(yearsAtLocation, yearsLoc);
        typeText(yearsInBusiness, yearsBus);
        typeText(yearInc, inc);
        typeText(insuranceCo, insCo);
        typeText(policyName, policy);
        typeText(streetAddress, address);
        typeText(coCity, city);
        typeText(coState, state);
        typeText(coZip, zip);

    }

    public void verifyMissingDataAlertPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
        if(wait.until(ExpectedConditions.alertIsPresent())==null){
            System.out.println("alert was not present");
        }
        else
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("alert was present and accepted");
        }

    }

}






