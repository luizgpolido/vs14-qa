package br.com.dbccompany.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static br.com.dbccompany.factory.selenium.Waits.aguardarElementoFicarVisivel;
import static br.com.dbccompany.factory.selenium.Waits.waitElement;

public class Interactions extends Elements{
    protected static void sendKeys(By by, String text) {
        waitElement(by);
        element(by).sendKeys(text);
    }

    protected static void click(By by) {
        aguardarElementoFicarVisivel(by);
        element(by).click();
    }

    protected static void clear(By by) {
        aguardarElementoFicarVisivel(by);
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

    protected static void pegarInputSelect(By by, int option){
        waitElement(by);
        Select select = new Select(element(by));
        select.selectByIndex(option);
    }


}
