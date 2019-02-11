package com.triveniit.goya.qa.framework.steps;

import com.triveniit.goya.qa.framework.pages.CreateOrderPage;
import com.triveniit.goya.qa.framework.pages.HomePage;
import com.triveniit.goya.qa.framework.pages.LoginPage;
import com.triveniit.goya.qa.framework.utils.WebElementUtils;



public class StepBase extends WebElementUtils {

    protected LoginPage LoginPage = new LoginPage();
    protected HomePage HomePage = new HomePage();
    protected CreateOrderPage CreateOrderPage = new CreateOrderPage();


}
