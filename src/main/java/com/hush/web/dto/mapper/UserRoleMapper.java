package com.hush.web.dto.mapper;

import com.hush.web.dto.UserRoleDTO;
import com.hush.web.mybatis.model.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author zheyangzhang
 * @date 2019-12-16
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRoleMapper {

    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    UserRole toUserRole(UserRoleDTO.UserRoleAddVO userRoleAddVO);

    UserRole toUserRole(UserRoleDTO.UserRoleUpdateVO userRoleUpdateVO);

}
