package org.example.bankapi.dto;

import org.example.bankapi.entity.Account;

import java.math.BigDecimal;

public class AccountDetails {
    private Long accountNumber;

    private String firstName;

    private String lastName;

    private BigDecimal balance;

    public AccountDetails() {

    }

    public AccountDetails(Account account) {
        this.accountNumber = account.getAccountNumber();
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.balance = account.getBalance();
    }

    public AccountDetails(Long accountNumber, String firstName, String lastName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
