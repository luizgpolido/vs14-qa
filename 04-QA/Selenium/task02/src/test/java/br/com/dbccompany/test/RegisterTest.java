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

    SignUpPage cadastro = new SignUpPage();
    Validation validation = new Validation();
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
        cadastro.cadastrarConta();
        String msg = cadastro.validaMsgCreated();
        validation.validateText("Your account has been created.",msg);
    }

    @Test
    public void testAdicionarEnderecoNaConta() {
        cadastro.cadastrarConta();
        AddressDto addressDto = addressData.novoEndereco();
        accountPage.adicionarNovoEndereço(addressDto);
        String msg = accountPage.validaNovoEndereco();
        validation.validateText(addressDto.getAddressTitle().toUpperCase(),msg);
    }

    @Test
    public void testAdicionarEnderecoComAliasMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoAliasLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("alias is too long. Maximum length: 32", msg);
    }

    @Test
    public void testAdicionarEnderecoComCompanyMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoCompanyLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("company is too long. Maximum length: 64", msg);
    }

    @Test
    public void testAdicionarEnderecoComLastNameMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoLastNameLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("lastname is too long. Maximum length: 32", msg);
    }


}
