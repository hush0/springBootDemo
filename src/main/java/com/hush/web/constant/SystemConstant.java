package com.hush.web.constant;

/**
 * @Author: huangshuai
 * @Date: 2020-09-08
 * @Version 1.0
 */
public interface SystemConstant {


    /**
     * 分布式锁
     */

    Long DAY_LOCK_TIME = 86400L;

    String RULR_LOCK_NAME = "lock::hush:rule";

    String RULR_ITEM_LOCK_NAME = "lock::hush:ruleItem";

    String RULR_TRAFFIC_LOCK_NAME = "lock::hush:ruleTraffic";

    /**
     * security角色权限前缀
     */
    String ROLE_AUTH_PERFIX = "ROLE_";

}
