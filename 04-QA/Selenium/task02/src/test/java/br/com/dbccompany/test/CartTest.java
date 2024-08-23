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



}
