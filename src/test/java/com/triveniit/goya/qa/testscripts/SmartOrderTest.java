package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmartOrderTest extends ScriptBase {


    @BeforeMethod
    public void navigateToSmartOrderPage() {
        homePage.navigateToCustomersPage();
        customersPage.verifyCustomersPageUrl();
        customersPage.selectCustomer();
        customersPage.selectButton();
        customersPage.alertConfirm();
        homePage.verifyCustomerInfo();
        homePage.navigateToSmartOrderPage();
        smartOrderPage.verifySmartOrderURL();
    }

    @Test
    public void verifyCorrectCustomerInfo(){
        smartOrderPage.verifyCustInfo();
    }

    @Test
    public void addOneItemToOrder() {
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.verifyCaseTotal("1");
        smartOrderPage.verifyCartQty("1");
    }

    @Test
    public void addTwoDifferentItems(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(2000);
        smartOrderPage.clearUPCSearch();
        smartOrderPage.addItemByUPC("1107");
        delayFor(2000);
        smartOrderPage.verifyItemCount("2");
        smartOrderPage.verifyCaseTotal("3");
        smartOrderPage.verifyCartQty("3");
    }

    @Test
    public void addItemByTextQty(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.addItemQtyByText();
        smartOrderPage.verifyCaseTotal("10");
        smartOrderPage.verifyCartQty("10");
    }

    @Test
    public void deletingItemUsingQtyButton(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.reduceItemQty();
        smartOrderPage.verifyItemCount("0");
    }

    @Test
    public void deletingItemfromCart(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.openCart();
        smartOrderPage.deleteItemfromCart();
        smartOrderPage.verifyItemCount("0");
    }

    @Test
    public void verifyCorrectItemInCart(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.openCart();
        smartOrderPage.verifyCartItem("1105");
    }

    @Test
    public void verifyMinusKeyDisabledWhenCartEmpty(){
        smartOrderPage.verifyMinusKeyDisabled();
    }

    @Test
    public void verifyMinusKeyCannotInputNeg(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.increaseItemQty();
        smartOrderPage.reduceItemQty();
        smartOrderPage.reduceItemQty();
        smartOrderPage.verifyMinusKeyDisabled();
    }

}
