package com.hush.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zheyangzhang
 * @date 2019-12-16
 */
public class UserRoleDTO {

    @Data
    public static class UserRoleBaseOperateVO implements Serializable {

        private static final long serialVersionUID = -6229847191521849106L;

        /**
         * 角色ID: 1 管理员 2 产品 3 开发
         */
        @ApiModelProperty(value = "用户角色", required = true, dataType = "Integer")
        private Integer roleId;

        /**
         * 用户邮箱
         */
        @Email
        @ApiModelProperty(value = "用户邮箱", required = true, dataType = "String")
        private String userEmail;

        /**
         * 用户姓名
         */
        @ApiModelProperty(value = "用户姓名", required = true, dataType = "String")
        private String userName;

    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class UserRoleAddVO extends UserRoleBaseOperateVO {
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class UserRoleUpdateVO extends UserRoleBaseOperateVO {
        @ApiModelProperty(value = "自增id", dataType = "Integer")
        @NotNull(message = "自增ID不能为空")
        private Integer id;

    }

    @Data
    public static class UserRoleQueryVO implements Serializable {
        private static final long serialVersionUID = -1460368728016517774L;

        @ApiModelProperty(value = "用户角色", required = true, dataType = "Integer")
        @NotNull(message = "角色id不能为空")
        private Integer roleId;

        @ApiModelProperty(value = "用户邮箱", required = true, dataType = "String")
        @NotBlank(message = "用户邮箱不能为空")
        private String userEmail;
    }

    @Data
    public static class UserRoleParamVO implements Serializable {
        private static final long serialVersionUID = 7252200757018464482L;
        private Integer roleId;
        private String userEmail;
        private String userName;
    }

    @Data
    public static class UserRoleListVO {
        private Integer id;
        private Integer roleId;
        private String roleIdDesc;
        private String userEmail;
        private String userName;
        private Date createTime;
        private Date updateTime;
    }


    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class Menus {
        private Integer id;
        private Integer parentId;
        private String name;
        private String comment;
        List<Menus> Menus;
    }
}
