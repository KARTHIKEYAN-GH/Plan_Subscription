package com.plansubscription.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "purchase_subscription")
@Entity
public class PurchaseSubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pax_head_Uuid", referencedColumnName = "uuid", updatable = false)
	private PaxUser paxHeadUuid;

	@ManyToOne
	@JoinColumn(name = "plan_name", referencedColumnName = "uuid", updatable = false)
	private Plans plan;

	private boolean recurring;

	@Column(nullable = false)
	private boolean paid;

	@Column(name = "is_active")
	private boolean isActive;

	@Version
	private int version;
	
	@CreatedDate
	@Column(name="purchase_at",nullable = false, updatable = false)
	private LocalDateTime createdAt;

	/**
	 * To identify the time of updatedAt
	 */
	@LastModifiedDate
	@Column(name="updated_at",nullable = false)
	private LocalDateTime updatedAt;
	
	/**
	 * To identify the ,who created the category
	 */
	@CreatedBy
	@Column(name = "created_by")
	private String createdBY;
	
	/**
	 * To identify the ,who updates the category(ADMIN or TRAINEE)
	 */
	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;


}
