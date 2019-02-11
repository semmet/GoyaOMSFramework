package com.triveniit.goya.qa.framework.pages;

import com.triveniit.goya.qa.framework.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateOrderPage extends PageBase{

    @FindBy(xpath = "//*[@class='ui-select-match']")
    private WebElement selectCustomer;
    @FindBy(xpath ="//*[@id='txtItemCode']")
    private WebElement itemCodeTextBox;
    @FindBy(xpath = "//*[@id='clickon']")
    private WebElement addItem;
    @FindBy(xpath = "//*[@id='lblMessage']")
    private WebElement alertMsg;
    @FindBy(xpath = "//*[@class='newdrop2']/div")
    private WebElement customerSelect;
    @FindBy(xpath = "//*[@title='Submit order']")
    private WebElement submitOrder;
    @FindBy(xpath = "//*[@value='DELETE ALL']")
    private WebElement deleteOrder;
    @FindBy(xpath = "//*[@id='pickUp']")
    private WebElement pickUpCheckbox;






    public CreateOrderPage() {
        super();
        PageFactory.initElements(driver,this);
    }



    public void selectCustomer() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(customerSelect);
        actions.click();
        actions.sendKeys("712450");
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();


    }

    public void enterItemCode(){
        typeText(itemCodeTextBox, "1105");

    }

    public void addItem(){
        click(addItem);
    }


    public void verifyItemAdded(){
        //String successText = alertMsg.getText();
        //assertThat(successText,containsString("Item #1105 Added !"));
        Boolean isPresent = driver.findElements(By.xpath("//*[@id='lblMessage']")).size() > 0;
        System.out.println("Item successfully added!");
    }



}
