package com.vemser.rest.tests.produtos;

import com.vemser.rest.client.ProdutoClient;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.ProdutosModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CadastrarProdutoTest {

    ProdutoClient produtoClient = new ProdutoClient();

    @Test
    @DisplayName("[Positivo] - Cadastrar produto com todos os dados válidos e validação de contrato")
    public void testCadastrarProdutoValido() {

        ProdutosModel produto = ProdutoDataFactory.produtoValido();

        produtoClient.cadastrarProduto(produto)
        .then()
            .header("Content-Type", "application/json; charset=utf-8")
            .statusCode(201)
            .body("message", equalTo("Cadastro realizado com sucesso"))
            .body("_id", notNullValue())
            .body(matchesJsonSchemaInClasspath("schemas/cadastrar_produto.json"));
    }

    @Test
    @DisplayName("[Negativo] - Cadastrar produto com nome já existente")
    public void testCadastrarProdutoComNomeJaExistente() {

        ProdutosModel produto = ProdutoDataFactory.produtoComNomeJaExistente();


        produtoClient.cadastrarProduto(produto)
                .then()
                .statusCode(400)
                .body("message", equalTo("Já existe produto com esse nome"))
        ;

    }

    @Test
    @DisplayName("[Negativo] - Cadastrar produto com preço com negativo")
    public void testCadastrarProdutoComPrecoInvalido() {

        ProdutosModel produto = ProdutoDataFactory.produtoComPrecoNegativo();

        produtoClient.cadastrarProduto(produto)
                .then()
                .statusCode(400)
                .body("preco", equalTo("preco deve ser um número positivo"));
    }

    @ParameterizedTest
    @MethodSource("com.vemser.rest.data.provider.ProdutosDataProvider#produtoDataProvider")
    public void testCadastrarProdutosComDataProvider(ProdutosModel produtos, String key, String value){

        produtoClient.cadastrarProduto(produtos)
                .then()
                    .statusCode(400)
                    .body(key, equalTo(value))
                ;
    }
}
