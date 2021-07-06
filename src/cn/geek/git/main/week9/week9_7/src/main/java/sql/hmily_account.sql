CREATE DATABASE IF NOT EXISTS `hmily_account1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
USE `hmily_account1`;
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(128) NOT NULL,
  `balance_rmb` decimal(10,0) NOT NULL COMMENT '用户余额(人民币)',
  `balance_usa` decimal(10,0) NOT NULL COMMENT '用户余额(美元)',
  `freeze_amount_rmb` decimal(10,0) NOT NULL COMMENT '冻结金额，扣款暂存余额(人民币)',
  `freeze_amount_usa` decimal(10,0) NOT NULL COMMENT '冻结金额，扣款暂存余额(美元)',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
insert  into `account`(`id`,`user_id`,`balance_rmb`,`balance_usa`,`freeze_amount_rmb`,`freeze_amount_usa`,`create_time`,`update_time`) values
(1,'A',0, 100,100,0,'2021-07-05 20:54:22',NULL);


CREATE DATABASE IF NOT EXISTS `hmily_account2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
USE `hmily_account2`;
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(128) NOT NULL,
  `balance_rmb` decimal(10,0) NOT NULL COMMENT '用户余额(人民币)',
  `balance_usa` decimal(10,0) NOT NULL COMMENT '用户余额(美元)',
  `freeze_amount_rmb` decimal(10,0) NOT NULL COMMENT '冻结金额，扣款暂存余额(人民币)',
  `freeze_amount_usa` decimal(10,0) NOT NULL COMMENT '冻结金额，扣款暂存余额(美元)',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
insert  into `account`(`id`,`user_id`,`balance_rmb`,`balance_usa`,`freeze_amount_rmb`,`freeze_amount_usa`,`create_time`,`update_time`) values
(1,'B',100, 100,0,0,'2021-07-05 20:54:22',NULL);