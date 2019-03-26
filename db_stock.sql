/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1(本地)
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : db_stock

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 26/03/2019 17:17:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_dict
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict`;
CREATE TABLE `tb_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dict
-- ----------------------------
INSERT INTO `tb_dict` VALUES (1, 'gender', '性别');

-- ----------------------------
-- Table structure for tb_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict_item`;
CREATE TABLE `tb_dict_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_id` int(255) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `udpate_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dict_id`(`dict_id`) USING BTREE,
  INDEX `value`(`value`) USING BTREE,
  CONSTRAINT `tb_dict_item_ibfk_1` FOREIGN KEY (`dict_id`) REFERENCES `tb_dict` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dict_item
-- ----------------------------
INSERT INTO `tb_dict_item` VALUES (8, 1, '男', 'sex01', '2019-02-20 16:16:38');
INSERT INTO `tb_dict_item` VALUES (9, 1, '女', 'sex02', '2019-02-20 16:16:56');

-- ----------------------------
-- Table structure for tb_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge`;
CREATE TABLE `tb_knowledge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` timestamp(0) NULL DEFAULT NULL,
  `websites` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_knowledge
-- ----------------------------
INSERT INTO `tb_knowledge` VALUES (5, '什么是黄金', '这是黄金的简介........', '黄金', '2019-02-12 10:03:34', 'http://www.baidu.com');
INSERT INTO `tb_knowledge` VALUES (15, '标题', '内容', '关键字', '2019-02-19 16:16:31', 'http://www.baidu.com');
INSERT INTO `tb_knowledge` VALUES (17, '添加', '这是content', '这是关键字', '2019-02-20 09:50:46', 'http://www.baidu.com');
INSERT INTO `tb_knowledge` VALUES (31, 'fasefasfdg', 'htfdhtfh', NULL, '2019-03-26 13:51:34', 'dhtdtfhtrfht');
INSERT INTO `tb_knowledge` VALUES (32, 'fasefasfdg', 'htfdhtfh', 'drgdfghtf', '2019-03-26 13:55:48', 'dhtdtfhtrfht');
INSERT INTO `tb_knowledge` VALUES (33, '撒发生粉丝', '啊飞洒发色发', '安抚塞菲艾斯', '2019-03-26 16:17:52', '发涩发顺丰');
INSERT INTO `tb_knowledge` VALUES (34, '按法定封建嗯快忘记', '罚恶法是发涩发', '发文发是发', '2019-03-26 16:30:47', '发噶色发顺丰');
INSERT INTO `tb_knowledge` VALUES (37, 'safasfe', 'efasfase', 'fesafesf', '2019-03-26 17:08:08', 'fasefsefsef');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` timestamp(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gender`(`gender`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '123456', '1', '2019-02-20 12:55:50', '15196608376@163.com');
INSERT INTO `tb_user` VALUES (2, 'root', '123456', '0', '2019-02-19 12:56:11', '2379181662@qq.com');
INSERT INTO `tb_user` VALUES (6, '黄小兵56', '654321', 'sex01', '2019-02-21 16:22:13', '123456@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
