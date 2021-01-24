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
    @Query(value = "INSERT INTO user_debts (id, amount_owed, apr, lender, min_due_date, minimum_due, payment_amount, user_secure_info_id) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Double amountOwed, Double apr, String lender, Double minimumDue, Integer minimumDueDate, Double paymentAmount, Long userSecureInfoId);

    List<UserDebts> getUserDebtsByUserSecureInfoId(Long id);
}
