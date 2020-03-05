package com.tuningboard.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tuningboard.domain.Role;
import com.tuningboard.domain.UserInfo;
import com.tuningboard.repository.RoleRepository;
import com.tuningboard.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {
 
 @Autowired
 private UserInfoRepository userinfoepository;
 
 @Autowired
 private RoleRepository rolerespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public UserInfo findByEmail(String email) {
  return userinfoepository.findByEmail(email);
 }

 @Override
 @Transactional
 public void save(UserInfo userinfo) {
  userinfo.setPassword(bCryptPasswordEncoder.encode(userinfo.getPassword()));
  userinfo.setActive(1);
  Role userRole = rolerespository.findByRole("ADMIN");
  userinfo.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userinfoepository.save(userinfo);
 }

}
