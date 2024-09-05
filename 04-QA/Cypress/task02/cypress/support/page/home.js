export default class HomePage{

    transferenciaBtn = '#btn-TRANSFERÊNCIA'
    pagamentos = '#btn-PAGAMENTOS'
    exatratos = '#btn-EXTRATO'
    saque = '#btn-SAQUE'
    saldo = '#textBalance > span'
    numeroConta = '#textAccountNumber > span';
    btnExit = '#btnExit'


    pegarSaldo(){
        return cy.get(this.saldo).then(($saldo) => {
            return cy.wrap($saldo.text());
        })
    }

    pegarNumeroConta(){
        return cy.get(this.numeroConta).then(($numeroConta) => {
            return cy.wrap($numeroConta.text());
        })
    }

}