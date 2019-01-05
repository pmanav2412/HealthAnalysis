package com.example.demo.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
 //User findbyusername(String username);
 //User findbyUser(String username);
	public User findByUsernameAndPassword(String username,String password);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u set u.registeredevent = ?1 where u.username = ?2")
	 public void setUserInfoById(String re,String r1);
	//public User findRole(String username);
	
	@Modifying
	@Transactional	
	@Query("Update User u set u.coin=?1 where u.username=?2")
	public void setUserCoinById(int r1,String r2);
	
	
	public User findByUsername(String username);
}
