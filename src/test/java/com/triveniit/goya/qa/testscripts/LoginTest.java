package com.triveniit.goya.qa.testscripts;

import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.triveniit.goya.qa.framework.pages.HomePage;
import com.triveniit.goya.qa.framework.pages.LoginPage;
import com.triveniit.goya.qa.framework.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


    @Listeners({ExtentTestNGITestListener.class}) //Extent Reporter
    //@Listeners({ReporterTestListener.class})    //PAXO REPORTER

    public class LoginTest extends WebElementUtils {

        protected WebDriver driver;
        protected WebElementUtils webElementUtils;
        protected HomePage homePage;
        protected LoginPage loginPage;

        private ExtentManager report = ExtentManager.getInstance();

        @BeforeClass
        public void beforeClass() throws Exception {

            report = ExtentManager.getInstance();
        }


        @BeforeMethod
        @Parameters({"browserName"})
        public void beforeMethod(@Optional(value = "chrome") String browserName)  {
            driver = DriverFactory.getInstance(browserName).getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();

            webElementUtils = new WebElementUtils();
            homePage = new HomePage();
            loginPage = new LoginPage();

            driver.get("https://portal.goya.com/omsdev/#/login");

    }



    @Test
    public void verifyBrokerLoginSuccess(){
        loginPage.login("013506","Pwd@013506");
        homePage.verifyHomePageURL();
        homePage.verifyBrokerInfo();
    }


    @Test
    public void verifySalesAuthorLoginSuccess(){
        loginPage.login("salesauthor1","Pwd1@salesauthor1");
        homePage.verifyHomePageURL();
        homePage.verifySalesAuthorInfo();
    }


    @Test(dataProvider = "goyaNegLoginExcelData")
    public void verifyUserCannotLoginWithIncorrectData(String name, String password){
        loginPage.loginExcelData(name, password);
        loginPage.verifyLoginNotSuccess();
    }


    @AfterMethod
    public void afterMethod() {
        webElementUtils = null;
        homePage = null;
        loginPage = null;

        DriverFactory.getInstance().removeDriver();
    }



    @DataProvider
    public static Object[][] goyaNegLoginExcelData(){
        Object[][] data = null;
        String dataFile = System.getProperty("user.dir") + "/src/test/resources/GoyaNegLoginData.xlsx";
        ExcelReader reader = new ExcelReader(dataFile);
        data = reader.getExcelSheetData("Sheet1",true);
        return data;
    }

}
