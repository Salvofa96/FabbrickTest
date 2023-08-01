package com.example.FabbickTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PayloadTransaction {
    @JsonProperty("list")
    public ArrayList<ListTransaction> getList() {
        return this.list; }
    public void setList(ArrayList<ListTransaction> list) {
        this.list = list; }
    ArrayList<ListTransaction> list;
}
