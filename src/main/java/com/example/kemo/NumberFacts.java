package com.example.kemo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class NumberFacts {
   @JsonProperty("text")
   String text;
   @JsonProperty("number")
    int number;
    @JsonProperty("found")
    String found;
    @JsonProperty("type")
    String type;

    public NumberFacts() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NumberFacts(String text, int number, String found, String type) {
        this.text = text;
        this.number = number;
        this.found = found;
        this.type= type;

    }

}
