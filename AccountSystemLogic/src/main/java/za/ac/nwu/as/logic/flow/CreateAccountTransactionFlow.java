package za.ac.nwu.as.logic.flow;

import dto.AccountTransactionDTO;

public interface CreateAccountTransactionFlow {
    AccountTransactionDTO create(AccountTransactionDTO accountTransaction);
}
