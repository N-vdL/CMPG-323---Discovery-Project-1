package flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import dto.AccountTransactionDTO;
import persistence.AccountTransaction;
import dto.AccountTransactionDetailsDTO;
import persistence.AccountType;
import za.ac.nwu.as.logic.flow.CreateAccountTransactionFlow;
import impl.AccountTransactionDetailsTranslater;
import impl.AccountTransactionTranslater;
import za.ac.nwu.as.logic.flow.FetchAccountTypeFlow;

import javax.transaction.Transactional;

@Transactional;
@Component;

public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final AccountTransactionTranslater accountTransactionTranslater;
    private final AccountTransactionDetailsTranslater accountTransactionDetailsTranslater;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountTransactionFlowImpl (AccountTransactionTranslater accountTransactionTranslater,
                                             AccountTransactionDetailsTranslater accountTransactionDetailsTranslater,
                                             FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountTransactionTranslater = accountTransactionTranslater;
        this.accountTransactionDetailsTranslater = accountTransactionDetailsTranslater;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTransactionDTO) {

        if(LOGGER.isDebugEnabled()) {
            String loggingOutput = "null";

            if((null != accountTransactionDTO) && (null != accountTransactionDTO.getDetails())) {
                loggingOutput = accountTransactionDTO.getDetails().toString();
            }

            LOGGER.debug("The input object is {} and the Details are {}",
                    accountTransactionDTO, loggingOutput);
        }

        accountTransactionDTO.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccounTypeDoEntityByMnemonic(
                accountTransactionDTO.getAccountTypeMnemonic());

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("The AccountType is {} and the AccountTypeID is {}",
                accountTransactionDTO.getAccountTypeMnemonic(), accountType.getAccountTypeID());
        }

        AccountTransaction accountTransaction = accountTransactionDTO.buildAccountTransaction(accountType);

        AccountTransaction createAccountTransaction = accountTransactionTranslater.save(accountTransaction);

        if(null != accountTransactionDTO.getDetails()) {
            AccountTransactionDetailsDTO accountTransactionDetails = AccountTransactionDTO.getDetails()
                    .buildAccountTransactionDetails(createAccountTransaction);
            createAccountTransaction.setDetails(accountTransactionDetails);
            accountTransactionDetailsTranslater.save(createAccountTransaction.getDetails());
        }

        AccountTransactionDTO results= new AccountTransactionDTO(createAccountTransaction);
        LOGGER.info("The return object is {}", results);
        return results;
    }
}
