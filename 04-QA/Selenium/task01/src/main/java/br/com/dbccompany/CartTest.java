package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
    private static JavascriptExecutor js;

    @BeforeTest
    public void abrirNavegador(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

    }

    @AfterTest
    public void fecharNavegador(){
        driver.quit();
    }

    @Test
    public void addProductsInCart(){
//Test Case 12: Add Products in Cart

        GenericMethods.validarSeElementoEstaVisivel(wait, "div.features_items");

        String btnProduct = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        String btnContinue = "#cartModal > div > div > div.modal-footer > button";
        String btnCard = "#cartModal > div > div > div.modal-body > p:nth-child(2) > a > u";

        GenericMethods.clicarElemento(driver, btnProduct);

        WebElement botaoAdicionar = driver.findElement(By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > a"));
        WebElement botapAdicionar2 = driver.findElement(By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(4) > div > div.single-products > div.product-overlay > div > a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(botaoAdicionar).click().perform();

        GenericMethods.esperarElemento(wait, btnContinue);

        actions.moveToElement(botapAdicionar2).click().perform();

        GenericMethods.esperarElemento(wait, btnProduct);
        GenericMethods.clicarElemento(driver, btnCard);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-1")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-2")));

        WebElement buttonElement1 = driver.findElement(By.cssSelector("#product-1 > td.cart_quantity > button"));
        String quantityText1 = buttonElement1.getText();

        WebElement buttonElement2 = driver.findElement(By.cssSelector("#product-2 > td.cart_quantity > button"));
        String quantityText2 = buttonElement2.getText();


        Assert.assertEquals("1", quantityText1, "A quantidade do produto 1 não é 1.");
        Assert.assertEquals("1", quantityText2, "A quantidade do produto 2 não é 1.");


        System.out.println("A quantidade de ambos os produtos é 1.");
    }



}
