package br.com.dbccompany.test;

import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.HomePage;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest{

    HomePage home = new HomePage();
    Validation validation = new Validation();

    @Test
    public void testValidaAusenciaDeProdutoPopular(){
        home.clicarPopular();
        String msg = home.validaPopularMsg();
        validation.validateText( "No featured products at this time.",msg);
    }
}
