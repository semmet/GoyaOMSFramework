package com.triveniit.goya.qa.framework.steps;

import com.triveniit.goya.qa.framework.utils.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

public class BeforeAfterHook extends StepBase {

    @Before
    public void setup() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){

        DriverFactory.getInstance().removeDriver();

    }


}
