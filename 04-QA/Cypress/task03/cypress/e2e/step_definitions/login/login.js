import { Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";

import UserDataFactory from "../../../support/data/UserDataFactory";

const usuarioDataFactory = new UserDataFactory()
let usuario = usuarioDataFactory.gerarUsuarioValido()

Given('Estou na pagina de login', () => {
    cy.visit('https://parabank.parasoft.com/parabank/about.htm')
});

When('Eu digitar um login e senha válidos', () => {
    cy.registroValido(usuario)
});

And('Clico no botão de login', () => {
});

Then('Devo ser logado com sucesso', () => {
});

