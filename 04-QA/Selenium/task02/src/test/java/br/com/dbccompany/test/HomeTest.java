package br.com.dbccompany.test;

import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.factory.data.LoginData;
import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.HomePage;
import br.com.dbccompany.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import static storys.HomeStory.*;

@Epic(EPIC)
@Story(USER_STORY_HOME)
public class HomeTest extends BaseTest{

    LoginData loginData = new LoginData();
    HomePage home = new HomePage();
    Validation validation = new Validation();

    @Test
    @Description(CT207_HOME)
    public void testValidaAusenciaDeProdutoPopular(){
        home.clicarPopular();
        String msg = home.validaPopularMsg();
        validation.validateText( "No featured products at this time.",msg);
    }

    @Test
    @Description(CT208_HOME)
    public void testValidaProdutoMaisVendido(){
        home.clicarBestSeller();
        String msg = home.validaBlouseProduct();
        validation.validateText( "Blouse",msg);
    }


    @Test
    @Description(CT201_NEWSLETTER)
    public void testIncreverNoNewsLetter() {
        LoginDto login = loginData.LoginDadoDinamicos();
        home.assinarNewsLetter(login.getEmail());
        String msg = home.validaNewsLetterMsg();
        validation.validateText( "Newsletter : You have successfully subscribed to this newsletter.",msg);
    }

    @Test
    @Description(CT202_NEWSLETTER)
    public void testIncreverNoNewsLetterComEmailCadastrado() {
        LoginDto login = loginData.loginDadosValidos();
        home.assinarNewsLetter(login.getEmail());
        String msg = home.validaNewsLetterMsg();
        validation.validateText( "Newsletter : This email address is already registered.",msg);
    }

    @Test
    @Description(CT205_SEARCHBAR)
    public void testValidaBtnPesquisa() {
        home.pesquisar("blouse");
        String msg = home.validaSearchPage();
        validation.validateText("INFORMATION",msg);
    }

    @Test
    @Description(CT204_SEARCHBAR)
    public void testValidaPesquisaDeItemInexistente() {
        home.pesquisar("a");
        String msg = home.validaWarning();
        validation.validateText("No results were found for your search \"a\"",msg);
    }

    @Test
    @Description(CT203_SEARCHBAR)
    public void testValidaPesquisaDeItemExistente() {
        home.clicarBestSeller();
        String item = home.validaBlouseProduct();
        home.pesquisar(item);
        String msg = home.validaBlouseProduct();
        validation.validateText("Blouse",msg);
    }

}
