package com.vemser.rest.tests.produtos;

import com.vemser.rest.model.login.LoginPOJO;
import com.vemser.rest.model.produtos.ProdutosPOJO;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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
                .header("Content-Type" , "application/json; charset=utf-8")
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/cadastrar_produto.json"))
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
    @DisplayName("[Positivo] - Deletar produto com ID válido")
    public void testDeletarProdutoVálido(){

        String id = "CBWoedarXnzPFS82";

        given()
                .pathParam("id", id)
                .header("Authorization" , bearerToken)
        .when()
                .delete("/produtos/{id}")
        .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Registro excluído com sucesso"))
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
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/todos_os_produtos.json"))
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
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/produto_por_id.json"))
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
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Produto não encontrado"))
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
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
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
                .body("message", notNullValue())
        ;
    }
}