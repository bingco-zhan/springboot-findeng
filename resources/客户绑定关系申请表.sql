#更新用户表数据 ----->>
update user u1 set u1.lower_count = (select t1.cnt from (select upper_user_id,count(1) as cnt from user group by upper_user_id) t1 where u1.user_id = t1.upper_user_id)
update user set lower_count = 0 where lower_count is null
#<<---------------

CREATE TABLE `customer_binding` (
  `id` int(11) NOT NULL COMMENT auto_increment '主键',
  `Apply_id` int(11) DEFAULT NULL COMMENT '申请人ID 对应 user表ID',
  `unbundling_id` int(11) DEFAULT NULL COMMENT '解绑ID 对应 user表ID',
  `status` int(1) DEFAULT NULL COMMENT '状态 0未审核 1审核失败 2审核成功',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;