package com.triveniit.goya.qa.testscripts;

import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DocBriefcaseTest extends ScriptBase {

    @BeforeMethod
    public void navigateToDocBriefcase(){
        homePage.navigateToDocBriefcase();
        docBriefcase.verifyBriefcaseURL();
    }










}
