package br.com.dbccompany.data.factory.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserService {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    DesiredCapabilities capabilities = new DesiredCapabilities();
    String hubUrl = "http://localhost:4444";

    public void initChromeDriver(String browser, String url) {
        try {
            capabilities.setBrowserName(browser);
            driver.set(new RemoteWebDriver(new URL(hubUrl), capabilities));
            driver.get().get(url);
            wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(15)));
            driver.get().manage().window().maximize();

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void quit() {
        driver.get().quit();
    }
}