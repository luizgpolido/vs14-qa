package com.vemser.rest.tests.usuarios;

import com.vemser.rest.model.usuarios.UsuarioResponse;
import com.vemser.rest.model.usuarios.UsuariosPOJO;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


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
                .body("message", notNullValue())
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
