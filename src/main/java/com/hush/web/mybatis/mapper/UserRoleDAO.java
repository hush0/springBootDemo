package com.hush.web.mybatis.mapper;

import com.hush.web.dto.UserRoleDTO.UserRoleListVO;
import com.hush.web.dto.UserRoleDTO.UserRoleParamVO;
import com.hush.web.mybatis.MyBatisBaseDao;
import com.hush.web.mybatis.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRoleDAO继承基类
 */
@Repository
public interface UserRoleDAO extends MyBatisBaseDao<UserRole, Integer> {

    Boolean deleteByIdLogical(Integer id);

    List<UserRole> selectByUserEmail(String userEmail);

    List<UserRoleListVO> selectUserRoleByPage(UserRoleParamVO queryVO);
}