package com.plansubscription.serviceImpl;

import java.util.ArrayList;

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
        return new org.springframework.security.core.userdetails.User(
        		adminUser.getUserName(),
        		adminUser.getPassword(),
                new ArrayList<>()  // No roles or authorities
            );
    }
}

