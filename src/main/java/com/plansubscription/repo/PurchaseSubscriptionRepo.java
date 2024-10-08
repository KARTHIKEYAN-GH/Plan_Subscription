package com.plansubscription.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plansubscription.model.PurchaseSubscription;


public interface PurchaseSubscriptionRepo extends JpaRepository<PurchaseSubscription, Long>  {

}
