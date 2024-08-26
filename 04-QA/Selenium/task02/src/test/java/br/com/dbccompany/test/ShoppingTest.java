package br.com.dbccompany.test;

import br.com.dbccompany.factory.selenium.Validation;
import br.com.dbccompany.page.WomenPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static storys.ShoppingStory.*;

@Epic(EPIC)
@Story(USER_STORY_SHOPPING)
public class ShoppingTest extends BaseTest {

    WomenPage womenPage = new WomenPage();
    Validation validation = new Validation();

    @Test
    @Description(CT101_SHOPPING)
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
    @Description(CT102_SHOPPING)
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
    @Description(CT103_SHOPPING)
    public void testValidarFiltroDePesquisPorDresses() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnDresses();
        validation.validateText("WOMEN " , womenPage.pegarTextoCategoriesDresses());
        Thread.sleep(400);
        validation.validateURL(driver.getCurrentUrl(), "http://www.automationpractice.pl/index.php?id_category=3&controller=category#/categories-dresses");

    }

    @Test
    @Description(CT104_SHOPPING)
    public void testValidarFiltroDePesquisPorTamanho() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnTamS();
        validation.validateText("WOMEN " , womenPage.pegarTextoCategoriesDresses());
        Thread.sleep(700);
        validation.validateURL(driver.getCurrentUrl(), "http://www.automationpractice.pl/index.php?id_category=3&controller=category#/size-s");

    }

    @Test
    @Description(CT105_SHOPPING)
    public void testValidarFiltroDePesquisPorPrecoMaiorParaMenor() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.setInputPrice();
        validation.validateText("WOMEN " , womenPage.pegarTextoCategoriesDresses());
        Thread.sleep(700);
        validation.validateURL(driver.getCurrentUrl(), "http://www.automationpractice.pl/index.php?id_category=3&controller=category&orderby=price&orderway=asc&orderway=asc");
        validation.validarPrecoDoMaisBaratoParaMaisCaro(womenPage.pegarRoupaMaisCara(), womenPage.pegarRoupaMaisBarata());

    }

    @Test
    @Description(CT106_SHOPPING)
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
    @Description(CT113_SHOPPING)
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
    @Description(CT107_SHOPPING)
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

    @Test
    @Description(CT108_SHOPPING)
    public void testValidarTrocaDeGridParaLista(){
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnList();
        womenPage.rolarAteRoupasEmList();
        validation.validarNaoEstaNulo(womenPage.pegarDescricaoPrimeiroProduto());
        validation.validarElementoEstaVisivel(womenPage.pegarPrimeiraFoto());
    }

    @Test
    @Description(CT109_SHOPPING)
    public void testTentarAdicionarProdutoSemEstoqueDuranteComparacao() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.rolarAteRoupas();
        womenPage.moverMouseRoupa1();
        womenPage.clicarBtnAdicionarCompare1();
        Thread.sleep(200);
        womenPage.moverMouseRoupa2();
        womenPage.clicarBtnAdicionarCompare2();
        womenPage.clicarBtnCompare();
        validation.validarBooleanFalso(womenPage.pegarBtnDesabilitado());
    }

    @Test
    @Description(CT110_SHOPPING)
    public void testEnviarParaAmigoValido() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnBlouse();
        Thread.sleep(200);
        womenPage.clicarBtnEnviarAmigo();
        womenPage.preencherNomeAmigo();
        womenPage.preencherEmailAmigo();
        womenPage.clicarBtnEnviar();
        Thread.sleep(200);
        validation.validarElementoEstaVisivel(womenPage.pegarCardEnviadoParaAmigo());
        validation.validarNaoEstaNulo(womenPage.pegarTextoEnviadoParaAmigo());
        womenPage.clicarBtnOk();
    }

    @Test
    @Description(CT111_SHOPPING)
    public void testEnviarParaAmigoInvalido() throws InterruptedException {
        womenPage.clicarBtnWomen();
        womenPage.clicarBtnBlouse();
        Thread.sleep(200);
        womenPage.clicarBtnEnviarAmigo();
        womenPage.preencherNomeAmigo();
        womenPage.preencherEmailAmigoInvalido();
        womenPage.clicarBtnEnviar();
        Thread.sleep(200);
        validation.validarElementoEstaVisivel(womenPage.pegarCardEnviadoParaAmigo());
        validation.validarNaoEstaNulo(womenPage.pegarTextoEnviadoParaAmigo());
        womenPage.clicarBtnOk();
    }

}
