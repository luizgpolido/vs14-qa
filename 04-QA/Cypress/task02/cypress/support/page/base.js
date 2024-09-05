import '../commands'

Cypress.Commands.add('preencherCampo', (element, text) => {
    cy.get(element).type(text, {force: true});
});

Cypress.Commands.add('clicar', (element) => {
    cy.get(element).click({force: true});
});

Cypress.Commands.add('validarTexto', (element, text) => {
    cy.get(element).contains(text)
});

Cypress.Commands.add('validarVisibilidade', (element) => {
    cy.get(element).should('be.visible')
})

Cypress.Commands.add('gerarUsuario', (usuario) => {
   cy.writeFile("cypress/fixtures/loginData.json",

       {
           "nome": usuario.name,
           "email": usuario.email,
           "senha": usuario.password
       }
       )
});


