package br.com.dbccompany.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericMethods {

    public static void clicarElemento(WebDriver driver, String path) {
        driver.findElement(By.cssSelector(path)).click();
    }
    public static void preencherElemento(WebDriver driver, String path, String valor) {
        driver.findElement(By.cssSelector(path)).sendKeys(valor);
    }
    public static void esperarElemento(WebDriverWait wait, String path) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
    }

    public static void validarSeElementoEstaVisivel(WebDriverWait wait, String path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(path)));
    }

    public static String pegarTexto(WebDriver driver, String path) {
        return driver.findElement(By.cssSelector(path)).getText();
    }

    public static WebElement pegarElemento(WebDriver driver, String path) {
        WebElement element = driver.findElement(By.cssSelector(path));
        return element;
    }

    public static boolean verificaSePaginaCarregou(WebDriver driver){
        WebElement main = driver.findElement(By.cssSelector("body"));
        return main.isDisplayed();
    }

}
