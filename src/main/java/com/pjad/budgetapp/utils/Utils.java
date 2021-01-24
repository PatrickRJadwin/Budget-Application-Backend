package com.pjad.budgetapp.utils;

import com.pjad.budgetapp.entity.UserBills;
import com.pjad.budgetapp.entity.UserDebts;
import com.pjad.budgetapp.entity.UserIncome;
import com.pjad.budgetapp.entity.UserSavings;
import com.pjad.budgetapp.model.Bills;
import com.pjad.budgetapp.model.Debts;
import com.pjad.budgetapp.model.Income;
import com.pjad.budgetapp.model.Savings;

import java.util.ArrayList;
import java.util.List;

public class Utils
{
    public static List<Debts> debtsFactory(List<UserDebts> userDebts)
    {
        List<Debts> debts = new ArrayList<>();
        userDebts.forEach(userDebt -> {
            Debts debt = new Debts();
            debt.setAmountOwed(userDebt.getAmountOwed());
            debt.setPaymentAmount(userDebt.getPaymentAmount());
            debt.setMinimumDue(userDebt.getMinimumDue());
            debt.setMinDueDate(userDebt.getMinDueDate());
            debt.setLender(userDebt.getLender());
            debt.setApr(userDebt.getApr());

            debts.add(debt);
        });
        return debts;
    }

    public static List<Bills> billsFactory(List<UserBills> userBills)
    {
        List<Bills> bills = new ArrayList<>();
        userBills.forEach(userBill -> {
            Bills bill = new Bills();
            bill.setAmount(userBill.getAmount());
            bill.setPaymentDate(userBill.getPaymentDate());
            bill.setPayTo(userBill.getPayTo());

            bills.add(bill);
        });
        return bills;
    }

    public static List<Income> incomesFactory(List<UserIncome> userIncomes)
    {
        List<Income> incomes = new ArrayList<>();
        userIncomes.forEach(userIncome -> {
            Income income = new Income();
            income.setPostTax(userIncome.getPostTax());
            income.setPreTax(userIncome.getPreTax());
            income.setType(userIncome.getType());

            incomes.add(income);
        });
        return incomes;
    }

    public static List<Savings> savingsFactory(List<UserSavings> userSavings)
    {
        List<Savings> savings = new ArrayList<>();
        userSavings.forEach(userSaving -> {
            Savings saving = new Savings();
            saving.setAmountToSavings(userSaving.getAmountToSavings());
            saving.setPercentage(userSaving.getPercentage());
            saving.setAccountName(userSaving.getAccountName());

            savings.add(saving);
        });
        return savings;
    }
}
