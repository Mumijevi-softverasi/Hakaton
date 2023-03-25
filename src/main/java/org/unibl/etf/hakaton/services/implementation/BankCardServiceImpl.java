package org.unibl.etf.hakaton.services.implementation;

import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.exceptions.EncryptionException;
import org.unibl.etf.hakaton.models.dto.BankCardName;
import org.unibl.etf.hakaton.models.dto.NewBankCard;
import org.unibl.etf.hakaton.models.entities.BankCardEntity;
import org.unibl.etf.hakaton.repositories.BankCardEntityRepository;
import org.unibl.etf.hakaton.services.BankCardService;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankCardServiceImpl implements BankCardService
{
    @Value("${aes.key}")
    private String aesKey;
    @Value("${aes.salt}")
    private String salt;
    private final String CONST_STR="Kartica koja zavrsava na ";

    private static final String ALGORITHM = "AES";

    private BankCardEntityRepository repository;
    private ModelMapper mapper;

    public BankCardServiceImpl(BankCardEntityRepository repository,ModelMapper mapper)
    {
        this.repository=repository;
        this.mapper=mapper;
    }

    @Override
    public List<BankCardName> getAllBankCardName(Long id) throws EncryptionException
    {
        var list=this.repository.findAllBankCardNames(id);
        var list2=new ArrayList<BankCardName>();
        for(var card:list)
        {
            var openText = decryptData(card.getLastFourDigit());
            list2.add(new BankCardName(card.getId(), CONST_STR + openText.substring(openText.length() - 4, openText.length())));
        }
        return list2;
    }

    @Override
    public Long insert(NewBankCard newBankCard) throws EncryptionException{

        var bankC=mapper.map(newBankCard, BankCardEntity.class);
        bankC.setId(null);

        bankC.setCreditCardName(encryptData(bankC.getCreditCardName()));
        bankC.setExpireDate(encryptData(bankC.getExpireDate()));
        bankC.setCardNumber(encryptData(bankC.getCardNumber()));
        bankC.setCvcVcc(encryptData(bankC.getCvcVcc()));

        bankC=this.repository.saveAndFlush(bankC);
        return bankC.getId();
    }

    private String encryptData(String plainText) {
        TextEncryptor encryptor = Encryptors.text(aesKey, salt);
        return encryptor.encrypt(plainText);
    }

    private String decryptData(String encryptedText) {
        TextEncryptor encryptor = Encryptors.text(aesKey, salt);
        return encryptor.decrypt(encryptedText);
    }

}
