package com.pjad.budgetapp.Repository;

import com.pjad.budgetapp.Entity.UserSecureInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserSecureInfoRepository extends CrudRepository<UserSecureInfo, Long>
{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_secure_info (id, email, password) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void insertValuesWithCustomIds(Long id, String email, String password);
}
