package com.pjad.budgetapp.controller;

import com.pjad.budgetapp.action.ActionFactory;
import com.pjad.budgetapp.action.BudgetRequestAction;
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
import com.pjad.budgetapp.repository.UserBillsRepository;
import com.pjad.budgetapp.repository.UserDebtsRepository;
import com.pjad.budgetapp.repository.UserIncomeRepository;
import com.pjad.budgetapp.repository.UserSavingsRepository;
import com.pjad.budgetapp.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;

public class BudgetControllerTest
{
    private UserBillsRepository userBillsRepository;
    private UserDebtsRepository userDebtsRepository;
    private UserIncomeRepository userIncomeRepository;
    private UserSavingsRepository userSavingsRepository;
    private ActionFactory actionFactory;
    private BudgetRequestAction budgetRequestAction;

    private BudgetController subject;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.openMocks(this);

        userBillsRepository = Mockito.mock(UserBillsRepository.class);
        userDebtsRepository = Mockito.mock(UserDebtsRepository.class);
        userIncomeRepository = Mockito.mock(UserIncomeRepository.class);
        userSavingsRepository = Mockito.mock(UserSavingsRepository.class);
        budgetRequestAction = Mockito.mock(BudgetRequestAction.class);

        actionFactory = new ActionFactory();
        ReflectionTestUtils.setField(actionFactory, "budgetRequestAction", budgetRequestAction);

        ReflectionTestUtils.setField(budgetRequestAction, "userBillsRepository", userBillsRepository);
        ReflectionTestUtils.setField(budgetRequestAction, "userDebtsRepository", userDebtsRepository);
        ReflectionTestUtils.setField(budgetRequestAction, "userSavingsRepository", userSavingsRepository);
        ReflectionTestUtils.setField(budgetRequestAction, "userIncomeRepository", userIncomeRepository);

        subject = new BudgetController();
        subject.setActionFactory(actionFactory);
    }

    @Test
    public void sendIdAndReceiveBudget()
    {
        Mockito.when(userBillsRepository.getUserBillsByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserBills()));
        Mockito.when(userDebtsRepository.getUserDebtsByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserDebts()));
        Mockito.when(userIncomeRepository.getUserIncomesByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserIncome()));
        Mockito.when(userSavingsRepository.getUserSavingsByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserSavings()));
        Mockito.when(actionFactory.getBudgetRequestAction().getBudgetById(ArgumentMatchers.anyLong())).thenReturn(TestUtils.getBudget());
        Mockito.when(budgetRequestAction.getBudgetById(ArgumentMatchers.anyLong())).thenReturn(TestUtils.getBudget());

        Budget budget = subject.budgetById(1L);

        Assertions.assertNotNull(budget);
        Assertions.assertEquals(budget.getBills().size(), 1L);
        Assertions.assertEquals(budget.getDebts().size(), 1L);
        Assertions.assertEquals(budget.getIncome().size(), 1L);
        Assertions.assertEquals(budget.getSavings().size(), 1L);
    }


}
