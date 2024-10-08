package com.plansubscription.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Plans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, updatable = false)
	private String uuid = UUID.randomUUID().toString();

	@Column(name = "plan_name", unique = true)
	private String planName;

	@Column(name = "plan_cost")
	private double planCost;

	@NotNull(message = "Description cannot be null")
	@Column(columnDefinition = "TEXT")
	private String description;

	public enum PLANTYPE {
		MONTHLY(1), // Once every 1 month
		QUARTERLY(3), // Once every 3 months
		HALF_YEARLY(6), // Once every 6 months
		ANNUALLY(12); // Once every 12 months

		private int months;

		PLANTYPE(int months) {
			this.months = months;
		}
	}
	
	@Enumerated(EnumType.STRING)
	private PLANTYPE planType;

	@Column(name="is_active")
	private boolean isActive;
	
	@Version
	private int version;
	
	/**
	 * To identify the time of Creation
	 */
	@CreatedDate
	@Column(name="created_at",nullable = false, updatable = false)
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
