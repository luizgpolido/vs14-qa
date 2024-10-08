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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CadastrarCarrinhoTest extends CarrinhoBase {

    private static final LoginClient loginClient = new LoginClient();

    @BeforeEach
    public void setUp(){
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
    public void testCadastrarCarrinhoValido(){

        ProdutosCarrinhoModel carrinho = CarrinhoDataFactory.carrinhoValido();

        carrinhoClient.cadastrarCarrinho(carrinho)
            .then()
                .statusCode(201)
                .body("_id", Matchers.notNullValue())
                .body("message", Matchers.equalTo(CADASTRO_SUCESSO))
        ;
    }

    @Test
    public void testCadastrarCarrinhoSemToken(){

        ProdutosCarrinhoModel carrinho = CarrinhoDataFactory.carrinhoValido();
        String token = "abcde";

        carrinhoClient.cadastrarCarrinhoComTokenInvalido(carrinho, token)
            .then()
                .statusCode(401)
                .body("message", Matchers.equalTo(TOKEN_INVALIDO))
        ;
    }

    @Test
    public void testCadastrarCarrinhoComProdutoDuplicado(){

        ProdutosCarrinhoModel carrinho = CarrinhoDataFactory.carrinhoComProdutoDuplicado();

        carrinhoClient.cadastrarCarrinho(carrinho)
            .then()
                .statusCode(400)
                .body("message", Matchers.equalTo(PRODUTO_DUPLICADO))
        ;
    }

    @AfterEach
    public void tearDown(){
        carrinhoClient.cancelarCarrinho();
    }
}
