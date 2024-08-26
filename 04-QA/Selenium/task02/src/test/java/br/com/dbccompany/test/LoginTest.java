package br.com.dbccompany.test;

import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.factory.data.LoginData;
import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import static storys.LoginStory.*;

@Epic(EPIC)
@Story(USER_STORY_LOGIN)
public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();
    Validation validation = new Validation();

    @Test
    @Description(CT210_LOGIN)
    public void testvalidarLoginDadosValidos() {
        LoginDto usu =  loginData.loginDadosValidos();
        loginPage.fazerLogin(usu.getEmail(), usu.getSenha());
        loginPage.clicarAppLogo();
        String nomeLogado = loginPage.validarNomeLogado();
        validation.validateText("Sala Nove",nomeLogado);
    }

    @Test
    @Description(CT229_LOGIN)
    public void testvalidarLoginDadosInvalidos() {
        LoginDto usu =  loginData.LoginDadoDinamicos();
        loginPage.fazerLogin(usu.getEmail(), usu.getSenha());
        String msg = loginPage.validarWarning();
        validation.validateText("Authentication failed.",msg);
    }


}


