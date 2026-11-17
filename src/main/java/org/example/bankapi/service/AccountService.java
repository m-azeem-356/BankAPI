package org.example.bankapi.service;

import jakarta.transaction.Transactional;
import org.example.bankapi.dto.AccountDetails;
import org.example.bankapi.entity.Account;
import org.example.bankapi.entity.Transaction;
import org.example.bankapi.exception.AccountNotFoundException;
import org.example.bankapi.exception.InsufficentBalanceException;
import org.example.bankapi.exception.NoRecordFoundException;
import org.example.bankapi.exception.WrongPasswordException;
import org.example.bankapi.repository.AccountsRepository;
import org.example.bankapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final AccountsRepository accountsRepository;
    private final TransactionRepository transactionRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountsRepository accountsRepository, TransactionRepository transactionRepository, PasswordEncoder passwordEncoder) {
        this.accountsRepository = accountsRepository;
        this.transactionRepository = transactionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<AccountDetails> getAllAccounts() {
        List<Account> accounts = accountsRepository.findAll();
        if (accounts.isEmpty()) {
            throw new NoRecordFoundException("No records found for the provided query");
        }
        return accountDtoList(accounts);
    }

    public Account getAccountById(long id) {
        return accountsRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("No Account with id " + id + " is found"));
    }

    public AccountDetails getAccountdetailsById(long id) {
        Account account = getAccountById(id);
        return accountDto(account);
    }

    public void saveAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountsRepository.save(account);
    }

    public BigDecimal deductBalance(long id, BigDecimal amount) {
        Account account = getAccountById(id);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficentBalanceException("The Balance is not enough.");
        }
        BigDecimal newBalance = account.getBalance().subtract(amount);
        account.setBalance(newBalance);
        saveAccount(account);
        return newBalance;
    }

    public void addBalance(long id, BigDecimal amount) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance().add(amount));
        saveAccount(account);
    }

    @Transactional
    public Transaction performTransaction(long sender, long receiver, BigDecimal amount) {
        BigDecimal balance = deductBalance(sender, amount);
        addBalance(receiver, amount);
        Transaction transaction = new Transaction(sender, receiver, amount, LocalDate.now(), LocalTime.now(), true);
        transactionRepository.save(transaction);
        return transaction;
    }

    public AccountDetails deleteAccount(long id) {
        Account account = getAccountById(id);
        accountsRepository.deleteById(id);
        return accountDto(account);
    }

    public Account changePassword(long id, String currentPassword, String newPasswrd) {
        Account account = getAccountById(id);
        if (!account.getPassword().equals(currentPassword))
            throw new WrongPasswordException("Entered Password is Wrong, Please Enter a Valid Password.");
        account.setPassword(newPasswrd);
        saveAccount(account);
        return account;
    }

    public Account changeFirstName(long id, String newFirstName) {
        Account account = getAccountById(id);
        account.setFirstName(newFirstName);
        saveAccount(account);
        return account;
    }

    public AccountDetails changeLastName(long id, String newLastName) {
        Account account = getAccountById(id);
        account.setLastName(newLastName);
        saveAccount(account);
        return accountDto(account);
    }

    public BigDecimal getAccountBalance(long id) {
        Account account = getAccountById(id);
        return account.getBalance();
    }

    public AccountDetails accountDto(Account account) {
        return new AccountDetails(account);
    }

    public List<AccountDetails> accountDtoList(List<Account> accounts) {
        List<AccountDetails> accountDtos = new ArrayList<>();
        for (Account account : accounts) {
            accountDtos.add(new AccountDetails(account));
        }
        return accountDtos;
    }

}
