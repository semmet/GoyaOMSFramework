package com.triveniit.goya.qa.framework.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerPageSteps extends StepBase {

    @Then("^Customers page should display$")
    public void Customer_page_should_display() throws Throwable {
        CustomersPage.verifyCustomersPageUrl();
    }

    @When("^User selects customer$")
    public void user_selects_customer() throws Throwable {
        CustomersPage.selectCustomer();
    }

    @When("^User clicks Select button$")
    public void user_clicks_Select_button() throws Throwable {
        CustomersPage.selectButton();
    }

    @When("^User accepts Confirm Alert$")
    public void user_accepts_Confirm_Alert() throws Throwable {
        CustomersPage.alertConfirm();
    }
}
