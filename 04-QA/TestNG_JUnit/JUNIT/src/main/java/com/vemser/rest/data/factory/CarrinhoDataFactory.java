package com.vemser.rest.data.factory;

import com.vemser.rest.model.CarrinhoModel;
import com.vemser.rest.model.ProdutosCarrinhoModel;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDataFactory {

    private static CarrinhoModel produtoValidoCarrinho(){
        String idProduto = ProdutoDataFactory.getPrimeiroProduto().get_id();
        int quantidade = 1;

        return new CarrinhoModel(idProduto, quantidade);
    }

    private static  List<CarrinhoModel> carrinho(){
        List<CarrinhoModel> carrinho = new ArrayList<>();
        carrinho.add(produtoValidoCarrinho());

        return carrinho;
    }

    public static ProdutosCarrinhoModel carrinhoValido(){
        return new ProdutosCarrinhoModel(carrinho());
    }

    public static ProdutosCarrinhoModel carrinhoComProdutoDuplicado(){
        List<CarrinhoModel> carrinho = carrinho();
        carrinho.add(produtoValidoCarrinho());

        return new ProdutosCarrinhoModel(carrinho);
    }
}
