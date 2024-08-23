package br.com.dbccompany.factory.data;

import br.com.dbccompany.dto.CartDto;

public class CartData {


    public static CartDto loginValido(){
        CartDto cartDto = new CartDto();
        cartDto.setEmail("celesta1250@uorak.com");
        cartDto.setSenha("123456");
        return cartDto;
    }
}
