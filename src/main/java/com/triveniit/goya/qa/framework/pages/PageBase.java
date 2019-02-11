package com.triveniit.goya.qa.framework.pages;

import com.triveniit.goya.qa.framework.utils.WebElementUtils;
import org.junit.Assert;

public class PageBase extends WebElementUtils {

           public PageBase(){super();}

           public void verifyPageTitle(String expectedTitle){
               String title = driver.getTitle();
               Assert.assertEquals(expectedTitle,title);
           }


}
