package com.tuningboard.service;

import com.tuningboard.domain.UserInfo;

public interface UserInfoService {
	
	 public UserInfo findByEmail(String email);

	 public void save(UserInfo userinfo);
}