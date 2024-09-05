describe('Transferencia', () => {

    beforeEach(() => {
        cy.visit("/")
    })

    it('CT 001 - Transferência com sucesso', () => {
        cy.transferenciaValida()
    })

    it('CT 002 - Trasferência com valor acima do saldo', () => {
        cy.transferenciaComValorAcimaDoSaldo()
    })

    it('CT 003 - Trasferência sem numero da conta', () => {
        cy.transferenciaSemNumeroDaConta()
    })
})