import {UserDataFactory} from '../support/data/UserDataFactory';

const userDataFactory = new UserDataFactory();
const usuarioValido = userDataFactory.criarRegistroValido();
const usuarioComEmailInvalido = userDataFactory.criarRegistroComEmailInvalido();
const usuarioComNomeVazio = userDataFactory.criarRegistroComNomeVazio()

describe('Registro', () => {

    beforeEach(() => {
        cy.visit("/")
    })

    it('CT 001 - Validar registro com dados válidos', () => {
        //Tentei passar um objeto mas retornou undefined
        cy.registroValido(usuarioValido.email, usuarioValido.name, usuarioValido.password)
    })

    it('CT 002 - Tentar registar com email inválido ', () => {
        cy.registroComEmailInvalido(usuarioComEmailInvalido)
    });

    //Bug Encontrado!!
    it('CT 003 - Tentar registar com nome vazio ', () => {
        cy.registroComNomeVazio(usuarioComNomeVazio)
    });
})