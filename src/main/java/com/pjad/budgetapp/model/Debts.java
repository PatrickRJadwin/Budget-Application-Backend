package com.pjad.budgetapp.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Debts implements Serializable
{
    private static final long serialVersionUID = 6573764179167526420L;

    private Double amountOwed;
    private Double apr;
    private String lender;
    private Integer minDueDate;
    private Double minimumDue;
    private Double paymentAmount;

    public Double getAmountOwed()
    {
        return amountOwed;
    }

    public void setAmountOwed(Double amountOwed)
    {
        this.amountOwed = amountOwed;
    }

    public Double getApr()
    {
        return apr;
    }

    public void setApr(Double apr)
    {
        this.apr = apr;
    }

    public String getLender()
    {
        return lender;
    }

    public void setLender(String lender)
    {
        this.lender = lender;
    }

    public Integer getMinDueDate()
    {
        return minDueDate;
    }

    public void setMinDueDate(Integer minDueDate)
    {
        this.minDueDate = minDueDate;
    }

    public Double getMinimumDue()
    {
        return minimumDue;
    }

    public void setMinimumDue(Double minimumDue)
    {
        this.minimumDue = minimumDue;
    }

    public Double getPaymentAmount()
    {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount)
    {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Debts.class.getSimpleName() + "[", "]")
                .add("amountOwed=" + amountOwed)
                .add("apr=" + apr)
                .add("lender='" + lender + "'")
                .add("minDueDate=" + minDueDate)
                .add("minimumDue=" + minimumDue)
                .add("paymentAmount=" + paymentAmount)
                .toString();
    }
}
