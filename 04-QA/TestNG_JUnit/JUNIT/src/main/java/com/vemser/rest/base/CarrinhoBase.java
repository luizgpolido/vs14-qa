package com.vemser.rest.base;

import com.vemser.rest.client.CarrinhoClient;

public class CarrinhoBase {

    public static CarrinhoClient carrinhoClient = new CarrinhoClient();
    public static final String CADASTRO_SUCESSO = "Cadastro realizado com sucesso";
    public static final String TOKEN_INVALIDO = "Token de acesso ausente, inválido, expirado ou usuário do token não existe mais";
    public static final String PRODUTO_DUPLICADO = "Não é permitido possuir produto duplicado";
    public static final String REGISTRO_EXCLUIDO = "Registro excluído com sucesso";
    public static final String CARRINHO_INEXISTENTE = "Não foi encontrado carrinho para esse usuário";

}
