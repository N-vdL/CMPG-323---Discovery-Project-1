package za.ac.nwu.as.logic.flow;

import persistence.AccountType;

public interface FetchAccountTypeFlow {
    AccountType getAccounTypeDoEntityByMnemonic(Object accountTypeMnemonic);
}
