package com.plansubscription.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plansubscription.model.Plans;


public interface PlansRepo extends JpaRepository<Plans, Long> {

}
