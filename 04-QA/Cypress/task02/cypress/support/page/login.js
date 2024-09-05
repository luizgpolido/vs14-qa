import './base'
import './registro'

let campoEmail = '.style__ContainerFormLogin-sc-1wbjw6k-0 > :nth-child(1) > .input__default'
let campoSenha = '.style__ContainerFormLogin-sc-1wbjw6k-0 > .login__password > .style__ContainerFieldInput-sc-s3e9ea-0 > .input__default'
let btnLogin = '.otUnI'
let modalLoginInvalido = '#modalText'
let btnModalInvalido = '#btnCloseModal'
let textName = '#textName'

Cypress.Commands.add('loginValido', (email, senha) => {
    cy.preencherCampo(campoEmail, email)
    cy.preencherCampo(campoSenha, senha)
    cy.clicar(btnLogin)
    cy.validarVisibilidade(textName)
});

Cypress.Commands.add('loginComDadosInvalidos', (email, senha) => {
    cy.preencherCampo(campoEmail, email)
    cy.preencherCampo(campoSenha, senha)
    cy.clicar(btnLogin)
    cy.validarTexto(modalLoginInvalido, "Usuário ou senha inválido.")
    cy.clicar(btnModalInvalido)
});
