package com.vemser.rest.client;

import com.vemser.rest.model.ProdutosCarrinhoModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Setter;

import static io.restassured.RestAssured.given;

public class CarrinhoClient extends BaseClient {

    private final String CARRINHO = "/carrinhos";
    @Setter
    private static String bearerToken;

    public Response cadastrarCarrinho(ProdutosCarrinhoModel carrinho){
        return
                given()
                        .spec(super.set())
                        .contentType(ContentType.JSON)
                        .header("Authorization", bearerToken)
                        .body(carrinho)
                .when()
                        .post(CARRINHO)
                ;
    }

    public Response cadastrarCarrinhoComTokenInvalido(ProdutosCarrinhoModel carrinho, String token){
        return
                given()
                        .spec(super.set())
                        .contentType(ContentType.JSON)
                        .header("Authorization", token)
                        .body(carrinho)
                .when()
                        .post(CARRINHO)
                ;
    }

    public Response cancelarCarrinho() {
        return
                given()
                        .spec(super.set())
                        .contentType(ContentType.JSON)
                        .header("Authorization", bearerToken)
                .when()
                        .delete(CARRINHO + "/cancelar-compra")
                ;
    }

    public Response cancelarCarrinhoSemToken(String token) {
        return
                given()
                        .spec(super.set())
                        .contentType(ContentType.JSON)
                        .header("Authorization", token)
                .when()
                        .delete(CARRINHO + "/cancelar-compra")
                ;
    }
}
