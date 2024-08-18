package com.vemser.rest.tests.produtos;

import com.vemser.rest.client.ProdutoClient;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeletarProdutoTest {

    ProdutoClient produtoClient = new ProdutoClient();


    @Test
    @DisplayName("[Positivo] - Deletar produto com ID válido")
    public void testDeletarProdutoValido(){

        String id = ProdutoDataFactory.getProdutoValido().get_id();

        produtoClient.removerProduto(id)
        .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Registro excluído com sucesso"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Deletar produto com  sem token de autenticação")
    public void testDeletarProdutoSemAutenticacao(){

        String id = ProdutoDataFactory.getPrimeiroProduto().get_id();

        produtoClient.removerProdutoSemToken(id)
        .then()
                .statusCode(401)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
        ;
    }

    @Test
    @DisplayName("[Negativo] - Deletar produto com  ID nulo")
    public void testDeletarProdutoComIDNulo(){

        produtoClient.removerProduto("")
        .then()
                .statusCode(405) // 405 pois tecnicamente ao inserir um ID NULO, seria como se estivessemos dando um delete em /produtos, ou seja, como não existe o método no backend retorna um (405), mas vale o teste
                .body("message", notNullValue())
        ;
    }
}
