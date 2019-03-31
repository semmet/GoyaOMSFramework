package com.triveniit.goya.qa.framework.pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    String url = "";
    HttpURLConnection huc = null;
    int respCode = 200;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePageURL() throws Throwable {

        delayFor(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/home", URL);
    }

    public void navigateToCreateOrderPage() {

        delayFor(2000);
        createOrderLink.click();
    }

    public void navigateToCreditAppPage() {
        creditAppLink.click();
    }

    public void navigateToSmartOrderPage() {
        smartOrderLink.click();
    }

    public void navigateToCustomersPage() {
        waitForVisibilityOfElement(customersLink);
        customersLink.click();
    }

    public void verifyCustomerInfo() {
        String customerInfo = customerBanner.getText();
        assertThat(customerInfo, CoreMatchers.containsString("712450"));
    }





   /* public void brokenLinks() {


        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while(it.hasNext()){

            url = it.next().getAttribute("href");

            System.out.println(url);

            if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

              if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    } */

}

