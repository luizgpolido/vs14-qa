//package com.vemser.rest.tests.produtos;
//
//import com.vemser.rest.model.login.LoginPOJO;
//import net.datafaker.Faker;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.notNullValue;
//
//public class DeletarProdutoTest {
//
//
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
//    @DisplayName("[Positivo] - Deletar produto com ID válido")
//    public void testDeletarProdutoVálido(){
//
//        String id = "CBWoedarXnzPFS82";
//
//        given()
//                .pathParam("id", id)
//                .header("Authorization" , bearerToken)
//        .when()
//                .delete("/produtos/{id}")
//        .then()
//                .statusCode(200)
//                .header("Content-Type" , "application/json; charset=utf-8")
//                .body("message", equalTo("Registro excluído com sucesso"))
//        ;
//    }
//
//    @Test
//    @DisplayName("[Negativo] - Deletar produto com  sem token de autenticação")
//    public void testDeletarProdutoSemAutenticacao(){
//
//        String id = "0WHK60qcupglDi5x";
//
//        given()
//                .pathParam("id", id)
//        .when()
//                .delete("/produtos/{id}")
//        .then()
//                .statusCode(401)
//                .header("Content-Type" , "application/json; charset=utf-8")
//                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
//        ;
//    }
//
//    @Test
//    @DisplayName("[Negativo] - Deletar produto com  ID nulo")
//    public void testDeletarProdutoComIDNulo(){
//
//        String id = "";
//
//        given()
//                .pathParam("id", id)
//        .when()
//                .delete("/produtos/{id}")
//        .then()
//                .statusCode(405) // 405 pois tecnicamente ao inserir um ID NULO, seria como se estivessemos dando um delete em /produtos, ou seja, como não existe o método no backend retorna um (405), mas vale o teste
//                .body("message", notNullValue())
//        ;
//    }
//}
