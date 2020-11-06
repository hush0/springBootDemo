CREATE TABLE IF NOT EXISTS `tb_user_role`
(
    `id`          INT(11)      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `role_id`     TINYINT(4)   NOT NULL DEFAULT '1' COMMENT '角色ID: 1 管理员 2 产品 3 开发',
    `user_email`  VARCHAR(100) NOT NULL DEFAULT '' COMMENT '用户邮箱',
    `user_name`   VARCHAR(100) NOT NULL DEFAULT '' COMMENT '用户姓名',
    `is_valid`    TINYINT(4)   NOT NULL DEFAULT '1' COMMENT '是否有效: 0 无效 1 有效',
    `create_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_role` (`user_email`, `role_id`)
) ENGINE = INNODB  DEFAULT CHARSET = utf8 COMMENT='dem_用户角色表';




INSERT INTO `decontroler_dev`.`tb_user_role`(`id`, `role_id`, `user_email`, `user_name`, `is_valid`, `create_time`, `update_time`) VALUES (1, 1, 'zheyangzhang@qq.com', 'zheyangzhang', 1, '2019-12-16 20:22:05', '2019-12-27 17:10:00');
INSERT INTO `decontroler_dev`.`tb_user_role`(`id`, `role_id`, `user_email`, `user_name`, `is_valid`, `create_time`, `update_time`) VALUES (2, 1, 'abczzz@qq.com', 'test-name', 0, '2019-12-20 15:43:16', '2019-12-20 15:43:16');
INSERT INTO `decontroler_dev`.`tb_user_role`(`id`, `role_id`, `user_email`, `user_name`, `is_valid`, `create_time`, `update_time`) VALUES (4, 2, 'zzy@qq.com', 'update', 1, '2019-12-20 15:49:03', '2019-12-23 15:02:22');
INSERT INTO `decontroler_dev`.`tb_user_role`(`id`, `role_id`, `user_email`, `user_name`, `is_valid`, `create_time`, `update_time`) VALUES (5, 1, 'abczz@qq.com', 'test-name', 1, '2019-12-20 15:55:17', '2019-12-20 15:55:17');
INSERT INTO `decontroler_dev`.`tb_user_role`(`id`, `role_id`, `user_email`, `user_name`, `is_valid`, `create_time`, `update_time`) VALUES (6, 1, 'test@qq.com', 'test-2', 0, '2019-12-23 11:09:01', '2019-12-23 15:12:28');