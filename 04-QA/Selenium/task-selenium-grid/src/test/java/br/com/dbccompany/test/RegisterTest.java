package br.com.dbccompany.test;

import br.com.dbccompany.dto.AccountDto;
import br.com.dbccompany.data.factory.SignUpData;
import br.com.dbccompany.data.factory.selenium.Validation;
import br.com.dbccompany.page.SignUpPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    SignUpData cadastroData = new SignUpData();
    SignUpPage cadastro = new SignUpPage();
    Validation validation = new Validation();

    @Test
    public void testCriarContaComEmailCadastrado() {
        cadastro.criarContaComEmailJaCadastrado();
        String msg = cadastro.validaMsgEmailEmUso();
        validation.validateText("An account using this email address has already been registered. Please enter a valid password or request a new one.",msg);
    }

    @Test
    public void testCadastrarContaComSucesso() {
        AccountDto accountDto = cadastroData.cadastroValido();
        cadastro.cadastrarConta(accountDto);
        String msg = cadastro.validaMsgCreated();
        validation.validateText("Your account has been created.",msg);

    }


}
