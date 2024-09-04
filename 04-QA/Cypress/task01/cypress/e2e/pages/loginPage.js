export default class LoginPage{

    url = 'https://bugbank.netlify.app/'
    email = '.style__ContainerFormLogin-sc-1wbjw6k-0 > :nth-child(1) > .input__default'
    senha = '.style__ContainerFormLogin-sc-1wbjw6k-0 > .login__password > .style__ContainerFieldInput-sc-s3e9ea-0 > .input__default'
    btnLogin = '.otUnI'
    modalLoginInvalido = '#modalText'
    btnModalInvalido = '#btnCloseModal'

    navegar(){
        cy.visit(this.url)
    }

    preencherEmail(email){
        cy.get(this.email).type(email)
    }

    preencherPassword(password){
        cy.get(this.senha).type(password)
    }

    clicarBtnLogin(){
        cy.get(this.btnLogin).click();
    }

    logarUsuarioValido(email, password){
       this.preencherEmail(email);
       this.preencherPassword(password);
       this.clicarBtnLogin();
    }

    validarTextoLoginInvalido(){
        cy.get(this.modalLoginInvalido).contains("Usuário ou senha inválido");
    }

    clicarBtnFecharModal(){
        cy.get(this.btnModalInvalido).contains("Fechar").click();
    }
}