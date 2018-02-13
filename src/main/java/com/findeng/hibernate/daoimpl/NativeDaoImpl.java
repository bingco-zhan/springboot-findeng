package com.findeng.hibernate.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.dao.NativeDao;

/**
 * 执行原生语句实现类
 *
 * @author Alien
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class NativeDaoImpl<T> implements NativeDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 执行原生sql语句
     *
     * @param hql 执行的语句
     */
    @Override
    public List<?> executeSQL(String sql) {
        List list = entityManager
                .createNativeQuery(sql)
                .getResultList();
        return list;
    }

    /**
     * 执行原生sql语句
     *
     * @param sql   执行的语句
     * @param clazz 返回的对象类型
     */
    @Override
    public List<T> executeSQL(String sql, Class entityClass) {
        List<T> list = entityManager
                .createNativeQuery(sql, entityClass)
                .getResultList();
        return list;
    }

    /**
     * 执行原生hql语句
     *
     * @param hql   执行的语句
     * @param clazz 返回的对象类型
     */
    @Override
    public List<T> executeHQL(String hql, Class entityClass) {
        List<T> list = entityManager
                .createQuery(hql, entityClass)
                .getResultList();
        return list;
    }

}
