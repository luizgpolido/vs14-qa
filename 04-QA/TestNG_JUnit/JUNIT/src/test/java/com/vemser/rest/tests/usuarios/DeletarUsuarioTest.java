package com.vemser.rest.tests.usuarios;

import com.vemser.rest.base.UsuarioBase;
import com.vemser.rest.data.factory.UsuariosDataFactory;
import com.vemser.rest.model.UsuarioModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeletarUsuarioTest extends UsuarioBase {

    @Test
    @DisplayName("[Positivo] - Deletar usuário com id válido")
    public void testDeletarUsuarioComSucesso() {

        UsuarioModel usuario = UsuariosDataFactory.usuarioValido();

        String id =
        usuarioClient.cadastrarUsuario(usuario)
                    .then()
                        .extract()
                        .path("_id")
                ;

        usuarioClient.removerUsuario(id)
                .then()
                .statusCode(200)
                .body("message", equalTo(REGISTRO_DELETADO_SUCESSO))
        ;
    }


    @Test
    @DisplayName("[Negativo] - Deletar usuário com id nulo")
    public void testListarUserPorNomeComFracasso() {


        usuarioClient.removerUsuario("")
                .then()
                .statusCode(405)
                .body("message", notNullValue())
        ;
    }

    @Test
    @DisplayName("[Negativo] - Deletar usuário com carrinho cadastrado")
    public void testDeletarUsuarioComFracasso() {


        //Recuperando dados do usuário root (0), pois é o único com carrinho cadastrado
        String id = UsuariosDataFactory.getPrimeiroUsuarioReponse().get_id();

        usuarioClient.removerUsuario(id)
                .then()
                .statusCode(400)
                .body("message", equalTo(ERRO_EXCLUIR_USUARIO_COM_CARRINHO))
                .body("idCarrinho", notNullValue())
        ;
    }
}
