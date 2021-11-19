package com.booster.investortypescheck.model;

public enum InvestorType {

    DEFENSIVE ("Defensive"),
    CONSERVATIVE ("Conservative"),
    BALANCED ("Balanced"),
    BALANCE_GROWTH("Balanced Growth"),
    GROWTH("Growth"),
    AGGRESSIVE_GROWTH("Aggressive Growth");

    private final String typeName;

    InvestorType(String s) {
        typeName = s;
    }

    public String toString() {
        return this.typeName;
    }
}
