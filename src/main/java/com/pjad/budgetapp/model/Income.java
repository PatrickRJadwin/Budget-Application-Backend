package com.pjad.budgetapp.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Income implements Serializable
{
    private static final long serialVersionUID = 7217377963170770638L;

    private String type;
    private Double preTax;
    private Double postTax;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Double getPreTax()
    {
        return preTax;
    }

    public void setPreTax(Double preTax)
    {
        this.preTax = preTax;
    }

    public Double getPostTax()
    {
        return postTax;
    }

    public void setPostTax(Double postTax)
    {
        this.postTax = postTax;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Income.class.getSimpleName() + "[", "]")
                .add("type='" + type + "'")
                .add("preTax=" + preTax)
                .add("postTax=" + postTax)
                .toString();
    }
}
