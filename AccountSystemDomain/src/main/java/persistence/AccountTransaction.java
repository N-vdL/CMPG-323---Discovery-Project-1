package persistence;

import dto.AccountTransactionDetailsDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name ="ACCOUNT_TYPE", schema = "VITRSA_SANDBOX")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 0;

    private long transactionID;
    private AccountType accountTypeID;
    private String accountTypeMnemonic;
    private long memberID;
    private long amount;
    private LocalDate transactionDate;
    private AccountTransactionDetailsDTO details;

    public AccountTransaction(long transactionID, String accountTypeMnemonic,
                                 long memberID, long amount, localDate transactionDate) {

        this.transactionID = transactionID;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction(long transactionID, String accountTypeMnemonic,
                                 long memberID, long amount, localDate transactionDate,
                                 AccountTransactionDetailsDTO createAccountTransaction) {

        this.transactionID = transactionID;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public AccountTransaction(AccountTransaction accountTransaction) {
        this.transactionID = accountTransaction.getTransactionID();
        this.accountTypeMnemonic = accountTransaction.getAccountTypeMnemonic();
        this.memberID = accountTransaction.getMemberID();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();


        if (null != accountTransaction.getDetails()) {
            this.details = new AccountTransactionDetailsDTO(accountTransaction.getDetails());
        }
    }

    public AccountTransaction buildAccountTransaction(AccountType accountType) {
        return new AccountTransaction(this.getTransactionID(), this.accountTypeID, this.getMemberID(),
                this.getAmount(), this.getTransactionID());
    }

    private long getAmount() {
        return amount;
    }

    @Column(name = "transactionID")
    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountTypeID")
    public AccountType getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(AccountType accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name = "accountTypeMnemonic")
    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    @Column(name = "memberID")
    public long getMemberID() {
        return memberID;
    }

    public void setMemberID(long memberID) {
        this.memberID = memberID;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Column(name = "transactionDate")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDetailsDTO getDetails() {
        return details;
    }

    public void setDetails(AccountTransactionDetailsDTO details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return transactionID == that.transactionID && memberID == that.memberID && amount == that.amount && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountTypeID, accountTypeMnemonic, memberID, amount, transactionDate, details);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", accountTypeID=" + accountTypeID +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", memberID=" + memberID +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", details=" + details +
                '}';
    }
}
