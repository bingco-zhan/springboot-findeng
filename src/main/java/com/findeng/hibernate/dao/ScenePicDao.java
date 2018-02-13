package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.ScenePic;

/**
 * 配灯系统场景图表Dao
 *
 * @author Alien
 */
@Repository
public interface ScenePicDao extends JpaRepository<ScenePic, Integer> {

}
