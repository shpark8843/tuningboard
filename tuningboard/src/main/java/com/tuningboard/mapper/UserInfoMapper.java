package com.tuningboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tuningboard.domain.UserInfoVO;

@Mapper
public interface UserInfoMapper {

	public void register(UserInfoVO userinfo) throws Exception;
	
	public List<UserInfoVO> login(String username, String password) throws Exception;
}
