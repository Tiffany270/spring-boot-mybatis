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

 Date: 29/04/2019 18:25:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for firm
-- ----------------------------
DROP TABLE IF EXISTS `firm`;
CREATE TABLE `firm`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `clabelname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of firm
-- ----------------------------
INSERT INTO `firm` VALUES (1, 'qw', '中文', '@', 'qw');
INSERT INTO `firm` VALUES (2, 'yiki222222', NULL, 'yiki222222', 'ddddsgag');
INSERT INTO `firm` VALUES (3, 'yiki3', '3', 'g', 'g');
INSERT INTO `firm` VALUES (4, '???', '???', 'yiki@com', 'qw');
INSERT INTO `firm` VALUES (5, 'sa\'g ??', ' ??', 'yiki', 's');
INSERT INTO `firm` VALUES (6, '???', '???', 'yiki', 's');
INSERT INTO `firm` VALUES (7, '中文测试', '3', 'g', 'g');
INSERT INTO `firm` VALUES (8, '中文', '设能ui', 'yiki', 's');
INSERT INTO `firm` VALUES (9, 'AHR', '  A有限公司', 'yikicom@foxmail.com', '123456');

SET FOREIGN_KEY_CHECKS = 1;
