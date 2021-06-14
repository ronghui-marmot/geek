CREATE TABLE `user_baseinfo` (
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `id_card` int(11) DEFAULT NULL COMMENT '证件号',
  `id_type` int(11) DEFAULT NULL COMMENT '证件类型',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户姓名',
  `login_name` varchar(45) NOT NULL COMMENT '登录名',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `status` varchar(1) DEFAULT NULL COMMENT '用户状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
