package com.hush.web.controller;

import com.github.pagehelper.PageInfo;
import com.hush.web.dto.PageDTO.PageVO;
import com.hush.web.dto.UserRoleDTO.*;
import com.hush.web.mybatis.model.UserRole;
import com.hush.web.service.UserRoleService;
import com.hush.web.utils.ResultInfo;
import com.hush.web.utils.ResultInfoGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: huangshuai
 * @Date: 2020-09-16
 * @Version 1.0
 */
@RestController
@RequestMapping("userRole")
@Api(value = "UserRoleController", tags = "用户管理")
public class UserRoleController {


    @Autowired
    private UserRoleService userRoleService;


    @GetMapping("v1.0/{id}")
    @ApiOperation(value = "获取某个用户信息")
    @ApiImplicitParam(name = "id", value = "自增id", paramType = "path", required = true)
    public ResultInfo<UserRole> getUserRoleById(@PathVariable Integer id) {
        return ResultInfoGenerator.ok(userRoleService.selectByPrimaryKey(id));
    }


    @PostMapping("v1.0/addUser")
    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "userRoleAddVO", value = "新增用户信息", required = true, dataType = "UserRoleAddVO")
    public ResultInfo<String> addUser(@Valid @RequestBody UserRoleAddVO userRoleAddVO) {
        userRoleService.insertUserRole(userRoleAddVO);
        return ResultInfoGenerator.ok("新增用户成功");
    }

    @PutMapping("v1.0/updateUser")
    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "userRoleUpdateVO", value = "更新用户信息", required = true, dataType = "UserRoleUpdateVO")
    public ResultInfo<String> updateUserRole(@Valid @RequestBody UserRoleUpdateVO userRoleUpdateVO) {
        userRoleService.updateUserRole(userRoleUpdateVO);
        return ResultInfoGenerator.ok("更新用户信息成功");
    }

    @PostMapping("v1.0/deleteUser")
    @ApiOperation(value = "通过id删除用户")
    @ApiImplicitParam(name = "id", value = "自增id", paramType = "query", required = true)
    public ResultInfo<String> deleteUserRoleById(@RequestParam(value = "id") Integer id) {
        userRoleService.deleteUserRoleById(id);
        return ResultInfoGenerator.ok("删除用户成功");
    }

    @PostMapping("v1.0/search")
    @ApiOperation(value = "分页查询用户角色")
    public ResultInfo<PageInfo<UserRoleListVO>> selectUserRoleByPage(@ApiParam(type = "form") UserRoleParamVO queryVO,
                                                                     @ApiParam(type = "form") PageVO pageVO) {
        return ResultInfoGenerator.ok(userRoleService.selectUserRoleByPage(queryVO, pageVO));
    }

}
