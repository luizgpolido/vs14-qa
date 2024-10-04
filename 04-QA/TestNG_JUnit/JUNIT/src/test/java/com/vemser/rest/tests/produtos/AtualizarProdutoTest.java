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

import static org.hamcrest.Matchers.equalTo;

public class AtualizarProdutoTest extends ProdutoBase {

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
    @DisplayName("[Positivo] - Editar produto com id existente e informações válidas")
    public void testEditarProdutoValido() {

        ProdutosModel produto = ProdutoDataFactory.produtoValido();

        String id = ProdutoDataFactory.getProdutoValido().get_id();

        produtoClient.atualizarProduto(produto, id)
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("message", equalTo(PUT_MENSAGEM_SUCESSO));
    }

    @Test
    @DisplayName("[Negativo] - Editar produto com nome existente")
    public void testEditarProdutoComNomeJaExistente() {

        ProdutosModel produto = ProdutoDataFactory.produtoComNomeJaExistente();

        String id = ProdutoDataFactory.getProdutoValido().get_id();

        produtoClient.atualizarProduto(produto, id)
            .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("message", equalTo(ERRO_PRODUTO_JA_EXISTE));
    }
}
