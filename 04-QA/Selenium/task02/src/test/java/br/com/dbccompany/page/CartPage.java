package br.com.dbccompany.page;

import static br.com.dbccompany.factory.selenium.Waits.waitElement;

import br.com.dbccompany.dto.CartDto;
import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class CartPage  extends Interactions {

    private static final By btnPaginaLogin = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private static final By campoEmail = By.cssSelector("#email");
    private static final By campoPassword = By.cssSelector("#passwd");
    private static final By btnFazerLogin = By.cssSelector("#SubmitLogin > span");
    private static final By imgConfirmLogin = By.cssSelector("#center_column > h1");
    private static final By irParaCarrinho = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_no_product");
    private static final By confirmarAcessoCarrinho = By.cssSelector("#cart_title");


    public void paginaLogin(){
        click(btnPaginaLogin);
    }

    public void confirmLogin(){
        waitElement(imgConfirmLogin);
    }

    public void paginaCarrinho(){
        click(irParaCarrinho);
    }

    public void validarPaginaCarrinho(){
        waitElement(confirmarAcessoCarrinho);
    }


    public void realizarLogin(CartDto login){
        paginaLogin();
        sendKeys(campoEmail, login.getEmail());
        sendKeys(campoPassword, login.getSenha());
        click(btnFazerLogin);
        confirmLogin();
    }




}
