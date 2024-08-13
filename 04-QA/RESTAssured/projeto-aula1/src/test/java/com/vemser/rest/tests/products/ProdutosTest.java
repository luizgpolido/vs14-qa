package com.vemser.rest.tests.products;

import com.vemser.rest.pojo.LoginPOJO;
import com.vemser.rest.pojo.ProdutosPOJO;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class ProdutosTest {

    Faker faker = new Faker(new Locale("PT-BR"));
    Random rand = new Random();
    String bearerToken;

    //Método de Extração do Path Auth retirado de uma solução no stackoverflow "Rest-assured. Is it possible to extract value from request json?"

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
                .statusCode(201)
        ;
    }

    @Test
    @DisplayName("[Positivo] - Editar produto com informações válidas")
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
        ;
    }

    @Test
    @DisplayName("[Positivo] - Deletar produto com ID válido")
    public void testDeletarProdutoVálido(){

        String id = "0vEH7WwvgS5IzuB6";

        given()
                .pathParam("id", id)
                .header("Authorization" , bearerToken)
                .when()
                .delete("/produtos/{id}")
                .then()
                .statusCode(200)
        ;
    }

    @Test
    @DisplayName("[Positivo] - Listar todos os produtos")
    public void testListarTodosProdutoVálido(){

        given()
                .header("Authorization" , bearerToken)
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
        ;
    }

    @Test
    @DisplayName("[Positivo] - Listar produto por ID")
    public void testListarProdutoPorID(){

        String id = "7SZbUWdrUUyiO7kz";

        given()
                .header("Authorization" , bearerToken)
                .pathParam("id", id)
                .when()
                .get("/produtos/{id}")
                .then()
                .statusCode(200)
        ;
    }

    //Testes Negativos

    @Test
    @DisplayName("[Negativo] - Listar produto por ID inválido")
    public void testListarProdutoPorIDInvalido(){

        String id = "7SZbUWdrUUyiO7kza";

        given()
                .header("Authorization" , bearerToken)
                .pathParam("id", id)
                .when()
                .get("/produtos/{id}")
                .then()
                .statusCode(400)
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
        ;
    }

    @Test
    @DisplayName("[Negativo] - Deletar produto com  sem token de autenticação")
    public void testDeletarProdutoSemAutenticacao(){

        String id = "0WHK60qcupglDi5x";

        given()
                .pathParam("id", id)
                .when()
                .delete("/produtos/{id}")
                .then()
                .statusCode(401)
        ;
    }

    @Test
    @DisplayName("[Negativo] - Deletar produto com  ID nulo")
    public void testDeletarProdutoComIDNulo(){

        String id = "";

        given()
                .pathParam("id", id)
                .when()
                .delete("/produtos/{id}")
                .then()
                .statusCode(405) // 405 pois tecnicamente ao inserir um ID NULO, seria como se estivessemos dando um delete em /produtos, ou seja, como não existe o método no backend retorna um (405), mas vale o teste
        ;
    }
}
