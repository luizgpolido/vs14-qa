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



}
