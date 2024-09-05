import {UserDataFactory} from '../support/data/UserDataFactory';

const userDataFactory = new UserDataFactory();
const usuarioValido = userDataFactory.criarRegistroValido();

describe('Login', () => {

    beforeEach(() => {
        cy.visit("/")
    })

    it('CT 001 - Validar login com dados válidos', () => {
        cy.registroValido(usuarioValido.email, usuarioValido.name, usuarioValido.password)
        cy.loginValido(usuarioValido.email, usuarioValido.password)
    })

    it('CT 002 - Validar login com dados inválidos', () => {
        cy.loginComDadosInvalidos("teste@teste.com", usuarioValido.password)
    })
})