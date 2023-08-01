package com.example.FabbickTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyTransfer {

    @JsonProperty("status")
    String status;
    @JsonProperty("code")
    String code;
    @JsonProperty("description")
    String description;
    @JsonProperty("receiverName")
    String receiverName;
    @JsonProperty("amount")
    String amount;
    @JsonProperty("currency")
    String currency;
    @JsonProperty("executionDate")
    String executionDate;

    Payload payload;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String error) {
        this.status = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
