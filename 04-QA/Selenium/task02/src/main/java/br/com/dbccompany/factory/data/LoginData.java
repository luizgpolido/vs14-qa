package br.com.dbccompany.factory.data;


import br.com.dbccompany.dto.LoginDto;
import br.com.dbccompany.util.DataFakerGeneretor;

public class LoginData {


    DataFakerGeneretor dataFakerGeneretor = new DataFakerGeneretor();



    public LoginDto loginDadosValidos(){

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("vs@gmail.com");
        loginDto.setSenha("123456");

        return loginDto;
    }



    public LoginDto LoginDadoDinamicos(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(dataFakerGeneretor.emailFaker());
        loginDto.setSenha(dataFakerGeneretor.senhaFaker());

        return loginDto;
    }

