import { Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";

import UserDataFactory from "../../../support/data/UserDataFactory";
import BillPaymentDataFactory from "../../../support/data/BillPaymentDataFactory";

const usuarioDataFactory = new UserDataFactory()
const billPaymentDataFactory = new BillPaymentDataFactory()

let usuario;
let billPayment;

beforeEach(()=>{
    usuario = usuarioDataFactory.gerarUsuarioValido()
    billPayment = billPaymentDataFactory.gerarBillPayValido()
    cy.visitarPaginaDeRegistro()
    cy.registroValido(usuario)
})

Given('Estou na página de services', () => {
});

And('Clico em Bill Pay', () => {
    cy.clicarBotaoBillPay()
});

When('Eu digitar um bill payment service válido', () => {
    cy.preencherBillPayValido(billPayment)
});

And('Clico no botão Send Payment', () => {
    cy.clicarSendPayment()
});

Then('Devo receber uma mensagem de sucesso', () => {
    cy.validarTextoSucessoBillPayment(billPayment)
});

//-------------------------------------------------------------------------

Given('Estou na página de services', () => {
});

And('Clico em Bill Pay', () => {
    cy.clicarBotaoBillPay()
});

When('Eu digitar um bill payment service com o amount vazio', () => {
    cy.preencherBillPayComAmountVazio(billPayment)
});

And('Clico no botão Send Payment', () => {
    cy.clicarSendPayment()
});

Then('Devo receber uma mensagem de amount cannot be empty', () => {
    cy.validarTextoAmountEmpty()
});
