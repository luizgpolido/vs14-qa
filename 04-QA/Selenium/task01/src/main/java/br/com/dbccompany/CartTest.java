package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {
//    15, 14, 13, 12


    public static WebDriver driver;
    public static WebDriverWait wait;
    private static JavascriptExecutor js;

    @BeforeTest
    public void abrirNavegador(){

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }

    @Test
    public void testPlaceOrderRegisterWhileCheckout() throws InterruptedException {
        Actions actions = new Actions(driver);

        js.executeScript("var css = '* { -webkit-transition: none !important; -moz-transition: none !important; -ms-transition: none !important; -o-transition: none !important; transition: none !important; -webkit-animation: none !important; -moz-animation: none !important; -ms-animation: none !important; animation: none !important; }', head = document.head || document.getElementsByTagName('head')[0], style = document.createElement('style'); style.type = 'text/css'; if (style.styleSheet){ style.styleSheet.cssText = css; } else { style.appendChild(document.createTextNode(css)); } head.appendChild(style);");

        String btnProdutos = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        GenericMethods.esperarElemento(wait, btnProdutos);

        String btnAddToCart = "/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div/a";
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript(
        "document.querySelector('div.features_items > div:nth-child(3) > div > div.single-products > div.product-overlay').remove();");
        synchronized (actions) {
            actions.wait(2000);
        }

        WebElement element1 = driver.findElement(By.xpath(btnAddToCart));
        actions.moveToElement(element1).perform();

        synchronized (actions) {
            actions.wait(2000);
        }

        element1.click();

        String btnCartPopUp = "#cartModal > div > div > div.modal-body > p:nth-child(2) > a";
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(btnCartPopUp)));
        element.click();

        String btnCheckout = "#do_action > div.container > div > div > a";
        GenericMethods.esperarElemento(wait, btnCheckout);
        GenericMethods.clicarElemento(driver, btnCheckout);

        String btnRegisterLogin = "#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a";
        GenericMethods.esperarElemento(wait, btnRegisterLogin);
        GenericMethods.clicarElemento(driver, btnRegisterLogin);
        //nova conta
        String newUserInputName = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)";
        GenericMethods.esperarElemento(wait,newUserInputName);
        GenericMethods.preencherElemento(driver, newUserInputName, "mateuslindo");

        String newUserInputEmail = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)";
        GenericMethods.esperarElemento(wait,newUserInputEmail);
        GenericMethods.preencherElemento(driver, newUserInputEmail, "mateuslindo@gmail.com");

        String btnSignUp = "#form > div > div > div:nth-child(3) > div > form > button";
        GenericMethods.esperarElemento(wait, btnSignUp);
        GenericMethods.clicarElemento(driver, btnSignUp);
        //account form
        GenericMethods.esperarElemento(wait, "#id_gender1");
        GenericMethods.clicarElemento(driver, "#id_gender1");
        GenericMethods.preencherElemento(driver, "#password", "123456");
        GenericMethods.clicarElemento(driver, "#days > option:nth-child(19)");
        GenericMethods.clicarElemento(driver, "#months > option:nth-child(2)");
        GenericMethods.clicarElemento(driver, "#years > option:nth-child(22)");
        GenericMethods.preencherElemento(driver, "#first_name", "Mateus");
        GenericMethods.preencherElemento(driver, "#last_name", "Barros");
        GenericMethods.preencherElemento(driver, "#address1", "Minha rua, Meu Bairro, Sou bonito");
        GenericMethods.clicarElemento(driver, "#country > option:nth-child(2)");
        GenericMethods.preencherElemento(driver, "#state", "RJ");
        GenericMethods.preencherElemento(driver, "#city", "Nova Iguaçu");
        GenericMethods.preencherElemento(driver, "#zipcode", "274992-82");
        GenericMethods.preencherElemento(driver, "#mobile_number", "926378492");

        element = driver.findElement(By.cssSelector("button[data-qa=\"create-account\"]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        GenericMethods.clicarElemento(driver, "button[data-qa=\"create-account\"]");

        String accountCreated = "#form > div > div > div > h2 > b";
        String text = GenericMethods.pegarTexto(driver, accountCreated);
        Assert.assertEquals(text, "ACCOUNT CREATED!");

        GenericMethods.clicarElemento(driver, "#form > div > div > div > div > a"); //btn continuar


        String loggedName = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b";
        GenericMethods.esperarElemento(wait, loggedName);
        text = GenericMethods.pegarTexto(driver, loggedName);
        Assert.assertEquals(text, "mateuslindo");

        GenericMethods.clicarElemento(driver, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a"); //btn cart
        GenericMethods.esperarElemento(wait, "#do_action > div.container > div > div > a"); //btn checkout
        GenericMethods.clicarElemento(driver, "#do_action > div.container > div > div > a"); //btn checkout

        GenericMethods.esperarElemento(wait, "#cart_items > div > div:nth-child(7) > a");
        Assert.assertEquals(
                GenericMethods.pegarTexto(driver, "#address_delivery > li.address_firstname.address_lastname")
                ,"Mr. Mateus Barros");
        Assert.assertEquals(
                GenericMethods.pegarTexto(driver, "#address_delivery > li:nth-child(4)")
                ,"Minha rua, Meu Bairro, Sou bonito");
        Assert.assertEquals(
                GenericMethods.pegarTexto(driver, "#address_delivery > li.address_city.address_state_name.address_postcode")
                ,"Nova Iguaçu RJ 274992-82");
        Assert.assertEquals(
                GenericMethods.pegarTexto(driver, "#address_delivery > li.address_country_name")
                ,"United States");



        GenericMethods.preencherElemento(driver, "#ordermsg > textarea", "Manda bala, to com pressa");
        GenericMethods.clicarElemento(driver, "#cart_items > div > div:nth-child(7) > a"); //btn place order

        GenericMethods.esperarElemento(wait, "[data-qa=\"name-on-card\"]");
        GenericMethods.preencherElemento(driver, "[data-qa=\"name-on-card\"]", "Mateus Barros");
        GenericMethods.preencherElemento(driver, "[data-qa=\"card-number\"]", "86753241");
        GenericMethods.preencherElemento(driver, "[data-qa=\"cvc\"]", "243");
        GenericMethods.preencherElemento(driver, "[data-qa=\"expiry-month\"]", "01");
        GenericMethods.preencherElemento(driver, "[data-qa=\"expiry-year\"]", "2077");

        GenericMethods.clicarElemento(driver, "#submit");

        Assert.assertEquals(
                GenericMethods.pegarTexto(driver, "#form > div > div > div > p")
                ,"Congratulations! Your order has been confirmed!");

        GenericMethods.esperarElemento(wait, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
        GenericMethods.clicarElemento(driver, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");//btn delete account

        GenericMethods.esperarElemento(wait, "#form > div > div > div > div > a");

        Assert.assertEquals(
                GenericMethods.pegarTexto(driver, "#form > div > div > div > h2 > b")
                ,"ACCOUNT DELETED!");
        GenericMethods.clicarElemento(driver, "#form > div > div > div > div > a");
    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }

}
