package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

import static br.com.dbccompany.Utils.GenericMethods.*;
import org.openqa.selenium.*;


public class CartTest {


    public static WebDriver driver;
    public static WebDriverWait wait;
    private static JavascriptExecutor js;
    Faker faker = new Faker(new Locale("pt", "BR"));

    @BeforeTest
    public void abrirNavegador(){

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
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




    @Test
    public void tesTAddProductsInCart(){
    //Test Case 12: Add Products in Cart

        GenericMethods.validarSeElementoEstaVisivel(wait, "div.features_items");

        String btnProduct = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        String btnContinue = "#cartModal > div > div > div.modal-footer > button";
        String btnCard = "#cartModal > div > div > div.modal-body > p:nth-child(2) > a > u";

        GenericMethods.clicarElemento(driver, btnProduct);

        WebElement botaoAdicionar = driver.findElement(By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > a"));
        WebElement botapAdicionar2 = driver.findElement(By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(4) > div > div.single-products > div.product-overlay > div > a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(botaoAdicionar).click().perform();

        GenericMethods.esperarElemento(wait, btnContinue);

        actions.moveToElement(botapAdicionar2).click().perform();

        GenericMethods.esperarElemento(wait, btnProduct);
        GenericMethods.clicarElemento(driver, btnCard);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-1")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-2")));

        WebElement buttonElement1 = driver.findElement(By.cssSelector("#product-1 > td.cart_quantity > button"));
        String quantityText1 = buttonElement1.getText();

        WebElement buttonElement2 = driver.findElement(By.cssSelector("#product-2 > td.cart_quantity > button"));
        String quantityText2 = buttonElement2.getText();


        Assert.assertEquals("1", quantityText1, "A quantidade do produto 1 não é 1.");
        Assert.assertEquals("1", quantityText2, "A quantidade do produto 2 não é 1.");


        System.out.println("A quantidade de ambos os produtos é 1.");
    }

    @Test
    public void testRegisterBeforeCheckout() throws InterruptedException {
        //Test Case 15: Place Order: Register before Checkout


        Actions actions = new Actions(driver);
        js.executeScript("var css = '* { -webkit-transition: none !important; -moz-transition: none !important; -ms-transition: none !important; -o-transition: none !important; transition: none !important; -webkit-animation: none !important; -moz-animation: none !important; -ms-animation: none !important; animation: none !important; }', head = document.head || document.getElementsByTagName('head')[0], style = document.createElement('style'); style.type = 'text/css'; if (style.styleSheet){ style.styleSheet.cssText = css; } else { style.appendChild(document.createTextNode(css)); } head.appendChild(style);");


        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

        GenericMethods.clicarElemento(driver, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

        String nome = faker.name().fullName();
        String newUserInputName = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)";
        GenericMethods.esperarElemento(wait, newUserInputName);
        GenericMethods.preencherElemento(driver, newUserInputName, nome);

        String email = faker.internet().emailAddress();
        String newUserInputEmail = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)";
        GenericMethods.esperarElemento(wait, newUserInputEmail);
        GenericMethods.preencherElemento(driver, newUserInputEmail, email);

        String btnSignUp = "#form > div > div > div:nth-child(3) > div > form > button";
        GenericMethods.esperarElemento(wait, btnSignUp);
        GenericMethods.clicarElemento(driver, btnSignUp);


        GenericMethods.esperarElemento(wait, "#id_gender1");
        GenericMethods.clicarElemento(driver, "#id_gender1");
        GenericMethods.preencherElemento(driver, "#password", faker.internet().password());
        GenericMethods.clicarElemento(driver, "#days > option:nth-child(" + (faker.number().numberBetween(1, 28) + 1) + ")");
        GenericMethods.clicarElemento(driver, "#months > option:nth-child(" + (faker.number().numberBetween(1, 12) + 1) + ")");
        GenericMethods.clicarElemento(driver, "#years > option:nth-child(" + (faker.number().numberBetween(18, 60) + 1) + ")");
        GenericMethods.preencherElemento(driver, "#first_name", faker.name().firstName());
        GenericMethods.preencherElemento(driver, "#last_name", faker.name().lastName());
        GenericMethods.preencherElemento(driver, "#address1", faker.address().fullAddress());
        GenericMethods.clicarElemento(driver, "#country > option:nth-child(2)");
        GenericMethods.preencherElemento(driver, "#state", faker.address().state());
        GenericMethods.preencherElemento(driver, "#city", faker.address().city());
        GenericMethods.preencherElemento(driver, "#zipcode", faker.address().zipCode());
        GenericMethods.preencherElemento(driver, "#mobile_number", faker.phoneNumber().cellPhone());

        WebElement element = driver.findElement(By.cssSelector("button[data-qa=\"create-account\"]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        GenericMethods.clicarElemento(driver, "button[data-qa=\"create-account\"]");

        String accountCreated = "#form > div > div > div > h2 > b";
        String text = GenericMethods.pegarTexto(driver, accountCreated);
        Assert.assertEquals(text, "ACCOUNT CREATED!");

        GenericMethods.clicarElemento(driver, "#form > div > div > div > div > a");


        String loggedName = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b";
        GenericMethods.esperarElemento(wait, loggedName);
        text = GenericMethods.pegarTexto(driver, loggedName);
        Assert.assertEquals(text,  faker.name().firstName());

        String btnAddToCart = "/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div/a";
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("document.querySelector('div.features_items > div:nth-child(3) > div > div.single-products > div.product-overlay').remove();");
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
        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(btnCartPopUp)));
        element.click();

        Assert.assertTrue(driver.getTitle().contains("Checkout"));

        String btnCheckout = "#do_action > div.container > div > div > a";
        GenericMethods.esperarElemento(wait, btnCheckout);
        GenericMethods.clicarElemento(driver, btnCheckout);

        GenericMethods.esperarElemento(wait, "#cart_items > div > div:nth-child(7) > a");
        Assert.assertEquals(GenericMethods.pegarTexto(driver, "#address_delivery > li.address_firstname.address_lastname"), faker.address().lastName());
        Assert.assertEquals(GenericMethods.pegarTexto(driver, "#address_delivery > li:nth-child(4)"), faker.address().fullAddress());
        Assert.assertEquals(GenericMethods.pegarTexto(driver, "#address_delivery > li.address_city.address_state_name.address_postcode"), faker.address().zipCode());
        Assert.assertEquals(GenericMethods.pegarTexto(driver, "#address_delivery > li.address_country_name"), faker.address().country());

        GenericMethods.preencherElemento(driver, "#ordermsg > textarea", "Manda bala, to com pressa");
        GenericMethods.clicarElemento(driver, "#cart_items > div > div:nth-child(7) > a");

        GenericMethods.esperarElemento(wait, "[data-qa=\"name-on-card\"]");
        GenericMethods.preencherElemento(driver, "[data-qa=\"name-on-card\"]", faker.name().fullName());
        GenericMethods.preencherElemento(driver, "[data-qa=\"card-number\"]", faker.finance().creditCard());
        GenericMethods.preencherElemento(driver, "[data-qa=\"cvc\"]", String.valueOf(faker.number().numberBetween(100, 999)));
        GenericMethods.preencherElemento(driver, "[data-qa=\"expiry-month\"]", String.format("%02d", faker.number().numberBetween(1, 12)));
        GenericMethods.preencherElemento(driver, "[data-qa=\"expiry-year\"]", String.valueOf(faker.number().numberBetween(2024, 2030)));


        GenericMethods.clicarElemento(driver, "#submit");

        Assert.assertEquals(GenericMethods.pegarTexto(driver, "#form > div > div > div > p"), "Congratulations! Your order has been confirmed!");

        GenericMethods.esperarElemento(wait, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
        GenericMethods.clicarElemento(driver, "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a"); //btn delete account

        GenericMethods.esperarElemento(wait, "#form > div > div > div > div > a");
        Assert.assertEquals(GenericMethods.pegarTexto(driver, "#form > div > div > div > h2 > b"), "ACCOUNT DELETED!");
        GenericMethods.clicarElemento(driver, "#form > div > div > div > div > a");
    }





}
