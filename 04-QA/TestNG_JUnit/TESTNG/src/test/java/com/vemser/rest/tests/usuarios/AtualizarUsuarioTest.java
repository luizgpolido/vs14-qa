package com.vemser.rest.tests.usuarios;

import com.vemser.rest.base.UsuarioBase;
import com.vemser.rest.data.factory.UsuariosDataFactory;
import com.vemser.rest.model.UsuarioModel;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.equalTo;

public class AtualizarUsuarioTest extends UsuarioBase {

    @Test
    public void testAtualizarUsuarioComSucesso() {

        UsuarioModel usuario = UsuariosDataFactory.usuarioValidoAdm();
        String id = UsuariosDataFactory.getPrimeiroUsuarioReponse().get_id();

        usuarioClient.atualizarUsuario(usuario, id)
        .then()
                .statusCode(200)
                .body("message", equalTo(REGISTRO_ALTERADO_SUCESSO))
        ;
    }

    @Test
    public void testAtualizarUsuarioComFracasso() {

        UsuarioModel novoUsuario = UsuariosDataFactory.usuarioValido();
        UsuarioModel usuario = UsuariosDataFactory.usuarioComEmailCadastrado();

        String id =
        usuarioClient.cadastrarUsuario(novoUsuario)
                    .then()
                        .extract()
                        .path("_id")
                    ;


        usuarioClient.atualizarUsuario(usuario, id)
            .then()
                .statusCode(400)
                .body("message", equalTo(EMAIL_JA_USADO))
        ;
    }
}
