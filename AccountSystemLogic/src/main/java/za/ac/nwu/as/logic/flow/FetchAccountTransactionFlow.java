package za.ac.nwu.as.logic.flow;

import dto.AccountTransactionDTO;

import java.util.List;

public interface FetchAccountTransactionFlow {
    List<AccountTransactionDTO> getAllAccountTransactions();

    AccountTransactionDTO getAllAccountTransactionByID(long transactionID);
}
