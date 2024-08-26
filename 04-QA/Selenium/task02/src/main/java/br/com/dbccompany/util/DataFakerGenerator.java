package br.com.dbccompany.util;

import com.github.javafaker.Faker;

public class DataFakerGenerator {

    private static final Faker faker = new Faker();

    public String emailFaker(){
        return faker.internet().emailAddress();
    }

    public String senhaFaker(){
        return faker.internet().password();
    }
    public String addressFaker() {
        return faker.address().fullAddress();
    }
    public String addressSecondFaker() {
        return faker.address().secondaryAddress();
    }
    public String mobilePhoneFaker() {
        return faker.phoneNumber().cellPhone();
    }
    public String homePhoneFaker() {
        return faker.phoneNumber().cellPhone();
    }
    public String postalCodeFaker() {
        return faker.number().digits(5);
    }
    public String cityFaker() {
        return faker.address().city();
    }
    public String companyFaker() {
        return faker.company().name();
    }
    public String lastnameFaker() {
        return faker.name().lastName();
    }
    public String firstNameFaker() {
        return faker.name().firstName();
    }
    public String textFaker() {
        return faker.lorem().paragraph(1);
    }

    public String mensagemFaker(){ return  faker.lorem().sentence();}

    public String orderFaker(){
        String letras = faker.letterify("???").toUpperCase();
        String numeros = faker.numerify("###");

        return letras + numeros;
    }


    public String titleFaker() {
        return faker.address().streetName();
    }

    public String longTextFaker() {

        return faker.lorem().sentence(200);
    }
}
