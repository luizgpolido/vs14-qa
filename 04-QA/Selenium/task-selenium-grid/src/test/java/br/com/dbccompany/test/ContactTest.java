package br.com.dbccompany.test;


import br.com.dbccompany.data.factory.ContacData;
import br.com.dbccompany.data.factory.selenium.Validation;
import br.com.dbccompany.dto.ContactDto;
import br.com.dbccompany.page.ContactUsPage;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    ContactUsPage contactUsPage = new ContactUsPage();
    Validation validation = new Validation();

    @Test
    public void testValidarContatoComDadosValiDosCustumerService() {
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarCustomerService();
        String mensagem = contactUsPage.preencherContatoValido(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getMessage());
        validation.validateText(mensagem, "Your message has been successfully sent to our team.");

    }

    @Test
    public void testValidarContatoComDadosValiDosWebMaster() {
        ContactDto contactDto = ContacData.contatoDadosValidos();
        contactUsPage.irParaPaginaContato();
        contactUsPage.selecionarWebmaster();
        String mensagem = contactUsPage.preencherContatoValido(contactDto.getEmail(), contactDto.getOrderReference(), contactDto.getMessage());
        validation.validateText(mensagem, "Your message has been successfully sent to our team.");
    }


}
