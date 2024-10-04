package com.vemser.rest.tests.usuarios;

import com.vemser.rest.base.UsuarioBase;
import com.vemser.rest.data.factory.UsuariosDataFactory;
import com.vemser.rest.model.UsuarioResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ListarUsuarioTest extends UsuarioBase {

    @Test
    @DisplayName("[Positivo] - Listar todos os usuários com validação de contrato")
    public void testListarTodosUsersComSucesso() {

        usuarioClient.buscarUsuarios()
            .then()
                .statusCode(200)
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/todos_os_users.json"))

        ;
    }

    @Test
    @DisplayName("[Positivo] - Listar usuário por ID válido")
    public void testListarUserPorIDComSucesso() {

        String id = UsuariosDataFactory.getPrimeiroUsuarioReponse().get_id();

        UsuarioResponse usuarioResponse =
                usuarioClient.buscarUsuarioPorId(id)
                .then()
                        .statusCode(200)
                        .extract()
                        .as(UsuarioResponse.class)
                ;

        Assertions.assertAll("response",
                () -> Assertions.assertNotNull(usuarioResponse.getNome()),
                () -> Assertions.assertNotNull(usuarioResponse.getEmail()),
                () -> Assertions.assertNotNull(usuarioResponse.getPassword()),
                () -> Assertions.assertNotNull(usuarioResponse.get_id()),
                () -> Assertions.assertEquals(usuarioResponse.getAdministrador(), "true")
        );
    }

    @Test
    @DisplayName("[Positivo] - Listar usuário por ID válido com validação de contrato")
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
    @DisplayName("[Negativo] - Listar usuário com id inválido")
    public void testListarUserPorIDComIDInexistente() {

        String id = "-1234";

        usuarioClient.buscarUsuarioPorId(id)
            .then()
                .statusCode(400)
                .body("message", equalTo(USUARIO_NAO_ENCONTRADO))
        ;
    }


}
