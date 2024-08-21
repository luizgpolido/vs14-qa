package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {
//    15, 14, 13, 12

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void abrirNavegador(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }

    @Test
    public void deveVerificarQuantidadeDeItensNoCarrinhoComSucesso(){

        String firstProduct = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a";
        String quantityInput = "#quantity";
        String addToCartBtn = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button";
        String cartModal = "#cartModal > div > div";
        String viewCart = "#cartModal > div > div > div.modal-body > p:nth-child(2) > a";
        String quantityOutput = "#product-1 > td.cart_quantity > button";

        Assert.assertTrue(GenericMethods.verificaSePaginaCarregou(driver));

        GenericMethods.esperarElemento(wait, firstProduct);
        GenericMethods.clicarElemento(driver, firstProduct);

        Assert.assertTrue(GenericMethods.verificaSePaginaCarregou(driver));

        GenericMethods.esperarElemento(wait, quantityInput);
        GenericMethods.pegarElemento(driver, quantityInput).clear();
        GenericMethods.preencherElemento(driver, quantityInput, "4");

        GenericMethods.esperarElemento(wait, addToCartBtn);
        GenericMethods.clicarElemento(driver, addToCartBtn);

        GenericMethods.esperarElemento(wait, cartModal);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(viewCart)));
        GenericMethods.clicarElemento(driver, viewCart);

        GenericMethods.esperarElemento(wait, quantityOutput);
        String quantidadeCarrinho = GenericMethods.pegarTexto(driver, quantityOutput);

        Assert.assertEquals(quantidadeCarrinho, "4");


    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }
}
