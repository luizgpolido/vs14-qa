package br.com.dbccompany.factory.selenium;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Validation {

    public void validateText(String expected, String Actual){
        Assertions.assertEquals(expected,Actual);
    }

    public void validarNaoEstaNulo(String expected){
        Assertions.assertNotNull(expected);
    }

    public void validarElementoEstaVisivel(By element){
        Waits.waitElement(element);
    }

    public void validarCor(String corEsperada, String corRecebida){
        Assertions.assertEquals(corEsperada, corRecebida);
    }

    public void validateURL(String URLEsperada, String URLRecebida){
        Assertions.assertEquals(URLEsperada, URLRecebida);
    }

    public void validarPrecoDoMaisBaratoParaMaisCaro(String maisCaro, String maisBarato){
        Assertions.assertTrue(Integer.parseInt(maisBarato.substring(1)) < Integer.parseInt(maisCaro.substring(1)) );
    }


}