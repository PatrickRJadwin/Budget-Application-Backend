package com.pjad.budgetapp.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Savings implements Serializable
{
    private static final long serialVersionUID = -8059284408034512626L;

    private Double amountToSavings;
    private Boolean percentage;
    private String accountName;

    public Double getAmountToSavings()
    {
        return amountToSavings;
    }

    public void setAmountToSavings(Double amountToSavings)
    {
        this.amountToSavings = amountToSavings;
    }

    public Boolean getPercentage()
    {
        return percentage;
    }

    public void setPercentage(Boolean percentage)
    {
        this.percentage = percentage;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Savings.class.getSimpleName() + "[", "]")
                .add("accountName='" + accountName + "'")
                .add("amountToSavings=" + amountToSavings)
                .add("percentage=" + percentage)
                .toString();
    }
}
