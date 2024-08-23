package br.com.dbccompany.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

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
}
