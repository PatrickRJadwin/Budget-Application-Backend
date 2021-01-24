package com.pjad.budgetapp.repository;

import com.pjad.budgetapp.entity.UserBills;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserBillsRepository extends CrudRepository<UserBills, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_bills (id, amount, pay_to, payment_date, user_secure_info_id) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, Double amount, String payTo, Integer paymentDate, Long userSecureInfoId);

    @Query(value = "SELECT * FROM user_bills WHERE user_secure_info_id = ?1", nativeQuery= true)
    List<UserBills> getUserBillsByUserSecureInfoId(Long secureInfoId);
}
