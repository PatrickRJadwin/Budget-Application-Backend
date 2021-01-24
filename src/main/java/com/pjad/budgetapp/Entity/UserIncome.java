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
@Table(name = "user_income")
public class UserIncome implements Serializable
{
    private static final long serialVersionUID = 5334094521784507273L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_SECURE_INFO_ID")
    private UserSecureInfo userSecureInfo;

    private String type;
    private String preTax;
    private String postTax;

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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getPreTax()
    {
        return preTax;
    }

    public void setPreTax(String preTax)
    {
        this.preTax = preTax;
    }

    public String getPostTax()
    {
        return postTax;
    }

    public void setPostTax(String postTax)
    {
        this.postTax = postTax;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", UserIncome.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userSecureInfo=" + userSecureInfo)
                .add("type='" + type + "'")
                .add("preTax='" + preTax + "'")
                .add("postTax='" + postTax + "'")
                .toString();
    }
}
