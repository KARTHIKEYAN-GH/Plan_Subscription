package com.plansubscription.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class AdminUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * It is an unique id for each user to identify
	 */
	@Column(nullable = false, unique = true, updatable = false)
	private String uuid = UUID.randomUUID().toString();

	/**
	 * email for communication
	 */
	@NotNull(message = "Email cannot be null")
	private String email;

	/**
	 * unique phoneNumber for each user
	 */
	@NotNull(message = "phoneNumber cannot be null")
	@Column(name="phone_number",nullable = false)
	private String phoneNumber;

	/**
	 * Unique userName for login
	 */
	@NotNull(message = "userName cannot be null")
	@Column(name="user_name",nullable = false)
	private String userName;

	/**
	 * password for login
	 */
	@NotNull(message = "password cannot be null")
	private String password;

	/**
	 * Used to represent a user is active or not
	 */
	@Column(name="is_active",nullable = false)
	private Boolean isActive;

	/**
	 * To identify the count of updated made on Users
	 */
	@Version
	private int version; // This is the version column for optimistic locking.

}
