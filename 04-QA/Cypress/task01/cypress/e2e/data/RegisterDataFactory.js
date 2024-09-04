import {faker} from "@faker-js/faker";

export class RegisterDataFactory {

    constructor(email, name, password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    criarRegistroValido(){
        return new RegisterDataFactory(faker.internet.email(), faker.person.fullName(), faker.internet.password());
    }

    criarRegistroComEmailInvalido(){
        return new RegisterDataFactory("a.com", faker.person.fullName(), faker.internet.password());
    }


}