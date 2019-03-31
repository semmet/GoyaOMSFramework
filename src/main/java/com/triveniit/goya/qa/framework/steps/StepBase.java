package com.triveniit.goya.qa.framework.steps;

import com.triveniit.goya.qa.framework.pages.*;
import com.triveniit.goya.qa.framework.utils.WebElementUtils;



public class StepBase extends WebElementUtils {

    protected LoginPage LoginPage = new LoginPage();
    protected HomePage HomePage = new HomePage();
    protected CreateOrderPage CreateOrderPage = new CreateOrderPage();
    protected CatalogPage CatalogPage = new CatalogPage();
    protected CustomersPage CustomersPage = new CustomersPage();
    protected SmartOrderPage SmartOrderPage = new SmartOrderPage();


}
