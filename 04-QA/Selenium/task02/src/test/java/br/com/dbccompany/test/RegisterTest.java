package br.com.dbccompany.test;

import br.com.dbccompany.dto.AccountDto;
import br.com.dbccompany.dto.AddressDto;
import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.factory.data.AddressData;
import br.com.dbccompany.factory.data.LoginData;
import br.com.dbccompany.factory.data.SignUpData;
import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.AccountPage;
import br.com.dbccompany.page.LoginPage;
import br.com.dbccompany.page.SignUpPage;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTest {

    SignUpData cadastroData = new SignUpData();
    SignUpPage cadastro = new SignUpPage();
    Validation validation = new Validation();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();
    AccountPage accountPage = new AccountPage();
    AddressData addressData =  new AddressData();

    @Test
    public void testCriarContaComEmailCadastrado() {
        cadastro.criarContaComEmailJaCadastrado();
        String msg = cadastro.validaMsgEmailEmUso();
        validation.validateText("An account using this email address has already been registered. Please enter a valid password or request a new one. ",msg);
    }

    @Test
    public void testCadastrarContaComSucesso() {
        AccountDto accountDto = cadastroData.cadastroValido();
        cadastro.cadastrarConta(accountDto);
        String msg = cadastro.validaMsgCreated();
        validation.validateText("Your account has been created.",msg);

    }

    @Test
    public void testAdicionarEnderecoNaConta() {
        AccountDto accountDto = cadastroData.cadastroValido();
        cadastro.cadastrarConta(accountDto);

//        loginPage.fazerLogin(accountDto.getEmail(), accountDto.getPassword());

        AddressDto addressDto = addressData.novoEndereco();
        accountPage.adicionarNovoEndereço(addressDto);
        String msg = accountPage.validaNovoEndereco();
        validation.validateText(addressDto.getAddressTitle().toUpperCase(),msg);
    }


}
