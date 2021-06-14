CREATE TABLE `sys_dict` (
  `dict_id` int(11) NOT NULL COMMENT '字典id',
  `dict_key` varchar(20) DEFAULT NULL COMMENT '字典键',
  `dict_value` varchar(45) DEFAULT NULL COMMENT '字典值',
  `dict_name` varchar(45) DEFAULT NULL COMMENT '字典名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';
