package com.vemser.rest.tests.users;

import com.vemser.rest.pojo.UsuariosPOJO;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UsersTest {

    Faker faker = new Faker(new Locale("pt", "BR"));
    Random geradorBoolean = new Random();

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

        ;
    }

    @Test
    @DisplayName("[Positivo] - Listar usuário por nome válido")
    public void testListarUserPorNomeComSucesso() {

        String nome = "Fulano da Silva";

        given()
                .queryParam("nome", nome)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)

        ;
    }


    @Test
    @DisplayName("[Positivo] - Listar usuário por ID válido")
    public void testListarUserPorIDComSucesso() {

        String id = "1WNpri9OrycpUkUQ";

        given()
                .pathParam("id", id)
        .when()
                .get("/usuarios/{id}")
        .then()
                .statusCode(200)

        ;
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

                .statusCode(201)
        ;
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
                .log().all()
        .when()
                .put("/usuarios/{id}")
        .then()
                .statusCode(200)
                .log().all()
        ;
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
        ;
    }

    //TESTES FRACASSADOS

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
                .log().all()
        .when()
                .post("/usuarios")
        .then()
                .log().all()

                .statusCode(400)
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
                .log().all()
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
        ;
    }

}

