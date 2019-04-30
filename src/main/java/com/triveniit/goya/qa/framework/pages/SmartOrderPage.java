package com.triveniit.goya.qa.framework.pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

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

    public void verifySmartOrderURL() {
        delayFor(2000);
        String title = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/Smart-Order", title);

    }

    public void verifyCustInfo() {
        String custInfo = custInfoFieldBox.getText();
        assertThat(custInfo, CoreMatchers.containsString("712457"));
    }

    public void addItemByUPC(String itemUPC){
         searchByUPC.sendKeys(itemUPC);
         addItem.click();
    }

    public void submitOrder(){ submitOrderButton.click(); }

    public void submitOrderButtonEnabled(){
        Boolean buttonEnabled = submitOrderButton.isEnabled();
        Assert.assertTrue(buttonEnabled);
    }

    public void submitOrderButtonDisabled(){
        Boolean buttonEnabled = submitOrderButton.isEnabled();
        Assert.assertFalse(buttonEnabled);
    }

    public void submitOrderAlert() { submitOrderAlert.click(); }

    public void confirmSubmit(){ confirmSubmitOrder.click(); }

    public void closeSubmitSuccessAlert(){closeSuccessfulSubmitAlert.click(); }

    public void clearUPCSearch(){ removeUPCSearch.click(); }


    public void reduceItemQty(){ reduceItemQty.click(); }

    public void verifyMinusKeyDisabled(){
        Boolean keyEnabled = reduceItemQty.isEnabled();
        Assert.assertFalse(keyEnabled);
    }

    public void verifyMinusKeyEnabled(){
        Boolean keyEnabled = reduceItemQty.isEnabled();
        Assert.assertTrue(keyEnabled);
    }

    public void increaseItemQty(){
        addItem.click();
    }


    public void verifyItemCount(String textToVerify) {
        delayFor(2000);
        String numberOfItems = itemCount.getText();
        assertThat(numberOfItems, CoreMatchers.containsString(textToVerify));
    }

    public void verifyCaseTotal(String textToVerify) {
        String numberOfCases = caseTotal.getText();
        assertThat(numberOfCases, CoreMatchers.containsString(textToVerify));
    }

    public void verifyCartQty(String textToVerify) {
        String casesInCart = cartQty.getText();
        assertThat(casesInCart, CoreMatchers.containsString(textToVerify));
    }

    public void verifyCartItem(String itemToVerify){
        String itemInCart = cartItemNo.getText();
        assertThat(itemInCart, CoreMatchers.containsString(itemToVerify));
    }

    public void addItemQtyByText() {
        textItemQty.clear();
        textItemQty.sendKeys("9");
        delayFor(2000);
        addItem.click();
        delayFor(2000);
    }

    public void openCart(){ cartButton.click(); }

    public void deleteItemfromCart(){ cartDeleteItem.click(); }

    public void confirmDeliveryCharge(){
        Boolean deliveryCharge = deliveryChargeAlert.isDisplayed();
        Assert.assertTrue(deliveryCharge);
    }

    public void changeNewCustomer() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", customerSelect);
        Actions actions = new Actions(driver);
        actions.moveToElement(customerSelect);
        actions.click();
        actions.sendKeys("712590");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    public void switchCustAlert(){
        String custAlert = switchCustAlert.getText();
        assertThat(custAlert, CoreMatchers.containsString("change customers?"));
    }








}