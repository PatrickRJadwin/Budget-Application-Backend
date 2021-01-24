package com.pjad.budgetapp.action;

import com.pjad.budgetapp.entity.UserBills;
import com.pjad.budgetapp.entity.UserDebts;
import com.pjad.budgetapp.entity.UserIncome;
import com.pjad.budgetapp.entity.UserSavings;
import com.pjad.budgetapp.model.Budget;
import com.pjad.budgetapp.repository.UserBillsRepository;
import com.pjad.budgetapp.repository.UserDebtsRepository;
import com.pjad.budgetapp.repository.UserIncomeRepository;
import com.pjad.budgetapp.repository.UserSavingsRepository;
import com.pjad.budgetapp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BudgetRequestAction extends ActionFactory
{
    private static final Logger logger = LoggerFactory.getLogger(BudgetRequestAction.class);

    @Autowired
    private UserBillsRepository userBillsRepository;

    @Autowired
    private UserDebtsRepository userDebtsRepository;

    @Autowired
    private UserIncomeRepository userIncomeRepository;

    @Autowired
    private UserSavingsRepository userSavingsRepository;

    public Budget getBudgetById(Long id)
    {
        Budget budget = new Budget();

        budget.setSavings(Utils.savingsFactory(getUserSavings(id)));
        budget.setIncome(Utils.incomesFactory(getUserIncomes(id)));
        budget.setDebts(Utils.debtsFactory(getUserDebts(id)));
        budget.setBills(Utils.billsFactory(getUserBills(id)));

        logger.info("Budget object transformation complete: {}", budget);

        return budget;
    }

    private List<UserBills> getUserBills(Long id)
    {
        try {
            return userBillsRepository.getUserBillsByUserSecureInfoId(id);
        } catch (Exception e)
        {
            logger.error("Error retrieving value from DB ", e);
            throw e;
        }
    }

    private List<UserDebts> getUserDebts(Long id)
    {
        try {
            return userDebtsRepository.getUserDebtsByUserSecureInfoId(id);
        } catch (Exception e)
        {
            logger.error("Error retrieving value from DB ", e);
            throw e;
        }
    }

    private List<UserIncome> getUserIncomes(Long id)
    {
        try {
            return userIncomeRepository.getUserIncomesByUserSecureInfoId(id);
        } catch (Exception e)
        {
            logger.error("Error retrieving value from DB ", e);
            throw e;
        }
    }

    private List<UserSavings> getUserSavings(Long id)
    {
        try
        {
            return userSavingsRepository.getUserSavingsByUserSecureInfoId(id);
        } catch (Exception e)
        {
            logger.error("Error retrieving value from DB ", e);
            throw e;
        }
    }
}
