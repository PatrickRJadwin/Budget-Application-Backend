package com.pjad.budgetapp.Repository;

import com.pjad.budgetapp.Entity.UserSavings;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserSavingsRepository extends CrudRepository<UserSavings, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_savings (id, amount_to_savings, percentage, user_secure_info_id) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Double amountToSavings, Boolean percentage, Long userSecureInfoId);
}
