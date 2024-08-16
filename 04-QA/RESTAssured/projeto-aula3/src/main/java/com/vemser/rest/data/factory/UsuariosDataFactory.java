package com.vemser.rest.data.factory;

import com.vemser.rest.client.UsuarioClient;
import com.vemser.rest.model.UsuarioModel;
import com.vemser.rest.model.UsuarioResponse;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class UsuariosDataFactory {

    private  static  Faker faker = new Faker(new Locale("pt", "BR"));
    private  static  Random rand = new Random();
    private static UsuarioClient usuarioClient = new UsuarioClient();


    private static UsuarioModel novoUsuario(){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(faker.name().fullName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(rand.nextBoolean()));

        return usuario;
    }

    public static UsuarioModel usuarioComEmailEmBranco() {
        UsuarioModel usuario = novoUsuario();
        usuario.setEmail("");
        return usuario;
    }

    public static UsuarioModel usuarioValido(){
        return novoUsuario();
    }


    public static UsuarioModel usuarioComNomeEmBranco(){
        UsuarioModel usuario = novoUsuario();
        usuario.setNome("");
        return usuario;
    }


    public static UsuarioModel usuarioComPasswordEmBranco() {
        UsuarioModel usuario = novoUsuario();
        usuario.setPassword("");
        return usuario;
    }

    public static UsuarioModel usuarioComIsAdminEmBranco() {
        UsuarioModel usuario = novoUsuario();
        usuario.setAdministrador("");
        return usuario;
    }

    public static UsuarioModel usuarioComEmailCadastrado(){
        UsuarioModel usuario = novoUsuario();
        usuario.setEmail(getUsuarioExistente().getEmail());
        return usuario;
    }

    private static UsuarioModel getUsuarioExistente(){

        UsuarioResponse usuarioResponse =
        usuarioClient.buscarUsuarios()
                .then()
                .extract()
                .jsonPath()
                .getObject("usuarios[0]", UsuarioResponse.class);

        return converterResponseParaModel(usuarioResponse);
    }

    private static UsuarioModel converterResponseParaModel(UsuarioResponse usuarioResponse){
        UsuarioModel usuario = new UsuarioModel();

        usuario.setNome(usuarioResponse.getNome());
        usuario.setEmail(usuarioResponse.getEmail());
        usuario.setPassword(usuarioResponse.getPassword());
        usuario.setAdministrador(usuarioResponse.getAdministrador());
        return usuario;
    }
}
