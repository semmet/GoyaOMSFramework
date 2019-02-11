package com.triveniit.goya.qa.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class HomePage extends PageBase {

    @FindBy(xpath = "//*[@value='Create Order']")
    private WebElement createOrderLink;
    @FindBy(xpath ="//*[@placeholder='Password']")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//*[@type='submit'][contains(text(),'Login')]")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Username or Password Incorrect')]")
    private WebElement alertMsg;
    @FindBy(xpath = "//*[@value='Credit Form']")
    private WebElement creditAppLink;



    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }


    public void navigateToCreateOrderPage(){
     createOrderLink.click();
    }

    public void navigateToCreditAppPage(){
        creditAppLink.click();

    }




    String url = "";
    HttpURLConnection huc = null;
    int respCode = 200;


    public void brokenLinks() {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while(it.hasNext()){

            url = it.next().getAttribute("href");

            System.out.println(url);

            /*if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

              if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            } */

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

    }
}
