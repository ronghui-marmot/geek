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
