package br.com.dbccompany.util;

import com.github.javafaker.Faker;
import io.qameta.allure.model.StepResult;

public class DataFakerGenerator {

    private static final Faker faker = new Faker();

    public String emailFaker(){
        return faker.internet().emailAddress();
    }

    public String senhaFaker(){
        return faker.internet().password();
    }

    public String mensagemFaker(){ return  faker.lorem().sentence();}

    public String orderFaker(){
        String letras = faker.letterify("???").toUpperCase();
        String numeros = faker.numerify("###");

        return letras + numeros;
    }




}
