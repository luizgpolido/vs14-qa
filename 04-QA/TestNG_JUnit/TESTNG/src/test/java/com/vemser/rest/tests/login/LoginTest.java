package com.vemser.rest.tests.login;

import com.vemser.rest.client.LoginClient;
import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.model.LoginModel;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class LoginTest {

    LoginClient loginClient = new LoginClient();

    @Test
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