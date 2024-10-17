package br.com.dbccompany.data.factory.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Waits extends BrowserService {

    public static void waitElement(By by) {
        wait.get().until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
