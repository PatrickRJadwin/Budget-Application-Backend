package com.pjad.budgetapp.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Bills implements Serializable
{
    private static final long serialVersionUID = -3643605788143903830L;

    private Double amount;
    private String payTo;
    private Integer paymentDate;

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public String getPayTo()
    {
        return payTo;
    }

    public void setPayTo(String payTo)
    {
        this.payTo = payTo;
    }

    public Integer getPaymentDate()
    {
        return paymentDate;
    }

    public void setPaymentDate(Integer paymentDate)
    {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Bills.class.getSimpleName() + "[", "]")
                .add("amount=" + amount)
                .add("payTo='" + payTo + "'")
                .add("paymentDate=" + paymentDate)
                .toString();
    }
}
