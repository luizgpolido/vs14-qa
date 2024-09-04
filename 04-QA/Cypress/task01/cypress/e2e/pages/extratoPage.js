export default class ExtratoPage{

    transferenciaRealizadaText = ':nth-child(2) > .bank-statement__ContainerDateAndType-sc-7n8vh8-14 > #textTypeTransaction'
    valorRecebido = ':nth-child(2) > .bank-statement__ContainerDescAndValue-sc-7n8vh8-15 > #textTransferValue'

    verficiarValorRecebido(){
        cy.get(this.valorRecebido).should('be.visible')
        cy.get(this.valorRecebido).contains('R$ 400,00')
        cy.get(this.transferenciaRealizadaText).should('be.visible')
    }
}