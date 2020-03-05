package com.tuningboard.repository;

import com.tuningboard.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	UserInfo findByEmail(String email);
}
