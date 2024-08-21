package br.com.dbccompany;

import static br.com.dbccompany.Utils.GenericMethods.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
        esperarElemento(wait, "body > ins.adsbygoogle.adsbygoogle-noablate[data-anchor-status=\"displayed\"]");
        js.executeScript("document.querySelector('body > ins.adsbygoogle.adsbygoogle-noablate[data-anchor-status=\"displayed\"]').remove();");

        Actions actions = new Actions(driver);
        js.executeScript("var css = '* { -webkit-transition: none !important; -moz-transition: none !important; -ms-transition: none !important; -o-transition: none !important; transition: none !important; -webkit-animation: none !important; -moz-animation: none !important; -ms-animation: none !important; animation: none !important; }', head = document.head || document.getElementsByTagName('head')[0], style = document.createElement('style'); style.type = 'text/css'; if (style.styleSheet){ style.styleSheet.cssText = css; } else { style.appendChild(document.createTextNode(css)); } head.appendChild(style);");

        String btnProdutos = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        esperarElemento(wait, btnProdutos);

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
        esperarElemento(wait, btnCheckout);
        clicarElemento(driver, btnCheckout);

        String btnRegisterLogin = "#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a";
        esperarElemento(wait, btnRegisterLogin);
        clicarElemento(driver, btnRegisterLogin);
        //nova conta
        String newUserInputName = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)";
        esperarElemento(wait,newUserInputName);
        preencherElemento(driver, newUserInputName, "mateuslindo");

        String newUserInputEmail = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)";
        esperarElemento(wait,newUserInputEmail);
        preencherElemento(driver, newUserInputEmail, "mateuslindo@gmail.com");

        String btnSignUp = "#form > div > div > div:nth-child(3) > div > form > button";
        esperarElemento(wait, btnSignUp);
        clicarElemento(driver, btnSignUp);
        //account form
        esperarElemento(wait, "#id_gender1");
        clicarElemento(driver, "#id_gender1");
        preencherElemento(driver, "#password", "123456");
        clicarElemento(driver, "#days > option:nth-child(19)");
        clicarElemento(driver, "#months > option:nth-child(2)");
        clicarElemento(driver, "#years > option:nth-child(22)");
        preencherElemento(driver, "#first_name", "Mateus");
        preencherElemento(driver, "#last_name", "Barros");
        preencherElemento(driver, "#address1", "Minha rua, Meu Bairro, Sou bonito");
        clicarElemento(driver, "#country > option:nth-child(2)");
        preencherElemento(driver, "#state", "RJ");
        preencherElemento(driver, "#city", "Nova Iguaçu");
        preencherElemento(driver, "#zipcode", "274992-82");
        preencherElemento(driver, "#mobile_number", "926378492");

        element = driver.findElement(By.cssSelector("button[data-qa=\"create-account\"]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        clicarElemento(driver, "button[data-qa=\"create-account\"]");

        String accountCreated = "#form > div > div > div > h2 > b";
        String text = pegarTexto(driver, accountCreated);
        Assert.assertEquals(text, "ACCOUNT CREATED!");

        clicarElemento(driver, "#form > div > div > div > div > a"); //btn continuar


        String loggedName = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b";
        esperarElemento(wait, loggedName);
        text = pegarTexto(driver, loggedName);
        Assert.assertEquals(text, "mateuslindo");

        clicarElemento(driver, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a"); //btn cart
        esperarElemento(wait, "#do_action > div.container > div > div > a"); //btn checkout
        clicarElemento(driver, "#do_action > div.container > div > div > a"); //btn checkout

        esperarElemento(wait, "#cart_items > div > div:nth-child(7) > a");
        Assert.assertEquals(
                pegarTexto(driver, "#address_delivery > li.address_firstname.address_lastname")
                ,"Mr. Mateus Barros");
        Assert.assertEquals(
                pegarTexto(driver, "#address_delivery > li:nth-child(4)")
                ,"Minha rua, Meu Bairro, Sou bonito");
        Assert.assertEquals(
                pegarTexto(driver, "#address_delivery > li.address_city.address_state_name.address_postcode")
                ,"Nova Iguaçu RJ 274992-82");
        Assert.assertEquals(
                pegarTexto(driver, "#address_delivery > li.address_country_name")
                ,"United States");



        preencherElemento(driver, "#ordermsg > textarea", "Manda bala, to com pressa");
        clicarElemento(driver, "#cart_items > div > div:nth-child(7) > a"); //btn place order

        esperarElemento(wait, "[data-qa=\"name-on-card\"]");
        preencherElemento(driver, "[data-qa=\"name-on-card\"]", "Mateus Barros");
        preencherElemento(driver, "[data-qa=\"card-number\"]", "86753241");
        preencherElemento(driver, "[data-qa=\"cvc\"]", "243");
        preencherElemento(driver, "[data-qa=\"expiry-month\"]", "01");
        preencherElemento(driver, "[data-qa=\"expiry-year\"]", "2077");

        clicarElemento(driver, "#submit");

        Assert.assertEquals(
                pegarTexto(driver, "#form > div > div > div > p")
                ,"Congratulations! Your order has been confirmed!");

        esperarElemento(wait, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
        clicarElemento(driver, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");//btn delete account

        esperarElemento(wait, "#form > div > div > div > div > a");

        Assert.assertEquals(
                pegarTexto(driver, "#form > div > div > div > h2 > b")
                ,"ACCOUNT DELETED!");
        clicarElemento(driver, "#form > div > div > div > div > a");
    }

    @Test
    public void deveVerificarQuantidadeDeItensNoCarrinhoComSucesso(){
        esperarElemento(wait, "body > ins.adsbygoogle.adsbygoogle-noablate[data-anchor-status=\"displayed\"]");
        js.executeScript("document.querySelector('body > ins.adsbygoogle.adsbygoogle-noablate[data-anchor-status=\"displayed\"]').remove();");

        String firstProduct = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a";
        String quantityInput = "#quantity";
        String addToCartBtn = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button";
        String cartModal = "#cartModal > div > div";
        String viewCart = "#cartModal > div > div > div.modal-body > p:nth-child(2) > a";
        String quantityOutput = "#product-1 > td.cart_quantity > button";

        Assert.assertTrue(verificaSePaginaCarregou(driver));

        esperarElemento(wait, firstProduct);
        clicarElemento(driver, firstProduct);

        Assert.assertTrue(verificaSePaginaCarregou(driver));

        esperarElemento(wait, quantityInput);
        pegarElemento(driver, quantityInput).clear();
        preencherElemento(driver, quantityInput, "4");

        esperarElemento(wait, addToCartBtn);
        clicarElemento(driver, addToCartBtn);

        esperarElemento(wait, cartModal);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(viewCart)));
        clicarElemento(driver, viewCart);

        esperarElemento(wait, quantityOutput);
        String quantidadeCarrinho = pegarTexto(driver, quantityOutput);

        Assert.assertEquals(quantidadeCarrinho, "4");


    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }
}
