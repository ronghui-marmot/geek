CREATE TABLE `prod_overview` (
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `product_sn` int(11) NOT NULL COMMENT '商品编号',
  `product_name` varchar(45) DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `description` varchar(200) DEFAULT NULL COMMENT '商品描述',
  `top_category` varchar(20) DEFAULT NULL COMMENT '一级分类',
  `second_category` varchar(20) DEFAULT NULL COMMENT '二级分类',
  `third_category` varchar(20) DEFAULT NULL COMMENT '三级分类',
  `manufact_date` date DEFAULT NULL COMMENT '生产日期',
  `validate_period` decimal(10,2) DEFAULT NULL COMMENT '有效期',
  `status` varchar(1) DEFAULT NULL COMMENT '商品状态',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品概览表';
