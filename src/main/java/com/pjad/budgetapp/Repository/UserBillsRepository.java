package com.pjad.budgetapp.Repository;

import com.pjad.budgetapp.Entity.UserBills;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserBillsRepository extends CrudRepository<UserBills, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_bills (id, amount, pay_to, payment_date, user_secure_info_id) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Double amount, String payTo, Integer paymentDate, Long userSecureInfoId);
}
