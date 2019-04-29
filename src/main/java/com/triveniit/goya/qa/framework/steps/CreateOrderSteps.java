package com.triveniit.goya.qa.framework.steps;


import com.triveniit.goya.qa.framework.pages.CreateOrderPage;
import com.triveniit.goya.qa.framework.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;

public class CreateOrderSteps extends StepBase {



    @When("^User clicks Create Order$")
    public void user_clicks_Create_Order() throws Throwable {
        HomePage.navigateToCreateOrderPage();
    }

    @Then("^Create Order page should display$")
    public void create_Order_page_should_display() throws Throwable {
        delayFor(2000);
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

    @When("^User enters restricted code item$")
    public void user_enters_restricted_code_item() throws Throwable {
        CreateOrderPage.enterRestrictedItem();

    }

    @Then("^Restricted Item alert should display$")
    public void restricted_Item_alert_should_display() throws Throwable {
        CreateOrderPage.verifyRestrictedItem();
    }

    @When ("^User enters an invalid UPC code$")
    public void user_enters_an_invalid_UPC_code() throws Throwable {
        CreateOrderPage.enterInvalidItemCode();
    }

    @Then("^Item not found alert should display$")
    public void item_not_found_alert_should_display() throws Throwable{
        CreateOrderPage.verifyItemNotFound();
    }

    @When("^User clicks on Search Item button$")
    public void user_click_on_Search_Item_button() throws Throwable{
        CreateOrderPage.clickSearchItem();
    }

    @Then("^Catalog page should display$")
    public void Catalog_page_should_display() throws Throwable{
        delayFor(2000);
        String title = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/search-item?EOR=&custID=", title);

    }

    @When("^User selects item and clicks Add to Cart button$")
    public void user_selects_item_and_clicks_Add_to_Cart_button() throws  Throwable {
        CatalogPage.addItemToOrder();
    }

    @Then("^Item qty window should display$")
    public void item_qty_window_should_display() throws Throwable{
        CatalogPage.verifyQtyWindowPopUp();
    }

    @When("^User clicks Add to Cart$")
    public void user_clicks_Add_to_Cart() throws Throwable{
        CatalogPage.addItemQty();
    }

    @Then("^Item should display in cart$")
    public void item_should_be_present_in_cart() throws Throwable{
        CatalogPage.verifyOneItemInCart();
    }

    @When("^User clicks on Continue button$")
    public void user_clicks_on_Continue_button() throws Throwable{
        CatalogPage.continueWithOrder();
    }

    @Then("^User should be directed back to Create Order page$")
    public void user_should_be_directed_back_to_Create_Order_page() throws Throwable{
        delayFor(2000);
        CreateOrderPage.verifyOrderPageDisplay();


    }

     @Then("^Item should display in table$")
    public void item_should_display_in_table() throws Throwable{

        CreateOrderPage.verifyItemInTable();
     }

    @When("^user clicks Submit button$")
    public void user_clicks_Submit_button() throws Throwable {
        CreateOrderPage.submitOrder();
    }

    @When("^user clicks Alert Submit$")
    public void user_clicks_Alert_Submit() throws Throwable {
        CreateOrderPage.confirmOrder();
    }

    @Then("^success message should display$")
    public void success_message_should_display() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }






}
