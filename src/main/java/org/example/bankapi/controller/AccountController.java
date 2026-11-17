package org.example.bankapi.controller;

import org.example.bankapi.dto.AccountDetails;
import org.example.bankapi.dto.TransferRequestInfo;
import org.example.bankapi.dto.TransferResponseInfo;
import org.example.bankapi.entity.Account;
import org.example.bankapi.entity.Transaction;
import org.example.bankapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDetails>> getAllAccounts() {
        List<AccountDetails> accounts = accountService.getAllAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDetails> getAccountById(@PathVariable long id) {
        AccountDetails account = accountService.getAccountdetailsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PostMapping("/save")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferResponseInfo> sendMoney(@RequestBody TransferRequestInfo transferRequestInfo) {
        Transaction transaction=accountService.performTransaction(
                transferRequestInfo.getSenderId(),
                transferRequestInfo.getReceiverId(),
                transferRequestInfo.getAmount()
        );
        TransferResponseInfo transferResponseInfo=new TransferResponseInfo(
                transaction.getTransactionId(),
                transaction.getSenderId(),
                transaction.getReceiverId(),
                transaction.getAmount(),
                transaction.getTransactionDate(),
                transaction.getTransactionTime(),
                transaction.isStatus(),
                accountService.getAccountBalance(transferRequestInfo.getSenderId())
        );
        return ResponseEntity.status(HttpStatus.OK).body(transferResponseInfo);
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable long id){
        BigDecimal balance=accountService.getAccountBalance(id);
        return ResponseEntity.status(HttpStatus.OK).body(balance);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long id){
        AccountDetails account=accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body("Accound Deleted Successfully.");
    }

}
