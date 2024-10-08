package com.vemser.rest.tests.carrinhos;

import com.vemser.rest.base.CarrinhoBase;
import com.vemser.rest.client.CarrinhoClient;
import com.vemser.rest.client.LoginClient;
import com.vemser.rest.data.factory.CarrinhoDataFactory;
import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.model.LoginModel;
import com.vemser.rest.model.ProdutosCarrinhoModel;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class DeletarCarrinhoTest extends CarrinhoBase {

    private static final LoginClient loginClient = new LoginClient();

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        if (testInfo.getTags().contains("skipCart")){
            ProdutosCarrinhoModel carrinho = CarrinhoDataFactory.carrinhoValido();

            carrinhoClient.cadastrarCarrinho(carrinho)
                    .then()
                    .statusCode(201)
            ;
        }
    }
    @BeforeEach
    public void login(){

        LoginModel loginModel = LoginDataFactory.loginAdminValido();

        String bearerToken =
                loginClient.realizarLogin(loginModel)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .path("authorization")
                ;

        CarrinhoClient.setBearerToken(bearerToken);
    }


    @Test
    void deletarCarrinhoValido() {

        carrinhoClient.cancelarCarrinho()
                .then()
                .statusCode(200)
                .body("message", Matchers.equalTo(REGISTRO_EXCLUIDO))
        ;
    }

    @Test
    @Tag("skipCart")
    void deletarCarrinhoInexistente() {

        carrinhoClient.cancelarCarrinho();

        carrinhoClient.cancelarCarrinho()
                .then()
                .statusCode(200)
                .body("message", Matchers.equalTo(CARRINHO_INEXISTENTE))
        ;
    }

    @Test
    void deletarCarrinhoSemToken() {

        String token = "";

        carrinhoClient.cancelarCarrinhoSemToken(token)
                .then()
                .statusCode(401)
                .body("message", Matchers.equalTo(CARRINHO_INEXISTENTE))
        ;
    }
}
