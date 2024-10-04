package com.vemser.rest.tests.produtos;

import com.vemser.rest.base.ProdutoBase;
import com.vemser.rest.client.LoginClient;
import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.LoginModel;
import com.vemser.rest.model.ProdutosModel;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CadastrarProdutoTest extends ProdutoBase {

    private static final LoginClient loginClient = new LoginClient();

    @BeforeAll
    public static void login(){
        LoginModel loginModel = LoginDataFactory.loginAdminValido();

        String bearerToken =
                loginClient.realizarLogin(loginModel)
                    .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .path("authorization")
        ;

        produtoClient.setBearerToken(bearerToken);
    }

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
                .body("message", equalTo(ERRO_PRODUTO_JA_EXISTE))
        ;

    }

    @Test
    @DisplayName("[Negativo] - Cadastrar produto com preço com negativo")
    public void testCadastrarProdutoComPrecoInvalido() {

        ProdutosModel produto = ProdutoDataFactory.produtoComPrecoNegativo();

        produtoClient.cadastrarProduto(produto)
                .then()
                .statusCode(400)
                .body("preco", equalTo(ERRO_PRECO_DEVE_SER_POSITIVO));
    }

    @ParameterizedTest
    @MethodSource("com.vemser.rest.data.provider.ProdutosDataProvider#produtoDataProvider")
    @DisplayName("[Negativo] - Testar cadastrar produtos com dados inválidos com data provider")
    public void testCadastrarProdutosComDataProvider(ProdutosModel produtos, String key, String value){

        produtoClient.cadastrarProduto(produtos)
                .then()
                    .statusCode(400)
                    .body(key, equalTo(value))
                ;
    }
}
