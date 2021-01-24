package com.pjad.budgetapp.repository;

import com.pjad.budgetapp.entity.UserSavings;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserSavingsRepository extends CrudRepository<UserSavings, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_savings (id, user_secure_info_id, amount_to_savings, percentage, account_name) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Long userSecureInfoId, Double amountToSavings, Boolean percentage, String accountName);

    List<UserSavings> getUserSavingsByUserSecureInfoId(Long id);
}
