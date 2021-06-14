CREATE TABLE `supplier_info` (
  `supplier_id` int(11) NOT NULL COMMENT '供应商id',
  `supplier_name` varchar(45) DEFAULT NULL COMMENT '供应商名字',
  `supplier_type` varchar(1) DEFAULT NULL COMMENT '供应商类型',
  `category` varchar(5) DEFAULT NULL COMMENT '供应商分类',
  `supplier_addr` varchar(200) DEFAULT NULL COMMENT '供应商地址',
  `phone_number` varchar(45) DEFAULT NULL COMMENT '电话号码',
  `bank_name` varchar(45) DEFAULT NULL COMMENT '开户银行名称',
  `bank_account` varchar(45) DEFAULT NULL COMMENT '银行账号',
  `status` varchar(1) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商信息表';
