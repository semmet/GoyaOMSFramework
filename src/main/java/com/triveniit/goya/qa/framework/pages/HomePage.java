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

    public void checkForBrokenLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links are "+links.size());

        for(int i=0; i<links.size(); i++) {
            WebElement element = links.get(i);

            String url=element.getAttribute("href");
            verifyLink(url);
        }
    }

    public  void verifyLink(String urlLink) {
        // may face exception "java.net.MalformedURLException". Keep code in try catch block to continue broken link analysis
        try {

            URL link = new URL(urlLink);

            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();

            if(httpConn.getResponseCode()== 200) {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(httpConn.getResponseCode()== 404) {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the server.
        catch (Exception e) {

        }
    }

    public void verifyHomePageURL() {
        delayFor(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/home", URL);
    }

    public void verifyBrokerInfo() {
        String broker = brokerInfo.getText();
        assertThat(broker, CoreMatchers.containsString("013506"));
    }

    public void verifySalesAuthorInfo() {
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

    public void navigateToDocBriefcase() {
        briefcaseLink.click();
    }


    public void confirmSmartOrderAlert() {
        delayFor(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertThat(alertText, CoreMatchers.containsString("Please select Customer"));
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

    public void navigateToContactSupport() {
        Select drpBroker = new Select(driver.findElement(By.xpath("//*[@class='btn-group']")));
        drpBroker.selectByVisibleText("Contact Support");
    }

}


