package impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import dto.AccountTypeDTO;
import persistence.AccountType;
import persistence.AccountTypeRepository;
import AccountTypeTranslater;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslaterImpl implements AccountTypeTranslater {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslaterImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes() {
        List<AccountTypeDTO> accountTypeDTOS = new ArrayList<>();

        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDTOS.add(new AccountTypeDTO(accountType));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return accountTypeDTOS;
    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountTypeDTO) {
        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDTO.getAccountType());
            return new AccountTypeDTO(accountType)
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public AccountTypeDTO getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDTO(accountType);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public AccountTypeDTO getAccountTypeByMnemonic(String mnemonic)
    {
        try
        {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDTO(accountType);
        }

        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public AccountTypeDTO getAccountTypeByMnemonic(String mnemonic)
    {
        try
        {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDTO(accountType);
        }

        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

}

