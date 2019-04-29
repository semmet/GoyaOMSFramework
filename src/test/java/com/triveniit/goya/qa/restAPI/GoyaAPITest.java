package com.triveniit.goya.qa.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

import static io.restassured.path.xml.XmlPath.from;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;


public class GoyaAPITest {


    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = "";
        RestAssured.port = 443;
        RestAssured.basePath = "";
    }

    @Test
    public void test1(){
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
    public void test2(){


        given()
                .log().all()
                .param("", "")
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .when()
                .get("")
                .then()
                .log().body()
                .statusCode(200);

    }




}




