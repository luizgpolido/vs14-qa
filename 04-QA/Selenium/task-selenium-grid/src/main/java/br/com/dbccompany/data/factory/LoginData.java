package br.com.dbccompany.data.factory;


import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.util.DataFakerGenerator;

public class LoginData {


    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();


    public LoginDto loginDadosValidos() {

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("sala9@gmail.com");
        loginDto.setSenha("123456");

        return loginDto;
    }


    public LoginDto LoginDadoDinamicos() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(dataFakerGenerator.emailFaker());
        loginDto.setSenha(dataFakerGenerator.senhaFaker());

        return loginDto;
    }

}

