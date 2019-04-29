$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/SmartOrder.feature");
formatter.feature({
  "line": 1,
  "name": "Goya OMS Smart Order",
  "description": "",
  "id": "goya-oms-smart-order",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5794418369,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Not a validated user",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User browse to website",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Login page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User enter username as \"013506\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User enter password as \"Pwd@013506\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User click login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Home page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User clicks on Customers",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Customers page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "User selects customer",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User clicks Select button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User accepts Confirm Alert",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User should be direct back to Homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Customer info should display at top",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.not_a_validated_user()"
});
formatter.result({
  "duration": 172515774,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_browse_to_website()"
});
formatter.result({
  "duration": 1748370067,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.login_page_should_display()"
});
formatter.result({
  "duration": 9090601,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "013506",
      "offset": 24
    }
  ],
  "location": "LoginSteps.user_enter_user_name_as(String)"
});
formatter.result({
  "duration": 2019824536,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pwd@013506",
      "offset": 24
    }
  ],
  "location": "LoginSteps.user_enter_password_as(String)"
});
formatter.result({
  "duration": 990601107,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_click_login_button()"
});
formatter.result({
  "duration": 1229874681,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.home_page_should_display()"
});
formatter.result({
  "duration": 4023934200,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_clicks_on_Customers()"
});
formatter.result({
  "duration": 427060981,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.Customer_page_should_display()"
});
formatter.result({
  "duration": 2016545473,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_selects_customer()"
});
formatter.result({
  "duration": 2445957982,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_clicks_Select_button()"
});
formatter.result({
  "duration": 386429633,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_accepts_Confirm_Alert()"
});
formatter.result({
  "duration": 403452178,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_should_be_direct_back_to_Homepage()"
});
formatter.result({
  "duration": 1997413926,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.customer_info_should_display_at_top()"
});
formatter.result({
  "duration": 46734830,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "1. Confirmation correct customer info is displayed",
  "description": "",
  "id": "goya-oms-smart-order;1.-confirmation-correct-customer-info-is-displayed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "User clicks on Smart Order",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "Smart Order page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Correct customer info should display in field box",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.user_clicks_on_Smart_Order()"
});
formatter.result({
  "duration": 888048828,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.smart_Order_page_should_display()"
});
formatter.result({
  "duration": 2002787546,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.correct_customer_info_should_display_in_field_box()"
});
formatter.result({
  "duration": 35433351,
  "status": "passed"
});
formatter.after({
  "duration": 1481478384,
  "status": "passed"
});
formatter.before({
  "duration": 4123992399,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Not a validated user",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User browse to website",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Login page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User enter username as \"013506\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User enter password as \"Pwd@013506\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User click login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Home page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User clicks on Customers",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Customers page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "User selects customer",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User clicks Select button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User accepts Confirm Alert",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User should be direct back to Homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Customer info should display at top",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.not_a_validated_user()"
});
formatter.result({
  "duration": 9202742,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_browse_to_website()"
});
formatter.result({
  "duration": 1468369352,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.login_page_should_display()"
});
formatter.result({
  "duration": 3329241,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "013506",
      "offset": 24
    }
  ],
  "location": "LoginSteps.user_enter_user_name_as(String)"
});
formatter.result({
  "duration": 2075924047,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pwd@013506",
      "offset": 24
    }
  ],
  "location": "LoginSteps.user_enter_password_as(String)"
});
formatter.result({
  "duration": 1041840944,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_click_login_button()"
});
formatter.result({
  "duration": 1199270973,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.home_page_should_display()"
});
formatter.result({
  "duration": 4019822636,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_clicks_on_Customers()"
});
formatter.result({
  "duration": 365623963,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.Customer_page_should_display()"
});
formatter.result({
  "duration": 1999406226,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_selects_customer()"
});
formatter.result({
  "duration": 332630333,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_clicks_Select_button()"
});
formatter.result({
  "duration": 329840126,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_accepts_Confirm_Alert()"
});
formatter.result({
  "duration": 272282408,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_should_be_direct_back_to_Homepage()"
});
formatter.result({
  "duration": 1995780857,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.customer_info_should_display_at_top()"
});
formatter.result({
  "duration": 630281579,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "2. User adds one item to order",
  "description": "",
  "id": "goya-oms-smart-order;2.-user-adds-one-item-to-order",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 28,
  "name": "User clicks on Smart Order",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Smart Order page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "User adds item to order",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Item count should display as 1",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "Case qty should display as 1",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Item should display in Smart Order cart",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.user_clicks_on_Smart_Order()"
});
formatter.result({
  "duration": 874282538,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.smart_Order_page_should_display()"
});
formatter.result({
  "duration": 2006742114,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.when_user_adds_item_to_order()"
});
formatter.result({
  "duration": 33268089,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: (//button[contains(text(),\u0027+\u0027)])[2]\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-HB18O22\u0027, ip: \u0027192.168.1.225\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002711.0.2\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 66.0.2, javascriptEnabled: true, moz:accessibilityChecks: false, moz:geckodriverVersion: 0.24.0, moz:headless: false, moz:processID: 6608, moz:profile: C:\\Users\\Steve Emmet\\AppDat..., moz:shutdownTimeout: 60000, moz:useNonSpecCompliantPointerOrigin: false, moz:webdriverClick: true, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, platformVersion: 10.0, rotatable: false, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: d4dff4be-006e-4f7f-9324-83c5533b1817\n*** Element info: {Using\u003dxpath, value\u003d(//button[contains(text(),\u0027+\u0027)])[2]}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy21.click(Unknown Source)\r\n\tat com.triveniit.goya.qa.framework.pages.SmartOrderPage.addFirstItem(SmartOrderPage.java:58)\r\n\tat com.triveniit.goya.qa.framework.steps.SmartOrderSteps.when_user_adds_item_to_order(SmartOrderSteps.java:31)\r\n\tat ✽.When User adds item to order(src/test/resources/features/SmartOrder.feature:30)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SmartOrderSteps.item_count_should_display_as_1()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmartOrderSteps.case_qty_should_display_as_1()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmartOrderSteps.item_should_display_in_smart_order_cart()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1933818870,
  "status": "passed"
});
formatter.before({
  "duration": 4055176157,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Not a validated user",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User browse to website",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Login page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User enter username as \"013506\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User enter password as \"Pwd@013506\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User click login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Home page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User clicks on Customers",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Customers page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "User selects customer",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User clicks Select button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User accepts Confirm Alert",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User should be direct back to Homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Customer info should display at top",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.not_a_validated_user()"
});
formatter.result({
  "duration": 9547907,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_browse_to_website()"
});
formatter.result({
  "duration": 1448737926,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.login_page_should_display()"
});
formatter.result({
  "duration": 3374478,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "013506",
      "offset": 24
    }
  ],
  "location": "LoginSteps.user_enter_user_name_as(String)"
});
formatter.result({
  "duration": 2157087525,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pwd@013506",
      "offset": 24
    }
  ],
  "location": "LoginSteps.user_enter_password_as(String)"
});
formatter.result({
  "duration": 1009176893,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_click_login_button()"
});
formatter.result({
  "duration": 1191817622,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.home_page_should_display()"
});
formatter.result({
  "duration": 4030251320,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_clicks_on_Customers()"
});
formatter.result({
  "duration": 2940037915,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.Customer_page_should_display()"
});
formatter.result({
  "duration": 2019137628,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_selects_customer()"
});
formatter.result({
  "duration": 324623882,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_clicks_Select_button()"
});
formatter.result({
  "duration": 311850512,
  "status": "passed"
});
formatter.match({
  "location": "CustomerPageSteps.user_accepts_Confirm_Alert()"
});
formatter.result({
  "duration": 350728667,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_should_be_direct_back_to_Homepage()"
});
formatter.result({
  "duration": 2017644449,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.customer_info_should_display_at_top()"
});
formatter.result({
  "duration": 54294999,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "3. User adds multiple items to order",
  "description": "",
  "id": "goya-oms-smart-order;3.-user-adds-multiple-items-to-order",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 37,
  "name": "User clicks on Smart Order",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Smart Order page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "User adds 2 case of first item",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "User adds 1 case of second item",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "Item count should display as 2",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "Case qty should display as 3",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.user_clicks_on_Smart_Order()"
});
formatter.result({
  "duration": 523334534,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.smart_Order_page_should_display()"
});
formatter.result({
  "duration": 2010271308,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.user_adds_2_case_of_first_item()"
});
formatter.result({
  "duration": 554295569,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.user_adds_1_case_of_second_item()"
});
formatter.result({
  "duration": 292625832,
  "status": "passed"
});
formatter.match({
  "location": "SmartOrderSteps.item_count_should_display_as_2()"
});
formatter.result({
  "duration": 44386723,
  "error_message": "java.lang.AssertionError: \nExpected: a string containing \"2\"\n     but: was \"Item Count: 0\"\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:8)\r\n\tat com.triveniit.goya.qa.framework.pages.SmartOrderPage.verifyItemCount2(SmartOrderPage.java:77)\r\n\tat com.triveniit.goya.qa.framework.steps.SmartOrderSteps.item_count_should_display_as_2(SmartOrderSteps.java:63)\r\n\tat ✽.Then Item count should display as 2(src/test/resources/features/SmartOrder.feature:41)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SmartOrderSteps.case_qty_should_display_as_3()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1364518144,
  "status": "passed"
});
});