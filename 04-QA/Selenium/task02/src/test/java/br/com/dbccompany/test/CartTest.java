package br.com.dbccompany.test;

import br.com.dbccompany.dto.CartDto;
import br.com.dbccompany.factory.data.CartData;
import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.factory.selenium.Waits;
import br.com.dbccompany.page.CartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static br.com.dbccompany.factory.selenium.Waits.waitElement;
import static storys.CartStory.*;

@Epic(EPIC)
@Story(USER_STORY_CART)
public class CartTest extends BaseTest {

    CartPage cartPage = new CartPage();
    CartData cartData = new CartData();
    Validation validation = new Validation();

    @Test
    @Description(CT011_CARRINHO)
    public void testValidarAcessoAoCarrinho(){
        cartPage.paginaCarrinho();
        cartPage.validarPaginaCarrinho();

    }

    @Test
    @Description(CT012_CARRINHO)
    public void testValidarAcessoAoCarrinhoLogado(){
        CartDto login = CartData.loginValido();
        cartPage.realizarLogin(login);
        cartPage.paginaCarrinho();
        cartPage.validarPaginaCarrinho();

    }

    @Test
    @Description(CT013_CARRINHO)
    public void testValidarInclusaoDeProdutoNoCarrinho(){
        CartDto login = CartData.loginValido();
        cartPage.realizarLogin(login);
        cartPage.incluirProduto1();
    }

    @Test
    @Description(CT014_CARRINHO)
    public void testValidarCicloDeCompraNoCarrinho(){
        CartDto login = CartData.loginValido();
        cartPage.realizarLogin(login);
        cartPage.comprarProduto1();
    }

    @Test
    @Description(CT015_CARRINHO)
    public  void testTentativaDeFinalizarCarrinhoSemAceitarTermos(){
        CartDto login = CartData.loginValido();
        cartPage.realizarLogin(login);
        cartPage.comprarProduto1SemAceitarOsTermos();
    }



}
