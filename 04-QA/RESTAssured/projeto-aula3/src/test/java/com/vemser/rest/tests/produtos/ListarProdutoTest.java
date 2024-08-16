//package com.vemser.rest.tests.produtos;
//
//import com.vemser.rest.model.login.LoginPOJO;
//import net.datafaker.Faker;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.Locale;
//import java.util.Random;
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.notNullValue;
//
//public class ListarProdutoTest {
//
//    Faker faker = new Faker(new Locale("PT-BR"));
//    Random rand = new Random();
//    String bearerToken;
//
//    @BeforeEach
//    public void login(){
//        baseURI = "http://localhost:3000";
//
//        LoginPOJO login = new LoginPOJO();
//        login.setEmail("fulano@qa.com");
//        login.setPassword("teste");
//
//        bearerToken =
//                given()
//                        .body(login)
//                        .contentType("application/json")
//                        .log().all()
//                .when()
//                        .post("/login")
//                .then()
//                        .log().all()
//                        .statusCode(200)
//                        .extract()
//                        .path("authorization")
//        ;
//    }
//
//
//    @Test
//    @DisplayName("[Positivo] - Listar todos os produtos")
//    public void testListarTodosProdutoVálido(){
//
//
//        given()
//                .header("Authorization" , bearerToken)
//        .when()
//                .get("/produtos")
//        .then()
//                .statusCode(200)
//                .header("Content-Type" , "application/json; charset=utf-8")
//                .body("quantidade", notNullValue())
//                .body(matchesJsonSchemaInClasspath("schemas/todos_os_produtos.json"))
//        ;
//    }
//
//    @Test
//    @DisplayName("[Positivo] - Listar produto por ID")
//    public void testListarProdutoPorID(){
//
//        String id = "7SZbUWdrUUyiO7kz";
//
//        given()
//                .header("Authorization" , bearerToken)
//                .pathParam("id", id)
//        .when()
//                .get("/produtos/{id}")
//        .then()
//                .statusCode(200)
//                .header("Content-Type" , "application/json; charset=utf-8")
//                .body("quantidade", notNullValue())
//                .body(matchesJsonSchemaInClasspath("schemas/produto_por_id.json"))
//        ;
//    }
//
//    //Testes Negativos
//
//    @Test
//    @DisplayName("[Negativo] - Listar produto por ID inválido")
//    public void testListarProdutoPorIDInvalido(){
//
//        String id = "7SZbUWdrUUyiO7kza";
//
//        given()
//                .header("Authorization" , bearerToken)
//                .pathParam("id", id)
//        .when()
//                .get("/produtos/{id}")
//        .then()
//                .statusCode(400)
//                .header("Content-Type" , "application/json; charset=utf-8")
//                .body("message", equalTo("Produto não encontrado"))
//        ;
//
//    }
//}
