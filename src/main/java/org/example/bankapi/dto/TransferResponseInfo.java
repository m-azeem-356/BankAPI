package org.example.bankapi.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class TransferResponseInfo {
    private Long transactionId;

    private Long senderId;

    private Long receiverId;

    private BigDecimal amount;

    private LocalDate transactionDate;

    private LocalTime transactionTime;

    private boolean status;

    private BigDecimal remainingBalance;

    public TransferResponseInfo() {

    }

    public TransferResponseInfo(Long transactionId, Long senderId, Long receiverId, BigDecimal amount, LocalDate transactionDate, LocalTime transactionTime, boolean status, BigDecimal remainingBalance) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.status = status;
        this.remainingBalance = remainingBalance;
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

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
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

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}
