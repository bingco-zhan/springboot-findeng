package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.WelcomePic;

/**
 * 欢迎图表dao层
 *
 * @author Alien
 */
@Repository
public interface WelcomePicDao extends JpaRepository<WelcomePic, Integer> {

    List<WelcomePic> findByDeleteFlag(int deleteFlag);
}
