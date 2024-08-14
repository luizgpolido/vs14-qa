package com.vemser.rest.tests.produtos;

import com.vemser.rest.model.login.LoginPOJO;
import com.vemser.rest.model.produtos.ProdutosPOJO;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AtualizarProdutoTest {

    Faker faker = new Faker(new Locale("PT-BR"));
    Random rand = new Random();
    String bearerToken;


    @BeforeEach
    public void login(){
        baseURI = "http://localhost:3000";

        LoginPOJO login = new LoginPOJO();
        login.setEmail("fulano@qa.com");
        login.setPassword("teste");

        bearerToken =
                given()
                        .body(login)
                        .contentType("application/json")
                        .log().all()
                        .when()
                        .post("/login")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .path("authorization")
        ;
    }


    @Test
    @DisplayName("[Positivo] - Editar produto com id existente e informações válidas")
    public void testEditarProdutoVálido(){

        ProdutosPOJO produto = new ProdutosPOJO();
        produto.setNome(faker.food().fruit() + faker.food().fruit() + faker.food().fruit());
        produto.setPreco(rand.nextInt(100));
        produto.setDescricao(faker.text().text());
        produto.setQuantidade(rand.nextInt(100));

        String id = "7SZbUWdrUUyiO7kz";

        given()
                .header("Authorization" , bearerToken)
                .contentType("application/json")
                .body(produto)
                .log().all()
                .pathParam("id", id)
                .when()
                .put("/produtos/{id}")
                .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Registro alterado com sucesso"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Editar produto com nome existente")
    public void testEditarProdutoComNomeJaExistente(){

        ProdutosPOJO produto = new ProdutosPOJO();
        produto.setNome("Hat Sausages");
        produto.setPreco(rand.nextInt(100));
        produto.setDescricao(faker.text().text());
        produto.setQuantidade(rand.nextInt(100));
        String id = "0vEH7WwvgS5IzuB6";


        given()
                .header("Authorization" , bearerToken)
                .contentType("application/json")
                .body(produto)
                .log().all()
                .pathParam("id", id)
                .when()
                .put("/produtos/{id}")
                .then()
                .statusCode(400)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Já existe produto com esse nome"))
        ;
    }

}
