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



}
