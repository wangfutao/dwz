/*
 Navicat Premium Data Transfer

 Source Server         : 123.56.30.235
 Source Server Type    : MySQL
 Source Server Version : 50637
 Source Host           : 123.56.30.235:3306
 Source Schema         : dwz

 Target Server Type    : MySQL
 Target Server Version : 50637
 File Encoding         : 65001

 Date: 08/04/2019 14:00:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dwz
-- ----------------------------
DROP TABLE IF EXISTS `dwz`;
CREATE TABLE `dwz`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dwz` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ywz` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dwz
-- ----------------------------
INSERT INTO `dwz` VALUES (21, 'bd', 'http://www.baidu.com', '2019-04-08 13:53:45');
INSERT INTO `dwz` VALUES (22, 'bf3dc5d5', 'http://www.baidu.com', '2019-04-08 13:53:51');

-- ----------------------------
-- Table structure for dwz_log
-- ----------------------------
DROP TABLE IF EXISTS `dwz_log`;
CREATE TABLE `dwz_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dwz_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dwz_log
-- ----------------------------
INSERT INTO `dwz_log` VALUES (5, 21, '2019-04-08 13:53:48');
INSERT INTO `dwz_log` VALUES (6, 22, '2019-04-08 13:53:54');

SET FOREIGN_KEY_CHECKS = 1;
