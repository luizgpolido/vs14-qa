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
    @Description(CT001_CONTATO)
    public void testValidarContatoComDadosValiDosWebMaster(){
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarWebmaster();
        String mensagem = contactUsPage.preencherContatoValido(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getMessage());
        validation.validateText(mensagem, "Your message has been successfully sent to our team.");
    }


}
