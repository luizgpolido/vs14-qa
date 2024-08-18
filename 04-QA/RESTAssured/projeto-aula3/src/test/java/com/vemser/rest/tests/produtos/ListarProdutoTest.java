package com.vemser.rest.tests.produtos;

import com.vemser.rest.client.ProdutoClient;

import com.vemser.rest.data.factory.ProdutoDataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class ListarProdutoTest {

    ProdutoClient produtoClient = new ProdutoClient();


    @Test
    @DisplayName("[Positivo] - Listar todos os produtos com validação de contrato")
    public void testListarTodosProdutoValido(){


        produtoClient.listarProdutos()
        .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/todos_os_produtos.json"))
        ;
    }

    @Test
    @DisplayName("[Positivo] - Listar produto por ID com validação de contrato")
    public void testListarProdutoPorID(){

        String id = ProdutoDataFactory.getPrimeiroProduto().get_id();

        produtoClient.listarProdutosPorId(id)
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


        produtoClient.listarProdutosPorId("1234")
        .then()
                .statusCode(400)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Produto não encontrado"))
        ;

    }

    @Test
    @DisplayName("[Negativo] - Listar produto por ID nulo")
    public void testListarProdutoPorIDNulo(){

        produtoClient.listarProdutosPorId("")
                .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("produtos", notNullValue())
        ;

    }
}
