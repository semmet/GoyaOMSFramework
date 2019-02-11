package com.triveniit.goya.qa.framework.scriptbase;

import com.triveniit.goya.qa.framework.pages.CreateOrderPage;
import com.triveniit.goya.qa.framework.pages.CreditAppPage;
import com.triveniit.goya.qa.framework.pages.HomePage;
import com.triveniit.goya.qa.framework.pages.LoginPage;
import com.triveniit.goya.qa.framework.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;

import java.util.concurrent.TimeUnit;



    //@Listeners({ExtentTestNGITestListener.class})
    @Listeners({ReporterTestListener.class})
    public class ScriptBase extends WebElementUtils {

        protected WebDriver driver;
        protected WebElementUtils webElementUtils;
        protected HomePage homePage;
        protected LoginPage loginPage;
        protected CreateOrderPage createOrderPage;
        protected CreditAppPage creditAppPage;


        private ExtentManager report = ExtentManager.getInstance();
        protected ReporterService reporter = ReporterService.reporter();


        @BeforeClass
        public void beforeClass() throws Exception {
            reporter.setReportPath(System.getProperty("user.dir") + "/test-output/htmlReport/");
            reporter.setReportName("PaxoReport");
            reporter.setReportTitle("Paxo Functional Test");
            reporter.setCreateUniqueFileName(true);

            report = ExtentManager.getInstance();
        }

        @BeforeMethod
        @Parameters({"browserName"})
        public void beforeMethod(@Optional(value = "grid_chrome_16") String browserName) throws Exception {
            driver = DriverFactory.getInstance(browserName).getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();


            webElementUtils = new WebElementUtils();
            homePage = new HomePage();
            loginPage = new LoginPage();
            creditAppPage = new CreditAppPage();

            //driver.get("https://portal.goya.com/omsdev/#/login");
            driver.get("https://portal.goya.com/omsdev/#/home");

            //loginPage.login("013506", "Pwd@013506");
            //Thread.sleep(2000);

        }


        @AfterMethod
        public void afterMethod() {
            webElementUtils = null;
            homePage = null;
            loginPage = null;
            DriverFactory.getInstance().removeDriver();
        }


        /*public void verifyLinks(String urlLink) {
            try {
                URL link = new URL(urlLink);
                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
                httpConn.setConnectTimeout(2000);
                httpConn.connect();
                if (httpConn.getResponseCode() == 200) {
                    System.out.println(urlLink = " - " + httpConn.getResponseMessage());
                }
                if (httpConn.getResponseCode() == 404) {
                    System.out.println(urlLink = " - " + httpConn.getResponseMessage());
                }
            } catch (Exception e) {
            }

            //public void delayFor(int timeInMili){
            // homePage.delayFor(timeInMili);}

        } */
    }
