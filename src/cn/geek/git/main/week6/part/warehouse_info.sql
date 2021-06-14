CREATE TABLE `warehouse_info` (
  `warehouse_id` int(11) NOT NULL COMMENT '仓库id\n、',
  `warehouse_name` varchar(45) DEFAULT NULL COMMENT '仓库名字',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `warehouse_contacts` varchar(45) DEFAULT NULL COMMENT '仓库联系人',
  `warehouse_addr` varchar(200) DEFAULT NULL COMMENT '仓库地址',
  `status` varchar(1) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库信息表';
