import {fa, faker} from '@faker-js/faker';


export default class UserDataFactory {
    usuario;

    gerarUsuarioValido(){
        return this.usuario = {
            firstName: faker.person.firstName(),
            lastName: faker.person.lastName(),
            address: faker.location.streetAddress(),
            city: faker.location.city(),
            state: faker.location.state(),
            zipCode: faker.location.zipCode(),
            phone: faker.phone.number(),
            ssn: faker.helpers.replaceSymbols('###-##-####'),
            username: faker.internet.userName(),
            password: faker.internet.password()
        }
    }




}