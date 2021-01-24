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
@Table(name = "user_bills")
public class UserBills implements Serializable
{
    private static final long serialVersionUID = -4359579172818212672L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_SECURE_INFO_ID")
    private UserSecureInfo userSecureInfoId;

    private String payTo;
    private Double amount;
    private Integer paymentDate;

    public UserBills() {}

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public UserSecureInfo getUserSecureInfoId()
    {
        return userSecureInfoId;
    }

    public void setUserSecureInfoId(UserSecureInfo userSecureInfoId)
    {
        this.userSecureInfoId = userSecureInfoId;
    }

    public String getPayTo()
    {
        return payTo;
    }

    public void setPayTo(String payTo)
    {
        this.payTo = payTo;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
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
        return new StringJoiner(", ", UserBills.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userSecureInfoId=" + userSecureInfoId)
                .add("payTo='" + payTo + "'")
                .add("amount='" + amount + "'")
                .add("paymentDate=" + paymentDate)
                .toString();
    }
}
