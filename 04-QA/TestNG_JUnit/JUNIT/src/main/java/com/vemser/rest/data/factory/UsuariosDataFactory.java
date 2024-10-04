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

    private static UsuarioModel novoUsuarioAdm(){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(faker.name().fullName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador("true");

        return usuario;
    }

    private static UsuarioModel novoUsuarioComum(){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(faker.name().fullName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador("false");

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

    public static UsuarioModel usuarioValidoAdm(){
        return novoUsuarioAdm();
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
        usuario.setEmail(getUsuarioResponseToRequest().getEmail());
        return usuario;
    }

    public static UsuarioResponse getPrimeiroUsuarioReponse(){

        return
        usuarioClient.buscarUsuarios()
                .then()
                .extract()
                .jsonPath()
                .getObject("usuarios[0]", UsuarioResponse.class);

    }

    public static UsuarioResponse getUsuarioAdmin(){

        String id =
                usuarioClient.cadastrarUsuario(usuarioValidoAdm())
                        .then()
                        .extract()
                        .path("_id")
                        ;

        UsuarioResponse response =
                usuarioClient.buscarUsuarioPorId(id)
                        .then()
                        .extract()
                        .as(UsuarioResponse.class)
                        ;

        response.set_id(id);
        return response;
    }

    public static UsuarioResponse getUsuarioComum(){

        String id =
                usuarioClient.cadastrarUsuario(novoUsuarioComum())
                        .then()
                        .extract()
                        .path("_id")
                ;

        UsuarioResponse response =
                usuarioClient.buscarUsuarioPorId(id)
                        .then()
                        .extract()
                        .as(UsuarioResponse.class)
                ;

        response.set_id(id);
        return response;
    }


    private static UsuarioModel getUsuarioResponseToRequest(){
        UsuarioResponse usuarioResponse = getPrimeiroUsuarioReponse();
        UsuarioModel usuario = new UsuarioModel();

        usuario.setNome(usuarioResponse.getNome());
        usuario.setEmail(usuarioResponse.getEmail());
        usuario.setPassword(usuarioResponse.getPassword());
        usuario.setAdministrador(usuarioResponse.getAdministrador());
        return usuario;
    }
}
