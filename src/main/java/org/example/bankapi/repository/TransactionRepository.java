package org.example.bankapi.repository;

import org.example.bankapi.entity.Account;
import org.example.bankapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public List<Transaction> findByTransactionDate(LocalDate TransactionDate);

    public List<Transaction> findByTransactionTime(LocalTime TransactionTime);

    List<Transaction> findBySenderId(Long senderId);

    List<Transaction> findByReceiverId(Long receiverId);

    List<Transaction> findByTransactionDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );

}
