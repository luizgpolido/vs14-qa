package com.vemser.rest.tests.produtos;

import com.vemser.rest.model.produtos.ProdutosPOJO;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CadastrarProdutoTest {


    Faker faker = new Faker(new Locale("PT-BR"));
    Random rand = new Random();
    String bearerToken;

    @Test
    @DisplayName("[Positivo] - Cadastrar produto com informações válidas")
    public void testCadastrarProdutoVálido(){

        ProdutosPOJO produto = new ProdutosPOJO();
        produto.setNome(faker.food().fruit() + faker.food().fruit() + faker.food().fruit());
        produto.setPreco(rand.nextInt(100));
        produto.setDescricao(faker.text().text());
        produto.setQuantidade(rand.nextInt(100));

        given()
                .header("Authorization" , bearerToken)
                .contentType("application/json")
                .body(produto)
                .log().all()
                .when()
                .post("/produtos")
                .then()
                .header("Content-Type" , "application/json; charset=utf-8")
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/cadastrar_produto.json"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Cadastrar produto com nome já existente")
    public void testCadastrarProdutoComNomeJaExistente(){

        ProdutosPOJO produto = new ProdutosPOJO();
        produto.setNome("Hat Sausages");
        produto.setPreco(rand.nextInt(100));
        produto.setDescricao(faker.text().text());
        produto.setQuantidade(rand.nextInt(100));

        given()
                .header("Authorization" , bearerToken)
                .contentType("application/json")
                .body(produto)
                .log().all()
                .when()
                .post("/produtos")
                .then()
                .statusCode(400)
        ;
    }

    @Test
    @DisplayName("[Negativo] - Cadastrar produto com preço com negativo")
    public void testCadastrarProdutoComPrecoInvalido(){

        ProdutosPOJO produto = new ProdutosPOJO();
        produto.setNome(faker.food().fruit() + faker.food().fruit() + faker.food().fruit());
        produto.setPreco(-200);
        produto.setDescricao(faker.text().text());
        produto.setQuantidade(rand.nextInt(100));

        given()
                .header("Authorization" , bearerToken)
                .contentType("application/json")
                .body(produto)
                .log().all()
                .when()
                .post("/produtos")
                .then()
                .statusCode(400)
                .body("preco", equalTo("preco deve ser um número positivo"))
        ;
    }
}
