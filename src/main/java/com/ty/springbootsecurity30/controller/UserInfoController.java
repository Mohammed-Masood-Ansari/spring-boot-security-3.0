package com.ty.springbootsecurity30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springbootsecurity30.dto.UserInfo;
import com.ty.springbootsecurity30.service.UserInfoService;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

	@Autowired
	private UserInfoService infoService;
	
	/*
	 * save UserPassword
	 */
	@PostMapping("/saveUserInfo")
	public ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo info) {
		
		return infoService.saveUserInfo(info);
	}
}
