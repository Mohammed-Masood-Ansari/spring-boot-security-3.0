package com.ty.springbootsecurity30.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springbootsecurity30.dto.UserInfo;
import com.ty.springbootsecurity30.repository.UserRepository;

@Repository
public class UserInfoDao {

	@Autowired
	private UserRepository repository;
	
	/*
	 * save UserPassword
	 */
	public UserInfo saveUserInfo(UserInfo info) {
		
		return repository.save(info);
	}
	
}
