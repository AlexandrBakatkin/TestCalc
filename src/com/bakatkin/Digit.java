package com.bakatkin;

public class Digit {

    private int value;

    private RomanDigit romanDigit;

    public Digit(RomanDigit romanDigit) {
        this.romanDigit = romanDigit;
        this.value = romanDigit.getValue();
    }

    public Digit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RomanDigit getRomanDigit() {
        return romanDigit;
    }

    public void setRomanDigit(RomanDigit romanDigit) {
        this.romanDigit = romanDigit;
    }
}