package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class RestApiExample {
    String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
    private final String employeesEndpoint = "employees";
    private final String employeeEndpoint = "employee/4";
    private final String createEmployee = "create";
    private final String updateEmployee = "update/5";
    private final String deleteEmployee = "delete/6";
    

    @Test
    public void getAllEmployees() {
        Response response = RestAssured.given().when().get(employeesEndpoint)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

    }

    @Test
    public void getIndividualAllEmployees() {
        Response response = RestAssured.given().when().get(employeeEndpoint)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

    }

    @Test
    public void createAnEmployee() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "karim ");
        jsonObject.put("salary", "10000");
        jsonObject.put("age", "25");


        System.out.println(jsonObject);
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject)
                .when().post(createEmployee)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void updateAnEmployee() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("salary", "120000");
        jsonObject.put("name", "Test User001");


        System.out.println(jsonObject);
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
                .when().put(updateEmployee)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void deleteAnEmployee() {
        Response response = RestAssured.given().when().delete(deleteEmployee)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }
}