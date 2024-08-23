package br.com.dbccompany.factory.data;

import br.com.dbccompany.dto.ContactDto;
import br.com.dbccompany.util.DataFakerGenerator;
import org.apache.commons.lang3.StringUtils;

public class ContacData {

    static DataFakerGenerator dataFakerGenerator  = new DataFakerGenerator();

    public static ContactDto contatoDadosValidos(){
        ContactDto contactDto = new ContactDto();
        contactDto.setEmail(dataFakerGenerator.emailFaker());
        contactDto.setMessage(dataFakerGenerator.mensagemFaker());
        contactDto.setOrderReference(dataFakerGenerator.orderFaker());
        return contactDto;

    }

    public static ContactDto contatoComposVazios(){
        ContactDto contactDto = new ContactDto();
        contactDto.setEmail(StringUtils.EMPTY);
        contactDto.setMessage(StringUtils.EMPTY);
        contactDto.setOrderReference(StringUtils.EMPTY);
        return contactDto;
    }

    public static ContactDto contatoEmailInvalido(){
        ContactDto contactDto = new ContactDto();
        contactDto.setEmail(dataFakerGenerator.mensagemFaker());
        contactDto.setMessage(dataFakerGenerator.mensagemFaker());
        contactDto.setOrderReference(dataFakerGenerator.orderFaker());
        return contactDto;
    }

    public static ContactDto contatoDadosCampoMensagemVazio(){
        ContactDto contactDto = new ContactDto();
        contactDto.setEmail(dataFakerGenerator.emailFaker());
        contactDto.setMessage(StringUtils.EMPTY);
        contactDto.setOrderReference(dataFakerGenerator.orderFaker());
        return contactDto;
    }

}
