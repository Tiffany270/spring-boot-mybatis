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

 Date: 29/04/2019 18:26:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for firminfo
-- ----------------------------
DROP TABLE IF EXISTS `firminfo`;
CREATE TABLE `firminfo`  (
  `cid` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `brief` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of firminfo
-- ----------------------------
INSERT INTO `firminfo` VALUES (1, 'qw科技有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '电子', '>=50', 'hope u can join us');
INSERT INTO `firminfo` VALUES (2, 'XXX有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '互联网', '>=50', 'hope u can join us');
INSERT INTO `firminfo` VALUES (3, 'XXX有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '互联网', '>=50', 'hope u can join us');
INSERT INTO `firminfo` VALUES (4, 'XXX有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '互联网', '>=50', 'hope u can join us');
INSERT INTO `firminfo` VALUES (5, 'XXX有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '互联网', '>=50', 'hope u can join us');
INSERT INTO `firminfo` VALUES (6, 'XXX有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '互联网', '>=50', 'hope u can join us');
INSERT INTO `firminfo` VALUES (7, 'XXX有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '互联网', '>=50', 'hope u can join us');
INSERT INTO `firminfo` VALUES (8, 'XXX有限公司', 'yiki270@foxmail.com', '183239849999', '广州', '途迅科技是一家初创型企业，我们专注互联网产品开发及服务，创始人是技术出身，曾在知名企业担任CTO职位，要学习技术的小伙伴，赶紧加入我们吧！', '互联网', '>=50', 'hope u can join us');

SET FOREIGN_KEY_CHECKS = 1;
