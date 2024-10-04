package com.vemser.rest.client;

import com.vemser.rest.model.UsuarioModel;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsuarioClient extends BaseClient {

    private final String USUARIOS ="/usuarios";

    public Response cadastrarUsuario(UsuarioModel usuario){
        return
                given()
                        .spec(super.set())
                        .contentType("application/json")
                        .body(usuario)
                .when()
                    .post(USUARIOS)
                ;
    }

    public Response atualizarUsuario(UsuarioModel usuario, String id){
        return
                given()
                        .spec(super.set())
                        .contentType("application/json")
                        .pathParam("_id", id)
                        .body(usuario)
                .when()
                    .put(USUARIOS+"/{_id}")
                ;
    }

    public Response removerUsuario(String id){
        return
                given()
                        .spec(super.set())
                        .contentType("application/json")
                        .pathParam("_id" , id)
                .when()
                    .delete(USUARIOS + "/{_id}")
                ;
    }

    public Response buscarUsuarios(){
        return
                given()
                        .spec(super.set())
                        .contentType("application/json")
                .when()
                    .get(USUARIOS)
                ;
    }

    public Response buscarUsuarioPorId(String id){
        return
                given()
                        .spec(super.set())
                        .contentType("application/json")
                        .pathParam("_id" , id)
                .when()
                    .get(USUARIOS + "/{_id}")
                ;
    }
}
