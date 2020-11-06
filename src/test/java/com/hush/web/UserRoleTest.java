package com.hush.web;

import com.hush.web.mybatis.model.UserRole;
import com.hush.web.service.UserRoleService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: huangshuai
 * @Date: 2020-11-06
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleTest {


    public static int statu = 0;


    @BeforeClass
    public static void beforeClass() {
        statu = 1;
    }

    @AfterClass
    public static void afterClass() {
        statu = 5;
    }


    @Before
    public void before() {
        System.out.println("statu:"+statu);
        statu = 2;
        System.out.println("before + statu:"+statu);
    }


    @After
    public void after() {
        System.out.println("statu:"+statu);
        statu = 4;
        System.out.println("after+ statu:"+statu);
    }

    @Autowired
    private UserRoleService userRoleService;


    @Test
    public void userRoleTest() {
        System.out.println("statu:"+statu);
        UserRole userRole = userRoleService.selectByPrimaryKey(1);
        System.out.println(userRole);

    }
}
