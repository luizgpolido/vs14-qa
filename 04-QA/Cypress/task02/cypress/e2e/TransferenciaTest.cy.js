describe('Transferencia', () => {

    beforeEach(() => {
        cy.visit("/")
    })

    it('CT 001 - Transferência com sucesso', () => {
        cy.transferenciaValida()
    })


})