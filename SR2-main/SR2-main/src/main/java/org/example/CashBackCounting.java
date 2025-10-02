package org.example;

public class CashBackCounting {
    private final int boundary = 1000;
    public int remain(int amount) {
        return boundary - amount % boundary;
    }
}
