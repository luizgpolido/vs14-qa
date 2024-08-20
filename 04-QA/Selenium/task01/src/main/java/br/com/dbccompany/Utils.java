package br.com.dbccompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static WebDriver driver;
    public static WebDriverWait wait;


    public void clicarElemento(String path) {
        driver.findElement(By.cssSelector(path)).click();
    }
    public void preencherElemento(String path, String valor) {
        driver.findElement(By.cssSelector(path)).sendKeys(valor);
    }
    public void esperarElemento(String path) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
    }
}
