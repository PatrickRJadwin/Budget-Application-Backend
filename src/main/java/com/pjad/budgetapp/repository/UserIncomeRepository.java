package com.pjad.budgetapp.repository;

import com.pjad.budgetapp.entity.UserIncome;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserIncomeRepository extends CrudRepository<UserIncome, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_income (id, user_secure_info_id, type, pre_tax, post_tax) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Long userSecureInfoId, String type, Double preTax, Double postTax);

    List<UserIncome> getUserIncomesByUserSecureInfoId(Long id);
}
