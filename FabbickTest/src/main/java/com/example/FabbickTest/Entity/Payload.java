package com.example.FabbickTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload{
    @JsonProperty("date")
    public String getDate() {
        return this.date; }
    public void setDate(String date) {
        this.date = date; }
    String date;
    @JsonProperty("balance")
    public double getBalance() {
        return this.balance; }
    public void setBalance(double balance) {
        this.balance = balance; }
    double balance;
    @JsonProperty("availableBalance")
    public double getAvailableBalance() {
        return this.availableBalance; }
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance; }
    double availableBalance;
    @JsonProperty("currency")
    public String getCurrency() {
        return this.currency; }
    public void setCurrency(String currency) {
        this.currency = currency; }
    String currency;
}