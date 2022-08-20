/*
 Navicat Premium Data Transfer

 Source Server         : Web
 Source Server Type    : MySQL
 Source Server Version : 100406
 Source Host           : localhost:3306
 Source Schema         : web_ban_do_cong_nghe

 Target Server Type    : MySQL
 Target Server Version : 100406
 File Encoding         : 65001

 Date: 30/06/2022 01:20:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `isAdmin` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'admin', 'admin', 'ducminh0573.com', 1);
INSERT INTO `account` VALUES (2, 'minh', '73ec35dc33dd2cc2751573f8dc5b7fce1e52d98992729385aec9543d7434547a', 'ducminh0573@gmail.com', 0);
INSERT INTO `account` VALUES (3, 'minhccc', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'ducminh1311@gmail.com', 0);
INSERT INTO `account` VALUES (18, 'minh1', '3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'ducminh1311@gmail.com', 0);
INSERT INTO `account` VALUES (19, 'ducminh123', '123456', 'ducminh0573@gmail.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
