package com.vemser.rest.data.provider;

import com.vemser.rest.data.factory.ProdutoDataFactory;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ProdutosDataProvider {

    private static final String KEY_NOME = "nome";
    private static final String VALUE_NOME_EM_BRANCO = "nome não pode ficar em branco";
    private static final String KEY_MESSAGE = "message";
    private static final String VALUE_NOME_JA_EXISTE = "Já existe produto com esse nome";
    private static final String KEY_PRECO = "preco";
    private static final String KEY_QUANTIDADE = "quantidade";
    private static final String VALUE_QUANTIDADE_NEGATIVA = "quantidade deve ser maior ou igual a 0";
    private static final String KEY_DESCRICAO = "descricao";
    private static final String VALUE_DESCRICAO_EM_BRANCO = "descricao não pode ficar em branco";
    private static final String VALUE_PRECO_NEGATIVO = "preco deve ser um número positivo";

    public static Stream<Arguments> produtoDataProvider() {
        return Stream.of(
                Arguments.of(ProdutoDataFactory.produtoComNomeJaExistente(), KEY_MESSAGE, VALUE_NOME_JA_EXISTE),
                Arguments.of(ProdutoDataFactory.produtoComPrecoNegativo(), KEY_PRECO, VALUE_PRECO_NEGATIVO),
                Arguments.of(ProdutoDataFactory.produtoComDescricaoNula(), KEY_DESCRICAO, VALUE_DESCRICAO_EM_BRANCO),
                Arguments.of(ProdutoDataFactory.produtoComQuantidadeNegativa(), KEY_QUANTIDADE, VALUE_QUANTIDADE_NEGATIVA),
                Arguments.of(ProdutoDataFactory.produtoComNomeEmBranco(), KEY_NOME, VALUE_NOME_EM_BRANCO)
        );
    }
}