
import RegisterPage from "../pages/registerPage"
import {RegisterDataFactory} from "../data/RegisterDataFactory";
const registerPage = new RegisterPage

const registerDataFactory = new RegisterDataFactory();
const registroValido = registerDataFactory.criarRegistroValido();
const registroComEmailIValido = registerDataFactory.criarRegistroComEmailInvalido();

describe('Registro', () => {
  it('CT 001 - Validar registro com dados válidos', () => {
    registerPage.navegar();
    registerPage.clicarEmRegistrar();
    registerPage.preencherEmail(registroValido.email);
    registerPage.preencherName(registroValido.name);
    registerPage.preencherPassword(registroValido.password);
    registerPage.preencherConfirmarPassword(registroValido.password);
    registerPage.clicarCriarContaComSaldo();
    registerPage.clicarCadastrar();
    registerPage.verificarTextoContaCriadaComSucesso();
    registerPage.clicarCloseModal();
  })

  it('CT 002 - Tentar registar com email inválido ', () => {
    registerPage.navegar();
    registerPage.clicarEmRegistrar();
    registerPage.preencherEmail(registroComEmailIValido.email);
    registerPage.preencherName(registroComEmailIValido.name);
    registerPage.preencherPassword(registroComEmailIValido.password);
    registerPage.preencherConfirmarPassword(registroComEmailIValido.password);
    registerPage.clicarCriarContaComSaldo();
    registerPage.clicarCadastrar();
    registerPage.validarTextoFormatoInvalidoEmail()
  });
})