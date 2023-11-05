package com.socialmedia.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialmedia.model.LoginModel;

@Repository
public interface LoginDao extends JpaRepository<LoginModel, UUID> {
	LoginModel findByuserId = null;

	@Query(value = "SELECT * FROM sm_login sm WHERE sm.email= ?1", nativeQuery = true)
	LoginModel findByEmail(String email);
	
	@Query(value = "select * from sm_login sm where sm.id=?1",nativeQuery = true)
	LoginModel findByuserId(String id);

}