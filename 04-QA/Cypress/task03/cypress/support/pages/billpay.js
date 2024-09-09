import './base'

let billPayBtn = '#leftPanel > ul > li:nth-child(4) > a'
let payeeNameInput = 'input[name=\'payee.name\']'
let addressInput = 'input[name=\'payee.address.street\']'
let cityInput = 'input[name=\'payee.address.city\']'
let stateInput = 'input[name=\'payee.address.state\']'
let zipCodeInput = 'input[name=\'payee.address.zipCode\']'
let phoneInput = 'tbody > :nth-child(6) > :nth-child(2) >input'

let accountInput = 'input[name=\'payee.accountNumber\']'
let verifyAccountInput = 'input[name=\'verifyAccount\']'
let amountInput = 'input[name=\'amount\']'
let amountNotEmptyMsg = '#validationModel-amount-empty'

let sendPayment = 'input[class=\'button\']'

let billPaymentCompleteText = '#billpayResult h1'
let accountId = '#fromAccountId'

Cypress.Commands.add('preencherBillPayValido', (usuario) => {
    cy.preencherCampo(payeeNameInput, usuario.payeeName)
    cy.preencherCampo(addressInput, usuario.address)
    cy.preencherCampo(cityInput, usuario.city)
    cy.preencherCampo(stateInput, usuario.state)
    cy.preencherCampo(zipCodeInput, usuario.zipCode)
    cy.preencherCampo(phoneInput, usuario.phone)
    cy.preencherCampo(accountInput, usuario.account)
    cy.preencherCampo(verifyAccountInput, usuario.account)
    cy.preencherCampo(amountInput, usuario.amount)
})

Cypress.Commands.add('preencherBillPayComAmountVazio', (usuario) => {
    cy.preencherCampo(payeeNameInput, usuario.payeeName)
    cy.preencherCampo(addressInput, usuario.address)
    cy.preencherCampo(cityInput, usuario.city)
    cy.preencherCampo(stateInput, usuario.state)
    cy.preencherCampo(zipCodeInput, usuario.zipCode)
    cy.preencherCampo(phoneInput, usuario.phone)
    cy.preencherCampo(accountInput, usuario.account)
    cy.preencherCampo(verifyAccountInput, usuario.account)
})

Cypress.Commands.add('clicarSendPayment' , () => {
    cy.clicar(sendPayment)
} )

Cypress.Commands.add('validarTextoSucessoBillPayment', (usuario) =>{
    cy.validarVisibilidade(accountId)
    cy.validarVisibilidade(billPaymentCompleteText)
})

Cypress.Commands.add('clicarBotaoBillPay', () => {
    cy.clicar(billPayBtn)
})

Cypress.Commands.add('validarTextoAmountEmpty', () => {
    cy.validarTexto(amountNotEmptyMsg, 'The amount cannot be empty.')
})