import { Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";

import UserDataFactory from "../../../support/data/UserDataFactory";

const usuarioDataFactory = new UserDataFactory()
let usuario;

before(()=>{
    usuario = usuarioDataFactory.gerarUsuarioValido()
})

Given('Estou na pagina de registro', () => {
    cy.visitarPaginaDeRegistro()
});

When('Eu digitar um registro válidos', () => {
    cy.registroValido(usuario)
});

And('Clico no botão de registro', () => {
    cy.clicarBotaoRegistro()
});

Then('Devo ser logado com sucesso', () => {
    cy.validarWelcome(usuario)
});

//----------------------------------------------------------------------

Given('Estou na pagina de registro', () => {
    cy.visitarPaginaDeRegistro()
});

When('Eu digitar um registro com senhas diferentes', () => {
    cy.preencherRegistroInvalido(usuario)
});

And('Clico no botão de registro', () => {
    cy.clicarBotaoRegistro()
});

Then('Devo ser avisado que os campos estão diferentes e impedir o registro', () => {
    cy.validarTextoSenhasDiferentes()
});