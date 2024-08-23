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
        return faker.address().zipCode();
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

}