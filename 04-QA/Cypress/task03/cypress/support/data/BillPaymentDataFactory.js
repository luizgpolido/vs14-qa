import {faker} from '@faker-js/faker';


export default class BillPaymentDataFactory {
    billPay;

    gerarBillPayValido(){
        return this.billPay = {
            payeeName: faker.person.fullName(),
            address: faker.location.streetAddress(),
            city: faker.location.city(),
            state: faker.location.state(),
            zipCode: faker.location.zipCode(),
            phone: faker.phone.number(),
            account: faker.number.int(100),
            amount: faker.number.int(50)
        }
    }




}