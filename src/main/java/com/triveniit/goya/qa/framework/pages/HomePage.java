package com.triveniit.goya.qa.framework.pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;



public class HomePage extends PageBase {


    @FindBy(xpath = "//div[@class='homeSet']/div[@class='ng-scope']")
    private WebElement customerBanner;
    @FindBy(xpath = "//*[@value='Order']")
    private WebElement createOrderLink;
    @FindBy(xpath = "//*[@value='Credit App']")
    private WebElement creditAppLink;
    @FindBy(xpath = "//*[@value='Customers']")
    private WebElement customersLink;
    @FindBy(xpath = "//*[@value='Smart Order']")
    private WebElement smartOrderLink;
    @FindBy(xpath = "//input[@value='Briefcase']")
    private WebElement briefcaseLink;
    @FindBy(xpath = "//button[contains(text(),'013506')]")
    private WebElement brokerInfo;
    @FindBy(xpath = "//button[contains(text(),'SalesAuthor1')]")
    private WebElement salesAuthorInfo;
    @FindBy(xpath = "(//*[@class='notify-count ng-binding ng-scope'])[1]")
    private WebElement brokerNotice;





    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void checkForBrokenLinks() throws Throwable {
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        List<WebElement> activeLinks = new ArrayList<>();

        for (int i = 0; i < linksList.size(); i++) {
            //System.out.println(linksList.get(i).getAttribute("href"));
            if (linksList.get(i).getAttribute("href") != null) {
                activeLinks.add(linksList.get(i));
            }
        }

        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href")+"-->"+ response);
        }

    }


    public void verifyHomePageURL() {
        delayFor(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/home", URL);
    }

    public void verifyBrokerInfo(){
        String broker = brokerInfo.getText();
        assertThat(broker, CoreMatchers.containsString("013506"));
    }

    public void verifySalesAuthorInfo(){
        String broker = salesAuthorInfo.getText();
        assertThat(broker, CoreMatchers.containsString("SalesAuthor1"));
    }


    public void navigateToCreateOrderPage() {

        delayFor(1000);
        createOrderLink.click();
    }

    public void navigateToCreditAppPage() {
        creditAppLink.click();
    }

    public void navigateToSmartOrderPage() {
        smartOrderLink.click();
    }

    public void confirmSmartOrderAlert(){
        delayFor(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertThat(alertText,CoreMatchers.containsString("Please select Customer"));
        alert.accept();
    }

    public void navigateToCustomersPage() {
        waitForVisibilityOfElement(customersLink);
        customersLink.click();
    }

    public void verifyCustomerInfo() {
        String customerInfo = customerBanner.getText();
        assertThat(customerInfo, CoreMatchers.containsString("712457"));
    }

    public void navigateToContactSupport(){
        Select drpBroker = new Select(driver.findElement(By.xpath("//*[@class='btn-group']")));
        drpBroker.selectByVisibleText("Contact Support");

    }




}

