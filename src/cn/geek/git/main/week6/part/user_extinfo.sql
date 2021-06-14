CREATE TABLE `user_extinfo` (
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `province` varchar(45) DEFAULT NULL COMMENT '省',
  `city` varchar(45) DEFAULT NULL COMMENT '市',
  `region` varchar(45) DEFAULT NULL COMMENT '区',
  `postcode` int(10) DEFAULT NULL COMMENT '邮编',
  `registration_time` datetime DEFAULT NULL COMMENT '注册时间',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `lastlogin_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `user_level` varchar(1) DEFAULT NULL COMMENT '用户等级',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展信息表';
