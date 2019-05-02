package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.pages.CreateOrderPage;
import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;






public class CreateOrder extends ScriptBase {



    @BeforeMethod
    public void navigateToCreateOrderPage() {
        homePage.navigateToCreateOrderPage();
        createOrderPage.verifyOrderPageDisplay();
    }


    @Test
    public void userAddsItemToOrder(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
    }

    @Test
    public void userSubmitsCustomerOrder()  {
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.submitOrder();
        createOrderPage.confirmOrder();
        createOrderPage.confirmOrderSubmitted();

    }


    /*@Test
    public void userTriesToAddRestrictedItem(){
        createOrderPage.selectCustomer();
        createOrderPage.enterRestrictedItem();
        createOrderPage.addItem();
        createOrderPage.verifyRestrictedItem();
    } */

    @Test
    public void userEntersInvalidUPCForItem(){
        createOrderPage.selectCustomer();
        createOrderPage.enterInvalidItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemNotFound();
    }

    @Test
    public void userAddsItemUsingSearchFeature() {
        createOrderPage.selectCustomer();
        createOrderPage.clickSearchItem();
        catalogPage.verifyCatalogPage();
        catalogPage.addItemToOrder();
        catalogPage.verifyQtyWindowPopUp();
        catalogPage.addItemQty();
        catalogPage.verifyOneItemInCart();
        catalogPage.continueWithOrder();
        createOrderPage.verifyOrderPageDisplay();
        createOrderPage.verifyItemInTable();
    }

    @Test
    public void verifyUnder$200DeliverySurcharge(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.submitOrder();
        createOrderPage.verifyDeliverySurchargeAlert();
    }

    @Test
    public void verifyCannotSubmitEmptyOrder(){
        createOrderPage.selectCustomer();
        createOrderPage.submitOrder();
        createOrderPage.confirmNoItemsAdded();
    }

    @Test
    public void verifyNoSubmitalWhenAllItemsDeleted(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.addAnotherItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.deleteAllItems();
        createOrderPage.confirmDeleteAll();
        createOrderPage.submitOrder();
        createOrderPage.confirmNoItemsAdded();

    }

    @Test
    public void noCustomerSelected(){
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.noCustomerSelected();
    }

    @Test
    public void balanceOwedCollect(){
        createOrderPage.selectCustomer();
        createOrderPage.collectBalance();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.submitOrder();
        createOrderPage.verifyCorrectAmountCollected();
    }

    @Test
    public void addProgramTypePromoToOrder(){
        createOrderPage.selectCustomer();
        createOrderPage.enterPromoCode();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.submitOrder();
        delayFor(2000);
        createOrderPage.confirmPromoAdded();
    }

    @Test
    public void verifyDeliveryDayNoDeliveryDayCannotMatch(){
        createOrderPage.selectCustomer();
        createOrderPage.selectDeliveryDay();
        createOrderPage.selectNotDeliveryDay();
        createOrderPage.deliveryDayOptionAlert();
    }

    @Test
    public void userMustAddValidNumberItemCaseQty(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.enterInvalidItemQty();
        createOrderPage.addItem();
        createOrderPage.verifyInvalidQtyAlert();
    }


}
