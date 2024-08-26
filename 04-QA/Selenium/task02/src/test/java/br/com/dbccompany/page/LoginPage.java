package br.com.dbccompany.page;

import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class LoginPage extends Interactions {

    private static final By appLogo = By.cssSelector("#header_logo > a");
    private static final By nomeLogado = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");
    private static final By btnLogin = By.cssSelector(".login");
    private static final By campoEmail =
            By.cssSelector("#email");
    private static final By campoEmailCadastro =
            By.cssSelector("#email_create");
    private static final By campoSenha =
            By.cssSelector("#passwd");
    private static final By btnAcessar =
            By.cssSelector("#SubmitLogin");
    private static final By btnCadastrar =
            By.cssSelector("#submitAccount > span");
    private static final By btnIrParaCadastro =
            By.cssSelector("#SubmitCreate");
    private static final By TextMsgmBtn =
            By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private static final By msgmEmailIncorreto =
            By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p");
    private static final By warningMsg =
    By.cssSelector("#center_column > div.alert.alert-danger > ol > li");

    public void clicarAppLogo() {click(appLogo);}

    public void preencherCampoEmail(String email){
        sendKeys(campoEmail,email);
    }

    public void preencherCampoEmailDeCadastro(String email){
        sendKeys(campoEmailCadastro,email);
    }

    public void preencherCampoSenha(String senha){
        sendKeys(campoSenha,senha);
    }

    public void clicarBtnLogin() {click(btnLogin);}

    public void clicarBtnAcessar(){
        click(btnAcessar);
    }

    public void clicarBtnIrParaCadastro(){
        click(btnIrParaCadastro);
    }

    public String validarTextoBtnAposLogin(){
        return lerTexto(TextMsgmBtn);
    }

    public String validarMsgmEmailIncorreto(){
        return lerTexto(msgmEmailIncorreto);
    }

    public String validarNomeLogado() {
        return lerTexto(nomeLogado);
    }

    public void fazerLogin(String email, String senha){
        clicarBtnLogin();
        preencherCampoEmail(email);
        preencherCampoSenha(senha);
        clicarBtnAcessar();
    }
    public String loginEmailIncorreto(String email, String senha){
        sendKeys(campoEmail,email);
        sendKeys(campoSenha,senha);
        click(btnAcessar);
        return lerTexto(msgmEmailIncorreto);
    }
    public String acessarCadastro(String email) {
        preencherCampoEmailDeCadastro(email);
        clicarBtnIrParaCadastro();
        return lerTexto(btnCadastrar);
    }

    public String validarWarning() {
        return  lerTexto(warningMsg);
    }
}