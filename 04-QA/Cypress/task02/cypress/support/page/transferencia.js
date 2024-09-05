import './base'
import './registro'
import './login'
import {UserDataFactory} from "../data/UserDataFactory";
import {faker} from "@faker-js/faker";
import HomePage from "./home";

let numeroConta = ':nth-child(1) > .input__default'
let digitoConta = '.account__data > :nth-child(2) > .input__default'
let valorTransferencia = '.styles__ContainerFormTransfer-sc-1oow0wh-0 > :nth-child(2) > .input__default'
let descricao = ':nth-child(3) > .input__default'
let btnTransferir = '.style__ContainerButton-sc-1wsixal-0'
let modalText = '#modalText'
let btnFecharModel = '#btnCloseModal';
let btnSair = '.transfer__ContainerLink-sc-1yjpf2r-2'
let modalTextSaldoInsuficiente = '#modalText'
let transferenciaBtn = '#btn-TRANSFERÊNCIA'
let btnExit = '#btnExit'
let saldo = '#textBalance > span'
let botaoFecharX = '.styles__ContainerCloseButton-sc-8zteav-2 > a'

const homePage = new HomePage();
const userDataFactory = new UserDataFactory();
const registroValidoContaUm = userDataFactory.criarRegistroValido();
const registroValidoContaDois = userDataFactory.criarRegistroValido();


Cypress.Commands.add('transferenciaValida', () => {
    cy.registroValido(registroValidoContaUm.email, registroValidoContaUm.name, registroValidoContaUm.password)
    cy.loginValido(registroValidoContaUm.email, registroValidoContaUm.password)
    const idContaUm = homePage.pegarNumeroConta();
    cy.clicar(btnExit)

    cy.registroValido(registroValidoContaDois.email, registroValidoContaDois.name, registroValidoContaDois.password)
    cy.loginValido(registroValidoContaDois.email, registroValidoContaDois.password)
    cy.clicar(transferenciaBtn)

    idContaUm.then((id) => {
        const accountNumber = id.split('-')
        cy.preencherCampo(numeroConta , (accountNumber[0]))
        cy.preencherCampo(digitoConta , (accountNumber[1]))
    });

    cy.preencherCampo(valorTransferencia , 400)
    cy.preencherCampo(descricao , faker.lorem.text())
    cy.wait(100)
    cy.clicar(btnTransferir)
    cy.validarTexto(modalText, 'Transferencia realizada com sucesso')
    cy.clicar(botaoFecharX)
    cy.clicar(btnSair)

    cy.loginValido(registroValidoContaUm.email, registroValidoContaUm.password)
    cy.validarTexto(saldo , 'R$ 1.400,00')
});

Cypress.Commands.add('transferenciaComValorAcimaDoSaldo', () => {
    cy.registroValido(registroValidoContaUm.email, registroValidoContaUm.name, registroValidoContaUm.password)
    cy.loginValido(registroValidoContaUm.email, registroValidoContaUm.password)
    homePage.pegarNumeroContaFixture()
    cy.fixture('/dadosTransferencia').then((usuario) => {
        cy.clicar(btnExit)

        cy.registroValido(registroValidoContaDois.email, registroValidoContaDois.name, registroValidoContaDois.password)
        cy.loginValido(registroValidoContaDois.email, registroValidoContaDois.password)
        cy.clicar(transferenciaBtn)

        cy.preencherCampo(numeroConta, usuario.numero)
        cy.preencherCampo(digitoConta, usuario.digito)
        cy.preencherCampo(valorTransferencia , 2000)
        cy.preencherCampo(descricao , faker.lorem.text())
        cy.clicar(btnTransferir)
        cy.validarTexto(modalText, 'Você não tem saldo suficiente para essa transação')
        cy.clicar(btnFecharModel)
    })
});

Cypress.Commands.add('transferenciaSemNumeroDaConta', () => {
    cy.registroValido(registroValidoContaUm.email, registroValidoContaUm.name, registroValidoContaUm.password)
    cy.loginValido(registroValidoContaUm.email, registroValidoContaUm.password)
    homePage.pegarNumeroContaFixture()
    cy.fixture('/dadosTransferencia').then((usuario) => {
        cy.clicar(btnExit)

        cy.registroValido(registroValidoContaDois.email, registroValidoContaDois.name, registroValidoContaDois.password)
        cy.loginValido(registroValidoContaDois.email, registroValidoContaDois.password)
        cy.clicar(transferenciaBtn)

        cy.preencherCampo(numeroConta, 111)
        cy.preencherCampo(digitoConta, usuario.digito)
        cy.preencherCampo(valorTransferencia , 2000)
        cy.preencherCampo(descricao , faker.lorem.text())
        cy.clicar(btnTransferir)
        cy.validarTexto(modalText, 'Conta inválida ou inexistente')
        cy.clicar(btnFecharModel)
    })
});