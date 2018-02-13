package com.findeng.test;

import com.findeng.bean.TestHttpSession;
import com.findeng.mvc.mobile.controller.ShopCartController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 购物车单元测试
 * 注意:执行Test的时候,WebSocketConfig无法创建Bean,百思不得解.只好把@Bean注释掉!
 */
@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class ShopcartTest {

    @Autowired
    ShopCartController s;

    HttpSession session;

    @Before
    public void before() {
        session = new TestHttpSession();
        session.setAttribute("openId", "oHoQl0-hK5i-2dQq9icKZBoaYZJM");
    }

    @After
    public void after() {}

    /**
     * 测试添加购物车
     */
    @Test
    public void testAddShopcart() {
        System.out.println("Hello Wrold Java ! ----sdfsfsdfsdfsdfsdfsdfdfsdf--------------------------------->>>");
        System.err.println(s.addShopcart(180, 1, session));
    }

    /**
     * 测试查询购物车
     */
    @Test
    public void testFindShopcart() {
        System.out.println("Hello Wrold Java ! ----sdfsfsdfsdfsdfsdfsdfdfsdf--------------------------------->>>");
        System.err.println(s.findShopcart(session));
    }
}
