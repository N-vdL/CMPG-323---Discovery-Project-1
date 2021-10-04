package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import persistence.AccountTransaction;
import persistence.AccountTransactionDetails;

import java.util.Objects;

public class AccountTransactionDetailsDTO {
    String partnerName;
    long numberOfItems;

    public AccountTransactionDetailsDTO() {
    }

    public AccountTransactionDetailsDTO (String partnerName, long numberOfItems) {
        this.partnerName = partnerName;
        this.numberOfItems = numberOfItems;
    }

    public AccountTransactionDetailsDTO (AccountTransactionDetails details) {
        this.partnerName = details.getPartnerName();
        this.numberOfItems = details.getNumberOfItems();
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(AccountTransaction accountTransaction) {
        return new AccountTransactionDetails (accountTransaction, this.partnerName, this.numberOfItems);
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails() {
        return new AccountTransactionDetails (this.partnerName, this.numberOfItems);
    }

    public String getPartnerName() { return partnerName; }

    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }

    public long getNumberOfItems() { return numberOfItems; }

    public void setNumberOfItems(long numberOfItems) { this.numberOfItems = numberOfItems; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        AccountTransactionDetailsDTO that = (AccountTransactionDetailsDTO) object;

        return Objects.equals(partnerName, that.partnerName) && Objects.equals(numberOfItems, that.numberOfItems);
    }

    @Override
    public int hashCode() { return Objects.hash(partnerName, numberOfItems)}

    @Override
    public String toString() {
        return "AccountTransactionDetailsDTO {" +
                "partnerName = '" + partnerName + "' " +
                ", numberOfItems = '" + numberOfItems +
                "' }";
    }
}
