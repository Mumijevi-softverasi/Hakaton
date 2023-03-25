package org.unibl.etf.hakaton.services;

import org.unibl.etf.hakaton.exceptions.EncryptionException;
import org.unibl.etf.hakaton.models.dto.BankCardName;
import org.unibl.etf.hakaton.models.dto.NewBankCard;

import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.util.List;

public interface BankCardService
{
    List<BankCardName> getAllBankCardName(Long id)throws EncryptionException;
    Long insert(NewBankCard newBankCard) throws EncryptionException;
}
