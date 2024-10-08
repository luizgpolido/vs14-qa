package com.vemser.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("preco")
    private int preco;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("quantidade")
    private int quantidade;
    @JsonProperty("_id")
    private String _id;
}
