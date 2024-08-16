package com.vemser.rest.data.factory;

import com.vemser.rest.model.ProdutosModel;
import lombok.Data;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

@Data
public class ProdutoDataFactory {

    private  static Faker faker = new Faker(new Locale("pt", "BR"));
    private  static Random rand = new Random();


    private static ProdutosModel novoProduto(){
        ProdutosModel produto = new ProdutosModel();
        produto.setNome(faker.food().fruit() + " " + faker.food().fruit() + " " + faker.food().fruit());
        produto.setPreco(rand.nextInt(100));
        produto.setDescricao(faker.text().text());
        produto.setQuantidade(rand.nextInt(100));

        return produto;
    }

    public static ProdutosModel usuarioValido(){
        return novoProduto();
    }


}
