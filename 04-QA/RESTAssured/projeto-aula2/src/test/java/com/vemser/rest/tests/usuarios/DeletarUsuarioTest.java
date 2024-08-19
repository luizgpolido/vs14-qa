package com.vemser.rest.tests.usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeletarUsuarioTest {

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }


    @Test
    @DisplayName("[Positivo] - Deletar usuário com id válido")
    public void testDeletarUsuarioComSucesso() {

        String id = "jogfODIlXsqxNFS2";

        given()
                .pathParam("id", id)
        .when()
                .delete("/usuarios/{id}")
        .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"))
        ;
    }


    @Test
    @DisplayName("[Negativo] - Deletar usuário com id nulo")
    public void testListarUserPorNomeComFracasso() {

        String id = "";

        given()
                .pathParam("id", id)
        .when()
                .delete("/usuarios/{id}")
        .then()
                .statusCode(405)
                .body("message", notNullValue())
        ;
    }

    @Test
    @DisplayName("[Negativo] - Deletar usuário com carrinho cadastrado")
    public void testDeletarUsuarioComFracasso() {

        String id = "0uxuPY0cbmQhpEz1";

        given()
                .pathParam("id", id)
        .when()
                .delete("/usuarios/{id}")
        .then()
                .statusCode(400)
                .body("message", equalTo("Não é permitido excluir usuário com carrinho cadastrado"))
                .body("idCarrinho", notNullValue())
        ;
    }
}
