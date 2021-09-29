package flow;

import dto.AccountTypeDTO;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.as.translater.AccountTypeTranslater;

import javax.transaction.*;
import java.Time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")

public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow
{
    private final AccountTypeTranslater accountTypeTranslater;

    public CreateAccountTypeFlowImpl (AccountTypeTranslater accountTypeTranslater)
    {
        this.accountTypeTranslater = accountTypeTranslater;
    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountType)
    {
        if (null == accountType.getCreationDate)
        {
            accountType.setCreationDate(LocalDate.now());
        }
        AccountTypeDTO accountTypeDTO = accountTypeTranslater.create(accountType);
        return accountTypeTranslater.create(accountType);
    }
}
