
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_privilege
-- ----------------------------
DROP TABLE IF EXISTS `base_privilege`;
CREATE TABLE `base_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `hidden` int(1) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `base_privilege_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `base_privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for base_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `base_role_privilege`;
CREATE TABLE `base_role_privilege` (
  `id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `privilege_id` bigint(20) DEFAULT NULL,
  KEY `role_id` (`role_id`),
  KEY `privilege_id` (`privilege_id`),
  CONSTRAINT `base_role_privilege_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `base_role` (`id`),
  CONSTRAINT `base_role_privilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `base_privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `telephone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_face` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `register_time` bigint(20) DEFAULT NULL,
  `last_login_time` bigint(20) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `id_photo_positive` varchar(255) DEFAULT NULL,
  `id_photo_negative` varchar(255) DEFAULT NULL,
  `bank_card` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `score` int(255) DEFAULT NULL,
  `balance` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `base_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `base_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_account_customer
-- ----------------------------
DROP TABLE IF EXISTS `jz_account_customer`;
CREATE TABLE `jz_account_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money` varchar(255) DEFAULT NULL,
  `transaction_time` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `jz_account_customer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `base_user` (`id`),
  CONSTRAINT `jz_account_customer_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `jz_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_account_employee
-- ----------------------------
DROP TABLE IF EXISTS `jz_account_employee`;
CREATE TABLE `jz_account_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money` varchar(255) DEFAULT NULL,
  `transaction_time` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `jz_account_employee_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `base_user` (`id`),
  CONSTRAINT `jz_account_employee_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `jz_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_account_system
-- ----------------------------
DROP TABLE IF EXISTS `jz_account_system`;
CREATE TABLE `jz_account_system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money` varchar(255) DEFAULT NULL,
  `transaction_time` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `jz_account_system_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `base_user` (`id`),
  CONSTRAINT `jz_account_system_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `jz_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_address
-- ----------------------------
DROP TABLE IF EXISTS `jz_address`;
CREATE TABLE `jz_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `jz_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `base_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_category
-- ----------------------------
DROP TABLE IF EXISTS `jz_category`;
CREATE TABLE `jz_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `nu` int(10) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `jz_category_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `jz_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_comment
-- ----------------------------
DROP TABLE IF EXISTS `jz_comment`;
CREATE TABLE `jz_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `score` int(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `comment_time` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `jz_comment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `jz_order` (`id`),
  CONSTRAINT `jz_comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `base_user` (`id`),
  CONSTRAINT `jz_comment_ibfk_3` FOREIGN KEY (`parent_id`) REFERENCES `jz_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_order
-- ----------------------------
DROP TABLE IF EXISTS `jz_order`;
CREATE TABLE `jz_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_time` bigint(20) DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `employee_id` (`employee_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `jz_order_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `base_user` (`id`),
  CONSTRAINT `jz_order_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `base_user` (`id`),
  CONSTRAINT `jz_order_ibfk_3` FOREIGN KEY (`address_id`) REFERENCES `jz_address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_order_line
-- ----------------------------
DROP TABLE IF EXISTS `jz_order_line`;
CREATE TABLE `jz_order_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(10) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` varchar(10) DEFAULT NULL,
  `product_introduce` varchar(255) DEFAULT NULL,
  `product_photo` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `jz_order_line_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `jz_product` (`id`),
  CONSTRAINT `jz_order_line_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `jz_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jz_product
-- ----------------------------
DROP TABLE IF EXISTS `jz_product`;
CREATE TABLE `jz_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `introduce` text,
  `price` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `sales` int(10) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `jz_product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `jz_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
