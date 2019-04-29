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

 Date: 29/04/2019 18:27:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `uemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `upassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'yiki', 's', 's');
INSERT INTO `user` VALUES (2, 'kkk', NULL, NULL);
INSERT INTO `user` VALUES (3, 'yiki1', '1111', 'dddd');
INSERT INTO `user` VALUES (4, 'tiffany2', '1111', 'dddd');
INSERT INTO `user` VALUES (5, 'tiffany3', '1111', 'dddd');
INSERT INTO `user` VALUES (6, 'tiffany4', '1111', 'dddd');
INSERT INTO `user` VALUES (7, 'yiki', 'dddddd', 'ddddsgag');
INSERT INTO `user` VALUES (8, 'yiki222222', NULL, 'ddddsgag');
INSERT INTO `user` VALUES (9, 'q', 'q', 'q');

SET FOREIGN_KEY_CHECKS = 1;
