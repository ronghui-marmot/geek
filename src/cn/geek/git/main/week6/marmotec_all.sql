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

CREATE TABLE `prod_comment` (
  `comment_id` int(11) NOT NULL COMMENT '评论id',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  `comment_title` varchar(45) DEFAULT NULL COMMENT '评论标题',
  `comment_content` varchar(200) DEFAULT NULL COMMENT '评论内容',
  `status` varchar(1) DEFAULT NULL COMMENT '审核状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评论表';

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

CREATE TABLE `sys_dict` (
  `dict_id` int(11) NOT NULL COMMENT '字典id',
  `dict_key` varchar(20) DEFAULT NULL COMMENT '字典键',
  `dict_value` varchar(45) DEFAULT NULL COMMENT '字典值',
  `dict_name` varchar(45) DEFAULT NULL COMMENT '字典名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

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

CREATE TABLE `user_extinfo` (
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `province` varchar(45) DEFAULT NULL COMMENT '省',
  `city` varchar(45) DEFAULT NULL COMMENT '市',
  `region` varchar(45) DEFAULT NULL COMMENT '区',
  `postcode` int(10) DEFAULT NULL COMMENT '邮编',
  `registration_time` datetime DEFAULT NULL COMMENT '注册时间',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `lastlogin_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `user_level` varchar(1) DEFAULT NULL COMMENT '用户等级',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展信息表';

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
