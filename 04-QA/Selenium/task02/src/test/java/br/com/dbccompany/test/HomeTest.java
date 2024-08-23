package br.com.dbccompany.test;

import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.factory.data.LoginData;
import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.HomePage;
import br.com.dbccompany.page.LoginPage;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest{

    LoginData loginData = new LoginData();
    HomePage home = new HomePage();
    Validation validation = new Validation();

    @Test
    public void testValidaAusenciaDeProdutoPopular(){
        home.clicarPopular();
        String msg = home.validaPopularMsg();
        validation.validateText( "No featured products at this time.",msg);
    }

    @Test
    public void testValidaProdutoMaisVendido(){
        home.clicarBestSeller();
        String msg = home.validaBlouseProduct();
        validation.validateText( "Blouse",msg);
    }


    @Test
    public void testIncreverNoNewsLetter() {
        LoginDto login = loginData.LoginDadoDinamicos();
        home.assinarNewsLetter(login.getEmail());
        String msg = home.validaNewsLetterMsg();
        validation.validateText( "Newsletter : You have successfully subscribed to this newsletter.",msg);
    }

    @Test
    public void testIncreverNoNewsLetterComEmailCadastrado() {
        LoginDto login = loginData.loginDadosValidos();
        home.assinarNewsLetter(login.getEmail());
        String msg = home.validaNewsLetterMsg();
        validation.validateText( "Newsletter : This email address is already registered.",msg);
    }

    @Test
    public void testIncreverNoNewsLetterComEmailInvalido() {
        home.assinarNewsLetter("");
        String msg = home.validaNewsLetterMsg();
        validation.validateText( "Newsletter : Invalid email address.",msg);
    }

}
