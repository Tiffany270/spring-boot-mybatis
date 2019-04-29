/*
 Navicat Premium Data Transfer

 Source Server         : yiki
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 29/04/2019 18:27:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for workexp
-- ----------------------------
DROP TABLE IF EXISTS `workexp`;
CREATE TABLE `workexp`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `uid` int(255) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ocp` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `dep` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `opcDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of workexp
-- ----------------------------
INSERT INTO `workexp` VALUES (1, 2, 'yiki', 'el', 'pr', 'software', '89t', '吃苦耐劳');
INSERT INTO `workexp` VALUES (2, 2, 'yiki', 'el', 'pr', 'software', '89t', '吃苦耐劳');

SET FOREIGN_KEY_CHECKS = 1;
