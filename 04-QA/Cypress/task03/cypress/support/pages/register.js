import './base'
import { faker } from '@faker-js/faker';


let registerPageButton = 'html > body > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(1) > div > p:nth-of-type(2) > a'
let firstNameInput = 'input[id=\'customer.firstName\']'
let lastNameInput = 'input[id=\'customer.lastName\']'
let addressInput = 'input[id=\'customer.address.street\']'
let cityInput = 'input[id=\'customer.address.city\']'
let stateInput = 'input[id=\'customer.address.state\']'
let zipCodeInput = 'input[id=\'customer.address.zipCode\']'
let phoneInput = 'input[id=\'customer.phoneNumber\']'
let SSNInput = 'input[id=\'customer.ssn\']'
let userNameInput = 'input[id=\'customer.username\']'
let passwordInput = 'input[id=\'customer.password\']'
let confirmPasswordInput = '#repeatedPassword'
let registerButton = 'input[value=\'Register\']'
let mensagemDeBoasVindas = '.title'
let passwordRepeated = '#repeatedPassword\\.errors'

Cypress.Commands.add('registroValido', (usuario) => {
    cy.preencherCampo(firstNameInput, usuario.firstName);
    cy.preencherCampo(lastNameInput, usuario.lastName);
    cy.preencherCampo(addressInput, usuario.address)
    cy.preencherCampo(cityInput, usuario.city)
    cy.preencherCampo(stateInput, usuario.state)
    cy.preencherCampo(zipCodeInput, usuario.zipCode)
    cy.preencherCampo(phoneInput, usuario.phone)
    cy.preencherCampo(SSNInput, usuario.ssn)
    cy.preencherCampo(userNameInput, usuario.username)
    cy.preencherCampo(passwordInput, usuario.password)
    cy.preencherCampo(confirmPasswordInput, usuario.password)
})

Cypress.Commands.add('validarWelcome', (usuario) => {
    cy.validarTexto(mensagemDeBoasVindas, 'Welcome ' + usuario.username)
})

Cypress.Commands.add('preencherRegistroInvalido', (usuario) => {
    cy.preencherCampo(firstNameInput, usuario.firstName);
    cy.preencherCampo(lastNameInput, usuario.lastName);
    cy.preencherCampo(addressInput, usuario.address)
    cy.preencherCampo(cityInput, usuario.city)
    cy.preencherCampo(stateInput, usuario.state)
    cy.preencherCampo(zipCodeInput, usuario.zipCode)
    cy.preencherCampo(phoneInput, usuario.phone)
    cy.preencherCampo(SSNInput, usuario.ssn)
    cy.preencherCampo(userNameInput, usuario.username)
    cy.preencherCampo(passwordInput, usuario.password)
    cy.preencherCampo(confirmPasswordInput, "teste")
})

Cypress.Commands.add('clicarBotaoRegistro', () => {
    cy.clicar(registerButton)
})

Cypress.Commands.add('visitarPaginaDeRegistro', () => {
    cy.visit('https://parabank.parasoft.com/parabank/about.htm')
    cy.clicar(registerPageButton);
})

Cypress.Commands.add('validarTextoSenhasDiferentes', () => {
    cy.validarTexto(passwordRepeated, 'Passwords did not match.')
})