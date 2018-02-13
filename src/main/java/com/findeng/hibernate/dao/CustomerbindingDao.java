package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.findeng.hibernate.entity.Customerbinding;

public interface CustomerbindingDao extends JpaRepository<Customerbinding, Integer>, JpaSpecificationExecutor<Customerbinding> {

    public Customerbinding findById(Integer id);

}
