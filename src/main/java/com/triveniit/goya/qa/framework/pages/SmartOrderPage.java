package com.triveniit.goya.qa.framework.pages;

import com.paxovision.execution.annotations.LogReport;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;



public class SmartOrderPage extends PageBase {

    @FindBy(xpath = "//p[@class='ng-binding ng-scope']")
    private WebElement custInfoFieldBox;
    @FindBy(xpath = "(//div[@title='Customer'])[2]")
    private WebElement customerSelect;
    @FindBy(xpath = "//button[@title='SmartOrder Contiune to Submit']")
    private WebElement submitOrderButton;
    @FindBy(xpath = "//*[@title='SmartOrder Submit']")
    private WebElement submitOrderAlert;
    @FindBy(xpath = "//button[contains (text(),'Yes, I am sure!')]")
    private WebElement confirmSubmitOrder;
    @FindBy(xpath = "//div[contains (text(),'Submitted Successfully!')]")
    private WebElement confirmSubmitSuccess;
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    private WebElement closeSuccessfulSubmitAlert;
    @FindBy(xpath = "(//*[@class='ui-grid-filter-container ng-scope']/div/input)[1]")
    private WebElement searchByUPC;
    @FindBy(xpath = "(//*[@aria-label='Remove Filter'])[1]")
    private WebElement removeUPCSearch;
    @FindBy(xpath = "(//button[contains(text(),'+')])[1]")
    private WebElement addItem;
    @FindBy(xpath = "//*[@class='btn btn-danger freen-new ng-scope']")
    private WebElement reduceItemQty;
    @FindBy(xpath = "//*[@class='deleteItem-btn']")
    private WebElement cartDeleteItem;
    @FindBy(xpath = "//input[@ng-model='row.entity.Count']")
    private WebElement textItemQty;
    @FindBy(xpath = "//*[@class='item-lbl  txt-lt ng-binding']")
    private WebElement itemCount;
    @FindBy(xpath = "//*[@class='item-lbl ng-binding'][contains(text(),'Case Total')]")
    private WebElement caseTotal;
    @FindBy(xpath = "//*[@class='items ng-binding']")
    private WebElement cartQty;
    @FindBy(xpath = "//*[@title='SmartOrder Cart']")
    private WebElement cartButton;
    @FindBy(xpath = "//li[@class='li-first ng-binding']")
    private WebElement cartItemNo;
    @FindBy(xpath = "//div[contains(text(),'$10 delivery charge')]")
    private WebElement deliveryChargeAlert;
    @FindBy(xpath = "//div[@class='swal-text']")
    private WebElement submitOrderNumber;
    @FindBy(xpath = "//div[@class='swal-title']")
    private WebElement switchCustAlert;




    public SmartOrderPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @LogReport(name = "verifyURL",description = "Smart Order Page URL should display")
    public void verifySmartOrderURL() {
        delayFor(2000);
        String title = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/Smart-Order", title);

    }

    @LogReport(name = "customerInfo",description = "Correct customer ID should display")
    public void verifyCustInfo() {
        String custInfo = custInfoFieldBox.getText();
        assertThat(custInfo, CoreMatchers.containsString("712457"));
    }


    @LogReport(name = "itemUPC",description = "Correct item should be added to order")
    public void addItemByUPC(String itemUPC){
         searchByUPC.sendKeys(itemUPC);
         delayFor(2000);
         addItem.click();
    }

    @LogReport(name = "submitOrder",description = "Click on Submit order")
    public void submitOrder(){ submitOrderButton.click(); }

    @LogReport(name = "submitButtonEnabled",description = "Submit Order button should be enabled")
    public void submitOrderButtonEnabled(){
        Boolean buttonEnabled = submitOrderButton.isEnabled();
        Assert.assertTrue(buttonEnabled);
    }

    @LogReport(name = "submitButtonDisabled",description = "Submit Order button should be disabled")
    public void submitOrderButtonDisabled(){
        Boolean buttonEnabled = submitOrderButton.isEnabled();
        Assert.assertFalse(buttonEnabled);
    }

    @LogReport(name = "submitOrderAlert",description = "Click on Submit")
    public void submitOrderAlert() { submitOrderAlert.click(); }

    @LogReport(name = "confirmSubmit",description = "Click on Yes to confirm order")
    public void confirmSubmit(){ confirmSubmitOrder.click(); }

    @LogReport(name = "closeAlert",description = "Successful Order alert should display")
    public void closeSubmitSuccessAlert(){closeSuccessfulSubmitAlert.click(); }

    @LogReport(name = "clearSearch",description = "Clear search filter box")
    public void clearUPCSearch(){ removeUPCSearch.click(); }

    @LogReport(name = "minusQtyKey",description = "click on minus qty key")
    public void reduceItemQty(){ reduceItemQty.click(); }

    @LogReport(name = "minusKeyDisable",description = "Minus qty key should be disabled")
    public void verifyMinusKeyDisabled(){
        Boolean keyEnabled = reduceItemQty.isEnabled();
        Assert.assertFalse(keyEnabled);
    }

    @LogReport(name = "minusQtyKey",description = "Minus qty key should be enabled")
    public void verifyMinusKeyEnabled(){
        Boolean keyEnabled = reduceItemQty.isEnabled();
        Assert.assertTrue(keyEnabled);
    }

    @LogReport(name = "addItem",description = "Add item to order")
    public void increaseItemQty(){
        addItem.click();
    }


    @LogReport(name = "itemCount",description = "Correct number item count should display")
    public void verifyItemCount(String textToVerify) {
        delayFor(2000);
        String numberOfItems = itemCount.getText();
        assertThat(numberOfItems, CoreMatchers.containsString(textToVerify));
    }

    @LogReport(name = "caseQty",description = "Correct number case qty should display")
    public void verifyCaseTotal(String textToVerify) {
        String numberOfCases = caseTotal.getText();
        assertThat(numberOfCases, CoreMatchers.containsString(textToVerify));
    }

    @LogReport(name = "cartQty",description = "Correct number item cases should display")
    public void verifyCartQty(String textToVerify) {
        String casesInCart = cartQty.getText();
        assertThat(casesInCart, CoreMatchers.containsString(textToVerify));
    }


    @LogReport(name = "cartItem",description = "Correct item should be shown in cart")
    public void verifyCartItem(String itemToVerify){
        String itemInCart = cartItemNo.getText();
        assertThat(itemInCart, CoreMatchers.containsString(itemToVerify));
    }


    @LogReport(name = "textQtyFunction",description = "Correct number should be accepted via text")
    public void addItemQtyByText() {
        WebElement qtyText = driver.findElement(By.xpath("(//*[@ng-model='row.entity.Count'])[2]"));
        qtyText.clear();
        qtyText.sendKeys("9");
        delayFor(1000);
        driver.findElement(By.xpath("(//button[contains(text(),'+')])[2]")).click();
    }

    @LogReport(name = "clickCart",description = "Contents of cart should display")
    public void openCart(){ cartButton.click(); }

    @LogReport(name = "clickDelete",description = "Item should be deleted from cart")
    public void deleteItemfromCart(){ cartDeleteItem.click(); }


    @LogReport(name = "deliveryCharge",description = "Delivery surcharge should display in alert")
    public void confirmDeliveryCharge(){
        Boolean deliveryCharge = deliveryChargeAlert.isDisplayed();
        Assert.assertTrue(deliveryCharge);
    }

    @LogReport(name = "switchCustomer",description = "User switches to new customer")
    public void changeNewCustomer() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", customerSelect);
        Actions actions = new Actions(driver);
        actions.moveToElement(customerSelect);
        actions.click();
        actions.sendKeys("712590");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    @LogReport(name = "customerAlert",description = "Switch Customer alert should display")
    public void switchCustAlert(){
        String custAlert = switchCustAlert.getText();
        assertThat(custAlert, CoreMatchers.containsString("change customers?"));
    }


}