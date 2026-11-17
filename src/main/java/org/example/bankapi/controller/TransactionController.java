package org.example.bankapi.controller;

import org.example.bankapi.dto.DatesDTO;
import org.example.bankapi.entity.Transaction;
import org.example.bankapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable long id) {
        Transaction transaction = transactionService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(transaction);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Transaction>> getTransactionByDate(@PathVariable LocalDate date) {
        List<Transaction> transactions = transactionService.findByDate(date);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/date/{time}")
    public ResponseEntity<List<Transaction>> getTransactionByTime(@PathVariable LocalTime time) {
        List<Transaction> transactions = transactionService.findByTime(time);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable long id) {
        Transaction transaction = transactionService.deleteTransaction(id);
        return ResponseEntity.status(HttpStatus.OK).body("Transaction with ID: " + transaction.getTransactionId() + " is deleted Successfully.");
    }

    @GetMapping("/sent/{id}")
    public ResponseEntity<List<Transaction>> getSentOnlyTransactoins(@PathVariable long id) {
        List<Transaction> transactions = transactionService.findSentRecord(id);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/received/{id}")
    public ResponseEntity<List<Transaction>> getReceivedOnlyTransactoins(@PathVariable long id) {
        List<Transaction> transactions = transactionService.findReceivedRecord(id);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Transaction>> getTransactionsBetweenDates(@RequestBody DatesDTO dates){
        List<Transaction> transactions=transactionService.findBetweenDates(dates.getStartDate(),dates.getEndDate());
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

}
