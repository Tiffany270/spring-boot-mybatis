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

 Date: 29/04/2019 18:26:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jobdes
-- ----------------------------
DROP TABLE IF EXISTS `jobdes`;
CREATE TABLE `jobdes`  (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `opc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tab` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `pay` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `exp` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `attr` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `must` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `hit` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `intv` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `endDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `relDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`jid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobdes
-- ----------------------------
INSERT INTO `jobdes` VALUES (1, 1, '软件工程师', '电子', '8k~9k', '广州', '三年', '本科', '全职', '福利号', '你需要做什么：\r\n\r\n1、负责对外谈判商务合作与执行，确保合作顺利完成；\r\n\r\n2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建\r\n\r\n立和维护内容合作渠道，扩大其商业价值；\r\n\r\n3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；\r\n\r\n4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '1.错峰的上班时间，周末双休，社会五险补贴；\r\n\r\n2.接触行业内的顶级资源；\r\n\r\n3.可以经常参加国内外活动，接触到JAY-Z、A$AP ROCKY、陈冠希、余文乐、热狗这些潮流ICON，出差机票\r\n\r\n+四/五星级酒店标配，期待与你同行；\r\n\r\n4.不定期收到品牌公关送的球鞋、衣服如家常便饭。', '有较多潮流行业运动品牌资源者和互联网传媒行业工作经验者优先。', '广州 - 天河区 - 石牌 - 新快报社01层03室', '前端记得转', '2019/4/29', 'A有限公司');
INSERT INTO `jobdes` VALUES (2, 2, '软件工程师', '互联网', '8k~9k', 'sds广州', 'sdf三年', 'sdag本科', '兼职', '福利号', '你需要做什么：\r\n\r\n1、负责对外谈判商务合作与执行，确保合作顺利完成；\r\n\r\n2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建\r\n\r\n立和维护内容合作渠道，扩大其商业价值；\r\n\r\n3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；\r\n\r\n4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '你需要做什么：\r\n\r\n1、负责对外谈判商务合作与执行，确保合作顺利完成；\r\n\r\n2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建\r\n\r\n立和维护内容合作渠道，扩大其商业价值；\r\n\r\n3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；\r\n\r\n4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '你需要做什么：\r\n\r\n1、负责对外谈判商务合作与执行，确保合作顺利完成；\r\n\r\n2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建\r\n\r\n立和维护内容合作渠道，扩大其商业价值；\r\n\r\n3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；\r\n\r\n4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '你需要做什么：\r\n\r\n1、负责对外谈判商务合作与执行，确保合作顺利完成；\r\n\r\n2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建\r\n\r\n立和维护内容合作渠道，扩大其商业价值；\r\n\r\n3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；\r\n\r\n4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '你需要做什么：\r\n\r\n1、负责对外谈判商务合作与执行，确保合作顺利完成；\r\n\r\n2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建\r\n\r\n立和维护内容合作渠道，扩大其商业价值；\r\n\r\n3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；\r\n\r\n4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '你需要做什么：\r\n\r\n1、负责对外谈判商务合作与执行，确保合作顺利完成；\r\n\r\n2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建\r\n\r\n立和维护内容合作渠道，扩大其商业价值；\r\n\r\n3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；\r\n\r\n4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', 'B有限公司');
INSERT INTO `jobdes` VALUES (3, 3, '软件工程师', '信息', '8k~9k', '广州', '1', '2', '3', '4', '5', '6', 'ddddsgag', 'ddddsgag', NULL, 'ddddsgag', 'C有限公司');
INSERT INTO `jobdes` VALUES (4, 4, '软件工程师', '运营', '8k~9k', '广州', '1', '2', '3', '4', '5', '6', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'C有限公司');
INSERT INTO `jobdes` VALUES (5, 4, '软件工程师', '不知道什么鬼', '8k~9k', '广州', '1', '2', '3', '4', '你需要做什么：1、负责对外谈判商务合作与执行，确保合作顺利完成； 2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建立和维护内容合作渠道，扩大其商业价值；3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '1.错峰的上班时间，周末双休，社会五险补贴；2.接触行业内的顶级资源；3.可以经常参加国内外活动，接触到JAY-Z、A$AP ROCKY、陈冠希、余文乐、热狗这些潮流ICON，出差机票+四五星级酒店标配，期待与你同行；\'4.不定期收到品牌公关送的球鞋、衣服如家常便饭。', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'C有限公司');
INSERT INTO `jobdes` VALUES (6, 4, '软件工程师', '产品', '8k~9k', '广州', '五年以少', '本科', '3', '4', '你需要做什么：1、负责对外谈判商务合作与执行，确保合作顺利完成； 2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建立和维护内容合作渠道，扩大其商业价值；3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '1.错峰的上班时间，周末双休，社会五险补贴；2.接触行业内的顶级资源；3.可以经常参加国内外活动，接触到JAY-Z、A$AP ROCKY、陈冠希、余文乐、热狗这些潮流ICON，出差机票+四五星级酒店标配，期待与你同行；\'4.不定期收到品牌公关送的球鞋、衣服如家常便饭。', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'C有限公司');
INSERT INTO `jobdes` VALUES (7, 5, '软件工程师', 'JAVA', '8k~9k', '广州', '五年以少', '本科', '全职', '4', '你需要做什么：1、负责对外谈判商务合作与执行，确保合作顺利完成； 2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建立和维护内容合作渠道，扩大其商业价值；3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '1.错峰的上班时间，周末双休，社会五险补贴；2.接触行业内的顶级资源；3.可以经常参加国内外活动，接触到JAY-Z、A$AP ROCKY、陈冠希、余文乐、热狗这些潮流ICON，出差机票+四五星级酒店标配，期待与你同行；\'4.不定期收到品牌公关送的球鞋、衣服如家常便饭。', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'B有限公司');
INSERT INTO `jobdes` VALUES (8, 5, '软件工程师', '互联网', '8k~9k', '广州', '五年以少', '本科', '全职', '4', '你需要做什么：1、负责对外谈判商务合作与执行，确保合作顺利完成； 2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建立和维护内容合作渠道，扩大其商业价值；3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '1.错峰的上班时间，周末双休，社会五险补贴；2.接触行业内的顶级资源；3.可以经常参加国内外活动，接触到JAY-Z、A$AP ROCKY、陈冠希、余文乐、热狗这些潮流ICON，出差机票+四五星级酒店标配，期待与你同行；\'4.不定期收到品牌公关送的球鞋、衣服如家常便饭。', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'B有限公司');
INSERT INTO `jobdes` VALUES (9, 5, '软件工程师', '软件', '8k~9k', '广州', '五年以少', '本科', '全职', '4', '你需要做什么：1、负责对外谈判商务合作与执行，确保合作顺利完成； 2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建立和维护内容合作渠道，扩大其商业价值；3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '1.错峰的上班时间，周末双休，社会五险补贴；2.接触行业内的顶级资源；3.可以经常参加国内外活动，接触到JAY-Z、A$AP ROCKY、陈冠希、余文乐、热狗这些潮流ICON，出差机票+四五星级酒店标配，期待与你同行；\'4.不定期收到品牌公关送的球鞋、衣服如家常便饭。', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'B有限公司');
INSERT INTO `jobdes` VALUES (10, 5, '软件工程师', '建筑', '8k~9k', '广州', '五年以少', '本科', '全职', '4', '你需要做什么：1、负责对外谈判商务合作与执行，确保合作顺利完成； 2、负责开拓公司与广告公司、媒体公司的合作，包括免费资源互换、活动合作、盈利合作、广告接入等，逐步建立和维护内容合作渠道，扩大其商业价值；3、能够独立进行商务沟通和谈判，独立策划执行合作方案，规划工作计划并能够按进度有效执行；4、积极建设并维护好相关客户关系，挖掘与客户长期深度合作的商业机会', '1.错峰的上班时间，周末双休，社会五险补贴；2.接触行业内的顶级资源；3.可以经常参加国内外活动，接触到JAY-Z、A$AP ROCKY、陈冠希、余文乐、热狗这些潮流ICON，出差机票+四五星级酒店标配，期待与你同行；\'4.不定期收到品牌公关送的球鞋、衣服如家常便饭。', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'ddddsgag', 'B有限公司');

SET FOREIGN_KEY_CHECKS = 1;
