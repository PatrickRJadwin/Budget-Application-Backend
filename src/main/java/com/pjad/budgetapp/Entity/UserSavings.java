package com.pjad.budgetapp.Entity;

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
@Table(name = "user_savings")
public class UserSavings implements Serializable
{
    private static final long serialVersionUID = 2585704363892867620L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_SECURE_INFO_ID")
    private UserSecureInfo userSecureInfo;

    private Double amountToSavings;
    private Boolean percentage;

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

    @Override
    public String toString()
    {
        return new StringJoiner(", ", UserSavings.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userSecureInfo=" + userSecureInfo)
                .add("amountToSavings=" + amountToSavings)
                .add("percentage=" + percentage)
                .toString();
    }
}
