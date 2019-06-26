package com.triveniit.goya.qa.framework.utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {

    private static DriverFactory instance = null;


    public static final String USERNAME = "steveemmet1";
    public static final String AUTOMATE_KEY = "iNtzP7DphwtmGfqeypik";
    public static final String URL = "";
    public static final String LOCAL_GRID_URL = "";

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public static DriverFactory getInstance(String browserName) {
        if (instance == null) {
            instance = new DriverFactory();
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            instance.driver.set(new ChromeDriver());
        }

        else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            instance.driver.set(new FirefoxDriver());
        }

        else if (browserName.equalsIgnoreCase("cloud_chrome_64")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "64.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1920x1080");

            try {
                instance.driver.set(new RemoteWebDriver(new URL(URL), caps));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        else if (browserName.equalsIgnoreCase("cloud_ie_11")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "IE");
            caps.setCapability("browser_version", "11.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "7");
            caps.setCapability("resolution", "1920x1080");
            try {
                instance.driver.set(new RemoteWebDriver(new URL(URL), caps));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        else if (browserName.equalsIgnoreCase("grid_chrome_16")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setPlatform(Platform.ANY);
            caps.setBrowserName("chrome");
            try {
                instance.driver.set(new RemoteWebDriver(new URL(LOCAL_GRID_URL), caps));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        else if (browserName.equalsIgnoreCase("grid_firefox_16")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setPlatform(Platform.ANY);
            caps.setBrowserName("firefox");
            try {
                instance.driver.set(new RemoteWebDriver(new URL(LOCAL_GRID_URL), caps));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return instance;

    }

        ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()  // thread local driver object for webdriver

       {
        @Override
        protected WebDriver initialValue() {
            //ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            //return new ChromeDriver();
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            return new FirefoxDriver();

        }
    };



        public WebDriver getDriver() {
            return driver.get();
        }

        public void removeDriver() {
            driver.get().quit();
            driver.remove();

        }


    }

