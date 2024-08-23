package br.com.dbccompany.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static br.com.dbccompany.factory.selenium.Waits.waitElement;

public class Interactions extends Elements{
    protected static void sendKeys(By by, String text) {
        waitElement(by);
        element(by).sendKeys(text);
    }

    protected static void click(By by) {
        waitElement(by);
        element(by).click();
    }

    protected static String lerTexto(By by) {
        waitElement(by);
        return element(by).getText();
    }

    protected static void sendTab(By by){
        waitElement(by);
        element(by).sendKeys("\t");
    }

    public static void selecionarComboBox(WebElement element, String texto){
        Select select = new Select(element);
        select.selectByVisibleText(texto);
    }
}
