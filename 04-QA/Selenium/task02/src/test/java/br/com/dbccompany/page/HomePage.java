package br.com.dbccompany.page;

import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class HomePage extends Interactions {

    private static final By btnPopular = By.cssSelector("#home-page-tabs > li:nth-child(1) > a");
    private static final By btnBestSellers = By.cssSelector("#home-page-tabs > li:nth-child(2) > a");
    private static final By blouseProduct = By.cssSelector("h5 > a[title=\"Blouse\"]");
    private static final By popularMsg = By.cssSelector("#homefeatured > li");



    public void clicarBestSeller() {click(btnBestSellers);}
    public void clicarPopular() {click(btnPopular);}
    public String validaBlouseProduct() {return lerTexto(blouseProduct);}
    public String validaPopularMsg() {return lerTexto(popularMsg);}


}
