package com.vemser.rest.base;

import com.vemser.rest.client.UsuarioClient;

public class UsuarioBase {

    public static UsuarioClient usuarioClient = new UsuarioClient();
    public static final String REGISTRO_ALTERADO_SUCESSO = "Registro alterado com sucesso";
    public static final String REGISTRO_DELETADO_SUCESSO = "Registro excluído com sucesso";
    public static final String ERRO_EXCLUIR_USUARIO_COM_CARRINHO = "Não é permitido excluir usuário com carrinho cadastrado";
    public static final String EMAIL_JA_USADO = "Este email já está sendo usado";
    public static final String NOME_EM_BRANCO = "nome não pode ficar em branco";
    public static final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado";

}
