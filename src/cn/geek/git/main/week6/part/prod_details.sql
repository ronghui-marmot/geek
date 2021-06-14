CREATE TABLE `prod_details` (
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '重量',
  `lenght` decimal(10,2) DEFAULT NULL COMMENT '长度',
  `width` decimal(10,2) DEFAULT NULL COMMENT '宽度',
  `height` decimal(10,2) DEFAULT NULL COMMENT '高度',
  `color` varchar(5) DEFAULT NULL COMMENT '颜色',
  `bar_code` varchar(45) DEFAULT NULL COMMENT '条码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情表';
