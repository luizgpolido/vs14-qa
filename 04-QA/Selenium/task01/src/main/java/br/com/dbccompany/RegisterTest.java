package br.com.dbccompany;

import br.com.dbccompany.Utils.GenericMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RegisterTest {
    //    1, 5
    public static WebDriver driver;
    public static WebDriverWait wait;
    static Faker faker = new Faker();
    static Random rand = new Random();
    private static JavascriptExecutor js;


    @BeforeTest
    public void abrirNavegador(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }

    @Test
    public void testRegistrarUsuarioComEmailJaCadastrado() {

        String linkLogin = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";
        GenericMethods.esperarElemento(wait, linkLogin);
        GenericMethods.clicarElemento(driver, linkLogin);

        String newSignUp = "#form > div > div > div:nth-child(3) > div > h2";
        GenericMethods.esperarElemento(wait, newSignUp);

        String newUserInputName = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)";
        GenericMethods.esperarElemento(wait,newUserInputName);
        GenericMethods.preencherElemento(driver, newUserInputName, "vs13");

        String newUserInputEmail = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)";
        GenericMethods.esperarElemento(wait,newUserInputEmail);
        GenericMethods.preencherElemento(driver, newUserInputEmail, "vs@gmail.com");

        String btnSignUp = "#form > div > div > div:nth-child(3) > div > form > button";
        GenericMethods.clicarElemento(driver, btnSignUp);

        String errorMessage = "#form > div > div > div:nth-child(3) > div > form > p";
        String realText = GenericMethods.pegarTexto(driver, errorMessage);
        Assert.assertEquals( realText,"Email Address already exist!");
    }

    @Test
    public void deveFazerRegistroComSucesso(){

        String btnLoginRegister = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";
        String newUserSignup = "#form > div > div > div:nth-child(3) > div > h2";
        String nameInput = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)";
        String emailInput = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)";
        String btnSignup = "#form > div > div > div:nth-child(3) > div > form > button";
        String enterAccountInfo = "#form > div > div > div > div > h2 > b";

        String btnTitleMr = "#id_gender1";
        String passwordInput = "#password";

        String dayBirthInput = "#days";
        String monthBirthInput = "#months";
        String yearBirthInput = "#years";

        String btnNewsletter = "#newsletter";
        String btnOffers = "#optin";

        String firstNameInput = "#first_name";
        String lastNameInput = "#last_name";
        String addressInput = "#address1";
        String countryInput = "#country";
        String cityInput = "#city";
        String stateInput = "#state";
        String zipcodeInput = "#zipcode";
        String phoneInput = "#mobile_number";

        String btnCreateAccount = "#form > div > div > div > div > form > button";

        String accountCreatedMessage = "#form > div > div > div > h2 > b";
        String btnContinue = "#form > div > div > div > div > a";
        String isLogged = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a";
        String btnDeleteAccount = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a";
        String accountDeletedMessage = "#form > div > div > div > h2 > b";

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String address = faker.address().streetAddress();
        String state = faker.address().state();
        String city = faker.address().city();
        String zipcode = faker.address().zipCode();
        String mobileNumber = faker.phoneNumber().phoneNumber();

        Assert.assertTrue(GenericMethods.verificaSePaginaCarregou(driver));

        GenericMethods.esperarElemento(wait, btnLoginRegister);
        GenericMethods.clicarElemento(driver, btnLoginRegister);

        String textNewUserSignup = GenericMethods.pegarTexto(driver , newUserSignup);

        Assert.assertEquals(textNewUserSignup, "New User Signup!");

        GenericMethods.esperarElemento(wait, nameInput);
        GenericMethods.preencherElemento(driver, nameInput, firstName + " " + lastName);

        GenericMethods.esperarElemento(wait, emailInput);
        GenericMethods.preencherElemento(driver, emailInput, email);

        GenericMethods.esperarElemento(wait, btnSignup);
        GenericMethods.clicarElemento(driver, btnSignup);

        GenericMethods.esperarElemento(wait, enterAccountInfo);
        String textEnterAccountInfo = GenericMethods.pegarTexto(driver, enterAccountInfo);

        Assert.assertEquals(textEnterAccountInfo, "ENTER ACCOUNT INFORMATION");

        GenericMethods.esperarElemento(wait, btnTitleMr);
        GenericMethods.clicarElemento(driver, btnTitleMr);

        GenericMethods.esperarElemento(wait, passwordInput);
        GenericMethods.preencherElemento(driver, passwordInput, password);

        GenericMethods.esperarElemento(wait, dayBirthInput);
        GenericMethods.preencherElemento(driver, dayBirthInput, dayBirthInput);

        GenericMethods.esperarElemento(wait, dayBirthInput);
        WebElement element = GenericMethods.pegarElemento(driver, dayBirthInput);
        selecionarSelectAleatorio(element);

        GenericMethods.esperarElemento(wait, monthBirthInput);
        element = GenericMethods.pegarElemento(driver, monthBirthInput);
        selecionarSelectAleatorio(element);

        GenericMethods.esperarElemento(wait, yearBirthInput);
        element = GenericMethods.pegarElemento(driver, yearBirthInput);
        selecionarSelectAleatorio(element);

        GenericMethods.esperarElemento(wait, "body > ins.adsbygoogle.adsbygoogle-noablate[data-anchor-status=\"displayed\"]");
        js.executeScript("document.querySelector('body > ins.adsbygoogle.adsbygoogle-noablate[data-anchor-status=\"displayed\"]').remove();");
        GenericMethods.esperarElemento(wait, btnNewsletter);
        GenericMethods.clicarElemento(driver, btnNewsletter);
        GenericMethods.esperarElemento(wait, btnOffers);
        GenericMethods.clicarElemento(driver, btnOffers);

        GenericMethods.esperarElemento(wait, firstNameInput);
        GenericMethods.preencherElemento(driver, firstNameInput, firstName);
        GenericMethods.esperarElemento(wait, lastNameInput);
        GenericMethods.preencherElemento(driver, lastNameInput, lastName);

        GenericMethods.esperarElemento(wait, addressInput);
        GenericMethods.preencherElemento(driver, addressInput, address);

        GenericMethods.esperarElemento(wait, countryInput);
        element = GenericMethods.pegarElemento(driver, countryInput);
        selecionarSelectAleatorio(element);

        GenericMethods.esperarElemento(wait, stateInput);
        GenericMethods.preencherElemento(driver, stateInput, state);
        GenericMethods.esperarElemento(wait, cityInput);
        GenericMethods.preencherElemento(driver, cityInput, city);
        GenericMethods.esperarElemento(wait, zipcodeInput);
        GenericMethods.preencherElemento(driver, zipcodeInput, zipcode);
        GenericMethods.esperarElemento(wait, phoneInput);
        GenericMethods.preencherElemento(driver, phoneInput, mobileNumber);

        GenericMethods.esperarElemento(wait, btnCreateAccount);
        GenericMethods.clicarElemento(driver, btnCreateAccount);

        GenericMethods.esperarElemento(wait, accountCreatedMessage);
        String accountCreadeMessageText = GenericMethods.pegarTexto(driver, accountCreatedMessage);
        Assert.assertEquals(accountCreadeMessageText, "ACCOUNT CREATED!");

        GenericMethods.esperarElemento(wait, btnContinue);
        GenericMethods.clicarElemento(driver, btnContinue);

        GenericMethods.esperarElemento(wait, isLogged);
        String isLoggedText = GenericMethods.pegarTexto(driver, isLogged);
        Assert.assertNotNull(isLoggedText);

        GenericMethods.esperarElemento(wait, btnDeleteAccount);
        GenericMethods.clicarElemento(driver, btnDeleteAccount);

        GenericMethods.esperarElemento(wait, accountDeletedMessage);
        String accountDeletedMessageText = GenericMethods.pegarTexto(driver, accountDeletedMessage);
        Assert.assertEquals(accountDeletedMessageText, "ACCOUNT DELETED!");

        GenericMethods.esperarElemento(wait, btnContinue);
        GenericMethods.clicarElemento(driver, btnContinue);

    }

    public void selecionarSelectAleatorio(WebElement element) {
        Select select = new Select(element);

        List<WebElement> optionList = select.getOptions();

        select.selectByIndex(rand.nextInt(optionList.size()));
    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }

}
