package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactTest {
// 6
    public static WebDriver driver;
    public static WebDriverWait wait;
    String btnContact = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a";

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
