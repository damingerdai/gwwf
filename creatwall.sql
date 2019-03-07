/*
Navicat MySQL Data Transfer

Source Server         : daming
Source Server Version : 50067
Source Host           : 127.0.0.1:3306
Source Database       : creatwall

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2016-04-13 21:24:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carid` char(7) NOT NULL,
  `cartype` varchar(10) default NULL,
  `dirverid` char(10) default NULL,
  `usagetype` varchar(10) default NULL,
  `buytime` date default NULL,
  `capacity` int(11) default NULL,
  `capunit` varchar(255) default NULL,
  PRIMARY KEY  (`carid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('苏DA999', '大众', 'AD20060005', '公用', '2016-03-16', '5', '人');
INSERT INTO `car` VALUES ('苏FDM888', '奥迪', 'AD20060002', '私用', '2006-01-01', '5', '人');
INSERT INTO `car` VALUES ('苏FNB888', '宝马', 'HR20060001', '公用', '2006-01-01', '5', '人');
INSERT INTO `car` VALUES ('苏FXM888', '解放', 'LG20060003', '私用', '2006-01-01', '5', '吨');
INSERT INTO `car` VALUES ('苏FXX888', '玛莎拉蒂', 'AD20060004', '私用', '2016-01-22', '4', '人');

-- ----------------------------
-- Table structure for car_usage_form
-- ----------------------------
DROP TABLE IF EXISTS `car_usage_form`;
CREATE TABLE `car_usage_form` (
  `cufid` int(11) NOT NULL auto_increment,
  `carid` char(7) default NULL,
  `usagetime_begin` varchar(20) default NULL,
  `usagetime_end` varchar(20) default NULL,
  `userid` char(10) default NULL,
  `remark` varchar(100) default NULL,
  PRIMARY KEY  (`cufid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_usage_form
-- ----------------------------
INSERT INTO `car_usage_form` VALUES ('1', '苏FDM888', '2016-01-02 00:00', '2016-01-03 00:00', 'HR20060004', 'java');
INSERT INTO `car_usage_form` VALUES ('2', '苏FNB888', '2016-01-01 00:00', '2016-01-02 00:00', 'HR20060001', 'C++');
INSERT INTO `car_usage_form` VALUES ('3', '苏FXM888', '2016-01-06 00:00', '2016-01-07 00:00', 'AD20060005', 'C语言');
INSERT INTO `car_usage_form` VALUES ('4', '苏FDM888', '2016-04-27 00:00', '2016-04-29 00:00', 'AD20060002', 'C#');
INSERT INTO `car_usage_form` VALUES ('5', '苏FDM888', '2015-03-23 00:30', '2015-03-24 20:00', 'HR20060004', 'php');
INSERT INTO `car_usage_form` VALUES ('6', '苏FXM888', '2016-03-23 09:00', '2016-03-30 00:40', 'HR20060001', 'html5');
INSERT INTO `car_usage_form` VALUES ('7', '苏FDM888', '2016-01-02 09:40', '2016-02-01 21:00', 'LG20060003', 'ccs3');
INSERT INTO `car_usage_form` VALUES ('8', '苏FNB888', '2015-04-04 12:00', '2015-05-28 23:00', 'LG20060003', 'swfit');
INSERT INTO `car_usage_form` VALUES ('9', '苏FDM888', '2016-03-23 16:00', '2016-03-24 07:35', 'AD20060002', 'verilog');
INSERT INTO `car_usage_form` VALUES ('10', '苏FXM888', '2015-09-20 12:40', '2015-09-23 14:00', 'AD20060002', 'xml');
INSERT INTO `car_usage_form` VALUES ('11', '苏FDM888', '2016-04-23 12:40', '2015-04-24 09:40', 'AD20060005', 'matlab');
INSERT INTO `car_usage_form` VALUES ('12', '苏FXM888', '2016-04-22 18:40', '2016-04-23 09:44', 'LG20060006', 'F#');
INSERT INTO `car_usage_form` VALUES ('13', '苏FDM888', '2014-04-22 17:40', '2014-04-23 17:40', 'LG20060006', '清明雨上');
INSERT INTO `car_usage_form` VALUES ('14', '苏DA999', '2015-03-29 14:30', '2015-05-30 17:44', 'HR20060001', '有何不可');
INSERT INTO `car_usage_form` VALUES ('15', '苏DA999', '2015-03-23 13:40', '2015-03-25 17:40', 'AD20060002', '泸州月光');
INSERT INTO `car_usage_form` VALUES ('16', '苏DA999', '2015-03-26 13:40', '2015-03-29 14:30', 'AD20060002', '散在心上');
INSERT INTO `car_usage_form` VALUES ('17', '苏FXX888', '2016-04-23 13:10', '2016-04-29 19:33', 'HR20060001', '如今你又在谁的身旁');
INSERT INTO `car_usage_form` VALUES ('18', '苏FXX888', '2016-05-12 10:30', '2016-05-19 21:30', 'HR20060001', '家乡月光');
INSERT INTO `car_usage_form` VALUES ('19', '苏FXX888', '2016-06-01 12:00', '2016-06-01 19:00', 'HR20060001', '深深烙在我心上');
INSERT INTO `car_usage_form` VALUES ('20', '苏FDM888', '2016-04-12 00:00', '2016-04-26 00:00', 'AD20060002', '太多的伤');
INSERT INTO `car_usage_form` VALUES ('21', '苏FDM888', '2016-04-13 00:00', '2016-04-27 00:00', 'AD20060002', '难诉衷肠');

-- ----------------------------
-- Table structure for checking_in_form
-- ----------------------------
DROP TABLE IF EXISTS `checking_in_form`;
CREATE TABLE `checking_in_form` (
  `cid` int(11) NOT NULL auto_increment,
  `empid` char(10) default NULL,
  `cdate` varchar(20) default NULL,
  `ontime` varchar(10) default NULL,
  `offtime` varchar(10) default NULL,
  `ctype` varchar(10) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checking_in_form
-- ----------------------------
INSERT INTO `checking_in_form` VALUES ('1', 'HR20060001', '2016-03-14', '09:00', '17:00', '上班');
INSERT INTO `checking_in_form` VALUES ('2', 'HR20060001', '2016-03-15', '09:40', '17:50', '上班');
INSERT INTO `checking_in_form` VALUES ('3', 'HR20060001', '2016-03-16', '09:00', '17:00', '加班');
INSERT INTO `checking_in_form` VALUES ('4', 'AD20060002', '2016-03-14', '09:00', '17:00', '上班');
INSERT INTO `checking_in_form` VALUES ('5', 'AD20060002', '2016-03-15', '09:15', '17:00', '上班');
INSERT INTO `checking_in_form` VALUES ('6', 'AD20060002', '2016-03-16', '09:00', '17:00', '加班');
INSERT INTO `checking_in_form` VALUES ('7', 'LG20060003', '2016-03-14', '09:30', '17:00', '上班');
INSERT INTO `checking_in_form` VALUES ('8', 'LG20060003', '2016-03-15', '09:00', '14:00', '上班');
INSERT INTO `checking_in_form` VALUES ('9', 'LG20060003', '2016-03-16', '09:00', '17:00', '加班');
INSERT INTO `checking_in_form` VALUES ('10', 'AD20060002', '2016-11-11', '07:00', '20:00', '加班');
INSERT INTO `checking_in_form` VALUES ('11', 'HR20060001', '2016-03-28', '09:40', '18:00', '上班');
INSERT INTO `checking_in_form` VALUES ('12', 'HR20060001', '2016-03-27', '09:00', '14:00', '上班');
INSERT INTO `checking_in_form` VALUES ('13', 'HR20060001', '2016-03-26', '09:05', '21:00', '上班');
INSERT INTO `checking_in_form` VALUES ('14', 'HR20060001', '2016-03-25', '07:00', '21:00', '上班');
INSERT INTO `checking_in_form` VALUES ('15', 'HR20060001', '2016-03-24', '11:00', '16:00', '上班');
INSERT INTO `checking_in_form` VALUES ('16', 'HR20060001', '2016-03-23', '10:30', '17:40', '上班');
INSERT INTO `checking_in_form` VALUES ('17', 'HR20060001', '2016-03-22', '09:20', '16:20', '加班');
INSERT INTO `checking_in_form` VALUES ('18', 'HR20060001', '2016-03-21', '08:30', '17:20', '上班');
INSERT INTO `checking_in_form` VALUES ('19', 'HR20060001', '2016-03-20', '08:30', '16:59', '上班');
INSERT INTO `checking_in_form` VALUES ('20', 'AD20060002', '2016-03-28', '09:30', '17:00', '上班');
INSERT INTO `checking_in_form` VALUES ('21', 'AD20060002', '2016-03-27', '09:30', '17:40', '上班');
INSERT INTO `checking_in_form` VALUES ('22', 'AD20060002', '2016-03-26', '08:55', '17:20', '上班');
INSERT INTO `checking_in_form` VALUES ('23', 'AD20060002', '2016-03-25', '09:22', '15:33', '上班');
INSERT INTO `checking_in_form` VALUES ('24', 'AD20060002', '2016-03-24', '09:00', '15:57', '上班');
INSERT INTO `checking_in_form` VALUES ('25', 'AD20060002', '2016-03-23', '09:30', '16:50', '上班');
INSERT INTO `checking_in_form` VALUES ('26', 'AD20060002', '2016-03-22', '09:00', '17:00', '加班');
INSERT INTO `checking_in_form` VALUES ('27', 'AD20060002', '2016-03-21', '08:20', '18:00', '上班');
INSERT INTO `checking_in_form` VALUES ('28', 'AD20060002', '2016-03-20', '09:20', '17:30', '上班');
INSERT INTO `checking_in_form` VALUES ('29', 'LG20060003', '2016-03-28', '09:33', '17:44', '上班');
INSERT INTO `checking_in_form` VALUES ('30', 'LG20060003', '2016-03-27', '09:22', '16:00', '上班');
INSERT INTO `checking_in_form` VALUES ('31', 'LG20060003', '2016-03-26', '08:40', '14:00', '上班');
INSERT INTO `checking_in_form` VALUES ('32', 'LG20060003', '2016-03-25', '08:11', '13:44', '上班');
INSERT INTO `checking_in_form` VALUES ('33', 'LG20060003', '2016-03-24', '08:00', '19:00', '上班');
INSERT INTO `checking_in_form` VALUES ('34', 'LG20060003', '2016-03-23', '07:00', '18:30', '上班');
INSERT INTO `checking_in_form` VALUES ('35', 'LG20060003', '2016-03-22', '09:00', '16:00', '加班');
INSERT INTO `checking_in_form` VALUES ('36', 'LG20060003', '2016-03-21', '08:30', '17:00', '上班');
INSERT INTO `checking_in_form` VALUES ('37', 'LG20060003', '2016-03-20', '08:30', '16:00', '上班');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `depId` char(2) NOT NULL,
  `dname` varchar(20) NOT NULL,
  PRIMARY KEY  (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('AD', '行政部门');
INSERT INTO `department` VALUES ('DM', '大明俱乐部');
INSERT INTO `department` VALUES ('HR', '人事部门');
INSERT INTO `department` VALUES ('LG', '后勤部门');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empid` char(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` char(32) NOT NULL,
  `gender` char(2) NOT NULL,
  `birthday` varchar(20) default NULL,
  `major` varchar(20) default NULL,
  `edu` varchar(20) default NULL,
  `college` varchar(20) default NULL,
  `depId` char(2) NOT NULL,
  PRIMARY KEY  (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('AD20060002', 'xiaoming', 'b59c67bf196a4758191e42f76670ceba', '男', '1994-09-21', '计嵌', '博士', '哈佛大学', 'AD');
INSERT INTO `employee` VALUES ('AD20060005', 'Jack', '81dc9bdb52d04dc20036dbd8313ed055', '男', '1994-09-25', '土木工程', '本科', '南京大学', 'AD');
INSERT INTO `employee` VALUES ('DM20160081', '1', 'c4ca4238a0b923820dcc509a6f75849b', '男', '1111-11-11', '11', '1', '11', 'DM');
INSERT INTO `employee` VALUES ('HR20060001', 'daming', '81dc9bdb52d04dc20036dbd8313ed055', '男', '1991-09-26', '电科', '本科', '南通大学', 'HR');
INSERT INTO `employee` VALUES ('HR20060004', 'Tom', '81dc9bdb52d04dc20036dbd8313ed055', '女', '1994-11-26', '工商管理', '本科', '北京大学', 'HR');
INSERT INTO `employee` VALUES ('LG20060003', 'ming', '81dc9bdb52d04dc20036dbd8313ed055', '男', '1988-01-11', '电信', '本科', '清华大学', 'LG');
INSERT INTO `employee` VALUES ('LG20060006', 'Jane', '81dc9bdb52d04dc20036dbd8313ed055', '女', '1981-09-01', '现代物流', '本科', '复旦大学', 'LG');

-- ----------------------------
-- Table structure for office_usage_form
-- ----------------------------
DROP TABLE IF EXISTS `office_usage_form`;
CREATE TABLE `office_usage_form` (
  `uid` int(11) NOT NULL auto_increment,
  `uname` varchar(20) NOT NULL,
  `unit` varchar(10) NOT NULL,
  `StoreNumber` int(11) NOT NULL,
  `remark` varchar(100) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of office_usage_form
-- ----------------------------
INSERT INTO `office_usage_form` VALUES ('1', 'A4纸', '张', '1000', null);
INSERT INTO `office_usage_form` VALUES ('2', '水笔', '支', '19', null);
INSERT INTO `office_usage_form` VALUES ('3', '橡皮', '块', '39', null);
INSERT INTO `office_usage_form` VALUES ('4', '曲回针', '个', '100000', null);
INSERT INTO `office_usage_form` VALUES ('5', 'daming', 'da', '22', null);

-- ----------------------------
-- Table structure for office_usage_info
-- ----------------------------
DROP TABLE IF EXISTS `office_usage_info`;
CREATE TABLE `office_usage_info` (
  `oid` int(11) NOT NULL auto_increment,
  `empid` char(10) default NULL,
  `uname` varchar(10) default NULL,
  `number` int(10) default NULL,
  `unit` varchar(10) default NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of office_usage_info
-- ----------------------------
INSERT INTO `office_usage_info` VALUES ('1', 'HR20060001', 'A4纸', '11', '张');
INSERT INTO `office_usage_info` VALUES ('2', 'LG20060003', '水笔', '1', '支');
INSERT INTO `office_usage_info` VALUES ('3', 'AD20060002', '橡皮', '2', '块');
INSERT INTO `office_usage_info` VALUES ('4', 'AD20060002', 'A4纸 ', '10000', '张');
INSERT INTO `office_usage_info` VALUES ('5', 'AD20060002', '曲回针 ', '50', '个');
INSERT INTO `office_usage_info` VALUES ('6', 'AD20060002', '水笔 ', '1', '支');

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `pid` char(5) NOT NULL,
  `carid` char(7) default NULL,
  `instrucation` varchar(100) default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES ('CW001', '苏FDM888', '董事长专用车位');
INSERT INTO `park` VALUES ('CW002', '苏FNB888', '轮流车位');
INSERT INTO `park` VALUES ('CW003', '苏FXM888', '货车专用车位');
INSERT INTO `park` VALUES ('CW004', '苏FXX888', '大明专用');

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `name` varchar(32) NOT NULL default '',
  `maxIndex` int(11) NOT NULL default '0',
  PRIMARY KEY  (`name`,`maxIndex`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('empid', '97');

-- ----------------------------
-- Function structure for f_a
-- ----------------------------
DROP FUNCTION IF EXISTS `f_a`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_a`(ai_n int) RETURNS varchar(64) CHARSET utf8
begin
 declare vs_res varchar(64);
 declare vi_count int;
 select max(n),count(1)  into vs_res ,vi_count from d where i = ai_n;
 if vs_res is null then
  set vs_res = '';
 end if;
 return vs_res;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval`(sequenceName VARCHAR(32)) RETURNS int(11)
BEGIN
	
  DECLARE iMaxIndex INTEGER;
	UPDATE sequence SET maxIndex = 1 WHERE name = sequenceName and maxIndex = 9999;
  UPDATE Sequence SET maxIndex = maxIndex + 1 WHERE name = sequenceName;
  SELECT maxIndex INTO iMaxIndex FROM Sequence WHERE name = sequenceName;
	
  RETURN iMaxIndex;
 
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for setMD5
-- ----------------------------
DROP FUNCTION IF EXISTS `setMD5`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `setMD5`(pwd varchar(10)) RETURNS char(32) CHARSET utf8
begin
  
 return MD5(pwd);
end
;;
DELIMITER ;
