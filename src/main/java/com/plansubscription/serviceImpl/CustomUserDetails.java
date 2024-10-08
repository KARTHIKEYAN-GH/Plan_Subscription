package com.plansubscription.serviceImpl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.plansubscription.model.AdminUser;

public class CustomUserDetails implements UserDetails {
    private final AdminUser adminUser;

    public CustomUserDetails(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    @Override
    public String getUsername() {
        return adminUser.getUserName();
    }

    @Override
    public String getPassword() {
        return adminUser.getPassword();
    }

    // Other required methods can return default values or implement additional security checks
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Since you don't have roles
    }

    // More methods from UserDetails can be implemented as needed
}
