CREATE TABLE `address_info` (
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `postcode` varchar(10) DEFAULT NULL COMMENT '邮编',
  `province` varchar(45) DEFAULT NULL COMMENT '省',
  `city` varchar(45) DEFAULT NULL COMMENT '市',
  `region` varchar(45) DEFAULT NULL COMMENT '区',
  `address` varchar(45) DEFAULT NULL COMMENT '具体到门牌号',
  `default_flag` varchar(1) DEFAULT NULL COMMENT '是否默认',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `address_id_UNIQUE` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址信息表';
