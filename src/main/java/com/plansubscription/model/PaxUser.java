package com.plansubscription.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PaxUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, updatable = false)
	private String uuid= UUID.randomUUID().toString();
	
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(name="phone_number",nullable = false,unique = true)
	private String phoneNumber;
	
	public enum PAXTYPE
	{
		HEAD,MEMBER
	}
	@Enumerated(EnumType.STRING)
	private PAXTYPE type;
	
	@Column(name="head_uuid")
	private String headUuid;
	
	public enum RELATION
	{
		FATHER,MOTHER,SPOUSE,CHILD,
	}
	@Enumerated(EnumType.STRING)
	private RELATION relation;
	
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
