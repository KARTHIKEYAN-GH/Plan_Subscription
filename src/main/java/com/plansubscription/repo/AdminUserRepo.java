package com.plansubscription.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansubscription.model.AdminUser;

@Repository
public interface AdminUserRepo extends JpaRepository<AdminUser, Long> {

	Optional<AdminUser> findByUserName(String userName);


}
