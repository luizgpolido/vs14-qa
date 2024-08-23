package br.com.dbccompany.test;

import br.com.dbccompany.factory.data.SignUpData;
import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.SignUpPage;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    SignUpData cadastroData = new SignUpData();
    SignUpPage cadastro = new SignUpPage();
    Validation validation = new Validation();


    @Test
    public void testCriarContaComEmailCadastrado() {
        cadastro.criarContaComEmailJaCadastrado();
        String msg = cadastro.validaMsgEmailEmUso();
        validation.validateText("An account using this email address has already been registered. Please enter a valid password or request a new one. ",msg);
    }
}
