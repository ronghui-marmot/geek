CREATE TABLE `pay_info` (
  `pay_id` int(11) NOT NULL COMMENT '支付id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `pay_method` varchar(5) DEFAULT NULL COMMENT '支付方式',
  `pay_account` varchar(45) DEFAULT NULL COMMENT '支付账号',
  `default_flag` varchar(1) DEFAULT NULL COMMENT '是否默认',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付信息表';
