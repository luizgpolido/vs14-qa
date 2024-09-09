import { Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";

import UserDataFactory from "../../../support/data/UserDataFactory";

const usuarioDataFactory = new UserDataFactory()
let usuario;

beforeEach(()=>{
    usuario = usuarioDataFactory.gerarUsuarioValido()
    cy.visitarPaginaDeRegistro()
    cy.registroValido(usuario)
    cy.logout()
})

Given('Estou na pagina de recuperar senha', () => {
    cy.clicarForgotInfo()
});

When('Digitar os dados de uma conta existente', () => {
    cy.preencherForgotLoginValido(usuario)
});

And('Clico no botão de recuperar senha', () => {
    cy.clicarFindMyLogin()
});

Then('Devo receber uma mensagem de conta recuperada', () => {
    cy.validarLoginInfoRecovery()
});

// ------------------------

Given('Estou na pagina de recuperar senha', () => {
    cy.clicarForgotInfo()
});

When('Digitar os dados de uma conta sem o first name', () => {
    cy.preencherForgotLoginComNomeVazio(usuario)
});

And('Clico no botão de recuperar senha', () => {
    cy.clicarFindMyLogin()
});

Then('Devo receber uma mensagem de First Name Required', () => {
    cy.validarFirstNameRequired()
});
