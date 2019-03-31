package com.triveniit.goya.qa.framework.pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;



public class SmartOrderPage extends PageBase {

    @FindBy(xpath = "//p[@class='ng-binding ng-scope']")
    private WebElement custInfoFieldBox;
    @FindBy(xpath = "//button[@title='Contiune to Order']")
    private WebElement checkoutOrderButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]" +
            "       /div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    private WebElement searchByUPC;
    @FindBy(xpath = "(//button[contains(text(),'+')])[2]")
    private WebElement addItem;
    @FindBy(xpath = "(//button[contains(text(),'+')])[4]")
    private WebElement addNextItem;

    @FindBy(xpath = "(//*[@class='num-bx ng-scope ng-pristine ng-valid'])[2]")
    private WebElement textItemQty;
    @FindBy(xpath = "//*[@class='item-lbl ng-binding'][contains(text(),'Item Count')]")
    private WebElement itemCount;
    @FindBy(xpath = "//*[@class='item-lbl ng-binding'][contains(text(),'Case Total')]")
    private WebElement caseTotal;
    @FindBy(xpath = "//*[@class='items ng-binding']")
    private WebElement cartQty;


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
        assertThat(custInfo, CoreMatchers.containsString("712450"));
    }

    public void addFirstItem() {
        addItem.click();
    }

    public void addAnotherItem(){
        addNextItem.click();
    }

    public void verifyCorrectItem(){

    }

    public void verifyItemCount1() {
        String numberOfItems = itemCount.getText();
        assertThat(numberOfItems, CoreMatchers.containsString("1"));
    }

    public void verifyItemCount2() {
        String numberOfItems = itemCount.getText();
        assertThat(numberOfItems, CoreMatchers.containsString("2"));
    }

    public void verifyCasetotal1() {
        String numberOfCases = caseTotal.getText();
        assertThat(numberOfCases, CoreMatchers.containsString("1"));
    }

    public void verifyCaseTotal3() {
        String numberOfCases = caseTotal.getText();
        assertThat(numberOfCases, CoreMatchers.containsString("3"));
    }

    public void verifyCartQty() {
        String casesInCart = cartQty.getText();
        assertThat(casesInCart, CoreMatchers.containsString("1"));
    }

    public void addFirstItemText() {
        textItemQty.sendKeys("10");
        delayFor(2000);
        addItem.click();
        delayFor(2000);
    }


}