package com.pjad.budgetapp.utils;

import com.pjad.budgetapp.entity.UserBills;
import com.pjad.budgetapp.entity.UserDebts;
import com.pjad.budgetapp.entity.UserIncome;
import com.pjad.budgetapp.entity.UserSavings;
import com.pjad.budgetapp.entity.UserSecureInfo;
import com.pjad.budgetapp.model.Bills;
import com.pjad.budgetapp.model.Budget;
import com.pjad.budgetapp.model.Debts;
import com.pjad.budgetapp.model.Income;
import com.pjad.budgetapp.model.Savings;

import java.util.Arrays;

public class TestUtils
{
    public static Budget getBudget()
    {
        Budget budget = new Budget();

        budget.setBills(Arrays.asList(new Bills()));
        budget.setDebts(Arrays.asList(new Debts()));
        budget.setIncome(Arrays.asList(new Income()));
        budget.setSavings(Arrays.asList(new Savings()));

        return budget;
    }

    public static UserSecureInfo getUserSecureInfo()
    {
        UserSecureInfo userSecureInfo = new UserSecureInfo();

        userSecureInfo.setEmail("email@domain.com");
        userSecureInfo.setId(1L);
        userSecureInfo.setPassword("password");

        return userSecureInfo;
    }

    public static UserBills getUserBills()
    {
        UserBills userBills = new UserBills();

        userBills.setAmount(100.00);
        userBills.setId(1L);
        userBills.setPaymentDate(1);
        userBills.setPayTo("bills");
        userBills.setUserSecureInfoId(getUserSecureInfo());

        return userBills;
    }

    public static UserDebts getUserDebts()
    {
        UserDebts userDebts = new UserDebts();

        userDebts.setAmountOwed(1000.00);
        userDebts.setApr(10.5);
        userDebts.setId(1L);
        userDebts.setLender("lender");
        userDebts.setMinDueDate(1);
        userDebts.setMinimumDue(124.00);
        userDebts.setPaymentAmount(200.00);
        userDebts.setUserSecureInfo(getUserSecureInfo());

        return userDebts;
    }

    public static UserIncome getUserIncome()
    {
        UserIncome userIncome = new UserIncome();

        userIncome.setId(1L);
        userIncome.setPostTax(1500.00);
        userIncome.setPreTax(1750.00);
        userIncome.setType("job");
        userIncome.setUserSecureInfo(getUserSecureInfo());

        return userIncome;
    }

    public static UserSavings getUserSavings()
    {
        UserSavings userSavings = new UserSavings();

        userSavings.setAmountToSavings(150.00);
        userSavings.setId(1L);
        userSavings.setPercentage(true);
        userSavings.setUserSecureInfo(getUserSecureInfo());

        return userSavings;
    }
}
