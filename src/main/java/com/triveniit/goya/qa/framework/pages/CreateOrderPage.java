package com.triveniit.goya.qa.framework.pages;

import com.paxovision.execution.annotations.LogReport;
import com.triveniit.goya.qa.framework.utils.SeleniumUtils;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Arrays;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateOrderPage extends PageBase{



    @FindBy(xpath = "//*[@id=\"qk-remove-space\"]/form/div/ul/li[2]/div/div")
    private WebElement customerSelect;
    @FindBy(xpath ="//*[@id='txtItemCode']")
    private WebElement itemCodeTextBox;
    @FindBy(css ="#txtCaseQtyDesktop")
    private WebElement itemCaseQty;
    @FindBy(xpath = "//*[@id='clickon']")
    private WebElement addItem;
    @FindBy(css = "#lblMessage")
    private WebElement alertMsg;
    @FindBy(xpath = "//*[@title='Submit order']")
    private WebElement submitOrder;
    @FindBy(xpath = "//*[@value='DELETE ALL']")
    private WebElement deleteAll;
    @FindBy(xpath = "//*[@id='pickUp']")
    private WebElement pickUpCheckbox;
    @FindBy(xpath = "//*[@name='searchitem']")
    private WebElement searchItemBox;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitConfirm;
    @FindBy(xpath = "//*[@name='deleteItem']")
    private WebElement deleteItem;
    @FindBy(xpath = "//div[contains(text(),'$10 delivery charge')]")
    private WebElement deliverySurchargeAlert;
    @FindBy(xpath = "//*[@name='amount']")
    private WebElement collectionAmount;
    @FindBy(xpath = "//*[@class='col-md-8 newpad ng-binding'][contains(text(),'$100.00')]")
    private WebElement collectionAmountAlert;
    @FindBy(xpath =    "//*[@id='qk-remove-space']/ul/li[4]/div/div/div[1]/input")
    private WebElement promoCodeBox;
    @FindBy(xpath = "//*[@class='col-md-8 newpad ng-binding'][contains(text(),'25')]")
    private WebElement promoCodeAlert;
    @FindBy(xpath = "//*[@id='selectday']")
    private WebElement selectDay;
    @FindBy(xpath = "//*[@id='selectnotday']")
    private WebElement selectNotDay;


    public CreateOrderPage() {
        super();
        PageFactory.initElements(driver,this);
    }

    @LogReport(name = "verifyURL",description = "Order Page URL should display")
    public void verifyOrderPageDisplay(){
        delayFor(2000);
        String url = driver.getCurrentUrl();
        assertThat(url, CoreMatchers.containsString("https://portal.goya.com/omsdev/#/order-entry"));
    }

    @LogReport(name = "selectCustomer",description = "Select customer from dropdown menu")
    public void selectCustomer() {

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", customerSelect);

        Actions actions = new Actions(driver);
        actions.moveToElement(customerSelect);
        actions.click();
        actions.sendKeys("712457");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();

    }

    @LogReport(name = "enterItemCode",description = "Enter product code of item")
    public void enterItemCode(){
        typeText(itemCodeTextBox, "1105");
    }

    @LogReport(name = "restrictedItem",description = "Enter an item that the customer has blocked")
    public void enterRestrictedItem(){
        typeText(itemCodeTextBox, "1107");
    }

    @LogReport(name = "invalidItem",description = "Enter invalid product code")
    public void enterInvalidItemCode() {
        typeText(itemCodeTextBox, "XXXX");
    }

   @LogReport(name = "addItem",description = "Click Add item to order")
    public void addItem(){
        click(addItem);
    }

    @LogReport(name = "invalidItemQty",description = "Try to add invalid number as item qty")
    public void enterInvalidItemQty(){
        typeText(itemCaseQty,"-10");
    }

    @LogReport(name = "addAnotherItem",description = "Add second item to order")
    public void addAnotherItem(){
        typeText(itemCodeTextBox,"2161");
        click(addItem);
    }

    @LogReport(name = "deleteItem",description = "Click Delete item from order")
    public void deleteItem(){click(deleteItem);}

    @LogReport(name = "itemAdded",description = "Item Added alert message should display")
    public void verifyItemAdded(){
        delayFor(1000);
        String alertText = alertMsg.getText();
        assertThat(alertText, CoreMatchers.containsString("Added !"));
    }

    @LogReport(name = "itemNotFound",description = "Item Not Found alert should display")
    public void verifyItemNotFound(){
        String alertText = alertMsg.getText();
        Assert.assertEquals(alertText, "Item Not Found.");
    }

    @LogReport(name = "restrictedItem",description = "Restricted Item alert should display")
    public void verifyRestrictedItem() {
        delayFor(1000);
        String alertText = alertMsg.getText();
        assertThat(alertText, CoreMatchers.containsString("Restricted Item"));
    }

    @LogReport(name = "searchItem",description = "click on Search Item")
    public void clickSearchItem(){
        searchItemBox.click();
    }


    @LogReport(name = "verifyItem",description = "Added item should display in table")
    public void verifyItemInTable() {
        delayFor(2000);
        WebElement table = driver.findElement(By.xpath("//*[@class='table over-x']"));
        String tableText[][] = getCellTextArray(table);
        String actualItem = tableText[0][1];
        Assert.assertEquals("1105", actualItem);

    }

    @LogReport(name = "submitOrder",description = "Click on Submit order")
    public void submitOrder(){
        submitOrder.click();
    }

    @LogReport(name = "confirmOrder",description = "Click on Confirm Submit")
    public void confirmOrder(){
        submitConfirm.click();
    }

    @LogReport(name = "deliverySurcharge",description = "Delivery Surcharge alert should display")
    public void verifyDeliverySurchargeAlert(){
        delayFor(1000);
        String alertText = deliverySurchargeAlert.getText();
        assertThat(alertText, CoreMatchers.containsString("$10 delivery charge"));
    }

    @LogReport(name = "deleteAll",description = "Click Delete All items")
    public void deleteAllItems(){
        click(deleteAll);
    }


    @LogReport(name = "collectBalance",description = "Type in amount of balance owed collected")
    public void collectBalance(){
        typeText(collectionAmount,"100.00");
    }


    @LogReport(name = "verifyBalanceAmount",description = "Correct amount should display")
    public void verifyCorrectAmountCollected(){
        waitForElementTextToBe(By.xpath("//*[@class='col-md-8 newpad ng-binding'][contains(text(),'$100.00')]"),"$100.00");
        String collectedAmt = collectionAmountAlert.getText();
        Assert.assertEquals(collectedAmt,"$100.00");
    }

    @LogReport(name = "enterPromoCode",description = "Enter promo code from dropdown menu")
    public void enterPromoCode(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", promoCodeBox);

        Actions actions = new Actions(driver);
        actions.moveToElement(promoCodeBox);
        actions.sendKeys("25");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    @LogReport(name = "confirm Promo",description = "Correct promo code should display in popup")
    public void confirmPromoAdded(){
        delayFor(2000);
        String promoType = promoCodeAlert.getText();
        assertThat(promoType,CoreMatchers.containsString("25"));
    }

    @LogReport(name = "deliveryDay",description = "Enter desired day for delivery")
    public void selectDeliveryDay(){
        WebElement element1 = selectDay;
        Select select = new Select(element1);
        select.selectByVisibleText("Mon");
    }

    @LogReport(name = "noDeliveryDay",description = "Enter desired day for no-delivery")
    public void selectNotDeliveryDay() {
        WebElement element1 = selectNotDay;
        Select select = new Select(element1);
        select.selectByVisibleText("Mon");

    }



}















