package com.pjad.budgetapp.repository;

import com.pjad.budgetapp.entity.UserDebts;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDebtsRepository extends CrudRepository<UserDebts, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_debts (id, user_secure_info_id, lender, amount_owed, apr, payment_amount, minimum_due, min_due_date) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Long userSecureInfoId, String lender, Double amountOwed, Double apr, Double paymentAmount, Double minimumDue, Integer minimumDueDate);

    List<UserDebts> getUserDebtsByUserSecureInfoId(Long id);
}
