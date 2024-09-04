export default class HomePage{

    transferenciaBtn = '#btn-TRANSFERÊNCIA'
    pagamentos = '#btn-PAGAMENTOS'
    exatratos = '#btn-EXTRATO'
    saque = '#btn-SAQUE'
    saldo = '#textBalance > span'
    numeroConta = '#textAccountNumber > span';
    btnExit = '#btnExit'

    clicarTransferencia(){
        cy.get(this.transferenciaBtn).click()
    }

    clicarPagamento(){
        cy.get(this.pagamentos).click()
    }

    clicarExtratos(){
        cy.get(this.exatratos).click()
    }

    clicarSaque(){
        cy.get(this.saque).click()
    }

    pegarSaldo(){
        return cy.get(this.saldo).then(($saldo) => {
            return cy.wrap($saldo.text());
        })
    }

    clicarBtnExit(){
        cy.get(this.btnExit).click()
    }

    pegarNumeroConta(){
        return cy.get(this.numeroConta).then(($numeroConta) => {
            return cy.wrap($numeroConta.text());
        })
    }

    verificarSaldo(){
        cy.get(this.saldo).contains('R$ 1.400,00')

    }
}