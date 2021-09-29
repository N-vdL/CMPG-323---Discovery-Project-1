package dto;

import org.springframework.format.datetime.joda.LocalDateParser;
import persistence.AccountType;
import sun.util.resources.LocaleData;

import java.io.Serializable;

public class AccountTypeDTO implements Serializable {

    private String mnemonic;
    private String accountTypeName;
    private LocalDateParser creationDate;

    public AccountTypeDTO(String mnemonic, String accountTypeName, LocalDateParser creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDTO() {

    }

    public AccountTypeDTO(AccountType accountType) {
        this.setAccountTypeName(accountType).getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
        this.setMnemonic(accountType.getMnemonic());
    }

    private Object setAccountTypeName(AccountType accountType) {
        return accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    private Object setCreationDate(AccountType accountType) {
        return accountType;
    }

    public LocalDateParser getCreationDate() {
        return creationDate;
    }

    private Object setMnemonic(AccountType accountType) {
        return accountType;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public Object getAccountType()
    {
        return null;
    }
}
