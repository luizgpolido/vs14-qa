package com.vemser.rest.tests.produtos;

import com.vemser.rest.base.ProdutoBase;
import com.vemser.rest.client.LoginClient;
import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.LoginModel;
import com.vemser.rest.model.ProdutosModel;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.vemser.rest.data.provider.ProdutosDataProvider.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CadastrarProdutoTest extends ProdutoBase {

    private static final LoginClient loginClient = new LoginClient();

    @BeforeClass
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
    public void testCadastrarProdutoComNomeJaExistente() {

        ProdutosModel produto = ProdutoDataFactory.produtoComNomeJaExistente();


        produtoClient.cadastrarProduto(produto)
                .then()
                .statusCode(400)
                .body("message", equalTo(ERRO_PRODUTO_JA_EXISTE))
        ;

    }

    @Test
    public void testCadastrarProdutoComPrecoInvalido() {

        ProdutosModel produto = ProdutoDataFactory.produtoComPrecoNegativo();

        produtoClient.cadastrarProduto(produto)
                .then()
                .statusCode(400)
                .body("preco", equalTo(ERRO_PRECO_DEVE_SER_POSITIVO));
    }

    @Test(dataProvider = "produtoDataProvider")
    public void testCadastrarProdutosComDataProvider(ProdutosModel produtos, String key, String value){

        produtoClient.cadastrarProduto(produtos)
                .then()
                    .statusCode(400)
                    .body(key, equalTo(value))
                ;
    }

    @DataProvider(name = "produtoDataProvider")
    public Object[][] produtoDataProvider() {

            return new Object[][]{
                    {ProdutoDataFactory.produtoComPrecoNegativo(), KEY_PRECO, VALUE_PRECO_NEGATIVO},
                    {ProdutoDataFactory.produtoComDescricaoNula(), KEY_DESCRICAO, VALUE_DESCRICAO_EM_BRANCO},
                    {ProdutoDataFactory.produtoComQuantidadeNegativa(), KEY_QUANTIDADE, VALUE_QUANTIDADE_NEGATIVA},
                    {ProdutoDataFactory.produtoComNomeEmBranco(), KEY_NOME, VALUE_NOME_EM_BRANCO}
            };

    }
}
