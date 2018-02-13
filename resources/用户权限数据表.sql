CREATE DATABASE 

USE `findeng`;

DROP TABLE IF EXISTS `user_permission`;

CREATE TABLE `user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_des` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


insert  into `user_permission`(`id`,`permission_des`) values (1,'修改轮播图'),(2,'角色权限管理'),(3,'用户管理'),(4,'修改欢迎图'),(5,'业绩报表'),(6,'用户认证'),(7,'审批用户认证'),(8,'导购机权限'),(9,'折扣审批'),(10,'客户绑定关系'),(11,'客户解绑审批'),(12,'供应商商品管理'),(13,'供应商添加商品'),(14,'商品推广'),(15,'供应商订单列表'),(16,'库存状况'),(17,'售后服务'),(18,'财务报表'),(19,'用户报表'),(20,'用户地图'),(21,'资金流水表'),(22,'审批提现申请'),(23,'审批用户认证'),(24,'审批厂家产品'),(25,'经销商商品管理'),(26,'平台商品管理'),(27,'经销商添加商品'),(28,'平台添加商品'),(29,'经销商订单列表'),(30,'平台订单列表'),(31,'公众号数据'),(32,'商品系列管理'),(33,'平台修改商品'),(34,'供应商修改商品');

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_backstage` tinyint(4) DEFAULT NULL,
  `permissions` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


insert  into `user_role`(`id`,`login_backstage`,`permissions`,`role_name`) values (1,1,'','厂家'),(2,1,',1,2,3,4,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,','繁灯网员工'),(3,0,'','游客'),(4,1,'','经销商'),(5,0,'','消费者'),(6,1,'','未知'),(7,1,'','超级管理员'),(8,1,'','平台');
