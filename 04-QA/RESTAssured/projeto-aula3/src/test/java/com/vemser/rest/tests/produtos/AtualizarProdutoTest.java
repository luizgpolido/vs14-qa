package com.vemser.rest.tests.produtos;

import com.vemser.rest.client.ProdutoClient;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.ProdutosModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class AtualizarProdutoTest {

    ProdutoClient produtoClient = new ProdutoClient();

    @Test
    @DisplayName("[Positivo] - Editar produto com id existente e informações válidas")
    public void testEditarProdutoValido() {

        ProdutosModel produto = ProdutoDataFactory.produtoValido();

        String id = ProdutoDataFactory.getProdutoValido().get_id();

        produtoClient.atualizarProduto(produto, id)
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @DisplayName("[Negativo] - Editar produto com nome existente")
    public void testEditarProdutoComNomeJaExistente() {

        ProdutosModel produto = ProdutoDataFactory.produtoComNomeJaExistente();

        String id = ProdutoDataFactory.getProdutoValido().get_id();

        produtoClient.atualizarProduto(produto, id)
                .then()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("Já existe produto com esse nome"));
    }
}
