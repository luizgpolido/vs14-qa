package br.com.dbccompany.factory.data;


import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.util.DataFakerGenerator;

public class LoginData {


    DataFakerGenerator dataFakerGeneretor = new DataFakerGenerator();


    public LoginDto loginDadosValidos() {

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("vs@gmail.com");
        loginDto.setSenha("123456");

        return loginDto;
    }


    public LoginDto LoginDadoDinamicos() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(dataFakerGeneretor.emailFaker());
        loginDto.setSenha(dataFakerGeneretor.senhaFaker());

        return loginDto;
    }
}

