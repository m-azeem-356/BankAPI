package org.example.bankapi.service;

import org.example.bankapi.entity.Transaction;
import org.example.bankapi.exception.NoRecordFoundException;
import org.example.bankapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        if (transactions.isEmpty()) {
            throw new NoRecordFoundException("No records found for the provided query");
        }
        return transactions;
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new NoRecordFoundException("No records found for the provided query"));
    }

    public List<Transaction> findByDate(LocalDate date) {
        List<Transaction> transactions = transactionRepository.findByTransactionDate(date);
        if (transactions.isEmpty()) {
            throw new NoRecordFoundException("No records found for the provided query");
        }
        return transactions;
    }

    public List<Transaction> findByTime(LocalTime time) {
        List<Transaction> transactions = transactionRepository.findByTransactionTime(time);
        if (transactions.isEmpty()) {
            throw new NoRecordFoundException("No records found for the provided query");
        }
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Transaction deleteTransaction(long id) {
        Transaction transaction = findById(id);
        transactionRepository.deleteById(id);
        return transaction;
    }

    public List<Transaction> findSentRecord(long id) {
        List<Transaction> transactions = transactionRepository.findBySenderId(id);
        if (transactions.isEmpty()) {
            throw new NoRecordFoundException("No records found for the provided query");
        }
        return transactions;
    }

    public List<Transaction> findReceivedRecord(long id) {
        List<Transaction> transactions = transactionRepository.findByReceiverId(id);
        if (transactions.isEmpty()) {
            throw new NoRecordFoundException("No records found for the provided query");
        }
        return transactions;
    }

    public List<Transaction> findBetweenDates(LocalDate start, LocalDate end) {
        List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(start, end);
        if (transactions.isEmpty()) {
            throw new NoRecordFoundException("No records found for the provided query");
        }
        return transactions;
    }


}
