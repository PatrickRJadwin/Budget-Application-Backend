package com.pjad.budgetapp.Repository;

import com.pjad.budgetapp.Entity.UserBills;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserBillsRepositoryIntegrationTest
{
    @Autowired
    private UserBillsRepository userBillsRepository;

    @Autowired
    private UserSecureInfoRepository userSecureInfoRepository;

    @Test
    public void whenCalledSave_thenGetObjectById()
    {
        userSecureInfoRepository.insertValuesWithCustomIds(-4L, "bob@domain.com", "password");
        userBillsRepository.insertValuesWithCustomIds(-4L, 500.00, "rent", 14, -4L);
        UserBills userBills = userBillsRepository.findById(-4L).orElse(new UserBills());

        Assertions.assertEquals(500.00, userBills.getAmount());
        userSecureInfoRepository.deleteById(-4L);
        userBillsRepository.deleteById(-4L);
    }
}
