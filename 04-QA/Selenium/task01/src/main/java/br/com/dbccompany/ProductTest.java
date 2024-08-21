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

public class ProductTest {
//    9,8, 7


    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void abrirNavegador(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();

    }

    @AfterTest
    public void fecharNavegador(){
        driver.quit();
    }

    @Test
    public void searchProduct(){
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
