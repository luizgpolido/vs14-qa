package br.com.dbccompany.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static br.com.dbccompany.factory.selenium.Waits.*;

public class Interactions extends Elements{
    protected static void sendKeys(By by, String text) {
        waitElement(by);
        element(by).sendKeys(text);
    }

    protected static void click(By by) {
        waitElementVisibily(by);
        element(by).click();
    }

    protected static void clear(By by) {
        waitElementVisibily(by);
        element(by).clear();
    }

    protected static String lerTexto(By by) {
        waitElement(by);
        return element(by).getText();
    }

    protected static String lerValor(By by) {
        waitElement(by);
        return element(by).getAttribute("value");
    }

    protected static void sendTab(By by){
        waitElement(by);
        element(by).sendKeys("\t");
    }

    public static void selecionarComboBox(WebElement element, String texto){
        Select select = new Select(element);
        select.selectByVisibleText(texto);
    }

    protected static void selecionarSelectAleatorio(String path) {
        WebElement element = driver.findElement(By.cssSelector(path));
        Random rand = new Random();
        Select select = new Select(element);
        List<WebElement> optionList = select.getOptions();
        int i = rand.nextInt(optionList.size());
        if (i==0) {
            i = i+1;
        }
        select.selectByIndex(i);
    }

    protected static void limparCampo(String path){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
        element.clear();
    }


    protected static void pegarInputSelect(By by, int option){
        waitElement(by);
        Select select = new Select(element(by));
        select.selectByIndex(option);
    }

    protected static String pegarCor(By by){
        waitElement(by);
        return element(by).getCssValue("background-color");
    }


}
