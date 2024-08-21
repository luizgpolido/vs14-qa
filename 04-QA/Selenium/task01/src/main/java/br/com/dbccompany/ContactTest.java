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

    @Test
    public void formulárioDeContato(){
//Test Case 6: Contact Us Form
        GenericMethods.validarSeElementoEstaVisivel(wait, "div.features_items");
        GenericMethods.clicarElemento(driver, btnContact);
        GenericMethods.validarSeElementoEstaVisivel(wait, "#contact-page > div.row > div.col-sm-8 > div > h2");

        GenericMethods.preencherElemento(driver, "input[data-qa=\"name\"]","Teste");

        GenericMethods.esperarElemento(wait, "input[data-qa=\"email\"]");
        GenericMethods.preencherElemento(driver, "input[data-qa=\"email\"]", "testedasilva@test.com");

        GenericMethods.esperarElemento(wait, "input[data-qa=\"subject\"]");
        GenericMethods.preencherElemento(driver, "input[data-qa=\"subject\"]", "Quero testar");

        GenericMethods.esperarElemento(wait, "textarea[data-qa=\"message\"]");
        GenericMethods.preencherElemento(driver, "textarea[data-qa=\"message\"]", "MMensagemm");

        String filePath = "C:/Users/ricks/OneDrive/Área de Trabalho/git-l/vs14-qa/04-QA/Selenium/task01/src/main/java/br/com/dbccompany/resources/Teste.pdf";
        driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(6) > input")).sendKeys(filePath);

        WebElement btnSubmit = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSubmit);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        GenericMethods.esperarElemento(wait,"#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success");

    }




}
