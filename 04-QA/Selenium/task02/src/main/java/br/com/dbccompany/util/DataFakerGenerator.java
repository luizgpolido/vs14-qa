package br.com.dbccompany.util;

import com.github.javafaker.Faker;

public class DataFakerGeneretor {
    
    private static final Faker faker = new Faker();

    public String emailFaker(){
        return faker.internet().emailAddress();
    }

    public String senhaFaker(){
        return faker.internet().password();
    }


}
