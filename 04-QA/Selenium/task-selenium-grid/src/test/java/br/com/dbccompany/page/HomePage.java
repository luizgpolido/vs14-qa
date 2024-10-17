package br.com.dbccompany.page;

import br.com.dbccompany.data.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class HomePage extends Interactions {

    private static final By btnPopular = By.cssSelector("#home-page-tabs > li:nth-child(1) > a");
    private static final By btnBestSellers = By.cssSelector("#home-page-tabs > li:nth-child(2) > a");
    private static final By blouseProduct = By.cssSelector("h5 > a[title=\"Blouse\"]");
    private static final By popularMsg = By.cssSelector("#homefeatured > li");

    private static final By campoNewsLetter = By.cssSelector("#newsletter-input");
    private static final By btnNewsLetter = By.cssSelector("#newsletter_block_left > div > form > div > button");
    private static final By newsLetterMsg = By.cssSelector("#columns > p");


    public void clicarBtnNewsLetter() {click(btnNewsLetter);}
    public void clicarBestSeller() {click(btnBestSellers);}
    public void clicarPopular() {click(btnPopular);}
    public String validaBlouseProduct() {return lerTexto(blouseProduct);}
    public String validaPopularMsg() {return lerTexto(popularMsg);}
    public void preencherCampoNewsLetter(String email) {sendKeys(campoNewsLetter, email);}
    public String validaNewsLetterMsg() {return lerTexto(newsLetterMsg);}



    public void assinarNewsLetter(String email) {
        preencherCampoNewsLetter(email);
        click(btnNewsLetter);
    }


}
