package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.pages.CreateOrderPage;
import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;
import com.triveniit.goya.qa.framework.utils.WebElementUtils;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;






public class CreateOrderTest extends ScriptBase {



    @BeforeMethod
    public void navigateToCreateOrderPage() {
        homePage.navigateToCreateOrderPage();
        createOrderPage.verifyOrderPageDisplay();
    }


    @Test (description = "Verifies user must first select a customer to be able to place order")
    public void userMustFirstSelectCustomer(){
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        webElementUtils.verifyAlertMessage("Please select customer.");
    }


    @Test (description = "Verifies items are correctly added to an order")
    public void addItemToOrder(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
    }

    @Test (description = "Verifies successful submission of the order")
    public void submitCustomerOrder()  {
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.submitOrder();
        createOrderPage.confirmOrder();
        webElementUtils.verifyAlertMessage("Submitted Successfully");

    }


    /*@Test   // de-activated pending info on what items are restricted for test customer
    public void userTriesToAddRestrictedItem(){
        createOrderPage.selectCustomer();
        createOrderPage.enterRestrictedItem();
        createOrderPage.addItem();
        createOrderPage.verifyRestrictedItem();
    } */

    @Test (description = "Verifies items must have a valid UPC code")
    public void userEntersInvalidUPCForItem(){
        createOrderPage.selectCustomer();
        createOrderPage.enterInvalidItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemNotFound();
    }

    @Test (description = "Verifies functionality of the Search feature")
    public void addItemUsingSearchFeature() {
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

    @Test (description = "Verifies alert notification of surcharge for orders under $200")
    public void under$200DeliverySurcharge(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.submitOrder();
        createOrderPage.verifyDeliverySurchargeAlert();
    }

    @Test (description = "Verifies a user cannot submit an order without any items")
    public void cannotSubmitEmptyOrder(){
        createOrderPage.selectCustomer();
        createOrderPage.submitOrder();
        webElementUtils.verifyAlertMessage("No Items added.");

    }

    @Test (description = "Verifies an order cannot be submitted if all added items are then deleted")
    public void cannotSubmitWhenAllItemsDeleted(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.addAnotherItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.deleteAllItems();
        webElementUtils.verifyAlertMessage("Delete All Items?");
        createOrderPage.submitOrder();
        webElementUtils.verifyAlertMessage("No Items added.");

    }

    @Test (description = "Verifies correct amount if owed balance is collected from customer")
    public void balanceOwedCollect(){
        createOrderPage.selectCustomer();
        createOrderPage.collectBalance();
        createOrderPage.enterItemCode();
        createOrderPage.addItem();
        createOrderPage.verifyItemAdded();
        createOrderPage.submitOrder();
        createOrderPage.verifyCorrectAmountCollected();
    }

    @Test (description = "Verifies the correct promo type has been added")
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

    @Test (description = "Verifies that user cannot select same day for delivery / no delivery")
    public void deliveryDayNoDeliveryDayCannotMatch(){
        createOrderPage.selectCustomer();
        createOrderPage.selectDeliveryDay();
        createOrderPage.selectNotDeliveryDay();
        webElementUtils.verifyAlertMessage("Day and Not Day can not be Same.");
    }

    @Test (description = "Verifies that user cannot add a neg number case qty for item")
    public void userMustAddValidNumberItemCaseQty(){
        createOrderPage.selectCustomer();
        createOrderPage.enterItemCode();
        createOrderPage.enterInvalidItemQty();
        createOrderPage.addItem();
        webElementUtils.verifyAlertMessage("Please enter valid quantity.");
    }


}
