package com.triveniit.goya.qa.framework.pages;

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


    public void verifyOrderPageDisplay(){
        delayFor(2000);
        String url = driver.getCurrentUrl();
        assertThat(url, CoreMatchers.containsString("https://portal.goya.com/omsdev/#/order-entry"));
    }


    public void selectCustomer() {

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", customerSelect);

        Actions actions = new Actions(driver);
        actions.moveToElement(customerSelect);
        actions.click();
        actions.sendKeys("712457");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();

    }

    public void enterItemCode(){
        typeText(itemCodeTextBox, "1105");
    }

    public void enterRestrictedItem(){
        typeText(itemCodeTextBox, "1107");
    }

    public void enterInvalidItemCode() {
        typeText(itemCodeTextBox, "XXXX");
    }

    public void addItem(){
        click(addItem);
    }

    public void enterInvalidItemQty(){
        typeText(itemCaseQty,"-10");
    }

    public void addAnotherItem(){
        typeText(itemCodeTextBox,"2161");
        click(addItem);
    }

    public void deleteItem(){click(deleteItem);}

    public void verifyItemAdded(){
        delayFor(1000);
        String alertText = alertMsg.getText();
        assertThat(alertText, CoreMatchers.containsString("Added !"));
    }

    public void verifyItemNotFound(){
        String alertText = alertMsg.getText();
        Assert.assertEquals(alertText, "Item Not Found.");
    }

    public void verifyRestrictedItem() {
        delayFor(1000);
        String alertText = alertMsg.getText();
        assertThat(alertText, CoreMatchers.containsString("Restricted Item"));
    }

    public void clickSearchItem(){
        searchItemBox.click();
    }


    public void verifyItemInTable() {

        delayFor(2000);
        WebElement table = driver.findElement(By.xpath("//*[@class='table over-x']"));
        String tableText[][] = getCellTextArray(table);
        String actualItem = tableText[0][1];
        Assert.assertEquals("1105", actualItem);

    }

    public void submitOrder(){
        submitOrder.click();
    }

    public void confirmOrder(){
        submitConfirm.click();
    }

    public void verifyDeliverySurchargeAlert(){
        delayFor(1000);
        String alertText = deliverySurchargeAlert.getText();
        assertThat(alertText, CoreMatchers.containsString("$10 delivery charge"));
    }


    public void deleteAllItems(){
        click(deleteAll);
    }


    public void collectBalance(){
        typeText(collectionAmount,"100.00");
    }

    public void verifyCorrectAmountCollected(){
        waitForElementTextToBe(By.xpath("//*[@class='col-md-8 newpad ng-binding'][contains(text(),'$100.00')]"),"$100.00");
        String collectedAmt = collectionAmountAlert.getText();
        Assert.assertEquals(collectedAmt,"$100.00");
    }

    public void enterPromoCode(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", promoCodeBox);

        Actions actions = new Actions(driver);
        actions.moveToElement(promoCodeBox);
        actions.sendKeys("25");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    public void confirmPromoAdded(){
        delayFor(2000);
        String promoType = promoCodeAlert.getText();
        assertThat(promoType,CoreMatchers.containsString("25"));
    }

    public void selectDeliveryDay(){
        WebElement element1 = selectDay;
        Select select = new Select(element1);
        select.selectByVisibleText("Mon");
    }

    public void selectNotDeliveryDay() {
        WebElement element1 = selectNotDay;
        Select select = new Select(element1);
        select.selectByVisibleText("Mon");

    }

}















