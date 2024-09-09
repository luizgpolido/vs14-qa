
Cypress.Commands.add('clicar', (element) => {
   cy.get(element).click();
});

Cypress.Commands.add('preencherCampo', (element, text) => {
    cy.get(element).type(text);
});

Cypress.Commands.add('validarVisibilidade', (element) => {
    cy.get(element).should('be.visible')
});

Cypress.Commands.add('validarTexto', (element, text) => {
    cy.get(element).should('be.visible').contains(text);
});