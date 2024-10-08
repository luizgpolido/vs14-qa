package com.vemser.rest.client;

import com.vemser.rest.model.LoginModel;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginClient extends BaseClient{

    private final String LOGIN = "/login";

    public Response realizarLogin(LoginModel loginModel){
        return
                given()
                        .spec(super.set())
                        .contentType("application/json")
                        .body(loginModel)
                .when()
                    .post(LOGIN)
                ;
    }
}
