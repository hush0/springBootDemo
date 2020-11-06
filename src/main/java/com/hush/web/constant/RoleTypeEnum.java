package com.hush.web.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 角色类型枚举
 *
 * @author zheyangzhang
 * @date 2019-12-25
 */
@Getter
@AllArgsConstructor
public enum RoleTypeEnum {
    /**
     * 管理员，拥有全部权限
     */
    ADMIN(1, "管理员"),
    /**
     * 产品经理
     */
    PRODUCT(2, "产品运营"),
    /**
     * 开发人员
     */
    DEVELOP(3, "研发"),
    /**
     * 运营只有读操作权限
     */
    NORMAL(4, "普通用户");



    Integer code;
    String status;

    public static String getStatusByCode(Integer code) {
        String label = "";
        for (RoleTypeEnum type : RoleTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                label = type.getStatus();
                break;
            }
        }
        return label;
    }
}
