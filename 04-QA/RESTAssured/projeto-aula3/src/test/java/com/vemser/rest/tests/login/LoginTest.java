package com.vemser.rest.tests.login;

import com.vemser.rest.client.LoginClient;
import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.model.LoginModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class LoginTest {

    LoginClient loginClient = new LoginClient();

    @Test
    @DisplayName("[Positivo] - Login com credenciais válidas")
    public void testLoginComCredenciaisValidas() {

        LoginModel login = LoginDataFactory.loginUsuarioValido();

            loginClient.realizarLogin(login)
            .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", notNullValue())
        ;
    }

    @Test
    @DisplayName("[Negativo] - Login com senha inválida")
    public void testLoginComSenhaInvalidas() {

        LoginModel login = LoginDataFactory.loginUsuarioComSenhaInvalida();

        loginClient.realizarLogin(login)
        .then()
                .statusCode(401)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("Email e/ou senha inválidos"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Login com email nulo")
    public void testLoginComEmailNula() {

        LoginModel login = LoginDataFactory.loginUsuarioComEmailNulo();


        loginClient.realizarLogin(login)
        .then()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("email", equalTo("email não pode ficar em branco"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Login com senha nula")
    public void testLoginComSenhaNula() {

        LoginModel login = LoginDataFactory.loginUsuarioComSenhaNula();


        loginClient.realizarLogin(login)
        .then()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("password", equalTo("password não pode ficar em branco"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Login com dados nulos")
    public void testLoginComDadosNulos() {

        LoginModel login = LoginDataFactory.loginUsuarioComDadosNulos();

        loginClient.realizarLogin(login)
                .then()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("email", equalTo("email não pode ficar em branco"))
                .body("password", equalTo("password não pode ficar em branco"))
        ;
    }


}