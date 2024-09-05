import {faker} from "@faker-js/faker";

export class UserDataFactory {

    constructor(email, name, password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    criarRegistroValido(){
        return new UserDataFactory(faker.internet.email(), faker.person.fullName(), faker.internet.password());
    }

    criarRegistroComEmailInvalido(){
        return new UserDataFactory("a.com", faker.person.fullName(), faker.internet.password());
    }

    criarRegistroComNomeVazio(){
        return new UserDataFactory(faker.internet.email(), " ", faker.internet.password());
    }


}