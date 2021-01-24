package com.pjad.budgetapp.action;

import com.pjad.budgetapp.model.Budget;
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

public class BudgetRequestActionTest
{
    private UserBillsRepository userBillsRepository;
    private UserDebtsRepository userDebtsRepository;
    private UserIncomeRepository userIncomeRepository;
    private UserSavingsRepository userSavingsRepository;

    private BudgetRequestAction budgetRequestAction;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.openMocks(this);

        userBillsRepository = Mockito.mock(UserBillsRepository.class);
        userDebtsRepository = Mockito.mock(UserDebtsRepository.class);
        userIncomeRepository = Mockito.mock(UserIncomeRepository.class);
        userSavingsRepository = Mockito.mock(UserSavingsRepository.class);

        budgetRequestAction = new BudgetRequestAction();

        ReflectionTestUtils.setField(budgetRequestAction, "userBillsRepository", userBillsRepository);
        ReflectionTestUtils.setField(budgetRequestAction, "userDebtsRepository", userDebtsRepository);
        ReflectionTestUtils.setField(budgetRequestAction, "userSavingsRepository", userSavingsRepository);
        ReflectionTestUtils.setField(budgetRequestAction, "userIncomeRepository", userIncomeRepository);
    }

    @Test
    public void testSendIdAndReceiveBudget()
    {
        Mockito.when(userBillsRepository.getUserBillsByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserBills()));
        Mockito.when(userDebtsRepository.getUserDebtsByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserDebts()));
        Mockito.when(userIncomeRepository.getUserIncomesByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserIncome()));
        Mockito.when(userSavingsRepository.getUserSavingsByUserSecureInfoId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(TestUtils.getUserSavings()));

        Budget budget = budgetRequestAction.getBudgetById(1L);

        Assertions.assertNotNull(budget);
        Assertions.assertEquals(budget.getBills().size(), 1L);
        Assertions.assertEquals(budget.getDebts().size(), 1L);
        Assertions.assertEquals(budget.getIncome().size(), 1L);
        Assertions.assertEquals(budget.getSavings().size(), 1L);
    }
}
