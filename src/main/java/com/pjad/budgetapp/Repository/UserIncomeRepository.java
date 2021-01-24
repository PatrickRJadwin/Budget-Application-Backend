package com.pjad.budgetapp.Repository;

import com.pjad.budgetapp.Entity.UserIncome;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserIncomeRepository extends CrudRepository<UserIncome, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_income (id, post_tax, pre_tax, type, user_secure_info_id) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Double postTax, Double preTax, String type, Long userSecureInfoId);
}
