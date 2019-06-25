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

    @Test (description = "Verifies item is correctly added using Smart Order")
    public void addOneItemToOrder() {
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.verifyCaseTotal("1");
        smartOrderPage.verifyCartQty("1");
    }

    @Test (description = "Verifies correct display of item count, case qty and cart total")
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

    @Test (description = "Verifies item qty may be adjusted using text")
    public void addItemByTextQty(){
        smartOrderPage.addItemQtyByText();
        delayFor(3000);
        smartOrderPage.verifyCaseTotal("10");
        smartOrderPage.verifyCartQty("10");
    }

    @Test (description = "Verifies minus button lowers item qty")
    public void deletingItemUsingQtyButton(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.reduceItemQty();
        delayFor(2000);
        smartOrderPage.verifyItemCount("0");
    }

    @Test (description = "Verifies items may be deleted directly from cart")
    public void deletingItemfromCart(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.verifyItemCount("1");
        smartOrderPage.openCart();
        smartOrderPage.deleteItemfromCart();
        delayFor(1000);
        smartOrderPage.verifyItemCount("0");
    }

    @Test (description = "Verifies the correct qty of an item is displayed in cart")
    public void verifyCorrectItemInCart() {
        smartOrderPage.addItemByUPC("1105");
        delayFor(2000);
        smartOrderPage.openCart();
        smartOrderPage.verifyCartItem("1105");
    }

    @Test (description = "Verifies an order is successfully submited from Smart Order")
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

    @Test (description = "Verifies the item minus button is not active unless items have been added")
    public void verifyMinusKeyDisabled(){
        smartOrderPage.verifyMinusKeyDisabled();
    }

    @Test (description = "Verifies that if all items are deleted minus key again is disabled")
    public void verifyMinusKeyDisabledAfterDeletingAllItemsFromCart(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(2000);
        smartOrderPage.verifyMinusKeyEnabled();
        smartOrderPage.openCart();
        smartOrderPage.deleteItemfromCart();
        delayFor(2000);
        smartOrderPage.verifyMinusKeyDisabled();

    }

    @Test (description = "Verifies minus key cannot input a neg number")
    public void verifyMinusKeyCannotInputNeg(){
        smartOrderPage.addItemByUPC("1105");
        smartOrderPage.increaseItemQty();
        smartOrderPage.reduceItemQty();
        smartOrderPage.reduceItemQty();
        smartOrderPage.verifyMinusKeyDisabled();
    }

    @Test (description = "Verifies the delivery surcharge alert")
    public void verifyDeliveryChargeAlert(){
        smartOrderPage.addItemByUPC("1105");
        delayFor(1000);
        smartOrderPage.submitOrder();
        delayFor(1000);
        smartOrderPage.confirmDeliveryCharge();
    }

    @Test (description = "Verifies user will see alert when switching customers")
    public void verifySwitchCustAlert(){
        smartOrderPage.changeNewCustomer();
        delayFor(1000);
        smartOrderPage.switchCustAlert();
    }

    @Test (description = "Verifies the submit order button is not active until items have been added")
    public void verifySubmitOrderButtonDisable(){
        smartOrderPage.submitOrderButtonDisabled();
    }

    @Test (description = "Verifies that if all items are deleted from cart submit order button will be disabled")
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




