package org.example.bankapi.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name="sender_id")
    private Long senderId;

    @Column(name="receiver_id")
    private Long receiverId;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="transaction_date")
    private LocalDate transactionDate;

    @Column(name="transaction_time")
    private LocalTime transactionTime;

    @Column(name="status")
    private boolean status;

    public Transaction() {

    }

    public Transaction(Long senderId, Long receiverId, BigDecimal amount, LocalDate transactionDate, LocalTime transactionTime, boolean status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.status = status;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
