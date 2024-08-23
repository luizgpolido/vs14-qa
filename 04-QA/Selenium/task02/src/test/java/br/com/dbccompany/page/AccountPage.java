package br.com.dbccompany.page;

import br.com.dbccompany.dto.AddressDto;
import br.com.dbccompany.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class AccountPage extends Interactions {

    //my addresses
    private static final By warningMsg = By.cssSelector("#center_column > p.alert.alert-warning");
    private static final By btnAddNewAddress = By.cssSelector("a[title=\"Add an address\"]");
//    private static final By btnAddFirstAddress = By.cssSelector("a[title=\"Add my first address\"]");
    private static final By btnAddFirstAddress = By.cssSelector("a[title=\"Add an address\"]");

    public void clicarBtnAddNewAddress() {click(btnAddNewAddress);}
    public void clicarBtnAddFirstAddress() {click(btnAddFirstAddress);}


    //btn home account
    private static final By btnOrderHistory = By.cssSelector("a[title=\"Orders\"]");
    private static final By btnCreditSlips = By.cssSelector("a[title=\"Credit slips\"]");
    private static final By btnAddresses = By.cssSelector("a[title=\"Addresses\"]");
    private static final By btnPersonalInfo = By.cssSelector("a[title=\"Information\"]");
    private static final By btnSave = By.cssSelector("#submitAddress");

    public void clicarBtnOrderHistory() {click(btnOrderHistory);}
    public void clicarBtnCreditSlips() {click(btnCreditSlips);}
    public void clicarBtnAddresses() {click(btnAddresses);}
    public void clicarBtnPersonalInfo() {click(btnPersonalInfo);}
    public void clicarBtnSave() {click(btnSave);}

// campos address
    private static final By campoFirstName = By.cssSelector("#firstname");
    private static final By campoLastName = By.cssSelector("#lastname");
    private static final By campoCompany = By.cssSelector("#company");
    private static final By campoAddress1 = By.cssSelector("#address1");
    private static final By campoAddress2 = By.cssSelector("#address2");
    private static final By campoCity = By.cssSelector("#city");
    private static final String campoState = "#id_state";
    private static final By campoPostCode = By.cssSelector("#postcode");
    private static final By campoPhone = By.cssSelector("#phone");
    private static final By campoPhoneMobile = By.cssSelector("#phone_mobile");
    private static final By campoAdditionalInfo = By.cssSelector("#other");
    private static final By campoAddressTitle = By.cssSelector("#alias");

    public void preencherFirstName(String valor) {sendKeys(campoFirstName,valor);}
    public void preencherLastName(String valor) {sendKeys(campoLastName,valor);}
    public void preencherCompany(String valor) {sendKeys(campoCompany,valor);}
    public void preencherAddress1(String valor) {sendKeys(campoAddress1,valor);}
    public void preencherAddress2(String valor) {sendKeys(campoAddress2,valor);}
    public void preencherCity(String valor) {sendKeys(campoCity,valor);}
    public void preencherPostCode(String valor) {sendKeys(campoPostCode,valor);}
    public void preencherPhone(String valor) {sendKeys(campoPhone,valor);}
    public void preencherPhoneMobile(String valor) {sendKeys(campoPhoneMobile,valor);}
    public void preencherAdditionalInfo(String valor) {sendKeys(campoAdditionalInfo,valor);}
    public void preencherAddressTitle(String valor) {sendKeys(campoAddressTitle,valor);}

    public void limparCampoFirstName() {limparCampo("#firstname");};
    public void limparCampoLastName() {limparCampo("#lastname");};
    public void limparCampoAddressTitle() {limparCampo("#alias");};


    private static final By newAddressTitle = By.cssSelector("#center_column > div.addresses > div > div > ul > li:nth-child(1) > h3");
    public String validaNovoEndereco() {return lerTexto(newAddressTitle);}

//fluxos
    public void adicionarNovoEndereço(AddressDto addressDto) {
        clicarBtnAddresses();
        clicarBtnAddFirstAddress();
        limparCampoFirstName();
        preencherFirstName(addressDto.getFirstName());
        limparCampoLastName();
        preencherLastName(addressDto.getLastName());
        preencherCompany(addressDto.getCompany());
        preencherAddress1(addressDto.getAddress1());
        preencherAddress2(addressDto.getAddress2());
        preencherCity(addressDto.getCity());
        selecionarSelectAleatorio(campoState);
        preencherPostCode(addressDto.getPostCode());
        preencherPhone(addressDto.getPhone());
        preencherPhoneMobile(addressDto.getPhoneMobile());
        preencherAdditionalInfo(addressDto.getAdditionalInfo());
        limparCampoAddressTitle();
        preencherAddressTitle(addressDto.getAddressTitle());
        click(btnSave);
    }



}
