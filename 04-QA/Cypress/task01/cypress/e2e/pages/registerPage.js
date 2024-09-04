export default class RegisterPage{

    url = 'https://bugbank.netlify.app/'
    btnRegister = '.ihdmxA'
    email = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(2) > input'
    nome = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(3) > input'
    senha = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(4) > div > input'
    confirmacaoSenha = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(5) > div > input'
    comSaldoBtn = '#toggleAddBalance'
    cadastrarBtn = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > button'
    contaCriadaComSucesso = '#modalText'
    btnCloseCriadoComSucesso = '#btnCloseModal'
    formatoInvalidoEmail = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div.style__ContainerFieldInput-sc-s3e9ea-0.kOeYBn.input__child > p'

    navegar(){
        cy.visit(this.url)
    }

    clicarEmRegistrar(){
        cy.get(this.btnRegister).click();
    }

    preencherEmail(email){
        cy.get(this.email).type(email, {force: true})
        
    }

    preencherName(name){
        cy.get(this.nome).type(name, {force: true})
    }

    preencherPassword(password){
        cy.get(this.senha).type(password, {force: true})
    }

    preencherConfirmarPassword(password){
        cy.get(this.confirmacaoSenha).type(password, {force: true})
    }

    clicarCriarContaComSaldo(){
        cy.get(this.comSaldoBtn).click({force: true});
    }

    clicarCadastrar(){
        cy.get(this.cadastrarBtn).click({force: true});
    }

    verificarTextoContaCriadaComSucesso(){
        cy.get(this.contaCriadaComSucesso).contains("sucesso", {force: true})
    }

    clicarCloseModal(){
        cy.get(this.btnCloseCriadoComSucesso).click({force: true});
    }

    criarUsuario(email, nome, password){
        this.clicarEmRegistrar();
        this.preencherEmail(email);
        this.preencherName(nome);
        this.preencherPassword(password);
        this.preencherConfirmarPassword(password);
        this.clicarCriarContaComSaldo();
        this.clicarCadastrar();
        this.verificarTextoContaCriadaComSucesso();
        this.clicarCloseModal();
    }

    validarTextoFormatoInvalidoEmail(){
        cy.get(this.formatoInvalidoEmail).contains("Formato inválido")
    }



}