import './base'

let forgotLoginInfo = 'html > body > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(1) > div > p:nth-of-type(1) > a'
let firstNameInput = '#firstName'
let firstNameRequired = 'span[id=\'firstName.errors\']'
let lastNameInput = '#lastName'
let addressInput = 'input[id=\'address.street\']'
let cityInput = 'input[id=\'address.city\']'
let stateInput = 'input[id=\'address.state\']'
let zipCodeInput = 'input[id=\'address.zipCode\']'
let SSN = '#ssn'
let btnFindLogin = 'input[value*=\'My\']'
let username = '#leftPanel > ul > :nth-child(8) > a'
let password = '#rightPanel > :nth-child(3) > :nth-child(3)'

Cypress.Commands.add('clicarForgotInfo' ,() => {
    cy.clicar(forgotLoginInfo)
})

Cypress.Commands.add('preencherForgotLoginValido', (usuario) => {
    cy.preencherCampo(firstNameInput, usuario.firstName)
    cy.preencherCampo(lastNameInput, usuario.lastName)
    cy.preencherCampo(addressInput, usuario.address)
    cy.preencherCampo(cityInput, usuario.city)
    cy.preencherCampo(stateInput, usuario.state)
    cy.preencherCampo(zipCodeInput, usuario.zipCode)
    cy.preencherCampo(SSN, usuario.ssn)
})

Cypress.Commands.add('clicarFindMyLogin', () => {
    cy.clicar(btnFindLogin)
})

Cypress.Commands.add('logout', () => {
    cy.clicar("#leftPanel > ul > :nth-child(8) > a")
})

Cypress.Commands.add('validarLoginInfoRecovery', () => {
    cy.validarVisibilidade(username)
    cy.validarVisibilidade(password)
})

Cypress.Commands.add('preencherForgotLoginComNomeVazio', (usuario) => {
    cy.preencherCampo(lastNameInput, usuario.lastName)
    cy.preencherCampo(addressInput, usuario.address)
    cy.preencherCampo(cityInput, usuario.city)
    cy.preencherCampo(stateInput, usuario.state)
    cy.preencherCampo(zipCodeInput, usuario.zipCode)
    cy.preencherCampo(SSN, usuario.ssn)
})

Cypress.Commands.add('validarFirstNameRequired', () => {
    cy.validarTexto(firstNameRequired, 'First name is required.')
})