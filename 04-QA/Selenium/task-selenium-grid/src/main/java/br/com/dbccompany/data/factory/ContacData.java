package br.com.dbccompany.data.factory;

import br.com.dbccompany.dto.ContactDto;
import br.com.dbccompany.util.DataFakerGenerator;

public class ContacData {

    static DataFakerGenerator dataFakerGenerator  = new DataFakerGenerator();

    public static ContactDto contatoDadosValidos(){
        ContactDto contactDto = new ContactDto();
        contactDto.setEmail(dataFakerGenerator.emailFaker());
        contactDto.setMessage(dataFakerGenerator.mensagemFaker());
        contactDto.setOrderReference(dataFakerGenerator.orderFaker());
        return contactDto;

    }

}
