package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v127.storage.model.InterestGroupAuctionNetworkRequestCreated;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {
    //    1, 5
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void abrirNavegador(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }

    @Test
    public void testRegistrarUsuarioComEmailJaCadastrado() {

        String linkLogin = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";
        GenericMethods.esperarElemento(wait, linkLogin);
        GenericMethods.clicarElemento(driver, linkLogin);

        String newSignUp = "#form > div > div > div:nth-child(3) > div > h2";
        GenericMethods.esperarElemento(wait, newSignUp);



        String newUserInputName = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)";
        GenericMethods.esperarElemento(wait,newUserInputName);
        GenericMethods.preencherElemento(driver, newUserInputName, "vs13");

        String newUserInputEmail = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)";
        GenericMethods.esperarElemento(wait,newUserInputEmail);
        GenericMethods.preencherElemento(driver, newUserInputEmail, "vs@gmail.com");

        String btnSignUp = "#form > div > div > div:nth-child(3) > div > form > button";
        GenericMethods.clicarElemento(driver, btnSignUp);

        String errorMessage = "#form > div > div > div:nth-child(3) > div > form > p";
        String realText = GenericMethods.pegarTexto(driver, errorMessage);
        Assert.assertEquals( realText,"Email Address already exist!");
    }


    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }
}
