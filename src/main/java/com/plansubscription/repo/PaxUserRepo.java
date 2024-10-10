package com.plansubscription.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansubscription.model.PaxUser;

@Repository
public interface PaxUserRepo extends JpaRepository<PaxUser, Long>{

	List<PaxUser> findByName(String name);
	Optional<PaxUser> findByPhoneNumber(String phoneNumber);
	Optional<PaxUser> findByEmail(String email);

}
