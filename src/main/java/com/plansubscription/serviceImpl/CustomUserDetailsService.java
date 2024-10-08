package com.plansubscription.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plansubscription.model.AdminUser;
import com.plansubscription.repo.AdminUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private AdminUserRepo adminUserRepo; // Your repository

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserRepo.findByUserName(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(adminUser);
    }
}

