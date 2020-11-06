package com.hush.web.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Stopwatch;
import com.hush.web.constant.RoleTypeEnum;
import com.hush.web.dto.UserRoleDTO.*;
import com.hush.web.dto.mapper.UserRoleMapper;
import com.hush.web.mybatis.mapper.UserRoleDAO;
import com.hush.web.mybatis.model.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hush.web.dto.PageDTO;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author huangshuai
 * @date 2020-09-16
 */
@Slf4j
@Service
public class UserRoleService {



    @Autowired
    private UserRoleDAO userRoleDAO;


    public UserRole selectByPrimaryKey(Integer id) {
        return userRoleDAO.selectByPrimaryKey(id);
    }

    public List<UserRole> selectByUserEmail(String email){
        return userRoleDAO.selectByUserEmail(email);
    }

    public void insertUserRole(UserRoleAddVO userRoleAddVO) {
        log.info("【新增用户】  userRoleAddVO:{}", JSON.toJSONString(userRoleAddVO));
        UserRole userRole = UserRoleMapper.INSTANCE.toUserRole(userRoleAddVO);
        userRoleDAO.insertSelective(userRole);
    }

    public void updateUserRole(UserRoleUpdateVO userRoleUpdateVO) {
        log.info("【修改用户】  userRoleUpdateVO:{}", JSON.toJSONString(userRoleUpdateVO));
        UserRole userRole = UserRoleMapper.INSTANCE.toUserRole(userRoleUpdateVO);
        userRoleDAO.updateByPrimaryKeySelective(userRole);
    }

    public void deleteUserRoleById(Integer id) {
        log.info("【删除用户】 id:{}", id);
        userRoleDAO.deleteByIdLogical(id);
        log.info("【删除用户】 success, id:{}", id);
    }

    public PageInfo<UserRoleListVO> selectUserRoleByPage(UserRoleParamVO queryVO, PageDTO.PageVO pageVO) {
        log.info("【查询用户列表】 queryVO:{}", JSON.toJSONString(queryVO));
        Stopwatch stopwatch = Stopwatch.createStarted();
        Page page = PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        userRoleDAO.selectUserRoleByPage(queryVO);
        List<UserRoleListVO> list = page.getResult();
        list.parallelStream().forEach(e -> {
            e.setRoleIdDesc(RoleTypeEnum.getStatusByCode(e.getRoleId()));
        });
        log.info("【查询用户列表】结束， 耗时：{}毫秒", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        return new PageInfo<>(list);
    }
}
