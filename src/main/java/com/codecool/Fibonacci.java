package com.codecool;


import java.util.function.Supplier;

public class Fibonacci implements Supplier<Integer> {
    private int previousVal = 0;
    private int currentVal = 1;


    @Override
    public Integer get() {
        int tempNum = this.currentVal + this.previousVal;
        this.previousVal = this.currentVal;
        this.currentVal = tempNum;
        return tempNum;
    }
}
