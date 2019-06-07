package com.triveniit.goya.qa.framework.pages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocBriefcase extends PageBase {

    @FindBy(xpath = "(//*[@class='notify-count ng-binding ng-scope'])[1]")
    private WebElement brokerNotice;
    @FindBy(xpath = "//button[@title='Briefcase Select default customer to ADD']")
    private WebElement addDocButton;
    @FindBy(xpath = "//*[@class='ng-binding ng-scope'][@value='Other']")
    private WebElement docTypeOther;
    @FindBy(xpath = "//*[@name='comment']")
    private WebElement addComment;
    @FindBy(xpath = "//*[@class='tags']")
    private WebElement addTag;
    @FindBy(xpath = "//button[@title='Briefcase upload Document']")
    private WebElement saveDoc;





    public DocBriefcase() {
        super();
        PageFactory.initElements(driver, this);
    }


    public void verifyBriefcaseURL() {
        delayFor(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://portal.goya.com/omsdev/#/Sales-Doc-Uploader", URL);
    }




}
