package com.vemser.rest.client;

import com.vemser.rest.model.ProdutosModel;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ProdutoClient extends BaseClient{

    private final String PRODUTO = "/produtos";

    public Response cadastrarProduto(ProdutosModel produto){
        return
                given()
                        .spec(super.set())
                        .contentType("json/aplication")
                        .body(produto)
                .when()
                    .post(PRODUTO)
                ;
    }

    public Response atualizarProduto(ProdutosModel produto){
        return
                given()
                        .spec(super.set())
                        .contentType("json/aplication")
                        .body(produto)
                .when()
                    .put(PRODUTO)
                ;
    }

    public Response removerProduto(String id){
        return
                given()
                        .spec(super.set())
                        .contentType("json/aplication")
                        .pathParam("_id" , id)
                .when()
                    .delete(PRODUTO + "{_id}")
                ;
    }

    public Response listarProdutosPorId(String id){
        return
                given()
                        .spec(super.set())
                        .contentType("json/aplication")
                        .pathParam("_id" , id)
                .when()
                    .get(PRODUTO + "{_id}")
                ;
    }

    public Response listarProdutos(String id){
        return
                given()
                        .spec(super.set())
                        .contentType("json/aplication")
                        .pathParam("_id" , id)
                .when()
                   .get(PRODUTO)
                ;
    }
}
