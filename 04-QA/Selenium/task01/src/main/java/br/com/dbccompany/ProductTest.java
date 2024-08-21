package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class ProductTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static JavascriptExecutor js;

    @BeforeTest
    public void abrirNavegador(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        js = (JavascriptExecutor) driver;

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }


    @Test
    public void testValidaProdutosEDetalhes() {

        String btnProdutos = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        GenericMethods.esperarElemento(wait, btnProdutos);
        GenericMethods.clicarElemento(driver, btnProdutos);

        String produtosList = "body > section:nth-child(3) > div.container > div > div.col-sm-9.padding-right > div";
        GenericMethods.esperarElemento(wait, produtosList);

        String viewProduct = "div:nth-child(3) > div > div.choose > ul > li > a";
        WebElement element = driver.findElement(By.cssSelector(viewProduct));
        js.executeScript("arguments[0].scrollIntoView();", element);
        GenericMethods.clicarElemento(driver, viewProduct);

        String name = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > h2";
        GenericMethods.esperarElemento(wait, name);
        String category = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(3)";
        GenericMethods.esperarElemento(wait, category);
        String price = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > span";
        GenericMethods.esperarElemento(wait, price);
        String availability = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(6) > b";
        GenericMethods.esperarElemento(wait, availability);
        String condition = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(7) > b";
        GenericMethods.esperarElemento(wait, condition);
        String brand = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(8) > b";
        GenericMethods.esperarElemento(wait, brand);

    }



    @Test
    public void testSearchProduct(){
        //Test Case 9: Search Product
        String btnProduct = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        String alProducts = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div";

        GenericMethods.validarSeElementoEstaVisivel(wait, "div.features_items");

        GenericMethods.clicarElemento(driver, btnProduct);

        GenericMethods.validarSeElementoEstaVisivel(wait, alProducts);

        GenericMethods.preencherElemento(driver, "#search_product", "Blue Top");

        GenericMethods.clicarElemento(driver, "#submit_search");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Blue Top')]")));

    }


}
