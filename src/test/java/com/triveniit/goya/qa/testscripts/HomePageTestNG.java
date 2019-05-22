package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;


import static org.hamcrest.MatcherAssert.assertThat;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class HomePageTestNG extends ScriptBase {



    @Test
    public void checkBrokenLinks() throws IOException,InterruptedException {
        //delayFor(3000);
       // homePage.checkForBrokenLinks();
    }

    @Test
    public void smartOrderNotEnabledWithoutCustomer(){
        homePage.navigateToSmartOrderPage();
        homePage.confirmSmartOrderAlert();
    }



}








