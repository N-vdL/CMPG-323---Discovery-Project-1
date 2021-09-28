package flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import dto.AccountTypeDTO;
import flow.FetchAccountTypeFlowImpl;
import AccountTypeTranslater;

import javax.transaction.Transactional;
import java.util.List;

@Component

public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow{

    private AccountTypeTranslater accountTypeTranslater;

    @Autowired
    public void fetchAccountTypeFlowImpl(AccountTypeTranslater accountTypeTranslater) {
        this.accountTypeTranslater = accountTypeTranslater;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes() {
        return accountTypeTranslater.getAllAccountTypes();
    }

    @Override
    public AccountTypeDTO getAccountTypeByMnemonic(String mnemonic) {
        return accountTypeTranslater.getAccountTypeByMnemonic(mnemonic);
    }

}
