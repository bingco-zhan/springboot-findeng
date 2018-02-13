package com.findeng.util;

import javax.servlet.http.Cookie;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis缓存工具类
 *
 * @author bingc
 */
public class RedisUtil {

    private static String Ip = "127.0.0.1";
    private static Integer Port = 6379;
    private static Integer MaxTotal = 500;
    private static Integer MaxIdle = 5;
    private static Integer MaxWaitMillis = 1000 * 100;

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MaxTotal);
        config.setMaxIdle(MaxIdle);
        config.setMaxWaitMillis(MaxWaitMillis);
        jedisPool = new JedisPool(config, Ip, Port);
    }

    private final static ThreadLocal<Jedis> threadLocal = new ThreadLocal<>();

    /**
     * <p>获取redis池对象,如果没有reids池没有成功创建抛出 无法创建连接池
     *
     * @return
     */
    public static JedisPool getJedisPool() {
        if (jedisPool != null) return jedisPool;

        else throw new RuntimeException("JedisPool did not Created !!!");
    }

    /**
     * <p>获取redis对象,如果没有reids池没有成功创建抛出 无法创建连接池，如果池中没有可用连接则抛出无法获取jedis
     *
     * @return
     */
    public static Jedis getJedis() {
        Jedis jedis = threadLocal.get();
        if (jedis == null) {
            jedis = getJedisPool().getResource();
            threadLocal.set(jedis);
        }
        if (jedis != null) return jedis;

        else throw new RuntimeException("Jedis is unable to getting !!!");
    }

    /**
     * 释放资源
     *
     * @param jedis
     */
    public static void close() {
        Jedis jedis = threadLocal.get();
        if (jedis != null) {
            jedis.close();
            threadLocal.remove();
        }
    }

    public static String getCookieValue(Cookie[] cookies, String key) {
        String value = null;
        if (cookies != null && key != null && key.trim().length() > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(key)) return cookie.getValue();
            }
        }
        return value;
    }
}
