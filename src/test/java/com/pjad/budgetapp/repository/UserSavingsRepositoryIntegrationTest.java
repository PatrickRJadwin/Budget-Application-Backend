package com.pjad.budgetapp.repository;

import com.pjad.budgetapp.entity.UserSavings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserSavingsRepositoryIntegrationTest
{
    @Autowired
    private UserSavingsRepository userSavingsRepository;

    @Autowired
    private UserSecureInfoRepository userSecureInfoRepository;

    @Test
    public void whenCalledSave_thenGetObjectById()
    {
        userSecureInfoRepository.insertValuesWithCustomIds(-4L, "bob@domain.com", "password");
        userSavingsRepository.insertValuesWithCustomIds(-4L, 150.00, false, -4L);
        UserSavings userDebts = userSavingsRepository.findById(-4L).orElse(new UserSavings());

        Assertions.assertEquals(150.00, userDebts.getAmountToSavings());
        userSecureInfoRepository.deleteById(-4L);
        userSavingsRepository.deleteById(-4L);
    }
}
