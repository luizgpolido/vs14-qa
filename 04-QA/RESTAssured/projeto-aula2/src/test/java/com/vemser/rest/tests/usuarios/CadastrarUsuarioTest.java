package com.vemser.rest.tests.usuarios;

import com.vemser.rest.model.usuarios.UsuariosPOJO;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CadastrarUsuarioTest {

    Faker faker = new Faker(new Locale("pt", "BR"));
    Random geradorBoolean = new Random();

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("[Positivo] - Cadastrar usuário com sucesso")
    public void testCadastrarUsuarioComSucesso() {

        UsuariosPOJO user = new UsuariosPOJO();
        user.setNome(faker.name().fullName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        given()
                .contentType("application/json")
                .body(user)
                .log().all()
                .when()
                .post("/usuarios")
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

        UsuariosPOJO user = new UsuariosPOJO();
        user.setNome(faker.name().fullName());
        user.setEmail("fulano@qa.com");
        user.setPassword(faker.internet().password());
        user.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(400)
                .body("message", equalTo("Este email já está sendo usado"))
        ;
    }

}
