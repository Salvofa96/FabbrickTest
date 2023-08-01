package com.example.FabbickTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    @JsonProperty("payload")
    public PayloadTransaction getPayload() {
        return this.payload; }
    public void setPayload(PayloadTransaction payload) {
        this.payload = payload; }
    PayloadTransaction payload;
}
