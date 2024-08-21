package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SubscriptionTest {
// 11, 10
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
    public void testValidaInscricaoNaPaginaCarrinho() {

        String linkLogin = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";
        GenericMethods.esperarElemento(wait, linkLogin);

        String btnCart = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a";
        GenericMethods.esperarElemento(wait, btnCart);
        GenericMethods.clicarElemento(driver, btnCart);

        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.END);

        String subscriptionText = "#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2";
        String text = GenericMethods.pegarTexto(driver, subscriptionText);
        Assert.assertEquals(text, "SUBSCRIPTION");

        GenericMethods.preencherElemento(driver, "#susbscribe_email", "vs@gmail.com");
        GenericMethods.clicarElemento(driver, "#subscribe");

        text = GenericMethods.pegarTexto(driver, "#success-subscribe > div");
        Assert.assertEquals(text, "You have been successfully subscribed!");
    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }
}
