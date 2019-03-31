package com.triveniit.goya.qa.framework.steps;


import com.triveniit.goya.qa.framework.pages.CustomersPage;
import com.triveniit.goya.qa.framework.pages.HomePage;
import com.triveniit.goya.qa.framework.pages.SmartOrderPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class SmartOrderSteps extends StepBase {



    @Then("^Smart Order page should display$")
    public void smart_Order_page_should_display() throws Throwable {
        SmartOrderPage.verifySmartOrderURL();

    }

    @Then("^Correct customer info should display in field box$")
    public void correct_customer_info_should_display_in_field_box() throws Throwable {
        SmartOrderPage.verifyCustInfo();

    }

    @When("^User adds item to order$")
    public void when_user_adds_item_to_order(){
        //SmartOrderPage.addFirstItem();
        SmartOrderPage.addFirstItemText();
    }

    @Then("^Item count should display as 1$")
    public void item_count_should_display_as_1(){
        SmartOrderPage.verifyItemCount1();
    }

    @Then("^Case qty should display as 1$")
    public void case_qty_should_display_as_1(){
        SmartOrderPage.verifyCasetotal1();
    }

    @Then("^Item should display in Smart Order cart$")
    public void item_should_display_in_smart_order_cart(){
        SmartOrderPage.verifyCartQty();
    }

    @When("^User adds 2 case of first item$")
    public void user_adds_2_case_of_first_item(){
        SmartOrderPage.addFirstItem();
        SmartOrderPage.addFirstItem();
    }

    @When("^User adds 1 case of second item$")
    public void user_adds_1_case_of_second_item() throws Throwable {
        SmartOrderPage.addAnotherItem();
    }

    @Then("^Item count should display as 2$")
    public void item_count_should_display_as_2() throws Throwable {
        SmartOrderPage.verifyItemCount2();
    }

    @Then("^Case qty should display as 3$")
    public void case_qty_should_display_as_3() throws Throwable {
        SmartOrderPage.verifyCaseTotal3();
    }

    @Then("^3 items should display in cart$")
    public void items_should_display_in_cart(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }












}
