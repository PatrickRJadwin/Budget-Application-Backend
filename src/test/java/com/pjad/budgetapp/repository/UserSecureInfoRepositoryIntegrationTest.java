package com.pjad.budgetapp.repository;

import com.pjad.budgetapp.entity.UserSecureInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserSecureInfoRepositoryIntegrationTest
{
    @Autowired
    private UserSecureInfoRepository userSecureInfoRepository;

    @Test
    public void whenCalledSave_thenGetObjectById()
    {
        userSecureInfoRepository.insertValuesWithCustomIds(-4L, "bob@domain.com", "password");
        UserSecureInfo users =  userSecureInfoRepository.findById(-4L).orElse(new UserSecureInfo());

        Assertions.assertEquals("bob@domain.com", users.getEmail());
        userSecureInfoRepository.deleteById(-4L);
    }
}
