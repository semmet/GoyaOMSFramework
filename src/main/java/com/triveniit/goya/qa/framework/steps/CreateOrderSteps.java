package com.triveniit.goya.qa.framework.steps;


import com.triveniit.goya.qa.framework.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CreateOrderSteps extends StepBase {



    @When("^User clicks Create Order$")
    public void user_clicks_Create_Order() throws Throwable {
        HomePage.navigateToCreateOrderPage();
    }

    @Then("^Create Order page should display$")
    public void create_Order_page_should_display() throws Throwable {
        Thread.sleep(2000);
        String title = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/order-entry", title);

    }

    @When("^User selects customer from dropdown menu$")
    public void user_selects_customer_from_dropdown_menu() throws Throwable {
        CreateOrderPage.selectCustomer();
    }

    @When("^User enters item code into UPC box$")
    public void user_enters_item_code_into_UPC_box() throws Throwable {
        CreateOrderPage.enterItemCode();
    }

    @When("^User clicks Add button$")
    public void user_clicks_Add_button() throws Throwable {
        CreateOrderPage.addItem();
    }

    @Then("^Item Added alert should display$")
    public void correct_item_should_display_in_table() throws Throwable {
        CreateOrderPage.verifyItemAdded();

    }

}
