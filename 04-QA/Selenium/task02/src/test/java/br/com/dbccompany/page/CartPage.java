package br.com.dbccompany.page;

import static br.com.dbccompany.factory.selenium.Waits.waitElement;
import static br.com.dbccompany.factory.selenium.Waits.waitElementVisibily;

import br.com.dbccompany.dto.CartDto;
import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartPage  extends Interactions {

    private static final By btnPaginaLogin = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private static final By campoEmail = By.cssSelector("#email");
    private static final By campoPassword = By.cssSelector("#passwd");
    private static final By btnFazerLogin = By.cssSelector("#SubmitLogin > span");
    private static final By imgConfirmLogin = By.cssSelector("#center_column > h1");
    private static final By irParaCarrinho = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_no_product");
    private static final By confirmarAcessoCarrinho = By.cssSelector("#cart_title");
    private static final By paginaCompras = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    private static final By validarProd1 = By.cssSelector("#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1");
    private static final By produtoDisponivel = By.cssSelector("#availability_value");
    private static final By adicionarAoCarrinho = By.cssSelector("#add_to_cart > button > span");
    private static final By btnIrParaCheckout = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");
    private static final By btnContiarComprando = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span");
    private static final By msgConfimacaoAddProduto1 = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2");
    private static final By campoTamanho = By.cssSelector("#group_1");
    private static final By tamanhoL = By.cssSelector("#group_1 > option:nth-child(3)");
    private static final By maisInformacoes = By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line hovered'] a[title='View'] span");
    private static final By btnProceedCheckout = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span");
    private static final By paginaConfirmacaoEndereco = By.cssSelector("#center_column > h1");
    private static final By btnProceedCheckout2 = By.cssSelector("#center_column > form > p > button > span");
    private static final By aceiteServicos = By.cssSelector("#cgv");
    private static final By mensagemDeAceiteObrigatorio = By.cssSelector("#order > div.fancybox-overlay.fancybox-overlay-fixed > div > div > div > div > p");
    private static final By BtnProceedCheckout3 = By.cssSelector("#form > p > button > span");
    private static final By telaPagamento = By.cssSelector("#center_column > h1");
    private static final By tipoDePagamentoPayBayBank = By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
    private static final By tipoDePagamentoPayByCheck = By.cssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p > a");
    private static final By btnConfirmarCompra = By.cssSelector("#cart_navigation > button > span");
    private static final By mensagemConfirmacaoCompra = By.cssSelector("#center_column > p.alert.alert-success");




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

    public void validarPaginaProdutos(){
        waitElement(paginaCompras);
    }
    public void validarProdutoDisponivel(){
        waitElement(produtoDisponivel);
    }
    public void rolarTela(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long viewportHeight = (Long) js.executeScript("return window.innerHeight;");
        js.executeScript("window.scrollBy(0, arguments[0]);", viewportHeight / 2);
    }


    public void realizarLogin(CartDto login){
        paginaLogin();
        sendKeys(campoEmail, login.getEmail());
        sendKeys(campoPassword, login.getSenha());
        click(btnFazerLogin);
        confirmLogin();
    }

    public void incluirProduto1(){
        click(paginaCompras);
        rolarTela();
        validarPaginaProdutos();
        WebElement elementToHover = driver.findElement(By.cssSelector("#center_column > " +
                "ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        click(maisInformacoes);
        waitElement(validarProd1);
        click(campoTamanho);
        click(tamanhoL);
        waitElement(produtoDisponivel);
        click(adicionarAoCarrinho);
        waitElementVisibily(msgConfimacaoAddProduto1);

    }

    public void comprarProduto1(){
        click(paginaCompras);
        rolarTela();
        validarPaginaProdutos();
        WebElement elementToHover = driver.findElement(By.cssSelector("#center_column > " +
                "ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        click(maisInformacoes);
        waitElement(validarProd1);
        click(campoTamanho);
        click(tamanhoL);
        waitElement(produtoDisponivel);
        click(adicionarAoCarrinho);
        waitElementVisibily(msgConfimacaoAddProduto1);
        click(btnIrParaCheckout);
        waitElementVisibily(btnProceedCheckout);
        click(btnProceedCheckout);
        waitElementVisibily(paginaConfirmacaoEndereco);
        click(btnProceedCheckout2);
        click(aceiteServicos);
        click(BtnProceedCheckout3);
        waitElementVisibily(telaPagamento);
        click(tipoDePagamentoPayBayBank);
        click(btnConfirmarCompra);
        waitElementVisibily(mensagemConfirmacaoCompra);


    }

    public void adicionarAoCarrinhoEContinuarComprando(){
        click(paginaCompras);
        rolarTela();
        validarPaginaProdutos();
        WebElement elementToHover = driver.findElement(By.cssSelector("#center_column > " +
                "ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        click(maisInformacoes);
        waitElement(validarProd1);
        click(campoTamanho);
        click(tamanhoL);
        waitElement(produtoDisponivel);
        click(adicionarAoCarrinho);
        waitElementVisibily(msgConfimacaoAddProduto1);
        click(btnContiarComprando);
        waitElement(produtoDisponivel);


    }

    public void comprarProduto1SemAceitarOsTermos(){
        click(paginaCompras);
        rolarTela();
        validarPaginaProdutos();
        WebElement elementToHover = driver.findElement(By.cssSelector("#center_column > " +
                "ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        click(maisInformacoes);
        waitElement(validarProd1);
        click(campoTamanho);
        click(tamanhoL);
        waitElement(produtoDisponivel);
        click(adicionarAoCarrinho);
        waitElementVisibily(msgConfimacaoAddProduto1);
        click(btnIrParaCheckout);
        waitElementVisibily(btnProceedCheckout);
        click(btnProceedCheckout);
        waitElementVisibily(paginaConfirmacaoEndereco);
        click(btnProceedCheckout2);
        click(BtnProceedCheckout3);
        waitElementVisibily(mensagemDeAceiteObrigatorio);


    }

    public void comprarProdutoComPagamentoPayCheck(){
        click(paginaCompras);
        rolarTela();
        validarPaginaProdutos();
        WebElement elementToHover = driver.findElement(By.cssSelector("#center_column > " +
                "ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        click(maisInformacoes);
        waitElement(validarProd1);
        click(campoTamanho);
        click(tamanhoL);
        waitElement(produtoDisponivel);
        click(adicionarAoCarrinho);
        waitElementVisibily(msgConfimacaoAddProduto1);
        click(btnIrParaCheckout);
        waitElementVisibily(btnProceedCheckout);
        click(btnProceedCheckout);
        waitElementVisibily(paginaConfirmacaoEndereco);
        click(btnProceedCheckout2);
        click(aceiteServicos);
        click(BtnProceedCheckout3);
        waitElementVisibily(telaPagamento);
        click(tipoDePagamentoPayByCheck);
        click(btnConfirmarCompra);
        waitElementVisibily(mensagemConfirmacaoCompra);


    }

    public void comprarProdutoComPagamentoPayBybankWire(){
        click(paginaCompras);
        rolarTela();
        validarPaginaProdutos();
        WebElement elementToHover = driver.findElement(By.cssSelector("#center_column > " +
                "ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        click(maisInformacoes);
        waitElement(validarProd1);
        click(campoTamanho);
        click(tamanhoL);
        waitElement(produtoDisponivel);
        click(adicionarAoCarrinho);
        waitElementVisibily(msgConfimacaoAddProduto1);
        click(btnIrParaCheckout);
        waitElementVisibily(btnProceedCheckout);
        click(btnProceedCheckout);
        waitElementVisibily(paginaConfirmacaoEndereco);
        click(btnProceedCheckout2);
        click(aceiteServicos);
        click(BtnProceedCheckout3);
        waitElementVisibily(telaPagamento);
        click(tipoDePagamentoPayBayBank);
        click(btnConfirmarCompra);
        waitElementVisibily(mensagemConfirmacaoCompra);


    }



}
