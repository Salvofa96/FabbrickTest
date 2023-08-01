package com.example.FabbickTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root {
    @JsonProperty("status")
    public String getStatus() {
        return this.status; }
    public void setStatus(String status) {
        this.status = status; }
    String status;
    @JsonProperty("error")
    public ArrayList<Object> getError() {
        return this.error; }
    public void setError(ArrayList<Object> error) {
        this.error = error; }
    ArrayList<Object> error;
    @JsonProperty("payload")
    public Payload getPayload() {
        return this.payload; }
    public void setPayload(Payload payload) {
        this.payload = payload; }
    Payload payload;

}
