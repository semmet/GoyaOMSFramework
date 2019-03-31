package com.triveniit.goya.qa.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;




public class CatalogPage extends PageBase {


    @FindBy(xpath = "//*[@title='Add item to Order']")
    private WebElement addItem;
    @FindBy(xpath = "//div[@id='cart']//button[@type='button']")
    private WebElement cartButton;
    @FindBy(xpath = "//*[@title='Contiune to Order']")
    private WebElement continueButton;
    @FindBy(xpath = "//button[contains(text(),'Add To Cart')]")
    private WebElement qtyAlertAdd;
    @FindBy(xpath = "//*[@ng-model='count']")
    private WebElement itemQtyText;
    @FindBy(xpath = "//*[@class='plus-btn1']")
    private WebElement itemIncrease;
    @FindBy(xpath = "//div[@class='modal-body padd-remove']//button[@id='minus']")
    private WebElement itemDecrease;
    @FindBy(xpath = "//*[@class='orangeBtn close-crt-btn1']")
    private WebElement qtyAlertClose;
    @FindBy(xpath = "//*[@name='s']")
    private WebElement searchItemCode;
    @FindBy(xpath = "//div[@class='pop-up-wind-ing']")
    private WebElement qtyPopUp;


    public CatalogPage() {

        PageFactory.initElements(driver, this);

    }

    public void addItemToOrder() throws InterruptedException {

        /*Actions actions = new Actions(driver);
        actions.moveToElement(searchItemCode);
        actions.sendKeys("1107");
        actions.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        addItem.click(); */

        searchItemCode.sendKeys("1105");
        Thread.sleep(2000);
        addItem.click();

    }

    public void verifyQtyWindowPopUp() {
        // WebElement
        Assert.assertEquals(true, qtyPopUp.isDisplayed());

    }

    public void addItemQty() {
        qtyAlertAdd.click();
    }

    public void verifyOneItemInCart() {

        verifyText(By.xpath("//div[@id='cart']//button[@type='button']"), "1 Items");

    }

    public void continueWithOrder() {
        continueButton.click();
    }


    public void urlVerify() {

        String title = driver.getCurrentUrl();
        assertThat(title, startsWith("https://portal.goya.com/omsdev/#/order-entry-addinfo"));
    }




}
