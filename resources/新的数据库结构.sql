/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.37 : Database - findengdev
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`findengdev` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `findengdev`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` char(128) NOT NULL,
  `address_name` char(128) DEFAULT NULL,
  `up_address_id` char(128) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `after_sale` */

DROP TABLE IF EXISTS `after_sale`;

CREATE TABLE `after_sale` (
  `after_sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `after_sale_status` int(11) DEFAULT NULL,
  `after_sale_user_id` int(11) DEFAULT NULL,
  `apply_time` timestamp NULL DEFAULT NULL,
  `check_time` timestamp NULL DEFAULT NULL,
  `handle_time` timestamp NULL DEFAULT NULL,
  `after_sale_pic1` varchar(128) DEFAULT NULL,
  `after_sale_pic2` varchar(128) DEFAULT NULL,
  `after_sale_pic3` varchar(128) DEFAULT NULL,
  `after_sale_description` varchar(256) DEFAULT NULL,
  `after_sale_order_item_id` int(11) DEFAULT NULL,
  `after_sale_order_item_number` int(11) DEFAULT NULL,
  `after_sale_handle_pic1` varchar(256) DEFAULT NULL,
  `after_sale_handle_description` varchar(255) DEFAULT NULL,
  `after_sale_handle_user_id` int(11) DEFAULT NULL,
  `after_sale_order_number` varchar(64) DEFAULT NULL,
  `after_sale_money` float(11,2) DEFAULT NULL,
  `suggest_wooden` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `is_repair` int(11) DEFAULT NULL,
  `after_sale_number` int(11) DEFAULT NULL,
  `after_sale_repair_name` varchar(128) DEFAULT NULL,
  `repair_receive_time` timestamp NULL DEFAULT NULL,
  `repair_receive_user_id` int(11) DEFAULT NULL,
  `after_sale_remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`after_sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=574 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `capital_flow` */

DROP TABLE IF EXISTS `capital_flow`;

CREATE TABLE `capital_flow` (
  `capital_flow_id` varchar(32) NOT NULL,
  `order_number` varchar(256) DEFAULT NULL,
  `capital_flow_type` int(11) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `settlement_status` int(11) DEFAULT NULL,
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `settle_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`capital_flow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `carousel` */

DROP TABLE IF EXISTS `carousel`;

CREATE TABLE `carousel` (
  `carousel_id` int(11) NOT NULL AUTO_INCREMENT,
  `carousel_link` varchar(256) DEFAULT NULL,
  `carousel_pic` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`carousel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `case_show` */

DROP TABLE IF EXISTS `case_show`;

CREATE TABLE `case_show` (
  `case_show_id` int(11) NOT NULL AUTO_INCREMENT,
  `case_show_description` varchar(256) DEFAULT NULL,
  `case_show_pic` longtext,
  `case_show_status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`case_show_id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `certification_application` */

DROP TABLE IF EXISTS `certification_application`;

CREATE TABLE `certification_application` (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `company_name` varchar(64) DEFAULT NULL,
  `legal_person` varchar(64) DEFAULT NULL,
  `lp_idcard_front_pic` varchar(256) DEFAULT NULL,
  `lp_idcard_back_pic` varchar(256) DEFAULT NULL,
  `lp_handheld_idcard_pic` varchar(256) DEFAULT NULL,
  `business_licence_number` varchar(128) DEFAULT NULL,
  `business_licence_pic` varchar(256) DEFAULT NULL,
  `contact` varchar(128) DEFAULT NULL,
  `logo_pic` varchar(256) DEFAULT NULL,
  `submit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `check_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `check_status` int(11) DEFAULT NULL,
  `province_id` varchar(32) DEFAULT NULL,
  `city_id` varchar(32) DEFAULT NULL,
  `area_id` varchar(32) DEFAULT NULL,
  `company_address_detail` varchar(256) DEFAULT NULL,
  `salesman_work_certify` varchar(256) DEFAULT NULL,
  `jcv` varchar(256) DEFAULT NULL,
  `short_company_name` varchar(64) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3217 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `custom_classify` */

DROP TABLE IF EXISTS `custom_classify`;

CREATE TABLE `custom_classify` (
  `custom_classify_id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_classify_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  `have_product` int(11) DEFAULT NULL,
  PRIMARY KEY (`custom_classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `custom_product` */

DROP TABLE IF EXISTS `custom_product`;

CREATE TABLE `custom_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_name` varchar(128) DEFAULT NULL,
  `product_content` longtext,
  `unit_price` float(11,2) DEFAULT NULL,
  `product_style` int(11) DEFAULT NULL,
  `product_color` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `product_length` float(11,2) DEFAULT NULL,
  `product_width` float(11,2) DEFAULT NULL,
  `product_height` float(11,2) DEFAULT NULL,
  `product_diameter` float(11,2) DEFAULT NULL,
  `product_trompil` float(11,2) DEFAULT NULL,
  `product_weight` float(11,2) DEFAULT NULL,
  `product_material` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `product_space` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `light_type` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `light_number` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `product_kind` int(11) DEFAULT NULL,
  `product_sales` int(11) DEFAULT NULL,
  `cover` longtext,
  `description_pic` longtext,
  `creat_time` timestamp NULL DEFAULT NULL,
  `is_popular` int(1) DEFAULT NULL,
  `product_qrCode_pic` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `online_time` timestamp NULL DEFAULT NULL,
  `product_status` int(11) DEFAULT NULL,
  `product_series_id` int(11) DEFAULT NULL,
  `series_index` int(11) DEFAULT NULL,
  `series_head` int(11) DEFAULT NULL,
  `purchase_quantity` int(11) DEFAULT NULL,
  `product_head_type` int(11) DEFAULT NULL,
  `product_visit_count` int(11) DEFAULT NULL,
  `product_report_pic` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `product_plies` int(11) DEFAULT NULL,
  `product_shape` int(11) DEFAULT NULL,
  `cost_price` float(11,2) DEFAULT NULL,
  `product_tag` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `is_spread_product` int(11) DEFAULT NULL,
  `product_power` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `product_code` varchar(64) DEFAULT NULL,
  `product_type` int(11) DEFAULT NULL,
  `product_classify` int(11) DEFAULT NULL,
  `product_png_pic` varchar(256) DEFAULT NULL,
  `product_spread_pic` varchar(256) DEFAULT NULL,
  `three_c_certification` varchar(256) DEFAULT NULL,
  `product_stock` int(11) DEFAULT NULL,
  `has_light_source` int(11) DEFAULT NULL,
  `quality_guarantee_time` varchar(255) DEFAULT NULL,
  `product_qr_code_pic` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=342 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `discount_application` */

DROP TABLE IF EXISTS `discount_application`;

CREATE TABLE `discount_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `creat_time` timestamp NULL DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `check_time` timestamp NULL DEFAULT NULL,
  `welcome_title` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=291 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `favorite` */

DROP TABLE IF EXISTS `favorite`;

CREATE TABLE `favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `has_flag` int(1) DEFAULT NULL,
  `user_demand` int(11) DEFAULT NULL,
  `delivery_day` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `task_send_msg_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1028 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Table structure for table `freeback` */

DROP TABLE IF EXISTS `freeback`;

CREATE TABLE `freeback` (
  `freeback_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_way` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `opinion` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `submit_time` timestamp NULL DEFAULT NULL,
  `user_nickname` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `read_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`freeback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=371 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `information_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `info_content` longtext,
  `info_type` int(11) DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL,
  `read_flag` int(11) DEFAULT NULL,
  `media_id` varchar(256) DEFAULT NULL,
  `voice_upload_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`information_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30090 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `logistics_company` */

DROP TABLE IF EXISTS `logistics_company`;

CREATE TABLE `logistics_company` (
  `logistics_company_name` varchar(32) DEFAULT NULL,
  `logistics_company_code` varchar(64) NOT NULL DEFAULT '',
  `logistics_first_char` varchar(2) DEFAULT NULL,
  `logistics_phone_number` varchar(256) DEFAULT NULL,
  `logistics_website` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`logistics_company_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `logistics_map` */

DROP TABLE IF EXISTS `logistics_map`;

CREATE TABLE `logistics_map` (
  `logistics_map_id` int(11) NOT NULL AUTO_INCREMENT,
  `logistics_company` varchar(256) DEFAULT NULL,
  `logistics_park` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`logistics_map_id`)
) ENGINE=InnoDB AUTO_INCREMENT=553 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `order_form` */

DROP TABLE IF EXISTS `order_form`;

CREATE TABLE `order_form` (
  `order_number` varchar(32) NOT NULL,
  `wechat_pay_id` varchar(32) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `order_money` float(11,2) DEFAULT NULL,
  `order_service_money` float(11,2) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `receive_person` varchar(128) DEFAULT NULL,
  `receive_phone` varchar(128) DEFAULT NULL,
  `receive_province` varchar(128) DEFAULT NULL,
  `receive_city` varchar(32) DEFAULT NULL,
  `receive_area` varchar(32) DEFAULT NULL,
  `receive_address` varchar(256) DEFAULT NULL,
  `logistics_company_code` varchar(64) DEFAULT NULL,
  `transport_number` varchar(64) DEFAULT NULL,
  `order_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pay_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `send_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `receive_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `service_time` timestamp NULL DEFAULT NULL,
  `complete_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `if_happen_return` int(11) DEFAULT NULL,
  `if_happen_refund` int(11) DEFAULT NULL,
  `refund_return_pending_num` int(11) DEFAULT NULL,
  `facilitator_id` int(11) DEFAULT NULL,
  `is_install` int(11) DEFAULT NULL,
  `order_install_money` float(10,2) DEFAULT NULL,
  `order_service_status` int(11) DEFAULT NULL,
  `order_install_person` varchar(128) DEFAULT NULL,
  `order_install_person_contact` varchar(128) DEFAULT NULL,
  `order_real_money` float(11,2) DEFAULT NULL,
  `transport_type` int(11) DEFAULT NULL,
  `recommend_logistics` varchar(128) DEFAULT NULL,
  `up_user_id` int(11) DEFAULT NULL,
  `up_up_user_id` int(11) DEFAULT NULL,
  `transport_phone_number` varchar(64) DEFAULT NULL,
  `to_platform` int(11) DEFAULT NULL,
  `order_freight` float(11,2) DEFAULT NULL,
  `factory_send_flag` int(11) DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  `prepare_send_flag` int(11) DEFAULT NULL,
  `order_logistics_pic` varchar(256) DEFAULT NULL,
  `send_flag` int(11) DEFAULT NULL,
  `stocked_flag` int(11) DEFAULT NULL,
  `stocked_complete` int(11) DEFAULT NULL,
  `order_remark` varchar(256) DEFAULT NULL,
  `logistics_park` varchar(256) DEFAULT NULL,
  `factory_send_time` timestamp NULL DEFAULT NULL,
  `really_receive_flag` int(11) DEFAULT NULL,
  `order_wooden_fee` float(11,2) DEFAULT NULL,
  `settlement_method` int(11) DEFAULT NULL COMMENT '结算方式:1为现金结算',
  PRIMARY KEY (`order_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `order_item` */

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
  `order_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(32) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `order_item_price` float(10,2) DEFAULT NULL,
  `order_item_number` int(11) DEFAULT NULL,
  `refund_status` int(11) DEFAULT NULL,
  `return_status` int(11) DEFAULT NULL,
  `refund_id` int(11) DEFAULT NULL,
  `return_id` int(11) DEFAULT NULL,
  `order_item_commision` float(10,2) DEFAULT NULL,
  `order_item_freight` float(10,2) DEFAULT NULL,
  `order_item_service_fee` float(10,2) DEFAULT NULL,
  `order_item_install_fee` float(10,2) DEFAULT NULL,
  `platform_percent` float(11,4) DEFAULT NULL,
  `spread_percent` float(11,4) DEFAULT NULL,
  `order_item_origin_price` float(11,2) DEFAULT NULL,
  `receive_address` int(11) DEFAULT NULL,
  `have_goods_num` int(11) DEFAULT NULL,
  `consignment_time` int(11) DEFAULT NULL,
  `is_rush_order` int(11) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `send_flag` int(11) DEFAULT NULL,
  `factory_send_flag` int(11) DEFAULT NULL,
  `send_number` int(11) DEFAULT NULL,
  `factory_send_number` int(11) DEFAULT NULL,
  `perpare_send_flag` int(11) DEFAULT NULL,
  `perpare_send_number` int(11) DEFAULT NULL,
  `stocked_flag` int(11) DEFAULT NULL,
  `stocked_number` int(11) DEFAULT NULL,
  `order_item_remark` varchar(256) DEFAULT NULL,
  `receive_flag` int(11) DEFAULT NULL,
  `receive_number` int(11) DEFAULT NULL,
  `product_name` varchar(256) DEFAULT NULL,
  `wooden_fee` float(11,2) DEFAULT NULL,
  `pendding_after_sale` int(11) DEFAULT NULL,
  `spot_goods_num` int(11) DEFAULT NULL,
  `stock_reason` longtext,
  `actual_total_delivery_time` datetime DEFAULT NULL,
  `delay_remarks` varchar(255) DEFAULT NULL,
  `expect_total_delivery_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17877 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `check_time` datetime DEFAULT NULL,
  `cost_price` float DEFAULT NULL,
  `cover` longtext COLLATE utf8mb4_unicode_ci,
  `creat_time` datetime DEFAULT NULL,
  `delivery_time` int(11) DEFAULT NULL,
  `description_pic` longtext COLLATE utf8mb4_unicode_ci,
  `freight` float DEFAULT NULL,
  `has_light_source` int(11) DEFAULT NULL,
  `history_spread_product` int(11) DEFAULT NULL,
  `install_price` float DEFAULT NULL,
  `is_popular` int(11) DEFAULT NULL,
  `is_spread_product` int(11) DEFAULT NULL,
  `light_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `light_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `offline_time` datetime DEFAULT NULL,
  `online_time` datetime DEFAULT NULL,
  `origin_unit_price` float DEFAULT NULL,
  `package_height` float DEFAULT NULL,
  `package_length` float DEFAULT NULL,
  `package_weight` float DEFAULT NULL,
  `package_width` float DEFAULT NULL,
  `platform_percent` float DEFAULT NULL,
  `product_alias_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_box_number` int(11) DEFAULT NULL,
  `product_brand` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_color` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_diameter` float DEFAULT NULL,
  `product_head_type` int(11) DEFAULT NULL,
  `product_height` float DEFAULT NULL,
  `product_index` int(11) DEFAULT NULL,
  `product_kind` int(11) DEFAULT NULL,
  `product_length` float DEFAULT NULL,
  `product_material` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_other_material` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_other_space` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_plies` int(11) DEFAULT NULL,
  `product_png_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_power` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_qr_code_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_report_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_sales` int(11) DEFAULT NULL,
  `product_series_id` int(11) DEFAULT NULL,
  `product_shape` int(11) DEFAULT NULL,
  `product_size` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_space` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_spread_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_status` int(11) DEFAULT NULL,
  `product_stock` int(11) DEFAULT NULL,
  `product_style` int(11) DEFAULT NULL,
  `product_tag` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_type` int(11) DEFAULT NULL,
  `product_visit_count` int(11) DEFAULT NULL,
  `product_weight` float DEFAULT NULL,
  `product_width` float DEFAULT NULL,
  `quality_guarantee_time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `retail_price` float DEFAULT NULL,
  `series_head` int(11) DEFAULT NULL,
  `series_index` int(11) DEFAULT NULL,
  `service_price` float DEFAULT NULL,
  `shoper_spread_money` float DEFAULT NULL,
  `spread_percent` float DEFAULT NULL,
  `suggest_wooden` int(11) DEFAULT NULL,
  `three_c_certification` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `wooden_fee` float DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10202 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `product_column` */

DROP TABLE IF EXISTS `product_column`;

CREATE TABLE `product_column` (
  `product_column_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_column_name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_column_index` int(11) DEFAULT NULL,
  `product_column_delete_flag` int(11) DEFAULT NULL,
  `product_column_type` int(11) DEFAULT NULL,
  `product_column_property` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_column_property_value` longtext COLLATE utf8mb4_unicode_ci,
  `product_column_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_style_type` int(11) DEFAULT NULL,
  `product_column_url` longtext COLLATE utf8mb4_unicode_ci,
  `product_column_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`product_column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `product_old` */

DROP TABLE IF EXISTS `product_old`;

CREATE TABLE `product_old` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `product_content` varchar(64) DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `retail_price` float DEFAULT NULL,
  `product_stock` int(11) DEFAULT NULL,
  `product_code` varchar(128) DEFAULT NULL,
  `product_type` int(11) DEFAULT NULL,
  `product_style` int(11) DEFAULT NULL,
  `product_brand` varchar(128) DEFAULT NULL,
  `product_color` varchar(128) DEFAULT NULL,
  `product_length` float(11,2) DEFAULT NULL,
  `product_width` float(11,2) DEFAULT NULL,
  `product_height` float(11,2) DEFAULT NULL,
  `product_diameter` float(11,2) DEFAULT NULL,
  `product_trompil` float(11,2) DEFAULT NULL,
  `product_weight` float(11,2) DEFAULT NULL,
  `product_material` varchar(256) DEFAULT NULL,
  `product_space` varchar(256) DEFAULT NULL,
  `light_type` varchar(64) DEFAULT NULL,
  `light_number` varchar(64) DEFAULT NULL,
  `product_kind` int(11) DEFAULT NULL,
  `product_sales` int(11) DEFAULT NULL,
  `cover1` varchar(256) DEFAULT NULL,
  `cover2` varchar(256) DEFAULT NULL,
  `cover3` varchar(256) DEFAULT NULL,
  `cover4` varchar(256) DEFAULT NULL,
  `cover5` varchar(256) DEFAULT NULL,
  `description_pic1` varchar(256) DEFAULT NULL,
  `description_pic2` varchar(256) DEFAULT NULL,
  `description_pic3` varchar(256) DEFAULT NULL,
  `description_pic4` varchar(256) DEFAULT NULL,
  `description_pic5` varchar(256) DEFAULT NULL,
  `description_pic6` varchar(256) DEFAULT NULL,
  `description_pic7` varchar(256) DEFAULT NULL,
  `description_pic8` varchar(256) DEFAULT NULL,
  `description_pic9` varchar(256) DEFAULT NULL,
  `description_pic10` varchar(256) DEFAULT NULL,
  `creat_time` timestamp NULL DEFAULT NULL,
  `publish_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `check_time` timestamp NULL DEFAULT NULL,
  `is_popular` int(1) DEFAULT NULL,
  `service_price` float DEFAULT NULL,
  `shoper_spread_money` float DEFAULT NULL,
  `origin_unit_price` float(10,2) DEFAULT NULL,
  `freight` float(10,2) DEFAULT NULL,
  `product_qrCode_pic` varchar(256) DEFAULT NULL,
  `install_price` float(10,2) DEFAULT NULL,
  `offline_time` timestamp NULL DEFAULT NULL,
  `online_time` timestamp NULL DEFAULT NULL,
  `product_status` int(11) DEFAULT NULL,
  `product_series_id` int(11) DEFAULT NULL,
  `package_weight` float(11,2) DEFAULT NULL,
  `package_height` float(11,2) DEFAULT NULL,
  `package_width` float(11,2) DEFAULT NULL,
  `package_length` float(11,2) DEFAULT NULL,
  `series_index` int(11) DEFAULT NULL,
  `series_head` int(11) DEFAULT NULL,
  `product_fiction_sales` int(11) DEFAULT NULL,
  `purchase_quantity` int(11) DEFAULT NULL,
  `product_head_type` int(11) DEFAULT NULL,
  `platform_percent` float(11,4) DEFAULT NULL,
  `spread_percent` float(11,4) DEFAULT NULL,
  `receive_address` int(11) DEFAULT NULL,
  `product_visit_count` int(11) DEFAULT NULL,
  `product_report_pic` varchar(256) DEFAULT NULL,
  `delivery_time` int(11) DEFAULT NULL,
  `buy_flag` int(11) DEFAULT NULL,
  `product_plies` int(11) DEFAULT NULL,
  `product_shape` int(11) DEFAULT NULL,
  `cost_price` float(11,2) DEFAULT NULL,
  `product_tag` varchar(64) DEFAULT NULL,
  `is_spread_product` int(11) DEFAULT NULL,
  `history_spread_product` int(11) DEFAULT NULL,
  `wooden_fee` float(11,2) DEFAULT NULL,
  `suggest_wooden` int(11) DEFAULT NULL,
  `product_power` varchar(64) DEFAULT NULL,
  `product_png_pic` varchar(256) DEFAULT NULL,
  `product_size` varchar(256) DEFAULT NULL,
  `description_pic11` varchar(256) DEFAULT NULL,
  `description_pic12` varchar(256) DEFAULT NULL,
  `description_pic13` varchar(256) DEFAULT NULL,
  `description_pic14` varchar(256) DEFAULT NULL,
  `description_pic15` varchar(256) DEFAULT NULL,
  `description_pic16` varchar(256) DEFAULT NULL,
  `description_pic17` varchar(256) DEFAULT NULL,
  `description_pic18` varchar(256) DEFAULT NULL,
  `description_pic19` varchar(256) DEFAULT NULL,
  `description_pic20` varchar(256) DEFAULT NULL,
  `three_c_certification` varchar(256) DEFAULT NULL,
  `product_box_number` int(11) DEFAULT NULL,
  `product_other_material` varchar(256) DEFAULT NULL,
  `product_other_space` varchar(256) DEFAULT NULL,
  `product_alias_name` varchar(256) DEFAULT NULL,
  `has_light_source` int(11) DEFAULT NULL,
  `product_spread_pic` varchar(256) DEFAULT NULL,
  `quality_guarantee_time` varchar(64) DEFAULT NULL,
  `product_index` int(11) DEFAULT NULL,
  `product_qr_code_pic` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10201 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `product_spread_record` */

DROP TABLE IF EXISTS `product_spread_record`;

CREATE TABLE `product_spread_record` (
  `product_spread_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_spread_record_time` timestamp NULL DEFAULT NULL,
  `product_spread_id_list` varchar(256) DEFAULT NULL,
  `product_spread_pic` varchar(256) DEFAULT NULL,
  `product_spread_text` varchar(128) DEFAULT NULL,
  `product_spread_text1` varchar(128) DEFAULT NULL,
  `product_spread_title` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`product_spread_record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `property_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(64) DEFAULT NULL,
  `is_required` int(11) DEFAULT NULL,
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Table structure for table `property_value` */

DROP TABLE IF EXISTS `property_value`;

CREATE TABLE `property_value` (
  `property_value_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_id` int(11) DEFAULT NULL,
  `property_value` varchar(128) DEFAULT NULL,
  `is_digital` int(11) DEFAULT NULL,
  `property_desc` varchar(128) DEFAULT NULL,
  `p_index` int(11) DEFAULT NULL,
  `have_product` int(11) DEFAULT NULL,
  PRIMARY KEY (`property_value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=686 DEFAULT CHARSET=utf8;

/*Table structure for table `receive_address` */

DROP TABLE IF EXISTS `receive_address`;

CREATE TABLE `receive_address` (
  `receive_address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `province_id` char(128) DEFAULT NULL,
  `city_id` char(128) DEFAULT NULL,
  `area_id` char(128) DEFAULT NULL,
  `address_detail` varchar(256) DEFAULT NULL,
  `default_flag` int(11) DEFAULT NULL,
  `receive_person` varchar(32) DEFAULT NULL,
  `contact_number` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`receive_address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2138 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `receive_product` */

DROP TABLE IF EXISTS `receive_product`;

CREATE TABLE `receive_product` (
  `receive_product_id` int(11) NOT NULL AUTO_INCREMENT,
  `receive_orderItem_id` int(11) DEFAULT NULL,
  `receive_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `receive_user_id` int(11) DEFAULT NULL,
  `receive_number` int(11) DEFAULT NULL,
  `receive_order_item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`receive_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10561 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `return_record` */

DROP TABLE IF EXISTS `return_record`;

CREATE TABLE `return_record` (
  `return_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_item_id` int(11) DEFAULT NULL,
  `return_info_money` float DEFAULT NULL,
  `apply_time` timestamp NULL DEFAULT NULL,
  `handle_time` timestamp NULL DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `receive_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `refund_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `buyer_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `is_latest` int(11) DEFAULT NULL,
  `buyer_capital_flow_id` varchar(32) DEFAULT NULL,
  `seller_capital_flow_id` varchar(32) DEFAULT NULL,
  `pay_money_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`return_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=702 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `scene_pic` */

DROP TABLE IF EXISTS `scene_pic`;

CREATE TABLE `scene_pic` (
  `scene_pic_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  `scene_pic_url` varchar(255) DEFAULT NULL,
  `scene_style` int(11) DEFAULT NULL,
  `scene_space` int(11) DEFAULT NULL,
  PRIMARY KEY (`scene_pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5463 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `send_record` */

DROP TABLE IF EXISTS `send_record`;

CREATE TABLE `send_record` (
  `send_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `send_logistics_company` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `send_logistics_pic` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `order_number` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transport_number` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `send_phone_number` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `send_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`send_record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9583 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `shopcart` */

DROP TABLE IF EXISTS `shopcart`;

CREATE TABLE `shopcart` (
  `shopcart_id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `buy_immediately` int(11) DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`shopcart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63987 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `shopcart_item` */

DROP TABLE IF EXISTS `shopcart_item`;

CREATE TABLE `shopcart_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `product_number` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `shopcart_id` int(11) DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106941 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `store_address` */

DROP TABLE IF EXISTS `store_address`;

CREATE TABLE `store_address` (
  `store_address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `province_id` char(128) DEFAULT NULL,
  `city_id` char(128) DEFAULT NULL,
  `area_id` char(128) DEFAULT NULL,
  `address_detail` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`store_address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `unbunding` */

DROP TABLE IF EXISTS `unbunding`;

CREATE TABLE `unbunding` (
  `unbunding_id` int(11) NOT NULL AUTO_INCREMENT,
  `unbunding_user_id` int(11) DEFAULT NULL,
  `unbunding_reason` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `unbunding_up_user_id` int(11) DEFAULT NULL,
  `unbunding_apply_time` timestamp NULL DEFAULT NULL,
  `unbunding_handle_time` timestamp NULL DEFAULT NULL,
  `unbunding_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`unbunding_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `upper_user_id` int(11) DEFAULT NULL,
  `user_nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_protrait_pic` varchar(256) DEFAULT NULL,
  `phone_number` varchar(32) DEFAULT NULL,
  `open_id` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `qq_number` varchar(16) DEFAULT NULL,
  `wechat_number` varchar(32) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  `withdraw_money` float(11,2) DEFAULT NULL,
  `flow_money` float(11,2) DEFAULT NULL,
  `pending_money` float(11,2) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `legal_person_name` varchar(255) DEFAULT NULL,
  `province_id` char(128) DEFAULT NULL,
  `city_id` char(128) DEFAULT NULL,
  `area_id` char(128) DEFAULT NULL,
  `company_address_detail` varchar(256) DEFAULT NULL,
  `salesman_work_certify` varchar(256) DEFAULT NULL,
  `check_status` int(11) DEFAULT NULL,
  `apply_id` int(11) DEFAULT NULL,
  `follow_time` timestamp NULL DEFAULT NULL,
  `qr_code_pic` varchar(256) DEFAULT NULL,
  `short_company_name` varchar(64) DEFAULT NULL,
  `salesman_id` int(11) DEFAULT NULL,
  `spread_qr_code_pic` varchar(255) DEFAULT NULL,
  `longitude` varchar(128) DEFAULT NULL,
  `latitude` varchar(128) DEFAULT NULL,
  `new_qr_code` varchar(256) DEFAULT NULL,
  `union_id` varchar(128) DEFAULT NULL,
  `person_qr_code` varchar(256) DEFAULT NULL,
  `user_identical_code` varchar(32) DEFAULT NULL,
  `agent_commision_percent` float(11,2) DEFAULT NULL,
  `information_phone` varchar(64) DEFAULT NULL,
  `we_app_open_id` varchar(64) DEFAULT NULL,
  `rent_visit_time` timestamp NULL DEFAULT NULL,
  `spread_code_generate_time` timestamp NULL DEFAULT NULL,
  `agency_discount` float(11,2) DEFAULT NULL,
  `discount_title` varchar(256) DEFAULT NULL,
  `welcome_title` varchar(255) DEFAULT NULL,
  `welcome_pic` varchar(256) DEFAULT NULL,
  `lamp_selection_login` int(11) DEFAULT NULL,
  `is_concern` int(11) DEFAULT NULL,
  `wechat_pay_qr_code` varchar(255) DEFAULT NULL,
  `alipay_qr_code` varchar(255) DEFAULT NULL,
  `manage_role` int(11) DEFAULT NULL,
  `purchase_money` float(11,2) DEFAULT NULL,
  `abbreviation` varchar(255) DEFAULT NULL,
  `abbrevivation` varchar(255) DEFAULT NULL,
  `wechat_scene` varchar(255) DEFAULT NULL,
  `lamp_permission_authro_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `openid` (`open_id`),
  KEY `role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=43503 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='salesman_id栏原本用于记录厂家业务员，现在改为记录门市业务员id';

/*Table structure for table `user_bank` */

DROP TABLE IF EXISTS `user_bank`;

CREATE TABLE `user_bank` (
  `user_bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_bank_person` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_bank_account` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_bank_province_id` int(11) DEFAULT NULL,
  `user_bank_city_id` int(11) DEFAULT NULL,
  `user_bank_name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_bank_sub_name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_contact_person` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_contact` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `user_logistics` */

DROP TABLE IF EXISTS `user_logistics`;

CREATE TABLE `user_logistics` (
  `logistics_company_name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `logistics_phone_number` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_logistics_id` int(11) NOT NULL AUTO_INCREMENT,
  `logistics_park` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_logistics_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2686 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `user_permission` */

DROP TABLE IF EXISTS `user_permission`;

CREATE TABLE `user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_des` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_backstage` tinyint(4) DEFAULT NULL,
  `permissions` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `user_temp` */

DROP TABLE IF EXISTS `user_temp`;

CREATE TABLE `user_temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户表user的主键',
  `area_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区/镇编号ID-对应address表ID',
  `city_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '市编号ID-对应address表ID',
  `province_id` char(128) COLLATE utf8_bin DEFAULT NULL COMMENT '省编号ID-对应address表ID',
  `company_address_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `company_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名称',
  `createtime` datetime DEFAULT NULL COMMENT '申请时间',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户邮箱',
  `endtime` datetime DEFAULT NULL COMMENT '结束时间',
  `phone_number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户手机号',
  `qq_number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户QQ号',
  `state` int(11) DEFAULT NULL COMMENT '状态码，0未审批，1不通过，2已通过',
  `user_nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户昵称',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `user_protrait_pic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户需要更改用户信息，未审核时用的临时记录表';

/*Table structure for table `welcome_pic` */

DROP TABLE IF EXISTS `welcome_pic`;

CREATE TABLE `welcome_pic` (
  `welcome_pic_id` int(11) NOT NULL AUTO_INCREMENT,
  `welcome_pic_url` varchar(256) DEFAULT NULL,
  `welcome_pic_link` longtext,
  `delete_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`welcome_pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `withdraw_platform` */

DROP TABLE IF EXISTS `withdraw_platform`;

CREATE TABLE `withdraw_platform` (
  `withdraw_platform_id` int(11) NOT NULL AUTO_INCREMENT,
  `withdraw_money` float(11,2) DEFAULT NULL,
  `withdraw_time` timestamp NULL DEFAULT NULL,
  `withdraw_person` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`withdraw_platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `withdraw_to_credit_card` */

DROP TABLE IF EXISTS `withdraw_to_credit_card`;

CREATE TABLE `withdraw_to_credit_card` (
  `withdraw_to_credit_card_id` varchar(32) NOT NULL,
  `account_person` varchar(128) DEFAULT NULL,
  `account` varchar(128) DEFAULT NULL,
  `account_bank` varchar(128) DEFAULT NULL,
  `contact_person` varchar(128) DEFAULT NULL,
  `contact_way` varchar(128) DEFAULT NULL,
  `withdraw_money` float(11,2) DEFAULT NULL,
  `account_province` varchar(64) DEFAULT NULL,
  `account_city` varchar(64) DEFAULT NULL,
  `to_wechat` int(11) DEFAULT NULL,
  `account_bank_sub_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`withdraw_to_credit_card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `withdraw_to_wechat` */

DROP TABLE IF EXISTS `withdraw_to_wechat`;

CREATE TABLE `withdraw_to_wechat` (
  `withdraw_to_wechat_id` varchar(32) NOT NULL,
  `withdraw_description` varchar(128) DEFAULT NULL,
  `withdraw_money` float(11,2) DEFAULT NULL,
  PRIMARY KEY (`withdraw_to_wechat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
