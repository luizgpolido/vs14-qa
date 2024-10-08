package com.vemser.rest.client;

import com.vemser.rest.model.ProdutosModel;
import io.restassured.response.Response;
import lombok.Setter;

import static io.restassured.RestAssured.given;

public class ProdutoClient extends BaseClient{

    private final String PRODUTO = "/produtos";
    @Setter
    private String bearerToken;

    public Response cadastrarProduto(ProdutosModel produto){

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

        return
                given()
                        .spec(super.set())
                        .contentType("json/aplication")
                .when()
                   .get(PRODUTO)
                ;
    }

}
