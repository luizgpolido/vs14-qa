package br.com.dbccompany.test;

import br.com.dbccompany.factory.selenium.BrowserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest extends BrowserService {

    @BeforeEach
    public void abrirNavegador(){
        initChromeDriver("http://www.automationpractice.pl/index.php");
    }

    @AfterEach
    public void fecharNavegador(){
        //quit();
    }

}
