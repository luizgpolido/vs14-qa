package com.vemser.rest.tests.usuarios;

import com.vemser.rest.model.usuarios.UsuarioResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ListarUsuarioTest {

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }


    @Test
    @DisplayName("[Positivo] - Listar todos os usuários com sucesso")
    public void testListarTodosUsersComSucesso() {

        given()
        .when()
                .get("/usuarios")
        .then()
                .statusCode(200)
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/todos_os_users.json"))

        ;
    }


    @Test
    @DisplayName("[Positivo] - Listar usuário por ID válido")
    public void testListarUserPorIDComSucesso() {

        String id = "0uxuPY0cbmQhpEz1";

        UsuarioResponse response =

                given()
                        .pathParam("id", id)
                .when()
                        .get("/usuarios/{id}")
                .then()
                        .statusCode(200)
                        .extract()
                        .as(UsuarioResponse.class)
                ;

        Assertions.assertAll("response",
                () -> Assertions.assertEquals("Fulano da Silva", response.getNome()),
                () -> Assertions.assertEquals("fulano@qa.com", response.getEmail()),
                () -> Assertions.assertNotNull(response.getPassword()),
                () -> Assertions.assertNotNull(response.get_id()),
                () -> Assertions.assertNotNull(response.getAdministrador())
        );
    }

    @Test
    @DisplayName("[Positivo] - Listar usuário por ID válido c/ JSON")
    public void testListarUserPorIDComSucessoComValidacaoDoJSON() {

        String id = "0uxuPY0cbmQhpEz1";


        given()
                .pathParam("id", id)
        .when()
                .get("/usuarios/{id}")
        .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body(matchesJsonSchemaInClasspath("schemas/usuarios_por_id.json"))
        ;

    }


    @Test
    @DisplayName("[Negativo] - Listar usuário com id inválido")
    public void testListarUserPorIDComIDInexistente() {

        String id = "1234";

        given()
                .pathParam("id", id)
        .when()
                .get("/usuarios/{id}")
        .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"))
        ;
    }


}
