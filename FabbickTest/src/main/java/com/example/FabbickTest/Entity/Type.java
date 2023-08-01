package com.example.FabbickTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Type {
    @JsonProperty("enumeration")
    public String getEnumeration() {
        return this.enumeration; }
    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration; }
    String enumeration;
    @JsonProperty("value")
    public String getValue() {
        return this.value; }
    public void setValue(String value) {
        this.value = value; }
    String value;
}
