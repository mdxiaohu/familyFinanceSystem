/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50168
Source Host           : 127.0.0.1:3306
Source Database       : db_licai

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2014-02-23 21:19:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(55) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');
INSERT INTO `t_admin` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_rizhi
-- ----------------------------
DROP TABLE IF EXISTS `t_rizhi`;
CREATE TABLE `t_rizhi` (
  `id` int(11) NOT NULL DEFAULT '0',
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `shijian` varchar(200) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rizhi
-- ----------------------------
INSERT INTO `t_rizhi` VALUES ('1', 'ddddddddddd', 'dddddddddddddddddddddddddd', '2012-05-09', '1');

-- ----------------------------
-- Table structure for t_shouru
-- ----------------------------
DROP TABLE IF EXISTS `t_shouru`;
CREATE TABLE `t_shouru` (
  `id` int(11) NOT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `jine` decimal(18,2) DEFAULT NULL,
  `chengyuan` varchar(50) DEFAULT NULL,
  `leixing` varchar(50) DEFAULT NULL,
  `beizhu` longtext,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shouru
-- ----------------------------
INSERT INTO `t_shouru` VALUES ('2', '2012-05-03', '10000.00', '本人', '工资', '开工资的日子', '1');
INSERT INTO `t_shouru` VALUES ('3', '2012-05-03', '8000.00', '配偶', '工资', '老婆也开工资了', '1');
INSERT INTO `t_shouru` VALUES ('4', '2012-05-03', '500.59', '爸爸', '彩票中奖', '彩票中奖高兴', '1');
INSERT INTO `t_shouru` VALUES ('5', '2012-05-04', '2000.00', '爸爸', '开工资了', '开工资了', '1');
INSERT INTO `t_shouru` VALUES ('6', '2013-03-06', '2000.00', '本人', '多发点', ' 发的 ', '1');

-- ----------------------------
-- Table structure for t_touzi
-- ----------------------------
DROP TABLE IF EXISTS `t_touzi`;
CREATE TABLE `t_touzi` (
  `id` int(11) NOT NULL,
  `xangmu` varchar(50) DEFAULT NULL,
  `benjin` decimal(18,2) DEFAULT NULL,
  `kaishi` varchar(50) DEFAULT NULL,
  `jiehsu` varchar(50) DEFAULT NULL,
  `shouyi` decimal(18,2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_touzi
-- ----------------------------
INSERT INTO `t_touzi` VALUES ('4', '股票', '10000.00', '2012-03-04', '2012-05-04', '2000.00', '1');
INSERT INTO `t_touzi` VALUES ('5', '基金', '1000.00', '2014-02-23', '2014-02-23', '330.00', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `user_realname` varchar(50) DEFAULT NULL,
  `user_sex` varchar(50) DEFAULT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_pw` varchar(50) DEFAULT NULL,
  `user_del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '刘三', '男', '13888888888', '北京路', 'liusan', '000000', 'yes');
INSERT INTO `t_user` VALUES ('2', '刚刚', '男', '嗯嗯', '嗯嗯', 'simon', '888888', 'no');

-- ----------------------------
-- Table structure for t_xiaofei
-- ----------------------------
DROP TABLE IF EXISTS `t_xiaofei`;
CREATE TABLE `t_xiaofei` (
  `id` int(11) NOT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `jine` decimal(18,2) DEFAULT NULL,
  `chengyuan` varchar(50) DEFAULT NULL,
  `leixing` varchar(50) DEFAULT NULL,
  `beizhu` longtext,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xiaofei
-- ----------------------------
INSERT INTO `t_xiaofei` VALUES ('1', '2012-05-03', '1000.00', '本人', '购买笔记本', '购买IBM笔记本', '1');
INSERT INTO `t_xiaofei` VALUES ('2', '2012-05-03', '200.00', '配偶', '烫发染发', '烫发染发焗油', '1');
INSERT INTO `t_xiaofei` VALUES ('3', '2014-02-23', '100.00', '配偶', '雯雯', '呜呜1', '2');
