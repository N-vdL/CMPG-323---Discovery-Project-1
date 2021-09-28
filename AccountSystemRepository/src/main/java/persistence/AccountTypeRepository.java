package persistence;

public interface AccountTypeRepository {
    AccountType[] findAll();

    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    AccountType getAccountTypeByMnemonic(String mnemonic);
}
