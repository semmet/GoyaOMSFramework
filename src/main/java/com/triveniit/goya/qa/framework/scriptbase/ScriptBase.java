package com.triveniit.goya.qa.framework.scriptbase;

import com.triveniit.goya.qa.framework.pages.*;
import com.triveniit.goya.qa.framework.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;

import java.util.concurrent.TimeUnit;



    @Listeners({ExtentTestNGITestListener.class}) //THIS IS FOR EXTENT MANAGER REPORTER
    //@Listeners({ReporterTestListener.class})    //PAXO REPORTER
    public class ScriptBase extends WebElementUtils {

        protected WebDriver driver;
        protected WebElementUtils webElementUtils;
        protected HomePage homePage;
        protected LoginPage loginPage;
        protected CreateOrderPage createOrderPage;
        protected CreditAppPage creditAppPage;
        protected CustomersPage customersPage;
        protected SmartOrderPage smartOrderPage;


        private ExtentManager report = ExtentManager.getInstance();  //THIS IS FOR EXTENT MANAGER REPORTER
        //protected ReporterService reporter = ReporterService.reporter();  //PAXO REPORTER


        @BeforeClass
        public void beforeClass() throws Exception {
            /*reporter.setReportPath(System.getProperty("user.dir") + "/test-output/htmlReport/");
            reporter.setReportName("PaxoReport");
            reporter.setReportTitle("Paxo Functional Test");
            reporter.setCreateUniqueFileName(true); */

            report = ExtentManager.getInstance();   //THIS IS FOR EXTENT MANAGER REPORTER
        }

        @BeforeMethod
        @Parameters({"browserName"})
        public void beforeMethod(@Optional(value = "grid_chrome_16") String browserName) throws Exception {
            driver = DriverFactory.getInstance(browserName).getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();



            webElementUtils = new WebElementUtils();
            homePage = new HomePage();
            loginPage = new LoginPage();
            creditAppPage = new CreditAppPage();
            createOrderPage = new CreateOrderPage();


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
            DriverFactory.getInstance().removeDriver();
        }



    }
