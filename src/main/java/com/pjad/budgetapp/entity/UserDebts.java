package com.pjad.budgetapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.StringJoiner;

@Entity
@Table(name = "user_debts")
public class UserDebts implements Serializable
{
    private static final long serialVersionUID = -1187285450459604827L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_SECURE_INFO_ID")
    private UserSecureInfo userSecureInfo;

    private String lender;
    private Double amountOwed;
    private Double apr;
    private Double paymentAmount;
    private Double minimumDue;
    private Integer minDueDate;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public UserSecureInfo getUserSecureInfo()
    {
        return userSecureInfo;
    }

    public void setUserSecureInfo(UserSecureInfo userSecureInfo)
    {
        this.userSecureInfo = userSecureInfo;
    }

    public String getLender()
    {
        return lender;
    }

    public void setLender(String lender)
    {
        this.lender = lender;
    }

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

    public Double getPaymentAmount()
    {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount)
    {
        this.paymentAmount = paymentAmount;
    }

    public Double getMinimumDue()
    {
        return minimumDue;
    }

    public void setMinimumDue(Double minimumDue)
    {
        this.minimumDue = minimumDue;
    }

    public Integer getMinDueDate()
    {
        return minDueDate;
    }

    public void setMinDueDate(Integer minDueDate)
    {
        this.minDueDate = minDueDate;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", UserDebts.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userSecureInfo=" + userSecureInfo)
                .add("lender='" + lender + "'")
                .add("amountOwed=" + amountOwed)
                .add("apr=" + apr)
                .add("paymentAmount=" + paymentAmount)
                .add("minimumDue=" + minimumDue)
                .add("minDueDate=" + minDueDate)
                .toString();
    }
}
