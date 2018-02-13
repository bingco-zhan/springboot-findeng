package com.findeng.hibernate.dao;

import java.util.List;

/**
 * 执行原生语句接口
 *
 * @author Alien
 */
@SuppressWarnings("rawtypes")
public interface NativeDao<T> {
    //基于原生sql进行查询
    public List<?> executeSQL(String sql);

    //基于原生sql进行查询
    List<T> executeSQL(String sql, Class entityClass);

    //基于hql进行查询
    List<T> executeHQL(String hql, Class entityClass);
}
