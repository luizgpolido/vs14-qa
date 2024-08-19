package com.vemser.rest.tests.produtos;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.vemser.rest.client.ProdutoMockClient;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.ProdutosModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ProdutosWireMockTest {

    private final ProdutoMockClient produtoMockClient = new ProdutoMockClient();
    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void setUp() {

        baseURI = "http://localhost:3000";

        wireMockServer = new WireMockServer(wireMockConfig()
                .withRootDirectory("src/test/resources")
                .port(3000));

        wireMockServer.start();
    }

    @AfterAll
    public static void downServer(){
        wireMockServer.stop();
    }

    @Test
    @DisplayName("[WireMock] - Cadastrar produto com todos os dados válidos")
    public void testCadastrarProdutoValido() {

        ProdutosModel produtosModel = ProdutoDataFactory.produtoWireMockValido();

        produtoMockClient.cadastrarProduto(produtosModel)
                .then()
                    .log().all()
                    .statusCode(201)
                    .body("message", equalTo("Cadastro realizado com sucesso"))
                    .body("_id", notNullValue())
                ;

    }

    @Test
    @DisplayName("[WireMock] - Listar produto por ID")
    public void testListarProdutoValido() {

        produtoMockClient.listarProdutosPorId("100")
        .then()
                .statusCode(200)
                .body("nome", notNullValue())
        ;

    }

    @Test
    @DisplayName("[WireMock] - Deletar produto por ID")
    public void testDeletarProdutoValido() {

        produtoMockClient.removerProduto("105")
        .then()
                .statusCode(200)
                .body("message", notNullValue())
        ;

    }

    @Test
    @DisplayName("[WireMock] - Atualizar produto com todos os dados válidos")
    public void testAtualizarProdutoValido() {

        ProdutosModel produtosModel = ProdutoDataFactory.produtoWireMockValido();
        produtosModel.setNome("Mouse Nada Legal");

        produtoMockClient.atualizarProduto(produtosModel, "200")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"))
        ;

    }

    @Test
    @DisplayName("[WireMock] - Listar produto por ID que não existe")
    public void testListarProdutoComIDNaoExistente() {

        produtoMockClient.listarProdutosPorId("900")
        .then()
                .statusCode(400)
                .body("message", notNullValue())
        ;

    }

    @Test
    @DisplayName("[WireMock] - Cadastrar produto com o nome em branco")
    public void testCadastrarProdutoComNomeEmBranco() {

        ProdutosModel produtosModel = ProdutoDataFactory.produtoWireMockValido();
        produtosModel.setNome("");

        produtoMockClient.cadastrarProduto(produtosModel)
                .then()
                .log().all()
                .statusCode(400)
                .body("nome", equalTo("nome não pode ficar em branco"))
        ;

    }


}
