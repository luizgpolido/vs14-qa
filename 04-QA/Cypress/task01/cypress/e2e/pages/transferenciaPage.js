export default class TransferenciaPage {

    numeroConta = ':nth-child(1) > .input__default'
    digitoConta = '.account__data > :nth-child(2) > .input__default'
    valorTransferencia = '.styles__ContainerFormTransfer-sc-1oow0wh-0 > :nth-child(2) > .input__default'
    descricao = ':nth-child(3) > .input__default'
    btnTransferir = '#__next > div > div.transfer__ContainerForm-sc-1yjpf2r-8.gasnNO > form > button'
    modalText = '#modalText'
    btnFecharModel = '#btnCloseModal';
    btnSair = '.transfer__ContainerLink-sc-1yjpf2r-2'
    modalTextSaldoInsuficiente = '#modalText'


    preencherNumeroConta(numeroConta){
        cy.get(this.numeroConta).type(numeroConta)
    }

    preencherDigitoConta(digitoConta){
        cy.get(this.digitoConta).type(digitoConta)
    }

    preencherValorTransferencia(valorTransferencia){
        cy.get(this.valorTransferencia).type(valorTransferencia)
    }

    preencherDescricao(descricao){
        cy.get(this.descricao).type(descricao)
    }

    clicarBtnTransferir(){
        cy.get(this.btnTransferir).click();
    }

    clicarFecharModal(){
        cy.get(this.btnFecharModel).click({force: true});
    }

    verificarTextoModalSucesso(){
        cy.get(this.modalText).contains('Transferencia realizada com sucesso')
    }

    clicarBtnSair(){
        cy.get(this.btnSair).click()
    }

    verificarTextoSaldoInsuficiente(){
        cy.get(this.modalTextSaldoInsuficiente).contains("Você não tem saldo suficiente para essa transação")
    }

}