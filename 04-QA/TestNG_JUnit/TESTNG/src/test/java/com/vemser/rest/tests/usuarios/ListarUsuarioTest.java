package com.vemser.rest.tests.usuarios;

import com.vemser.rest.base.UsuarioBase;
import com.vemser.rest.data.factory.UsuariosDataFactory;
import com.vemser.rest.model.UsuarioResponse;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ListarUsuarioTest extends UsuarioBase {

    @Test
    public void testListarTodosUsersComSucesso() {

        usuarioClient.buscarUsuarios()
            .then()
                .statusCode(200)
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/todos_os_users.json"))

        ;
    }

    @Test
    public void testListarUserPorIDComSucesso() {

        String id = UsuariosDataFactory.getPrimeiroUsuarioReponse().get_id();

        UsuarioResponse usuarioResponse =
                usuarioClient.buscarUsuarioPorId(id)
                .then()
                        .statusCode(200)
                        .extract()
                        .as(UsuarioResponse.class)
                ;


       assertNotNull(usuarioResponse.getNome());
       assertNotNull(usuarioResponse.getEmail());
       assertNotNull(usuarioResponse.getPassword());
       assertNotNull(usuarioResponse.get_id());
       assertEquals(usuarioResponse.getAdministrador(), "true");
    }

    @Test
    public void testListarUserPorIDComSucessoComValidacaoDoJSON() {

        String id = UsuariosDataFactory.getPrimeiroUsuarioReponse().get_id();


        usuarioClient.buscarUsuarioPorId(id)
            .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body(matchesJsonSchemaInClasspath("schemas/usuarios_por_id.json"))
        ;

    }


    @Test
    public void testListarUserPorIDComIDInexistente() {

        String id = "-1234";

        usuarioClient.buscarUsuarioPorId(id)
            .then()
                .statusCode(400)
                .body("message", equalTo(USUARIO_NAO_ENCONTRADO))
        ;
    }


}
