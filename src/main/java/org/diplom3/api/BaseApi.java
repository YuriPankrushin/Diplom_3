package org.diplom3.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.diplom3.utils.Constants.BASE_URL;

public class BaseApi {
    public RequestSpecification requestSpecification =
            RestAssured.given()
                    .baseUri(BASE_URL)
                    .header("Content-type", "application/json");
}