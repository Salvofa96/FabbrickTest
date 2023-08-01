package com.example.FabbickTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListTransaction {
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return this.transactionId; }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId; }
    String transactionId;
    @JsonProperty("operationId")
    public String getOperationId() {
        return this.operationId; }
    public void setOperationId(String operationId) {
        this.operationId = operationId; }
    String operationId;
    @JsonProperty("accountingDate")
    public String getAccountingDate() {
        return this.accountingDate; }
    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate; }
    String accountingDate;
    @JsonProperty("valueDate")
    public String getValueDate() {
        return this.valueDate; }
    public void setValueDate(String valueDate) {
        this.valueDate = valueDate; }
    String valueDate;
    @JsonProperty("type")
    public Type getType() {
        return this.type; }
    public void setType(Type type) {
        this.type = type; }
    Type type;
    @JsonProperty("amount")
    public double getAmount() {
        return this.amount; }
    public void setAmount(double amount) {
        this.amount = amount; }
    double amount;
    @JsonProperty("currency")
    public String getCurrency() {
        return this.currency; }
    public void setCurrency(String currency) {
        this.currency = currency; }
    String currency;
    @JsonProperty("description")
    public String getDescription() {
        return this.description; }
    public void setDescription(String description) {
        this.description = description; }
    String description;
}
