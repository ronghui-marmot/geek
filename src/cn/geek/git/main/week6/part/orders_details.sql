CREATE TABLE `orders_details` (
  `order_id` int(11) NOT NULL COMMENT '订单id',
  `order_sn` int(11) DEFAULT NULL COMMENT '订单编号',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `prod_weight` decimal(2,0) DEFAULT NULL COMMENT '商品重量',
  `prod_shares` int(11) DEFAULT NULL COMMENT '商品份数',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `order_amt` decimal(20,2) DEFAULT NULL COMMENT '订单金额',
  `shipping_amt` decimal(10,2) DEFAULT NULL COMMENT '运费金额',
  `discount_amt` decimal(20,2) DEFAULT NULL COMMENT '优惠金额',
  `shipping_comp_name` varchar(45) DEFAULT NULL COMMENT '快递公司名字',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';
