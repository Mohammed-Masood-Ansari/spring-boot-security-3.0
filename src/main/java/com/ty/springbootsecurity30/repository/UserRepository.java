package com.ty.springbootsecurity30.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springbootsecurity30.dto.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByName(String userName);
}
