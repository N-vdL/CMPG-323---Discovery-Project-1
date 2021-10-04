package dto;

import persistence.AccountTransaction;
import persistence.AccountType;

import java.io.Serializable;
import java.util.Objects;

public class AccountTransactionDTO implements Serializable {

    private static final long serialVersionUID = 0;
    private long transactionID;
    private String accountTypeMnemonic;
    private long memberID;
    private long amount;
    private localDate transactionDate;
    private AccountTransactionDetailsDTO details;

    public AccountTransactionDTO(long transactionID, String accountTypeMnemonic,
                                 long memberID, long amount, localDate transactionDate) {

        this.transactionID = transactionID;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDTO(long transactionID, String accountTypeMnemonic,
                                 long memberID, long amount, localDate transactionDate,
                                 AccountTransactionDetailsDTO createAccountTransaction) {

        this.transactionID = transactionID;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public AccountTransactionDTO(AccountTransaction accountTransaction) {
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
        return new AccountTransaction(this.getTransactionID(), accountType, this.getMemberID(),
        this.getAmount(), this.getTransactionID());
    }

    private Object getAmount() {
    }

    public long getTransactionID() { return transactionID; }

    public void setTransactionID(long transactionID) { this.transactionID = transactionID; }

    public String getAccountTypeMnemonic() { return accountTypeMnemonic; }

    public void setAccountTypeMnemonic(String accountTypeMnemonic)
    { this.accountTypeMnemonic = accountTypeMnemonic; }

    public long getMemberID() { return memberID; }

    public void setAmount(long amount) { this.amount = amount; }

    public localDate getTransactionDate() { return transactionDate; }

    public void setTransactionDate(localDate transactionDate) { this.transactionDate = transactionDate; }

    public AccountTransactionDetailsDTO getDetails() { return details; }

    public void setDetails(AccountTransactionDetailsDTO details) { this.details = details; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        AccountTransactionDTO that = (AccountTransactionDTO) object;

        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountTypeMnemonic, memberID, amount, transactionDate, details);
    }

    @Override
    public String toString() {
        return "AccountTransactionDTO {" +
                "transactionID = '" + transactionID + "' " +
                ", accountTypeMnemonic = '" + accountTypeMnemonic +
                ", memberID = '" + memberID +
                ", amount = '" + amount +
                ", transactionDate = '" + transactionDate +
                "' }";
    }

    public void setTransactionId(Object o) {
    }
}
