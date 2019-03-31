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
        creditAppPage.businessType();
        //creditAppPage.creditFormButton();
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

        creditAppPage.verifySubmitButtonNotEnabled();

    }


    @Test(dataProvider = "creditAppExcelData")
    public void dataDrivenCreditAppNegTest(String corpName, String storeName, String taxID, String telNo, String yearsLoc,
                                  String yearsBus, String inc, String insCo, String policy, String address,
                                  String city, String state, String zip ){

        creditAppPage.creditExcelData( corpName, storeName, taxID, telNo, yearsLoc,yearsBus,
                                       inc, insCo, policy, address, city, state, zip );
        creditAppPage.billingSame();
        creditAppPage.deliverySame();
        creditAppPage.businessType();
        creditAppPage.creditFormButton();
        creditAppPage.termsScroll();
        creditAppPage.guaranteeScroll();
        creditAppPage.submitDate();
        creditAppPage.creditManager();
        creditAppPage.corpName();
        creditAppPage.guarantor();
        creditAppPage.ownerName();
        creditAppPage.guarantorName();
        creditAppPage.salesBroker();
        creditAppPage.verifySubmitButtonNotEnabled();


    }




    @DataProvider
    public static Object[][] creditAppExcelData(){
        Object[][] data = null;
        String dataFile = System.getProperty("user.dir") + "/src/test/resources/GoyaCreditAppData.xlsx";

        ExcelReader reader = new ExcelReader(dataFile);
        data = reader.getExcelSheetData("Sheet1",true);
        return data;
    }

}