package com.triveniit.goya.qa.restAPI;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.triveniit.goya.qa.framework.scriptbase.ScriptBase;
import com.triveniit.goya.qa.framework.utils.ExtentManager;
import com.triveniit.goya.qa.framework.utils.ExtentTestNGITestListener;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



@Listeners({ExtentTestNGITestListener.class})

public class GoyaAPITest {

    private ExtentManager report = ExtentManager.getInstance();


    @BeforeClass
    public void beforeClass() {

        report = ExtentManager.getInstance();

        RestAssured.baseURI = "https://portal.goya.com";

        RestAssured.basePath = "OMSWebApiUAT2/api";
    }


    @Test
    public void loginTest(){

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("{\"grant_type\":\"password\",\"password\":\"Pwd@013506\",\"userId\":\"013506\"}");

        Response response  = requestSpecification.relaxedHTTPSValidation().post("/user");
        String jsonString =  response.asString();
        System.out.println(jsonString);

        //List<String> authToken = new ArrayList<>();
        String authToken = with(jsonString).get("Event");

        System.out.println("AuthToken:  " + authToken);

        assertThat(authToken, not(isEmptyOrNullString()));

    }


    @Test
    public void verifyAuthTokenRequired(){

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("{\"CompanyId\":\"01\", \"CustomerId\":\"717660\"}");

        Response response  = requestSpecification.relaxedHTTPSValidation().post("/Customer/CustomersDetailByCustomerIdPost");
        String jsonString =  response.asString();
        System.out.println(jsonString);


        String userAccess = with(jsonString).get("Message");

        System.out.println("User access :  " + userAccess);

        assertThat(userAccess, CoreMatchers.containsString("Authorization has been denied for this request."));

    }




}




