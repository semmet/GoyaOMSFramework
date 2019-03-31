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
    private WebElement deleteOrder;
    @FindBy(xpath = "//*[@id='pickUp']")
    private WebElement pickUpCheckbox;
    @FindBy(xpath = "//*[@name='searchitem']")
    private WebElement searchItemBox;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitConfirm;





    public CreateOrderPage() {
        super();
        PageFactory.initElements(driver,this);
    }



    public void selectCustomer() {

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", customerSelect);

        Actions actions = new Actions(driver);
        actions.moveToElement(customerSelect);
        actions.click();
        actions.sendKeys("712450");
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

    public void verifyItemAdded(){

        String alertText = alertMsg.getText();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(alertMsg));

        assertThat(alertText, CoreMatchers.containsString("Added !"));

        System.out.println("Item successfully added!");
    }

    public void verifyItemNotFound(){

        String alertText = alertMsg.getText();
        Assert.assertEquals(alertText, "Item Not Found.");
    }

    public void verifyRestrictedItem() {

        String alertText = alertMsg.getText();
        assertThat(alertText, CoreMatchers.containsString("Restricted Item"));

    }

    public void searchItem(){
        searchItemBox.click();
    }

    public void verifyItemInTable() {

        //String expectedItem = "1105";
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




    }










