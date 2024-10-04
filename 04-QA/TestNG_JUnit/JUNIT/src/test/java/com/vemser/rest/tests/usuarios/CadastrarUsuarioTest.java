package com.vemser.rest.tests.usuarios;

import com.vemser.rest.base.UsuarioBase;
import com.vemser.rest.data.factory.UsuariosDataFactory;
import com.vemser.rest.model.UsuarioModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CadastrarUsuarioTest extends UsuarioBase {

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("[Positivo] - Cadastrar usuário com sucesso")
    public void testCadastrarUsuarioComSucesso() {

        UsuarioModel usuario = UsuariosDataFactory.usuarioValido();

        usuarioClient.cadastrarUsuario(usuario)
        .then()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .body(matchesJsonSchemaInClasspath("schemas/cadastrar_usuario.json"))
                .body("message", notNullValue())
                .body("_id", notNullValue())
                .statusCode(201)
        ;
    }

    @Test
    @DisplayName("[Negativo] - Cadastrar usuário com email já cadastrado")
    public void testCadastrarUsuarioComEmailJaCadastrado() {

        UsuarioModel usuario = UsuariosDataFactory.usuarioComEmailCadastrado();

        usuarioClient.cadastrarUsuario(usuario)
            .then()
                .statusCode(400)
                .body("message", equalTo(EMAIL_JA_USADO))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Cadastrar usuário com nome em branco")
    public void testCadastrarUsuarioComNomeEmBranco() {

        UsuarioModel usuario = UsuariosDataFactory.usuarioComNomeEmBranco();

        usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(400)
                .body("nome", equalTo(NOME_EM_BRANCO))
        ;
    }

}
