package com.findeng.hibernate.daoimpl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.dao.RedisDao;
import com.findeng.hibernate.entity.User;
import com.findeng.util.CommonUtil;
import com.findeng.util.RedisUtil;

import redis.clients.jedis.Jedis;

/**
 * <p>
 * 用户缓存数据层实现类,主要作用是对缓存的操作,大数据以及持久化请不要存储到这里!
 *
 * @author bingco
 */
@Repository
public class RedisDaoImpl implements RedisDao {

    /**
     * 保存会话信息
     *
     * @param session
     * @param user
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public String setSession(HttpSession session, User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            String token = CommonUtil.EncrypMD5Util(user.getOpenId()).toUpperCase();
            Jedis jedis = RedisUtil.getJedis();
            jedis.hset(token, session.getId(), new JSONObject(user).toString());
            return token;
        } finally {
            RedisUtil.close();
        }
    }

    /**
     * 获取用户会话信息
     *
     * @param token
     * @param session
     */
    public JSONObject getUser(String token, HttpSession session) {
        // TODO Auto-generated method stub
        try {
            Jedis jedis = RedisUtil.getJedis();
            String json = jedis.hget(token, session.getId());
            return new JSONObject(json);
        } finally {
            RedisUtil.close();
        }
    }
}
