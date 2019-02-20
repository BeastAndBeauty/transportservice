package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Create by zoujunhao on 2019/2/1
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    @Transactional
    @Modifying
    @Query(value = "update user_info set user_role=?1 where user_name=?2", nativeQuery = true)
    Integer updateUserRole(String userRole, String userName);

    @Query(value = "SELECT user_role FROM user_info WHERE user_name=?1", nativeQuery = true)
    String selectUserRole(String userName);

    UserInfo findByUserName(String userName);

    UserInfo findByUserNameAndPassWord(String userName, String passWord);

    UserInfo findByPcardId(Long pcardId);

    UserInfo findByPtel(Long ptel);

    @Query(value = "SELECT pcard_id FROM user_info WHERE user_name=?1", nativeQuery = true)
    Long selectPcardId(String userName);
}
