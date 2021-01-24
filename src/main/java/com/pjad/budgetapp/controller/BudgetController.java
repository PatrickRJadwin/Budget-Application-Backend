package com.pjad.budgetapp.controller;

import com.pjad.budgetapp.action.ActionFactory;
import com.pjad.budgetapp.model.Budget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetController
{
    private static final Logger logger = LoggerFactory.getLogger(BudgetController.class);

    @Autowired
    private ActionFactory actionFactory;

    @GetMapping("/budget/{id}")
    public Budget budgetById(@PathVariable Long id)
    {
        logger.info("Retrieving budget for ID: {}", id);

        return actionFactory.getBudgetRequestAction().getBudgetById(id);
    }

    public void setActionFactory(ActionFactory actionFactory)
    {
        this.actionFactory = actionFactory;
    }
}
