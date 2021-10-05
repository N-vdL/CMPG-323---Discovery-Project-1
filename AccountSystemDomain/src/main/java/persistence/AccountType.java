package persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Table(name ="ACCOUNT_TYPE", schema = "VITRSA_SANDBOX")
public class AccountType implements Serializable {

    private static final long SerialVersionUID = 0;

    private long accountTypeID;
    private String accountTypeName;
    private String mnemonic;
    //private long accountTransactions;

    @Column(name = "Date Created")
    private LocalDate creationDate;

    public AccountType(long accountTypeID, String accountTypeName, String mnemonic, LocalDate creationDate) {
        this.accountTypeID = accountTypeID;
        this.accountTypeName = accountTypeName;
        this.mnemonic = mnemonic;
        this.creationDate = creationDate;
    }

    public AccountType() {

    }

    @Column(name = "accountTypeID")
    public long getAccountTypeID() {
        return accountTypeID;
    }

    @Column(name = "accountTypeNamed")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @Column(name = "mnemonic")
    public String getMnemonic() {
        return mnemonic;
    }

    @Column(name = "Date Created")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountTypeID"
            , orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransaction (Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public void setAccountTypeID(long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return accountTypeID == that.accountTypeID && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, accountTypeName, mnemonic, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
