package org.example.bankapi.dto;

import java.math.BigDecimal;

public class TransferRequestInfo {
    private long senderId;
    private long receiverId;
    private BigDecimal amount;

    public TransferRequestInfo() {
    }

    public TransferRequestInfo(long senderId, long receiverId, BigDecimal amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

    public long getSenderId() {
        return senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
