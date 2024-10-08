CREATE TABLE IF NOT EXISTS admin_user(
  	id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Primary key, Auto generated for each user
    uuid VARCHAR(36) NOT NULL UNIQUE DEFAULT(UUID()), --  Unique Identifier for each user
    phone_number VARCHAR(20) NOT NULL, -- User's phone number, mandatory field
    email VARCHAR(50) NOT NULL, -- User's email, mandatory field
    user_name VARCHAR(50) BINARY NOT NULL, -- Username, case-sensitive and must be unique, mandatory field
    password VARCHAR(255) NOT NULL, -- Encrypted password for the user, mandatory field
    is_active BOOLEAN DEFAULT TRUE, -- Indicates if the user is active; defaults to TRUE (active)
	version BIGINT NOT NULL DEFAULT 0-- optimistic locking to identify the count of records changes 
);
INSERT INTO admin_user (id,uuid,phone_number, email, user_name, password) VALUES
(NULL,UUID(), '+6383804074', 'admin@gmail.com', 'Admin', '$2a$10$sRxo7sgi4elrPdboR7jucutOC6AR3yzcDG7z2zHZmvaXr1Dablr5K');