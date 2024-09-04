import LoginPage from "../pages/loginPage"
import RegisterPage from "../pages/registerPage"
import TransferenciaPage from "../pages/transferenciaPage";
import HomePage from "../pages/homePage";
import ExtratoPage from "../pages/extratoPage";
import {RegisterDataFactory} from "../data/RegisterDataFactory";
import {faker} from "@faker-js/faker";


const loginPage = new LoginPage
const registerPage = new RegisterPage()
const transferenciaPage = new TransferenciaPage()
const homePage = new HomePage()
const extratoPage = new ExtratoPage()

const registerDataFactory = new RegisterDataFactory();
const registroValidoContaUm = registerDataFactory.criarRegistroValido();
const registroValidoContaDois = registerDataFactory.criarRegistroValido();

describe('Transferencia', () => {

    it('CT 001 - Transferência com sucesso', () => {
        loginPage.navegar();
        registerPage.criarUsuario(registroValidoContaUm.email, registroValidoContaUm.name, registroValidoContaUm.password)
        loginPage.logarUsuarioValido(registroValidoContaUm.email, registroValidoContaUm.password)
        const idContaUm = homePage.pegarNumeroConta();
        homePage.clicarBtnExit()

        registerPage.criarUsuario(registroValidoContaDois.email, registroValidoContaDois.name, registroValidoContaDois.password)
        loginPage.logarUsuarioValido(registroValidoContaDois.email, registroValidoContaDois.password)
        homePage.clicarTransferencia()

        idContaUm.then((id) => {
            const accountNumber = id.split('-')
            transferenciaPage.preencherNumeroConta(accountNumber[0])
            transferenciaPage.preencherDigitoConta(accountNumber[1])
        })

        transferenciaPage.preencherValorTransferencia(400)
        transferenciaPage.preencherDescricao(faker.lorem.text())
        transferenciaPage.clicarBtnTransferir()
        transferenciaPage.verificarTextoModalSucesso()
        transferenciaPage.clicarFecharModal()
        transferenciaPage.clicarBtnSair()
        loginPage.logarUsuarioValido(registroValidoContaUm.email, registroValidoContaUm.password)
        homePage.verificarSaldo()
        homePage.clicarExtratos()
        extratoPage.verficiarValorRecebido()
    })

    it.only('CT 002 - Trasferência com valor acima do saldo ', () => {
        loginPage.navegar();
        registerPage.criarUsuario(registroValidoContaUm.email, registroValidoContaUm.name, registroValidoContaUm.password)
        loginPage.logarUsuarioValido(registroValidoContaUm.email, registroValidoContaUm.password)
        const idContaUm = homePage.pegarNumeroConta();
        homePage.clicarBtnExit()

        registerPage.criarUsuario(registroValidoContaDois.email, registroValidoContaDois.name, registroValidoContaDois.password)
        loginPage.logarUsuarioValido(registroValidoContaDois.email, registroValidoContaDois.password)
        homePage.clicarTransferencia()

        idContaUm.then((id) => {
            const accountNumber = id.split('-')
            transferenciaPage.preencherNumeroConta(accountNumber[0])
            transferenciaPage.preencherDigitoConta(accountNumber[1])
        })

        transferenciaPage.preencherValorTransferencia(2000)
        transferenciaPage.preencherDescricao(faker.lorem.text())
        transferenciaPage.clicarBtnTransferir()
        transferenciaPage.verificarTextoSaldoInsuficiente()
        transferenciaPage.clicarFecharModal()
    });
})