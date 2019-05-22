package com.triveniit.goya.qa.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.*;
import static io.restassured.path.xml.XmlPath.from;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;


public class GoyaAPITest {


    @BeforeMethod
    public void beforeClass(){
        RestAssured.baseURI = "https://portal.goya.com/omsdev";
        RestAssured.port = 80;
        RestAssured.basePath = "";
    }


    @Test
    public void testStatusCode(){

        RequestSpecification request = given()
                                        .log().all()
                                        .contentType(ContentType.XML)
                                        .accept(ContentType.XML)
                                        .param("q","");

        Response response = request.get("");
        System.out.println(response.prettyPrint());

        ValidatableResponse responseToValidate = response.then();

        responseToValidate.statusCode(200);
    }

    @Test
    public void test(){

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.param("");

        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.get("");

        int statusCode =  response.statusCode();
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");
    }


    @Test
    public void searchTestProducts(){

    }






}




