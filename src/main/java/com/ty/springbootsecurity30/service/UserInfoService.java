package com.ty.springbootsecurity30.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ty.springbootsecurity30.dao.UserInfoDao;
import com.ty.springbootsecurity30.dto.UserInfo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * save UserPassword
	 */
	public ResponseEntity<UserInfo> saveUserInfo(UserInfo info) {
		
		info.setUserPassword(passwordEncoder.encode(info.getUserPassword()));
		userInfoDao.saveUserInfo(info);
		
		return new ResponseEntity<UserInfo>(HttpStatusCode.valueOf(200));
	}
}
