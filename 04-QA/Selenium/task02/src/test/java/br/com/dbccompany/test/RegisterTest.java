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
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static storys.RegisterStory.*;

@Epic(EPIC)
@Story(USER_STORY_CADASTRO)
public class RegisterTest extends BaseTest {

    SignUpPage cadastro = new SignUpPage();
    Validation validation = new Validation();
    AccountPage accountPage = new AccountPage();
    AddressData addressData =  new AddressData();

    @Test
    @Description(CT215_CADASTRO)
    public void testCriarContaComEmailCadastrado() {
        cadastro.criarContaComEmailJaCadastrado();
        String msg = cadastro.validaMsgEmailEmUso();
        validation.validateText("An account using this email address has already been registered. Please enter a valid password or request a new one.",msg);
    }

    @Test
    @Description(CT209_CADASTRO)
    public void testCadastrarContaComSucesso() {
        cadastro.cadastrarConta();
        String msg = cadastro.validaMsgCreated();
        validation.validateText("Your account has been created.",msg);
    }

    @Test
    @Description(CT212_CADASTRO)
    public void testAdicionarEnderecoNaConta() {
        cadastro.cadastrarConta();
        AddressDto addressDto = addressData.novoEndereco();
        accountPage.adicionarNovoEndereço(addressDto);
        String msg = accountPage.validaNovoEndereco();
        validation.validateText(addressDto.getAddressTitle().toUpperCase(),msg);
    }

    @Test
    @Description(CT213_CADASTRO)
    public void testAdicionarEnderecoComAliasMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoAliasLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("alias is too long. Maximum length: 32", msg);
    }

    @Test
    @Description(CT219_CADASTRO)
    public void testAdicionarEnderecoComCompanyMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoCompanyLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("company is too long. Maximum length: 64", msg);
    }

    @Test
    @Description(CT220_CADASTRO)
    public void testAdicionarEnderecoComLastNameMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoLastNameLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("lastname is too long. Maximum length: 32", msg);
    }

    @Test
    @Description(CT221_CADASTRO)
    public void testAdicionarEnderecoComFirstNameMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoFirstNameLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("firstname is too long. Maximum length: 32", msg);
    }

    @Test
    @Description(CT222_CADASTRO)
    public void testAdicionarEnderecoComAddressMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoAddressLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("address1 is too long. Maximum length: 128", msg);
    }

    @Test
    @Description(CT223_CADASTRO)
    public void testAdicionarEnderecoComPostCodeMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoPostCodeLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("postcode is invalid.", msg);
    }

    @Test
    @Description(CT224_CADASTRO)
    public void testAdicionarEnderecoComOtherMuitoLongo() {
        cadastro.cadastrarConta();
        accountPage.adicionarNovoEndereço(addressData.enderecoOtherLongo());
        String msg = accountPage.validaMsgErro();
        validation.validateText("other is too long. Maximum length: 300", msg);
    }


}
