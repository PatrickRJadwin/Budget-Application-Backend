package com.pjad.budgetapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class Budget implements Serializable
{
    private static final long serialVersionUID = -6104148515599242760L;

    private List<Income> income;
    private List<Bills> bills;
    private List<Debts> debts;
    private List<Savings> savings;

    public List<Income> getIncome()
    {
        return income;
    }

    public void setIncome(List<Income> income)
    {
        this.income = income;
    }

    public List<Bills> getBills()
    {
        return bills;
    }

    public void setBills(List<Bills> bills)
    {
        this.bills = bills;
    }

    public List<Debts> getDebts()
    {
        return debts;
    }

    public void setDebts(List<Debts> debts)
    {
        this.debts = debts;
    }

    public List<Savings> getSavings()
    {
        return savings;
    }

    public void setSavings(List<Savings> savings)
    {
        this.savings = savings;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Budget.class.getSimpleName() + "[", "]")
                .add("income=" + income)
                .add("bills=" + bills)
                .add("debts=" + debts)
                .add("savings=" + savings)
                .toString();
    }
}
