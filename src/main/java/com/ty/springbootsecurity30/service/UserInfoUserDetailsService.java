package com.ty.springbootsecurity30.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ty.springbootsecurity30.config.UserInfoUserDetails;
import com.ty.springbootsecurity30.dto.UserInfo;
import com.ty.springbootsecurity30.repository.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo = userRepository.findByUserName(username);
		
		/*
		 * convert userinfo to userdetails what you have created
		 */
		
		return userInfo.map(UserInfoUserDetails::new)
			.orElseThrow(()->new UsernameNotFoundException("user not found"+username));
	}

}
