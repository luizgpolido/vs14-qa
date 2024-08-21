package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    // 2, 3 ,4
    public static WebDriver driver;
    public static WebDriverWait wait;
    String btnSignupLogin = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";
    String btnLogin = "#form  div div div.col-sm-4.col-sm-offset-1 div  form > button";
    String btnLogout = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) a";

    @BeforeTest
    public void abrirNavegador(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com/");

        driver.manage().window().maximize();
    }


    @Test
    public void deveFazerLoginComSucesso(){

        GenericMethods.clicarElemento(driver, btnSignupLogin);

        GenericMethods.esperarElemento(wait, "input[data-qa=\"login-email\"]");
        GenericMethods.preencherElemento(driver,"input[data-qa=\"login-email\"]","vs@gmail.com");

        GenericMethods.esperarElemento(wait, "[data-qa=\"login-password\"]");
        GenericMethods.preencherElemento(driver,"[data-qa=\"login-password\"]","123456");

        GenericMethods.esperarElemento(wait, btnLogin);
        GenericMethods.clicarElemento(driver, btnLogin);

        GenericMethods.esperarElemento(wait, btnLogout);
        String textBtnLogout = GenericMethods.pegarTexto(driver, btnLogout);

        Assert.assertEquals(textBtnLogout , "Logout");
    }

    @Test
    public void tesTLoginUserWithIncorretEmailAndPassword(){
        //Test Case 3: Login User with incorrect email and password

        GenericMethods.validarSeElementoEstaVisivel(wait, "div.features_items");
        GenericMethods.clicarElemento(driver, btnSignupLogin);

        GenericMethods.esperarElemento(wait, "input[data-qa=\"login-email\"]");
        GenericMethods.preencherElemento(driver,"input[data-qa=\"login-email\"]","vemser@gmail.com");

        GenericMethods.esperarElemento(wait, "[data-qa=\"login-password\"]");
        GenericMethods.preencherElemento(driver,"[data-qa=\"login-password\"]","132789");

        GenericMethods.esperarElemento(wait, btnLogin);
        GenericMethods.clicarElemento(driver, btnLogin);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]")));

    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }
}
