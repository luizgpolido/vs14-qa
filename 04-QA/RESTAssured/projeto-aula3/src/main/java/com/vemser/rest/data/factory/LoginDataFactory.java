package com.vemser.rest.data.factory;

import com.vemser.rest.model.LoginModel;
import com.vemser.rest.model.UsuarioModel;
import com.vemser.rest.model.UsuarioResponse;

public class LoginDataFactory {



    private static LoginModel loginUsuario(){
        UsuarioResponse userResponse = UsuariosDataFactory.getUsuarioComum();
        return new LoginModel(userResponse.getEmail(), userResponse.getPassword());
    }

    private static LoginModel loginAdminstrador(){
        UsuarioResponse userResponse = UsuariosDataFactory.getUsuarioAdmin();
        return new LoginModel(userResponse.getEmail(), userResponse.getPassword());
    }

    public static LoginModel loginUsuarioValido(){
        return loginUsuario();
    }

    public static LoginModel loginAdminValido(){
        return loginAdminstrador();
    }

    public static LoginModel loginUsuarioComSenhaInvalida(){
        LoginModel loginModel = loginUsuario();
        loginModel.setPassword("teste123");
        return loginModel;
    }

    public static LoginModel loginUsuarioComEmailInvalido(){
        LoginModel loginModel = loginUsuario();
        loginModel.setEmail("luiz@teste.com");
        return loginModel;
    }

    public static LoginModel loginUsuarioComDadosNulos(){
        LoginModel loginModel = loginUsuario();
        loginModel.setEmail("");
        loginModel.setPassword("");
        return loginModel;
    }

    public static LoginModel loginUsuarioComSenhaNula(){
        LoginModel loginModel = loginUsuario();
        loginModel.setPassword("");
        return loginModel;
    }

    public static LoginModel loginUsuarioComEmailNulo(){
        LoginModel loginModel = loginUsuario();
        loginModel.setEmail("");
        return loginModel;
    }

    public static LoginModel loginAdminComDadosNulos(){
        LoginModel loginModel = loginAdminstrador();
        loginModel.setEmail("");
        loginModel.setPassword("");
        return loginModel;
    }

}
