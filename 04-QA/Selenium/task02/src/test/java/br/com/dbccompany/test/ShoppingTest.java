package br.com.dbccompany.test;

import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.WomenPage;
import org.junit.jupiter.api.Test;

public class ShoppingTest extends BaseTest {

    WomenPage womenPage = new WomenPage();
    Validation validation = new Validation();

    @Test
    public void testValidarQuantidadeDeRoupasComCarrinho(){
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnBlouse();
        womenPage.preencherTamanho();
        womenPage.clicarBtnCorPreta();
        womenPage.clicarBtnCorPreta();
        womenPage.preencherQuantidade();
        womenPage.clicarEmAddToCart();
        womenPage.clicarIrParaCheckout();
        validation.validateText("3",womenPage.pegarQuantidadeCarrinho());
        validation.validarNaoEstaNulo(womenPage.pegarSKU());
        validation.validarNaoEstaNulo(womenPage.pegarShoppingCartSummaryTexto());
        validation.validarNaoEstaNulo(womenPage.pegarTextoAvaliabilidade());
        validation.validarCor( "rgba(85, 198, 94, 1)" , womenPage.pegarCorAvaliability());

    }

    @Test
    public void testValidarQuantidadeValorDoCarrinho(){
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnBlouse();
        womenPage.preencherTamanho();
        womenPage.clicarBtnCorPreta();
        womenPage.clicarBtnCorPreta();
        womenPage.preencherQuantidade();
        womenPage.clicarEmAddToCart();
        womenPage.clicarIrParaCheckout();
        validation.validateText("3",womenPage.pegarQuantidadeCarrinho());
        validation.validarNaoEstaNulo(womenPage.pegarSKU());
        validation.validarNaoEstaNulo(womenPage.pegarShoppingCartSummaryTexto());
        validation.validarNaoEstaNulo(womenPage.pegarTextoAvaliabilidade());
        validation.validateText("$" + (27 * 3), womenPage.pegarTextoValorTotal());
        validation.validarCor( "rgba(85, 198, 94, 1)" , womenPage.pegarCorAvaliability());

    }

    @Test
    public void testValidarFiltroDePesquisPorDresses() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnDresses();
        validation.validateText("WOMEN " , womenPage.pegarTextoCategoriesDresses());
        Thread.sleep(400);
        validation.validateURL(driver.getCurrentUrl(), "http://www.automationpractice.pl/index.php?id_category=3&controller=category#/categories-dresses");

    }

    @Test
    public void testValidarFiltroDePesquisPorTamanho() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnTamS();
        validation.validateText("WOMEN " , womenPage.pegarTextoCategoriesDresses());
        Thread.sleep(700);
        validation.validateURL(driver.getCurrentUrl(), "http://www.automationpractice.pl/index.php?id_category=3&controller=category#/size-s");

    }

    @Test
    public void testValidarFiltroDePesquisPorPrecoMaiorParaMenor() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.setInputPrice();
        validation.validateText("WOMEN " , womenPage.pegarTextoCategoriesDresses());
        Thread.sleep(700);
        validation.validateURL(driver.getCurrentUrl(), "http://www.automationpractice.pl/index.php?id_category=3&controller=category&orderby=price&orderway=asc&orderway=asc");
        validation.validarPrecoDoMaisBaratoParaMaisCaro(womenPage.pegarRoupaMaisCara(), womenPage.pegarRoupaMaisBarata());

    }

    @Test
    public void testValidarComparacaoDeRoupas() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.rolarAteRoupas();
        womenPage.moverMouseRoupa1();
        womenPage.clicarBtnAdicionarCompare1();
        String nomePrimeiraRoupa = womenPage.pegarNomePrimeiraRoupa();
        String nomeSegundaRoupa = womenPage.pegarNomeSegundaRoupa();
        Thread.sleep(200);
        womenPage.moverMouseRoupa2();
        womenPage.clicarBtnAdicionarCompare2();
        womenPage.clicarBtnCompare();
        validation.validateText(nomePrimeiraRoupa , womenPage.pegarNomePrimeiraRoupaCompare());
        validation.validateText(nomeSegundaRoupa, womenPage.pegarNomeSegundaRoupaCompare() );
    }

    @Test
    public void testValidarQuantidadeDeRoupasNegativoComCarrinho(){
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnBlouse();
        womenPage.preencherTamanho();
        womenPage.clicarBtnCorPreta();
        womenPage.clicarBtnCorPreta();
        womenPage.preencherQuantidadeNegativa();
        womenPage.clicarEmAddToCart();
        womenPage.clicarIrParaCheckout();
        validation.validateText("-3",womenPage.pegarQuantidadeCarrinho());
    }

    @Test
    public void testValidarQuantidadeDeRoupasComValorMaiorQueEmEstoque() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnBlouse();
        womenPage.preencherTamanho();
        womenPage.clicarBtnCorPreta();
        womenPage.clicarBtnCorPreta();
        womenPage.preencherQuantidadeAcimaEstoque();
        womenPage.clicarEmAddToCart();
        Thread.sleep(200);
        validation.validateText("There isn't enough product in stock." , womenPage.pegarTextoEstoqueInsuficiente());
    }

}
