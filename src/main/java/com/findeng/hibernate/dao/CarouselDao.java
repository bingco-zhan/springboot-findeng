package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.Carousel;

/**
 * 手机商城轮播图dao层
 *
 * @author Alien
 */
@Repository
public interface CarouselDao extends JpaRepository<Carousel, Integer> {

}
