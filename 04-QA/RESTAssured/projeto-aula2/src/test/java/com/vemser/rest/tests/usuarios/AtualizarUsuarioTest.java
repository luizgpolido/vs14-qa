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
import static org.hamcrest.Matchers.equalTo;

public class AtualizarUsuarioTest {

    Faker faker = new Faker(new Locale("pt", "BR"));
    Random geradorBoolean = new Random();

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }


    @Test
    @DisplayName("[Positivo] - Atualizar usuário com dados válidos")
    public void testAtualizarUsuarioComSucesso() {

        UsuariosPOJO user = new UsuariosPOJO();
        user.setNome(faker.name().fullName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));
        String id = "1WNpri9OrycpUkUQ";



        given()
                .contentType("application/json")
                .body(user)
                .pathParam("id", id)
        .when()
                .put("/usuarios/{id}")
        .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Atualizar usuário com email já cadastrado")
    public void testAtualizarUsuarioComFracasso() {

        UsuariosPOJO user = new UsuariosPOJO();
        user.setNome(faker.name().fullName());
        user.setEmail("fulano@qa.com");
        user.setPassword(faker.internet().password());
        user.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));
        String id = "1WNpri9OrycpUkUQ";



        given()
                .contentType("application/json")
                .body(user)
                .pathParam("id", id)
                .log().all()
        .when()
                .put("/usuarios/{id}")
        .then()
                .statusCode(400)
                .body("message", equalTo("Este email já está sendo usado"))
        ;
    }
}
