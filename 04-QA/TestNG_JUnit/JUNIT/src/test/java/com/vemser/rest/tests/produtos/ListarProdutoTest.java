package com.vemser.rest.tests.produtos;

import com.vemser.rest.base.ProdutoBase;
import com.vemser.rest.client.LoginClient;

import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.LoginModel;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class ListarProdutoTest extends ProdutoBase {

    private static final LoginClient loginClient = new LoginClient();

    @BeforeAll
    public static void login(){
        LoginModel loginModel = LoginDataFactory.loginAdminValido();

        String bearerToken =
                loginClient.realizarLogin(loginModel)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .path("authorization")
                ;

        produtoClient.setBearerToken(bearerToken);
    }

    @Test
    @DisplayName("[Positivo] - Listar todos os produtos com validação de contrato")
    public void testListarTodosProdutoValido(){


        produtoClient.listarProdutos()
        .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/todos_os_produtos.json"))
        ;
    }

    @Test
    @DisplayName("[Positivo] - Listar produto por ID com validação de contrato")
    public void testListarProdutoPorID(){

        String id = ProdutoDataFactory.getPrimeiroProduto().get_id();

        produtoClient.listarProdutosPorId(id)
        .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("quantidade", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/produto_por_id.json"))
        ;
    }

    //Testes Negativos

    @Test
    @DisplayName("[Negativo] - Listar produto por ID inválido")
    public void testListarProdutoPorIDInvalido(){


        produtoClient.listarProdutosPorId("1234")
        .then()
                .statusCode(400)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("message", equalTo(ERRO_PRODUTO_NAO_ENCONTRADO))
        ;

    }

    @Test
    @DisplayName("[Negativo] - Listar produto por ID nulo")
    public void testListarProdutoPorIDNulo(){

        produtoClient.listarProdutosPorId("")
                .then()
                .statusCode(200)
                .header("Content-Type" , "application/json; charset=utf-8")
                .body("produtos", notNullValue())
        ;

    }
}
