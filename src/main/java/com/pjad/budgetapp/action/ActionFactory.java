package com.pjad.budgetapp.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionFactory
{
    @Autowired
    private BudgetRequestAction budgetRequestAction;

    public BudgetRequestAction getBudgetRequestAction()
    {
        return budgetRequestAction;
    }
}
