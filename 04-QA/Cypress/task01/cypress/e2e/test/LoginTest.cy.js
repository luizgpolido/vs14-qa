
import LoginPage from "../pages/loginPage"
import RegisterPage from "../pages/registerPage"
import {RegisterDataFactory} from "../data/RegisterDataFactory";
const loginPage = new LoginPage
const registerPage = new RegisterPage()

const registerDataFactory = new RegisterDataFactory();
const registroValido = registerDataFactory.criarRegistroValido();

describe('Login', () => {
  it('CT 001 - Validar login com dados válidos', () => {
    loginPage.navegar()
    registerPage.criarUsuario(registroValido.email, registroValido.name, registroValido.password)
    loginPage.preencherEmail(registroValido.email)
    loginPage.preencherPassword(registroValido.password)
    loginPage.clicarBtnLogin()
  })

  it('CT 002 - Validar login com dados inválidos', () => {
    loginPage.navegar()
    loginPage.preencherEmail("teste@teste.com")
    loginPage.preencherPassword("teste")
    loginPage.clicarBtnLogin()
    loginPage.validarTextoLoginInvalido()
    loginPage.clicarBtnFecharModal()
  })
})