package br.com.dbccompany.page;

import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class HomePage extends Interactions {

    private static final By btnPopular = By.cssSelector("#home-page-tabs > li:nth-child(1) > a");
    private static final By btnBestSellers = By.cssSelector("#home-page-tabs > li:nth-child(2) > a");
    private static final By blouseProduct = By.cssSelector("h5 > a[title=\"Blouse\"]");
    private static final By popularMsg = By.cssSelector("#homefeatured > li");

    private static final By campoNewsLetter = By.cssSelector("#newsletter-input");
    private static final By btnNewsLetter = By.cssSelector("#newsletter_block_left > div > form > div > button");
    private static final By newsLetterMsg = By.cssSelector("#columns > p");
    private static final By btnPesquisa = By.cssSelector("#searchbox > button");
    private static final By campoPesquisa = By.cssSelector("#search_query_top");
    private static final By warningMsg = By.cssSelector("#center_column > p");
    private static final By searchPageConfirmation = By.cssSelector("#informations_block_left_1 > p > a");



    public void clicarBtnNewsLetter() {click(btnNewsLetter);}
    public void clicarBestSeller() {click(btnBestSellers);}
    public void clicarPopular() {click(btnPopular);}
    public String validaBlouseProduct() {return lerTexto(blouseProduct);}
    public String validaPopularMsg() {return lerTexto(popularMsg);}
    public void preencherCampoNewsLetter(String email) {sendKeys(campoNewsLetter, email);}
    public void preencherPesquisa(String pesquisa) {sendKeys(campoPesquisa, pesquisa);}
    public String validaNewsLetterMsg() {return lerTexto(newsLetterMsg);}
    public void clicarBtnPesquisa() {click(btnPesquisa);}
    public String validaWarning() {return lerTexto(warningMsg);}
    public String validaSearchPage() {return lerTexto(searchPageConfirmation);}


    public void assinarNewsLetter(String email) {
        preencherCampoNewsLetter(email);
        click(btnNewsLetter);
    }

    public void pesquisar(String pesquisa) {
        preencherPesquisa(pesquisa);
        clicarBtnPesquisa();
    }

}
