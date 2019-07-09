package com.triveniit.goya.qa.framework.pages;

import com.paxovision.execution.annotations.LogReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage extends PageBase {

    @FindBy(xpath = "//*[@placeholder='Username']")
    private WebElement userName;
    @FindBy(xpath ="//*[@placeholder='Password']")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//*[@type='submit'][contains(text(),'Login')]")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Username or Password Incorrect')]")
    private WebElement alertMsg;

    public LoginPage() {
        super();
        PageFactory.initElements(driver,this);
    }

    private WebElement getAlertMsg(){
        WebElement alertMsg;
        alertMsg = waitForElementDisplayed(By.xpath("//div[contains(text(),'Username or Password Incorrect')]"),2);
        return  alertMsg;
    }

    @LogReport(name = "userLoginToApp",description = "User enters valid name and password")
    public void login(String name, String password){
        typeText(userName, name);
        typeText(passwordTextbox, password);
        click(loginButton);
    }

    @LogReport(name = "invalidDataLogin",description = "User enters invalid combo of data")
    public void loginExcelData(String name, String password){
        typeText(userName, name);
        typeText(passwordTextbox, password);
        click(loginButton);
    }

    @LogReport(name = "verifyAlertMessage",description = "Invalid data alert should display")
    public void verifyLoginNotSuccess(){
        String successText = getAlertMsg().getText();
        assertThat(successText, containsString("Incorrect"));

        System.out.println("Unsuccessful login attempt");
    }


}
