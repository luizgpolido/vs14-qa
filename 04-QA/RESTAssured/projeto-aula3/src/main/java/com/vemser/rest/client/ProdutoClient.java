package com.vemser.rest.client;

import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.model.LoginModel;
import com.vemser.rest.model.ProdutosModel;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ProdutoClient extends BaseClient{

    private final String PRODUTO = "/produtos";
    private String bearerToken;
    private LoginModel login = LoginDataFactory.loginAdminValido();
    private LoginClient loginClient = new LoginClient();


    public void login(){

        bearerToken =
                loginClient.realizarLogin(login)
                .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .path("authorization")
        ;
    }

    public Response cadastrarProduto(ProdutosModel produto){

        login();

        return
                given()
                        .header("Authorization" , bearerToken)
                        .spec(super.set())
                        .contentType("application/json")
                        .body(produto)
                .when()
                    .post(PRODUTO)
                ;
    }

    public Response atualizarProduto(ProdutosModel produto, String id){

        login();

        return
                given()
                        .spec(super.set())
                        .header("Authorization" , bearerToken)
                        .pathParam("_id", id)
                        .contentType("application/json")
                        .body(produto)
                .when()
                    .put(PRODUTO + "/{_id}")
                ;
    }

    public Response removerProduto(String id){

        login();

        return
                given()
                        .spec(super.set())
                        .header("Authorization" , bearerToken)
                        .contentType("json/aplication")
                        .pathParam("_id" , id)
                .when()
                    .delete(PRODUTO + "/{_id}")
                ;
    }

    public Response removerProdutoSemToken(String id){

        login();

        return
                given()
                        .spec(super.set())
                        .contentType("json/aplication")
                        .pathParam("_id" , id)
                        .when()
                        .delete(PRODUTO + "/{_id}")
                ;
    }

    public Response listarProdutosPorId(String id){

        login();

        return
                given()
                        .spec(super.set())
                        .header("Authorization" , bearerToken)
                        .contentType("json/aplication")
                        .pathParam("_id" , id)
                .when()
                    .get(PRODUTO + "/{_id}")
                ;
    }

    public Response listarProdutos(){

        login();

        return
                given()
                        .spec(super.set())
                        .header("Authorization" , bearerToken)
                        .contentType("json/aplication")
                .when()
                   .get(PRODUTO)
                ;
    }
}
