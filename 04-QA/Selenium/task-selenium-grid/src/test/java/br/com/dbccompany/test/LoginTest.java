package br.com.dbccompany.test;

import br.com.dbccompany.data.factory.LoginData;
import br.com.dbccompany.data.factory.selenium.Validation;
import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.page.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();
    Validation validation = new Validation();

    @Test
    public void testvalidarLoginDadosValidos() {
        LoginDto usu = loginData.loginDadosValidos();
        loginPage.fazerLogin(usu.getEmail(), usu.getSenha());
        loginPage.clicarAppLogo();
        String nomeLogado = loginPage.validarNomeLogado();
        validation.validateText("Sala Nove", nomeLogado);
    }

}
