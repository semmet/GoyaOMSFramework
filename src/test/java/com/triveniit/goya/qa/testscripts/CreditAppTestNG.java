package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;

import com.triveniit.goya.qa.framework.utils.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class CreditAppTestNG extends ScriptBase {

    @BeforeMethod
    public void navigateToCreditAppPage() {
        homePage.navigateToCreditAppPage();
    }


    @Test (dataProvider = "creditAppExcelData",description = "verifies full long-form submission")
    public void submitCreditAppFull(String corpName, String storeName, String taxID, String telNo, String yearsLoc,
                                    String yearsBus, String inc, String insCo, String policy, String address,
                                    String city, String state, String zip)  {

        creditAppPage.creditExcelData( corpName, storeName, taxID, telNo, yearsLoc,yearsBus,
                inc, insCo, policy, address, city, state, zip );

        creditAppPage.billingSame();
        creditAppPage.deliverySame();
        creditAppPage.businessType();
        creditAppPage.clickCreditFormButton();
        creditAppPage.termsScroll();
        creditAppPage.guaranteeScroll();
        creditAppPage.submitDate();
        creditAppPage.creditManager();
        creditAppPage.corpName();
        creditAppPage.guarantor();
        creditAppPage.ownerName();
        creditAppPage.guarantorName();
        creditAppPage.salesBroker();
        creditAppPage.submitApp();
        creditAppPage.acceptAlert();
    }


    @Test(dataProvider = "creditAppExcelData2", description = "Verifies all required fields are needed to blitz submit form")
    public void verifyReqDataBlitz(String corpName, String storeName, String taxID, String telNo, String yearsLoc,
                                  String yearsBus, String inc, String insCo, String policy, String address,
                                  String city, String state, String zip ){

        creditAppPage.creditExcelData( corpName, storeName, taxID, telNo, yearsLoc,yearsBus,
                                       inc, insCo, policy, address, city, state, zip );
        creditAppPage.billingSame();
        creditAppPage.deliverySame();
        creditAppPage.businessType();
        creditAppPage.submitApp();
        creditAppPage.verifyMissingDataAlertPresent();
    }


    @Test (dataProvider = "creditAppExcelData",description = "Verifies all required fields are needed to blitz submit form")
    public void blankBillingAndDeliveryAddress(String corpName, String storeName, String taxID, String telNo, String yearsLoc,
                                    String yearsBus, String inc, String insCo, String policy, String address,
                                    String city, String state, String zip) {

        creditAppPage.creditExcelData(corpName, storeName, taxID, telNo, yearsLoc, yearsBus,
                inc, insCo, policy, address, city, state, zip);
        creditAppPage.submitApp();
        creditAppPage.verifyMissingDataAlertPresent();
    }

    @Test (dataProvider = "creditAppExcelData",description = "Verifies all required fields are needed to blitz submit form")
    public void blankDeliveryAddress(String corpName, String storeName, String taxID, String telNo, String yearsLoc,
                                               String yearsBus, String inc, String insCo, String policy, String address,
                                               String city, String state, String zip) {

        creditAppPage.creditExcelData(corpName, storeName, taxID, telNo, yearsLoc, yearsBus,
                inc, insCo, policy, address, city, state, zip);
        creditAppPage.billingSame();
        creditAppPage.submitApp();
        creditAppPage.verifyMissingDataAlertPresent();
    }




    @DataProvider
    public static Object[][] creditAppExcelData(){
        Object[][] data = null;
        String dataFile = System.getProperty("user.dir") + "/src/test/resources/GoyaCreditAppData.xlsx";

        ExcelReader reader = new ExcelReader(dataFile);
        data = reader.getExcelSheetData("Sheet1",true);
        return data;
    }

    @DataProvider
    public static Object[][] creditAppExcelData2(){
        Object[][] data = null;
        String dataFile = System.getProperty("user.dir") + "/src/test/resources/GoyaCreditAppData.xlsx";

        ExcelReader reader = new ExcelReader(dataFile);
        data = reader.getExcelSheetData("Sheet2",true);
        return data;
    }

}