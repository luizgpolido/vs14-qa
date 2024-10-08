package com.vemser.rest.data.provider;

import com.vemser.rest.data.factory.ProdutoDataFactory;

import java.util.stream.Stream;

public class ProdutosDataProvider {

    public static final String KEY_NOME = "nome";
    public static final String VALUE_NOME_EM_BRANCO = "nome não pode ficar em branco";
    public static final String KEY_MESSAGE = "message";
    public static final String VALUE_NOME_JA_EXISTE = "Já existe produto com esse nome";
    public static final String KEY_PRECO = "preco";
    public static final String KEY_QUANTIDADE = "quantidade";
    public static final String VALUE_QUANTIDADE_NEGATIVA = "quantidade deve ser maior ou igual a 0";
    public static final String KEY_DESCRICAO = "descricao";
    public static final String VALUE_DESCRICAO_EM_BRANCO = "descricao não pode ficar em branco";
    public static final String VALUE_PRECO_NEGATIVO = "preco deve ser um número positivo";

}