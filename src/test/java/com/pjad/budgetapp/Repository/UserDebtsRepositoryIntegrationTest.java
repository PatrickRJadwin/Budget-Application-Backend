package com.pjad.budgetapp.Repository;

import com.pjad.budgetapp.Entity.UserDebts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDebtsRepositoryIntegrationTest
{
    @Autowired
    private UserDebtsRepository userDebtsRepository;

    @Autowired
    private UserSecureInfoRepository userSecureInfoRepository;

    @Test
    public void whenCalledSave_thenGetObjectById()
    {
        userSecureInfoRepository.insertValuesWithCustomIds(-4L, "bob@domain.com", "password");
        userDebtsRepository.insertValuesWithCustomIds(-4L, 100.00, 10.0, "capital one", 10.0, 14, 50.00, -4L);
        UserDebts userDebts = userDebtsRepository.findById(-4L).orElse(new UserDebts());

        Assertions.assertEquals(100.00, userDebts.getAmountOwed());
        userSecureInfoRepository.deleteById(-4L);
        userDebtsRepository.deleteById(-4L);
    }
}
