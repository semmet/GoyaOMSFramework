package com.triveniit.goya.qa.framework.scriptbase;

import com.paxovision.execution.reporter.interceptor.ProxyGenerator;
import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;
import com.triveniit.goya.qa.framework.pages.*;
import com.triveniit.goya.qa.framework.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;



    //@Listeners({ExtentTestNGITestListener.class}) //THIS IS FOR EXTENT MANAGER REPORTER
    @Listeners({ReporterTestListener.class})    //PAXO REPORTER
    public class ScriptBase extends WebElementUtils {

        protected WebDriver driver;
        protected WebElementUtils webElementUtils;
        protected HomePage homePage;
        protected LoginPage loginPage;
        protected CatalogPage catalogPage;
        protected CreateOrderPage createOrderPage;
        protected CreditAppPage creditAppPage;
        protected CustomersPage customersPage;
        protected SmartOrderPage smartOrderPage;
        protected DocBriefcase docBriefcase;



        private ExtentManager report = ExtentManager.getInstance();  //THIS IS FOR EXTENT MANAGER REPORTER
        protected ReporterService reporter = ReporterService.reporter();  //PAXO REPORTER


        @BeforeClass
        public void beforeClass() throws Exception {
            reporter.setReportPath(System.getProperty("user.dir") + "/test-output/htmlReport/");
            reporter.setReportName("PaxoReport");
            reporter.setReportTitle("Paxo Functional Test");
            reporter.setCreateUniqueFileName(false);

            report = ExtentManager.getInstance();   //THIS IS FOR EXTENT MANAGER REPORTER
        }

        @BeforeMethod
        @Parameters({"browserName"})
        public void beforeMethod(@Optional(value = "") String browserName) throws Exception {
            driver = DriverFactory.getInstance(browserName).getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();


            //webElementUtils = new WebElementUtils();
            webElementUtils = ProxyGenerator.getEnhancedObject(WebElementUtils.class);
            //homePage = new HomePage();
            homePage = ProxyGenerator.getEnhancedObject(HomePage.class);
            //loginPage = new LoginPage();
            loginPage = ProxyGenerator.getEnhancedObject(LoginPage.class);
            //creditAppPage = new CreditAppPage();
            creditAppPage = ProxyGenerator.getEnhancedObject(CreditAppPage.class);
            //createOrderPage = new CreateOrderPage();
            createOrderPage = ProxyGenerator.getEnhancedObject(CreateOrderPage.class);
            //customersPage = new CustomersPage();
            customersPage = ProxyGenerator.getEnhancedObject(CustomersPage.class);
            //catalogPage = new CatalogPage();
            catalogPage = ProxyGenerator.getEnhancedObject(CatalogPage.class);
            //smartOrderPage = new SmartOrderPage();
            smartOrderPage = ProxyGenerator.getEnhancedObject(SmartOrderPage.class);
            docBriefcase = new DocBriefcase();


            driver.get("https://portal.goya.com/omsdev/#/login");
            //driver.get("https://portal.goya.com/omsdev/#/home");

            loginPage.login("013506", "Pwd@013506");
            delayFor(2000);

        }


        @AfterMethod
        public void afterMethod() {
            webElementUtils = null;
            homePage = null;
            loginPage = null;
            catalogPage = null;
            creditAppPage = null;
            createOrderPage = null;
            smartOrderPage = null;
            docBriefcase = null;

            DriverFactory.getInstance().removeDriver();
        }



    }
