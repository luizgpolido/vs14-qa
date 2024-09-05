import './base'

let btnRegister = '.ihdmxA'
let campoEmail = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(2) > input'
let campoNome = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(3) > input'
let campoSenha = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(4) > div > input'
let confirmacaoSenha = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(5) > div > input'
let comSaldoBtn = '#toggleAddBalance'
let cadastrarBtn = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > button'
let modalText = '#modalText'
let btnCloseCriadoComSucesso = '#btnCloseModal'
let formatoInvalidoEmail = '#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div.style__ContainerFieldInput-sc-s3e9ea-0.kOeYBn.input__child > p'


Cypress.Commands.add('registroValido', (email, nome, senha) => {
    cy.clicar(btnRegister)
    cy.preencherCampo(campoEmail, email)
    cy.preencherCampo(campoNome, nome)
    cy.preencherCampo(campoSenha, senha)
    cy.preencherCampo(confirmacaoSenha, senha)
    cy.clicar(comSaldoBtn)
    cy.clicar(cadastrarBtn)
    cy.validarTexto(modalText, "sucesso")
    cy.clicar(btnCloseCriadoComSucesso)
});

Cypress.Commands.add('registroComEmailInvalido', (usuario) => {
    cy.gerarUsuario(usuario)
    cy.fixture('/loginData').then((usuario) => {
        cy.clicar(btnRegister)
        cy.preencherCampo(campoEmail, usuario.email)
        cy.preencherCampo(campoNome, usuario.nome)
        cy.preencherCampo(campoSenha, usuario.senha)
        cy.preencherCampo(confirmacaoSenha, usuario.senha)
        cy.clicar(comSaldoBtn)
        cy.clicar(cadastrarBtn)
        cy.validarTexto(formatoInvalidoEmail, "Formato inválido")
    })
})

Cypress.Commands.add('registroComNomeVazio', (usuario) => {
    cy.gerarUsuario(usuario)
    cy.fixture('/loginData').then((usuario) => {
        cy.clicar(btnRegister)
        cy.preencherCampo(campoEmail, usuario.email)
        cy.preencherCampo(campoNome, usuario.nome)
        cy.preencherCampo(campoSenha, usuario.senha)
        cy.preencherCampo(confirmacaoSenha, usuario.senha)
        cy.clicar(comSaldoBtn)
        cy.clicar(cadastrarBtn)
        cy.validarTexto(modalText, "Nome")
    })
})

