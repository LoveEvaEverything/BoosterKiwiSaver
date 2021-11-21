package com.booster.investortypescheck.model;

import androidx.annotation.NonNull;

public enum InvestorType {

    /**
     * Investor type enum
     */
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

    @NonNull
    @Override
    public String toString() {
        return this.typeName;
    }
}
