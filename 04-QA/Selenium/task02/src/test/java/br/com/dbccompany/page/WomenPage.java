package br.com.dbccompany.page;

import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;

import static br.com.dbccompany.factory.selenium.Waits.waitElement;

public class WomenPage extends Interactions {

    private static final By btnWomen
            =  By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    private static final By btnQuickView
            = By.cssSelector("#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link");
    private static final By tamanhoInput
            = By.cssSelector("#group_1");
    private static final By quantidadeInput
            = By.cssSelector("#quantity_wanted");
    private static final By btnAddToCart
            = By.cssSelector("#add_to_cart > button > span");
    private static final By btnIrParaCheckout
            = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private static final By qtdCarrinho
            = By.cssSelector("#product_2_11_0_0 > td.cart_quantity.text-center > input.cart_quantity_input.form-control.grey");
    private static final By skuProduto
            = By.cssSelector("#product_2_11_0_0 > td.cart_description > small.cart_ref");
    private static final By textoShoppingCartSummary
            = By.cssSelector("#cart_title");
    private static final By textoAvaliabilidade
            = By.cssSelector("#product_2_11_0_0 > td.cart_avail > span");
    private static final By btnCorPreta
            = By.cssSelector("#color_11");

    public void clicarBtnWomen(){
        click(btnWomen);
    }

    public void clicarBtnBlouse(){
        click(btnQuickView);
    }

    public void preencherTamanho(){
        pegarInputSelect(tamanhoInput, 2);
    }

    public void preencherQuantidade(){
        clear(quantidadeInput);
        sendKeys(quantidadeInput, "3");
    }

    public void clicarEmAddToCart(){
        click(btnAddToCart);
    }

    public void clicarIrParaCheckout(){
        click(btnIrParaCheckout);
    }

    public String pegarQuantidadeCarrinho(){
        return lerValor(qtdCarrinho);
    }

    public String pegarSKU(){
        return lerTexto(skuProduto);
    }

    public String pegarShoppingCartSummaryTexto(){
        return lerTexto(textoShoppingCartSummary);
    }

    public String pegarTextoAvaliabilidade(){
        return lerTexto(textoAvaliabilidade);
    }

    public void clicarBtnCorPreta(){
        click(btnCorPreta);
    }

    public String pegarCorAvaliability(){
        return pegarCor(textoAvaliabilidade);
    }
}
