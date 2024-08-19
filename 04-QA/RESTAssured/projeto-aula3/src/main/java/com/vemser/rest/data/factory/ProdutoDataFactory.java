package com.vemser.rest.data.factory;

import com.vemser.rest.client.ProdutoClient;
import com.vemser.rest.model.ProdutoResponse;
import com.vemser.rest.model.ProdutosModel;
import lombok.Data;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

@Data
public class ProdutoDataFactory {

    private static Faker faker = new Faker(new Locale("pt", "BR"));
    private static Random rand = new Random();


    private static ProdutosModel novoProduto(){
        ProdutosModel produto = new ProdutosModel();
        produto.setNome(faker.food().fruit() + " " + faker.food().fruit() + " " + faker.food().fruit());
        produto.setPreco(rand.nextInt(100));
        produto.setDescricao(faker.text().text());
        produto.setQuantidade(rand.nextInt(100));

        return produto;
    }

    public static ProdutosModel produtoValido(){
        return novoProduto();
    }

    public static ProdutoResponse getPrimeiroProduto(){
        ProdutoClient produtoClient = new ProdutoClient();


        return
                produtoClient.listarProdutos()
                        .then()
                        .extract()
                        .jsonPath()
                        .getObject("produtos[0]", ProdutoResponse.class);
    }

    public static ProdutoResponse getProdutoValido(){
        ProdutoClient produtoClient = new ProdutoClient();


            String id =
                    produtoClient.cadastrarProduto(produtoValido())
                            .then()
                            .extract()
                            .path("_id")
                    ;

            ProdutoResponse response =
                    produtoClient.listarProdutosPorId(id)
                            .then()
                            .extract()
                            .as(ProdutoResponse.class)
                    ;

            response.set_id(id);
            return response;
    }

    public static ProdutosModel produtoComNomeJaExistente(){
        ProdutosModel produtosModel = produtoValido();
        produtosModel.setNome(getPrimeiroProduto().getNome());
        return produtosModel;
    }

    public static ProdutosModel produtoComPrecoNegativo(){
        ProdutosModel produtosModel = produtoValido();
        produtosModel.setPreco(-1);
        return produtosModel;
    }

    public static ProdutosModel produtoComDescricaoNula(){
        ProdutosModel produtosModel = produtoValido();
        produtosModel.setDescricao("");
        return produtosModel;
    }


    public static ProdutosModel produtoComQuantidadeNegativa() {
        ProdutosModel produtosModel = produtoValido();
        produtosModel.setQuantidade(-1);
        return produtosModel;
    }

    public static ProdutosModel produtoComNomeEmBranco() {
        ProdutosModel produtosModel = produtoValido();
        produtosModel.setNome("");
        return produtosModel;
    }

    public static ProdutosModel produtoWireMockValido(){
        ProdutosModel produtosMode = new ProdutosModel();
        produtosMode.setNome("Mouse Legal");
        produtosMode.setPreco(100);
        produtosMode.setDescricao("Gamer");
        produtosMode.setQuantidade(5);
        return produtosMode;
    }
}
