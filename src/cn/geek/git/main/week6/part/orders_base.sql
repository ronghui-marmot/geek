CREATE TABLE `orders_base` (
  `order_id` int(11) NOT NULL COMMENT '订单id',
  `order_sn` int(11) DEFAULT NULL COMMENT '订单编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(45) DEFAULT NULL COMMENT '收货人姓名',
  `receiver_addr` varchar(45) DEFAULT NULL COMMENT '收货地址',
  `pay_amt` int(11) DEFAULT NULL COMMENT '支付金额',
  `pay_method` varchar(1) DEFAULT NULL COMMENT '支付方式',
  `order_time` datetime DEFAULT NULL COMMENT '订单时间',
  `shipping_sn` int(11) DEFAULT NULL COMMENT '快递单号',
  `shipping_amt` int(11) DEFAULT NULL COMMENT '运费金额',
  `status` varchar(1) DEFAULT NULL COMMENT '订单状态',
  `order_points` int(11) DEFAULT NULL COMMENT '订单积分',
  `invoice_title` varchar(45) DEFAULT NULL COMMENT '发票抬头',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
