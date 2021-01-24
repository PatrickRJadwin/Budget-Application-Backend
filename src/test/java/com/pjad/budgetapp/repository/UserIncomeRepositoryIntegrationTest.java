package com.pjad.budgetapp.repository;

import com.pjad.budgetapp.entity.UserIncome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserIncomeRepositoryIntegrationTest
{
    @Autowired
    private UserIncomeRepository userIncomeRepository;

    @Autowired
    private UserSecureInfoRepository userSecureInfoRepository;

    @Test
    public void whenCalledSave_thenGetObjectById()
    {
        userSecureInfoRepository.insertValuesWithCustomIds(-4L, "bob@domain.com", "password");
        userIncomeRepository.insertValuesWithCustomIds(-4L, 1000.00, 1258.00, "job", -4L);
        UserIncome userIncome = userIncomeRepository.findById(-4L).orElse(new UserIncome());

        Assertions.assertEquals("job", userIncome.getType());
        userSecureInfoRepository.deleteById(-4L);
        userIncomeRepository.deleteById(-4L);
    }
}
