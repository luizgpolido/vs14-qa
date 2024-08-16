//package com.vemser.rest.tests.login;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//public class LoginTest {
//
//    @BeforeEach
//    public void setUp() {
//        baseURI = "http://localhost:3000";
//    }
//
//
//    @Test
//    @DisplayName("[Positivo] - Login com credenciais válidas")
//    public void testLoginComCredenciaisValidas() {
//
//        LoginPOJO login = new LoginPOJO();
//        login.setEmail("fulano@qa.com");
//        login.setPassword("teste");
//
//        given()
//                .body(login)
//                .contentType("application/json")
//        .when()
//                .post("/login")
//        .then()
//                .statusCode(200)
//                .header("Content-Type", "application/json; charset=utf-8")
//                .body("message", equalTo("Login realizado com sucesso"))
//                .body("authorization", notNullValue())
//        ;
//    }
//
//    @Test
//    @DisplayName("[Negativo] - Login com senha inválida")
//    public void testLoginComSenhaInvalidas() {
//
//        LoginPOJO login = new LoginPOJO();
//        login.setEmail("fulano@qa.com");
//        login.setPassword("salsicha");
//
//        given()
//                .body(login)
//                .contentType("application/json")
//        .when()
//                .post("/login")
//        .then()
//                .statusCode(401)
//                .header("Content-Type", "application/json; charset=utf-8")
//                .body("message", equalTo("Email e/ou senha inválidos"))
//        ;
//    }
//
//    @Test
//    @DisplayName("[Negativo] - Login com email nulo")
//    public void testLoginComEmailNula() {
//
//        LoginPOJO login = new LoginPOJO();
//        login.setEmail("");
//        login.setPassword("teste");
//
//        given()
//                .body(login)
//                .contentType("application/json")
//        .when()
//                .post("/login")
//        .then()
//                .statusCode(400)
//                .header("Content-Type", "application/json; charset=utf-8")
//                .body("email", equalTo("email não pode ficar em branco"))
//        ;
//    }
//
//    @Test
//    @DisplayName("[Negativo] - Login com senha nula")
//    public void testLoginComSenhaNula() {
//
//        LoginPOJO login = new LoginPOJO();
//        login.setEmail("fulano@qa.com");
//        login.setPassword("");
//
//        given()
//                .body(login)
//                .contentType("application/json")
//        .when()
//                .post("/login")
//        .then()
//                .statusCode(400)
//                .header("Content-Type", "application/json; charset=utf-8")
//                .body("password", equalTo("password não pode ficar em branco"))
//        ;
//    }
//
//
//}