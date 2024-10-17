package br.com.dbccompany.test;

import br.com.dbccompany.data.factory.selenium.BrowserService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTest extends BrowserService {

    @BeforeMethod
    @Parameters({"browser"})
    public void abrirNavegador(String browser) {
        initChromeDriver(browser,"http://www.automationpractice.pl/index.php");
    }

    @AfterMethod
    public void fecharNavegador(){
        quit();
    }

}
