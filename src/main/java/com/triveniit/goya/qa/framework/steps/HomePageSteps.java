package com.triveniit.goya.qa.framework.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends StepBase {

    @When("^User clicks on Customers$")
    public void user_clicks_on_Customers() throws Throwable {
        HomePage.navigateToCustomersPage();
    }

    @Then("^User should be direct back to Homepage$")
    public void user_should_be_direct_back_to_Homepage() throws Throwable {
        HomePage.verifyHomePageURL();

    }

    @Then("^Customer info should display at top$")
    public void customer_info_should_display_at_top() throws Throwable {
        HomePage.verifyCustomerInfo();
    }

    @When("^User clicks on Smart Order$")
    public void user_clicks_on_Smart_Order() throws Throwable {
        HomePage.navigateToSmartOrderPage();
    }

}
