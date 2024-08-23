package br.com.dbccompany.page;

import br.com.dbccompany.dto.AccountDto;
import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class SignUpPage extends Interactions {

    private static final By btnLogin = By.cssSelector(".login");
    private static final By btnIrParaCadastro = By.cssSelector("#SubmitCreate");
    private static final By campoEmail = By.cssSelector("#email_create");
    private static final By campoConfirmEmail = By.cssSelector("#email");
    private static final By campoGender = By.cssSelector("#id_gender1");
    private static final By campoFirstName = By.cssSelector("#customer_firstname");
    private static final By campoLastName = By.cssSelector("#customer_lastname");
    private static final By campoPasswd = By.cssSelector("#passwd");
    private static final By campoDays = By.cssSelector("#days");
    private static final By campoMonths = By.cssSelector("#months");
    private static final By campoYears = By.cssSelector("#years");
    private static final By msgCreated = By.cssSelector("p.alert.alert-success");
    private static final String idDays = "#days";
    private static final String idMonths = "#months";
    private static final String idYears = "#years";
    private static final By msgContaJaCadastrada = By.cssSelector("ol li");


    public void clicarBtnLogin() {
        click(btnLogin);
    }
    public void clicarBtnIrParaCadastro() {
        click(btnIrParaCadastro);
    }
    public void preencherCampoEmail(String email) {
        sendKeys(campoEmail, email);
    }
    public void preencherCampoConfirmarEmail(String campoConfirmEmail) {
        sendKeys(campoEmail, campoConfirmEmail);
    }
    public void preencherCampoGender(String Gender) {
        sendKeys(campoGender, Gender);
    }
    public void preencherCampoFirstName(String FirstName) {
        sendKeys(campoFirstName, FirstName);
    }
    public void preencherCampoLastName(String LastName) {
        sendKeys(campoLastName, LastName);
    }
    public void preencherCampoPasswd(String Passwd) {
        sendKeys(campoPasswd, Passwd);

    }
    public void preencherCampoDays(String idDays) {
        selecionarSelectAleatorio(idDays);
    }
    public void preencherCampoMonths(String idMonths) {
        selecionarSelectAleatorio(idMonths);
    }
    public void preencherCampoYears(String idYears) {
        selecionarSelectAleatorio(idYears);
    }
    public String validaMsgCreated() {
            return lerTexto(msgCreated);
    }

    public void criarContaComEmailJaCadastrado() {
        clicarBtnLogin();
        preencherCampoEmail("vs@gmail.com");
        clicarBtnIrParaCadastro();
    }


    public String validaMsgEmailEmUso() {
    return lerTexto(msgContaJaCadastrada);
    }
}
