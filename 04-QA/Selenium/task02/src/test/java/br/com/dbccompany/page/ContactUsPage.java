package br.com.dbccompany.page;

import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ContactUsPage extends Interactions {

    private static final By campoContactUs = By.cssSelector("#contact-link > a");
    private static final By campoSelecaoSubjectHeading = By.cssSelector("#id_contact");
    private static final By selecaoOpcaoCustomerservice = By.cssSelector("#id_contact > option:nth-child(2)");
    private static final By selecaoOpcaoWebmaster = By.cssSelector("#id_contact > option:nth-child(3)");
    private static final By campoEmail = By.cssSelector("#email");
    private static final By campoOrderReference = By.cssSelector("#id_order");
    private static final By btnParaFazerUpload = By.cssSelector("#fileUpload");
    private static final By campoMessage = By.cssSelector("#message");
    private static final By btnSend = By.cssSelector("#submitMessage");
    private static final By mensagemInvalidEmail =  By.xpath("//li[text()='Invalid email address.']");
    private static final By mensagemInvalidMenssageCamp =  By.xpath("//li[text()='The message cannot be blank.']");
    private static final By mensagemmSuccessfully = By.xpath("//p[text()='Your message has been successfully sent to our team.']");
    private static final By mensagemInvalidSubject = By.xpath("//li[text()='Please select a subject from the list provided. ']");
    private String filePah = "D://Teste_front//vs14-qa//04-QA//Selenium//task02//src//main//resources//pagina.png";

    public void irParaPaginaContato(){ click(campoContactUs); }
    public void clicarNoCampoSelecao(){ click(campoSelecaoSubjectHeading); }
    public void selecionarCustomerService(){ click(selecaoOpcaoCustomerservice); }
    public void selecionarWebmaster(){ click(selecaoOpcaoWebmaster); }
    public void preencherEmail(String email){ sendKeys(campoEmail,email); }
    public void preencherMessage(String message){ sendKeys(campoMessage,message); }
    public void preencherOrderReference(String reference){ sendKeys(campoOrderReference,reference); }
    public void clicarParaFazerUpload(){
        driver.findElement(By.cssSelector("#fileUpload")).sendKeys(filePah);
    }
    public void clicarParaEnviar(){
        click(btnSend);
    }

    public String validarMensagemEmailInvalid(){
        return lerTexto(mensagemInvalidEmail);
    }
    public String validarMensagemInvalidMenssageCamp(){
        return lerTexto(mensagemInvalidMenssageCamp);
    }
    public String validarMensagemmSuccessfully(){
        return lerTexto(mensagemmSuccessfully);
    }
    public String validarMensagemInvalidService(){ return lerTexto(mensagemInvalidSubject); }

    public String preencherContatoValido(String email, String order, String mensage){
        sendKeys(campoEmail, email);
        sendKeys(campoOrderReference, order);
        sendKeys(campoMessage, mensage);
        clicarParaFazerUpload();
        clicarParaEnviar();
        return lerTexto(mensagemmSuccessfully);
    }

    public String preencherContatoValidoSemUpload(String email, String order, String mensage){
        sendKeys(campoEmail, email);
        sendKeys(campoOrderReference, order);
        sendKeys(campoMessage, mensage);
        clicarParaEnviar();
        return lerTexto(mensagemmSuccessfully);
    }

    public String preencherContatoSemServico(String order, String mensagem, String email){
        sendKeys(campoEmail, email);
        sendKeys(campoOrderReference, order);
        sendKeys(campoMessage, mensagem);
        sendKeys(campoMessage, mensagem);
        clicarParaFazerUpload();
        clicarParaEnviar();
        return lerTexto(mensagemInvalidSubject);
    }

    public String preencherCamposVazios(String email, String order, String mensage){
        sendKeys(campoEmail, email);
        sendKeys(campoOrderReference, order);
        sendKeys(campoMessage, mensage);
        clicarParaEnviar();
        return lerTexto(mensagemInvalidEmail);
    }

    public String preencherContatoEmailInvalido(String order, String mensage){
        sendKeys(campoOrderReference, order);
        sendKeys(campoMessage, mensage);
        clicarParaFazerUpload();
        clicarParaEnviar();
        return lerTexto(mensagemInvalidEmail);
    }

    public String preencherContatoMensagemInvalid(String email, String order){
        sendKeys(campoEmail, email);
        sendKeys(campoOrderReference, order);
        clicarParaFazerUpload();
        clicarParaEnviar();
        return lerTexto(mensagemInvalidMenssageCamp);
    }


}
