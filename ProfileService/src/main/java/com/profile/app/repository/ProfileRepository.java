package com.profile.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profile.app.model.UserProfile;



@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, Integer>{

	List<UserProfile> findByMobileNo(Long mobileNo);
	
	List<UserProfile> findByEmail(String email);

	UserProfile findByUserName(String userName); 

	

}
