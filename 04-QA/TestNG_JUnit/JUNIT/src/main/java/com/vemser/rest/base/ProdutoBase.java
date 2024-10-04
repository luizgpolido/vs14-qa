package com.vemser.rest.base;

import com.vemser.rest.client.ProdutoClient;

public class ProdutoBase{

    public static ProdutoClient produtoClient = new ProdutoClient();
    public static final String PUT_MENSAGEM_SUCESSO = "Registro alterado com sucesso";
    public static final String DELETE_MENSAGEM_SUCESSO = "Registro excluído com sucesso";
    public static final String ERRO_PRODUTO_NAO_ENCONTRADO = "Produto não encontrado";
    public static final String ERRO_TOKEN_INVALIDO = "Token de acesso ausente, inválido, expirado ou usuário do token não existe mais";
    public static final String ERRO_PRODUTO_JA_EXISTE = "Já existe produto com esse nome";
    public static final String ERRO_PRECO_DEVE_SER_POSITIVO = "preco deve ser um número positivo";
}

