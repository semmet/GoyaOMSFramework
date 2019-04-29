package com.triveniit.goya.qa.framework.steps;


import com.triveniit.goya.qa.framework.pages.LoginPage;
import com.triveniit.goya.qa.framework.utils.SeleniumUtils;
import com.triveniit.goya.qa.framework.utils.WebElementUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginSteps extends StepBase {

    @Given("^Not a validated user$")
    public void not_a_validated_user() throws Throwable {
        driver.manage().deleteAllCookies();

    }

    @When("^User browse to website$")
    public void user_browse_to_website() throws Throwable {
        driver.get("https://portal.goya.com/omsdev/#/login");

    }

    @Then("^Login page should display$")
    public void login_page_should_display() throws Throwable {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/login", URL);

    }

    @When("^User enter username as \"([^\"]*)\"$")
    public void user_enter_user_name_as(String name) throws Throwable {
        typeText(By.xpath("//*[@placeholder='Username']"), name);

    }

    @When("^User enter password as \"([^\"]*)\"$")
    public void user_enter_password_as(String password) throws Throwable {
        typeText(By.xpath("//*[@placeholder='Password']"), password);

    }

    @When("^User click login button$")
    public void user_click_login_button() throws Throwable {
        click(By.xpath("//*[@type='submit'][contains(text(),'Login')]"));

    }

    @Then("^Home page should display$")
    public void home_page_should_display() throws Throwable {
        delayFor(2000);
        HomePage.verifyHomePageURL();

    }

    @Then("^Login error message should display$")
    public void login_error_messsage_should_display() throws Throwable {

        LoginPage.verifyLoginNotSuccess();
    }
}