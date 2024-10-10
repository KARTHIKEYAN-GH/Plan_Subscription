package com.plansubscription.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plansubscription.model.PaxUser;
import com.plansubscription.repo.PaxUserRepo;
import com.plansubscription.service.PaxUserService;

@Service
public class PaxUserServiceImpl implements PaxUserService{

	@Autowired 
	private PaxUserRepo paxUserRepo;
	@Override
	public PaxUser createpaxHead(PaxUser paxUser) {
		PaxUser existMobilenumber = paxUserRepo.findByPhoneNumber(paxUser.getPhoneNumber()).orElseThrow(()->  new IllegalArgumentException("Mobile number already exist"));
		paxUserRepo.findByPhoneNumber(paxUser.getPhoneNumber()).ifPresent(PaxUser->{new IllegalArgumentException("");});
	    //.ifPresent(user -> { throw new IllegalArgumentException("Mobile number already exist"); });

		Optional<PaxUser> existMail=paxUserRepo.findByEmail(paxUser.getEmail());
	    
//	    if (!oldUsers.isEmpty()) {
//	        throw new RuntimeException("User name already exists");
//	    }
	    paxUser.setName(paxUser.getName());
	    paxUser.setEmail(paxUser.getEmail());
	    paxUser.setPhoneNumber(paxUser.getPhoneNumber());
	    paxUser.setType(PaxUser.PAXTYPE.HEAD);
	    paxUser.setActive(true);
		PaxUser newPaxHead=paxUserRepo.save(paxUser);
		return newPaxHead;
		
	}
	@Override
	public PaxUser createpaxMember(PaxUser paxUser) {
		
		return null;
	}

}
