package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.entity.UserRole;

/**
 * 用户信息表dao层
 *
 * @author Alien
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    /**
     * 通过openid查询用户
     *
     * @param openId
     * @return User
     */
    User findByopenId(String openId);

    /**
     * 通过用户编码查询用户
     *
     * @param userIdenticalCode
     * @return List<User>
     */
    List<User> findByuserIdenticalCode(String userIdenticalCode);

    /**
     * 通过手机号码查找用户
     *
     * @param phoneNumber
     * @return user实体
     */
    User findByPhoneNumber(String phoneNumber);

    User findByUserId(Integer userId);

    @Query(value = "select u.user_id,u.lamp_selection_login,u.longitude,u.latitude from user u where role in (?1)", nativeQuery = true)
    List<String[]> findUserCoordinateByRole(Integer[] roles);

    /**
     * 通过用户角色查询公司简称
     */
    @Query(value = "select u.userId,u.role,u.shortCompanyName from User as u where role in (?1)")
    List<String[]> findUserIdAndShortCompanyNameByRole(UserRole... role);
}
