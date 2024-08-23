package br.com.dbccompany.test;


import br.com.dbccompany.dto.ContactDto;
import br.com.dbccompany.factory.data.ContacData;
import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.ContactUsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static storys.ContactStory.*;

@Epic(EPIC)
@Story(USER_STORY_CONTACT)
public class ContactTest extends BaseTest{

    ContactUsPage contactUsPage = new ContactUsPage();
    ContacData contacData = new ContacData();
    Validation validation = new Validation();

    @Test
    @Description(CT001_CONTATO)
    public void testValidarContatoComDadosValiDosCustumerService(){
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarCustomerService();
        String mensagem = contactUsPage.preencherContatoValido(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getMessage());
        validation.validateText(mensagem, "Your message has been successfully sent to our team.");

    }

    @Test
    @Description(CT002_CONTATO)
    public void testValidarContatoComDadosValiDosWebMaster(){
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarWebmaster();
        String mensagem = contactUsPage.preencherContatoValido(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getMessage());
        validation.validateText(mensagem, "Your message has been successfully sent to our team.");
    }

    @Test
    @Description(CT003_CONTATO)
    public void testTentativaContatoComDadosValiDosSemSujeito(){
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        String mensagem = contactUsPage.preencherContatoSemServico(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getEmail());
        validation.validateText(mensagem, "Please select a subject from the list provided.");
    }

    @Test
    @Description(CT004_CONTATO)
    public void testTentativaContatoCamposVazios(){
        ContactDto contactDto = ContacData.contatoComposVazios();
        contactUsPage.irParaPaginaContato();
        String mensagem = contactUsPage.preencherCamposVazios(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getEmail());
        validation.validateText(mensagem, "Invalid email address.");

    }

    @Test
    @Description(CT005_CONTATO)
    public void testValidarEnvioDeContatoSemUploadSujeitoWebmaster(){
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarWebmaster();
        String mensagem = contactUsPage.preencherContatoValidoSemUpload(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getEmail());
        validation.validateText(mensagem, "Your message has been successfully sent to our team.");
    }

    @Test
    @Description(CT006_CONTATO)
    public void testValidarEnvioDeContatoSemUploadSujeitoCustumerService(){
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarCustomerService();
        String mensagem = contactUsPage.preencherContatoValidoSemUpload(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getEmail());
        validation.validateText(mensagem, "Your message has been successfully sent to our team.");
    }

    @Test
    @Description(CT007_CONTATO)
    public void testTentativaContatoComEmialInvaliDosSujeitoWebmaster(){
        ContactDto contactDto = ContacData.contatoEmailInvalido();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarWebmaster();
        String mensagem = contactUsPage.preencherContatoEmailInvalido(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getEmail());
        validation.validateText(mensagem, "Invalid email address.");
    }

    @Test
    @Description(CT008_CONTATO)
    public void testTentativaContatoComEmialInvaliDosSujeitoCustumerService(){
        ContactDto contactDto = ContacData.contatoEmailInvalido();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarCustomerService();
        String mensagem = contactUsPage.preencherContatoEmailInvalido(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getEmail());
        validation.validateText(mensagem, "Invalid email address.");

    }


}
