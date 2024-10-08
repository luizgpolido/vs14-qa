package com.vemser.rest.tests.produtos;

import com.vemser.rest.base.ProdutoBase;
import com.vemser.rest.client.LoginClient;
import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.LoginModel;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeletarProdutoTest extends ProdutoBase {

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
    public void testDeletarProdutoValido(){

        String id = ProdutoDataFactory.getProdutoValido().get_id();

        produtoClient.removerProduto(id)
        .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo(DELETE_MENSAGEM_SUCESSO))
        ;
    }

    @Test
    public void testDeletarProdutoSemAutenticacao(){

        String id = ProdutoDataFactory.getPrimeiroProduto().get_id();

        produtoClient.removerProdutoSemToken(id)
        .then()
                .statusCode(401)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo(ERRO_TOKEN_INVALIDO))
        ;
    }

    @Test
    public void testDeletarProdutoComIDNulo(){

        produtoClient.removerProduto("")
        .then()
                .statusCode(405)
                .body("message", notNullValue())
        ;
    }
}
