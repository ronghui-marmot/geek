CREATE TABLE `cart_info` (
  `cart_id` int(11) NOT NULL COMMENT '购物车id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `product_shares` decimal(10,2) DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `add_time` datetime DEFAULT NULL COMMENT '加入购物车时间',
  `product_status` varchar(1) DEFAULT NULL COMMENT '商品状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车信息表';
