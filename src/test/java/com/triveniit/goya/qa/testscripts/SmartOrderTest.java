package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;



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
    public void addTwoDifferentItemsDiffQty(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(2000);
        smartOrderPage.clearUPCSearch();
        smartOrderPage.addItemByUPC("1107");
        delayFor(2000);
        smartOrderPage.increaseItemQty();
        smartOrderPage.verifyItemCount("2");
        smartOrderPage.verifyCaseTotal("3");
        smartOrderPage.verifyCartQty("3");
    }

    @Test
    public void addItemByTextQty(){
        smartOrderPage.addItemQtyByText();
        delayFor(1000);
        smartOrderPage.verifyCaseTotal("10");
        smartOrderPage.verifyCartQty("10");
    }

    @Test
    public void deletingItemUsingQtyButton(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.reduceItemQty();
        delayFor(2000);
        smartOrderPage.verifyItemCount("0");
    }

    @Test
    public void deletingItemfromCart(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.openCart();
        smartOrderPage.deleteItemfromCart();
        delayFor(1000);
        smartOrderPage.verifyItemCount("0");
    }

    @Test
    public void verifyCorrectItemInCart() {
        smartOrderPage.addItemByUPC("1105");
        delayFor(2000);
        smartOrderPage.openCart();
        smartOrderPage.verifyCartItem("1105");
    }

    @Test
    public void verifyUserCanSubmitOrder(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(1000);
        smartOrderPage.submitOrder();
        delayFor(1000);
        smartOrderPage.submitOrderAlert();
        delayFor(1000);
        smartOrderPage.confirmSubmit();
        delayFor(1000);
        smartOrderPage.closeSubmitSuccessAlert();
    }

    @Test
    public void verifyMinusKeyDisabledWhenLandingOnSmartOrderPage(){
        smartOrderPage.verifyMinusKeyDisabled();
    }

    @Test
    public void verifyMinusKeyDisabledAfterDeletingAllItemsFromCart(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(2000);
        smartOrderPage.verifyMinusKeyEnabled();
        smartOrderPage.openCart();
        smartOrderPage.deleteItemfromCart();
        delayFor(2000);
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

    @Test
    public void verifyDeliveryChargeAlert(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(1000);
        smartOrderPage.submitOrder();
        delayFor(1000);
        smartOrderPage.confirmDeliveryCharge();
    }

    @Test
    public void verifySwitchCustAlert(){
        smartOrderPage.changeNewCustomer();
        delayFor(1000);
        smartOrderPage.switchCustAlert();
    }

    @Test
    public void verifySubmitOrderButtonDisableWhenLandingOnSOPage(){
        smartOrderPage.submitOrderButtonDisabled();
    }

    @Test
    public void verifySubmitOrderButtonDisableWhenCartEmpty(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(1000);
        smartOrderPage.submitOrderButtonEnabled();
        smartOrderPage.openCart();
        smartOrderPage.deleteItemfromCart();
        delayFor(1000);
        smartOrderPage.submitOrderButtonDisabled();
    }









}




