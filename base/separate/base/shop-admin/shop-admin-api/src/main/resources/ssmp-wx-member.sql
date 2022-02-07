/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.18-cynos-log : Database - ssmp-wx-member
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssmp-wx-member` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssmp-wx-member`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `gender` char(1) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `source` char(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `login_count` int(11) DEFAULT NULL,
  `img_src` varchar(50) DEFAULT NULL,
  `last_visit` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`id`,`nick_name`,`gender`,`mobile`,`source`,`create_date`,`login_count`,`img_src`,`last_visit`) values 
(1,'用户32902333','0','12232313134','1','2021-01-07 09:07:44',2,NULL,'2021-05-21 16:04:21'),
(4,'用户32902333','1','18500287197','1','2021-03-04 11:12:38',1,NULL,'2021-05-21 16:04:23'),
(5,'用户32902333','1','13612646666','1','2021-03-10 17:28:49',1,NULL,'2021-05-21 16:04:26'),
(6,'用户32902333','1','18888888888','1','2021-03-11 11:27:31',1,NULL,'2021-05-21 16:04:26'),
(7,'用户32902222','1','18311369014','1','2021-03-12 15:24:49',1,NULL,'2021-05-21 16:04:26'),
(8,'用户32902231','1','13556666666','1','2021-03-23 15:20:45',1,NULL,'2021-05-21 16:04:26'),
(9,'用户32902231','1','18500287188','1','2021-03-23 15:23:53',1,NULL,'2021-05-21 16:04:26'),
(10,'用户37683564','1','18311369013','1','2021-03-23 15:25:39',1,NULL,'2021-05-21 16:04:26'),
(11,'用户68015372','1','18311369090','1','2021-03-29 09:41:47',1,NULL,'2021-05-21 16:04:26'),
(12,'用户09914024','1','15365166563','1','2021-03-30 12:34:20',1,NULL,'2021-05-21 16:04:26'),
(13,'用户96328556','1','17633345304','1','2021-03-30 12:47:48',1,NULL,'2021-05-21 16:04:26'),
(14,'用户60153447','1','15821470061','1','2021-03-31 11:19:40',1,NULL,'2021-05-21 16:04:26'),
(16,'用户08885455','1','18315097713','1','2021-04-03 21:10:31',NULL,NULL,NULL),
(17,'用户67098008','1','13228400178','1','2021-04-06 10:32:54',NULL,NULL,NULL),
(18,'用户71591376','1','13935812714','1','2021-04-08 16:14:41',NULL,NULL,NULL),
(19,'用户52117263','1','13236604627','1','2021-04-14 14:07:41',NULL,NULL,NULL),
(20,'用户06437035','1','15506337359','1','2021-04-21 16:58:24',NULL,NULL,NULL),
(21,'用户74876362','1','18168870536','1','2021-04-23 16:08:28',NULL,NULL,NULL),
(22,'用户47837883','1','18701357232','1','2021-04-24 19:15:07',NULL,NULL,NULL),
(29,'用户54200437','1','18824250377','1','2021-05-06 11:18:14',NULL,NULL,NULL),
(30,'用户85346731','1','15765964640','1','2021-05-08 09:38:22',NULL,NULL,NULL),
(31,'用户29084593','1','15650029132','1','2021-05-10 09:50:37',NULL,NULL,NULL),
(32,'用户53460288','1','15853227323','1','2021-05-11 16:40:55',NULL,NULL,NULL),
(33,'用户17698726','1','11111111','1','2021-05-14 17:36:08',NULL,NULL,NULL),
(34,'用户66052661','1','13999999999','1','2021-05-19 09:29:28',NULL,NULL,NULL),
(35,'用户08217560','1','15882770173','1','2021-05-19 14:48:09',NULL,NULL,NULL),
(36,'用户60352695','1','18994333979','1','2021-05-25 10:23:14',NULL,NULL,NULL),
(37,'用户53208066','1','18874934626','1','2021-05-26 16:09:34',NULL,NULL,NULL);

/*Table structure for table `member_address` */

DROP TABLE IF EXISTS `member_address`;

CREATE TABLE `member_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(100) DEFAULT NULL COMMENT '收货人真实名称',
  `mobile` varchar(20) DEFAULT NULL COMMENT '收货人手机号码',
  `address` varchar(500) DEFAULT NULL COMMENT '收货人地址',
  `member_id` int(11) DEFAULT NULL,
  `is_default` char(1) DEFAULT '1' COMMENT '0是1不是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `member_address` */

insert  into `member_address`(`id`,`real_name`,`mobile`,`address`,`member_id`,`is_default`) values 
(1,'张三1','19999999235','北京 密云区 城区1111111111111111111111',4,'1'),
(2,'a','11111111112','辽宁 本溪市 本溪县adsfasdfasd',4,'1'),
(3,'里斯','19999999255','浙江 台州市 三门县adadsfafd',4,'1'),
(6,'张三','19999999255','北京 密云区 城区以外弄11',7,'1'),
(7,'李四','19999999235','天津 河北区 全境天河家园',7,'0'),
(8,'张三','19999999255','甘肃 定西市 岷县222',10,'1'),
(9,'李四','19999999235','山东 烟台市 开发区22222222222222',10,'1'),
(10,'王五','12222222222','黑龙江 哈尔滨市 宾县3333333333333333',10,'1'),
(11,'赵六','11111111111','重庆 江北区 铁山坪镇222',10,'0'),
(12,'哈哈','15821477061','上海 虹口区 城区208',14,'0'),
(13,'WeiKang Xuan','15365166563','山西 太原市 迎泽区江苏南京奥术大师大所',12,'0'),
(14,'ww','18315097713','重庆 开县 天和镇无',16,'0'),
(15,'lxl','15536366584','北京 昌平区 六环以内无',18,'0'),
(17,'北京','18701357232','北京 大兴区 六环以外黄村',22,'0'),
(19,'贾宝玉','11111111111','上海 闸北区 城区顾村公园',7,'1'),
(20,'12123','18824250377','上海 闸北区 城区111',29,'0'),
(21,'王志胜','15765964641','黑龙江 大庆市 萨尔图区东北石油大学启智',30,'0'),
(22,'啊啊啊','15842568452','天津 河北区 全境两居室',32,'0'),
(23,'let go','19999999252','陕西 铜川市 宜君县北大青鸟',34,'0'),
(24,'dd','111','上海 闸北区 城区ddd',35,'0'),
(25,'fan fan','13111111111','上海 静安区 城区fanfanfanfanfanfanfanfanfanfanfanfanfanfan',36,'0'),
(26,'爱平','18874934626','湖南 长沙市 岳麓区马王堆',37,'0');

/*Table structure for table `msg_record` */

DROP TABLE IF EXISTS `msg_record`;

CREATE TABLE `msg_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识-主键',
  `category` bigint(20) NOT NULL COMMENT '类型（1.注册，2.找回密码等）',
  `category_name` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型名称',
  `mobile` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '手机',
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '短信内容',
  `sent_time` datetime DEFAULT NULL COMMENT '发送时间',
  `result` bit(1) DEFAULT NULL COMMENT '结果',
  `result_desc` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '结果描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='验证码记录';

/*Data for the table `msg_record` */

insert  into `msg_record`(`id`,`category`,`category_name`,`mobile`,`content`,`sent_time`,`result`,`result_desc`,`create_time`) values 
(1,2,'登录验证码','18512345672','290576','2019-09-10 11:45:05','','{\"Message\":\"OK\",\"RequestId\":\"CBD238AC-4B69-4951-9368-30694691295E\",\"BizId\":\"927002968087104732^0\",\"Code\":\"OK\"}','2019-09-10 11:45:05'),
(2,2,'登录验证码','18512345672','848828','2019-09-10 11:57:31','','{\"Message\":\"OK\",\"RequestId\":\"FA69C900-464F-456B-AF3C-05146AE49BAB\",\"BizId\":\"816712468087851087^0\",\"Code\":\"OK\"}','2019-09-10 11:57:31'),
(3,1,'注册验证码','18512345672','150702','2019-09-10 11:58:03','','{\"Message\":\"OK\",\"RequestId\":\"56CA20EC-DC3E-47D4-A114-CE758D551629\",\"BizId\":\"598413268087882704^0\",\"Code\":\"OK\"}','2019-09-10 11:58:03'),
(4,1,'登录注册','18311369014','5413','2021-04-13 16:53:08',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:5099008819865195990\",\"PhoneNumber\":\"+8618311369014\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"8329d867-4095-4963-aebe-bfc6d02fcdc1\"}','2021-04-13 16:53:08'),
(5,1,'登录注册','13236604627','0772','2021-04-14 14:07:20',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:5131980167105115298\",\"PhoneNumber\":\"+8613236604627\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"518193da-cd0c-49c2-a9ea-cce45186bb3c\"}','2021-04-14 14:07:20'),
(6,1,'登录注册','13236604627','4485','2021-04-14 14:07:20',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:5131979875047322898\",\"PhoneNumber\":\"+8613236604627\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"baa5acbc-3cba-4b6c-bb66-1a8ee4b99ba4\"}','2021-04-14 14:07:20'),
(7,1,'登录注册','13236604627','3129','2021-04-14 14:07:20',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2028:f825cdce1d49eb8a4100\",\"PhoneNumber\":\"+8613236604627\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"1146ad28-2faf-4b0e-b653-88c752ddb7db\"}','2021-04-14 14:07:20'),
(8,1,'登录注册','18311369014','2648','2021-04-19 10:17:54',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:5307805803101977103\",\"PhoneNumber\":\"+8618311369014\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"b1449d59-6ccd-4d6d-9de0-f850afb600bb\"}','2021-04-19 10:17:54'),
(9,1,'登录注册','15506337359','7185','2021-04-21 16:58:11',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2425:178939704916189954905803735\",\"PhoneNumber\":\"+8615506337359\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"87804ccd-327e-49b4-a9f9-a7a149216a8b\"}','2021-04-21 16:58:11'),
(10,1,'登录注册','15506337359','8140','2021-04-21 16:58:11',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:5387328273638656307\",\"PhoneNumber\":\"+8615506337359\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"86a25dfd-9ee9-4c7f-9363-29a17aa52c5f\"}','2021-04-21 16:58:11'),
(11,1,'登录注册','18168870536','3830','2021-04-23 16:08:07',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:5458505158862703644\",\"PhoneNumber\":\"+8618168870536\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"0ead99b1-fe78-45d4-a366-6dc9aabc9b70\"}','2021-04-23 16:08:07'),
(12,1,'登录注册','18701357232','0468','2021-04-24 19:14:56',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:5498030677735947826\",\"PhoneNumber\":\"+8618701357232\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"4bb4860b-94ed-435d-8e51-577cb4159872\"}','2021-04-24 19:14:56'),
(13,1,'登录注册','18311369014','7326','2021-05-17 17:06:51',NULL,'{\"SendStatusSet\":[{\"SerialNo\":\"2019:6396356399460670353\",\"PhoneNumber\":\"+8618311369014\",\"Fee\":1,\"SessionContext\":\"\",\"Code\":\"Ok\",\"Message\":\"send success\"}],\"RequestId\":\"055232fc-5398-4aa7-bd3d-b051b803b43c\"}','2021-05-17 17:06:51'),
(14,1,'登录注册','18311369014','6254','2021-05-19 09:29:10',NULL,'','2021-05-19 09:29:10'),
(15,1,'登录注册','13999999999','6870','2021-05-19 09:29:22',NULL,'','2021-05-19 09:29:22'),
(16,1,'登录注册','15882770173','5261','2021-05-19 14:48:02',NULL,'','2021-05-19 14:48:02'),
(17,1,'登录注册','18311369014','5172','2021-05-19 16:09:53',NULL,'','2021-05-19 16:09:53'),
(18,1,'登录注册','18994333979','1246','2021-05-25 10:23:05',NULL,'','2021-05-25 10:23:05'),
(19,1,'登录注册','18874934626','2845','2021-05-26 16:09:26',NULL,'','2021-05-26 16:09:26'),
(20,1,'登录注册','9','2054','2021-05-26 18:11:28',NULL,'','2021-05-26 18:11:28');

/*Table structure for table `undo_log` */

DROP TABLE IF EXISTS `undo_log`;

CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `undo_log` */

/*Table structure for table `wx_msg` */

DROP TABLE IF EXISTS `wx_msg`;

CREATE TABLE `wx_msg` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `del_flag` char(2) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `app_name` varchar(50) DEFAULT NULL COMMENT '公众号名称',
  `app_logo` varchar(500) DEFAULT NULL COMMENT '公众号logo',
  `wx_user_id` varchar(32) NOT NULL COMMENT '微信用户ID',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '微信用户昵称',
  `headimg_url` varchar(1000) DEFAULT NULL COMMENT '微信用户头像',
  `type` char(2) DEFAULT NULL COMMENT '消息分类（1、用户发给公众号；2、公众号发给用户；）',
  `rep_type` char(20) DEFAULT NULL COMMENT '消息类型（text：文本；image：图片；voice：语音；video：视频；shortvideo：小视频；location：地理位置；music：音乐；news：图文；event：推送事件）',
  `rep_event` char(20) DEFAULT NULL COMMENT '事件类型（subscribe：关注；unsubscribe：取关；CLICK、VIEW：菜单事件）',
  `rep_content` text COMMENT '回复类型文本保存文字、地理位置信息',
  `rep_media_id` varchar(64) DEFAULT NULL COMMENT '回复类型imge、voice、news、video的mediaID或音乐缩略图的媒体id',
  `rep_name` varchar(100) DEFAULT NULL COMMENT '回复的素材名、视频和音乐的标题',
  `rep_desc` varchar(200) DEFAULT NULL COMMENT '视频和音乐的描述',
  `rep_url` varchar(500) DEFAULT NULL COMMENT '链接',
  `rep_hq_url` varchar(500) DEFAULT NULL COMMENT '高质量链接',
  `content` mediumtext COMMENT '图文消息的内容',
  `rep_thumb_media_id` varchar(64) DEFAULT NULL COMMENT '缩略图的媒体id',
  `rep_thumb_url` varchar(500) DEFAULT NULL COMMENT '缩略图url',
  `rep_location_x` double DEFAULT NULL COMMENT '地理位置维度',
  `rep_location_y` double DEFAULT NULL COMMENT '地理位置经度',
  `rep_scale` double DEFAULT NULL COMMENT '地图缩放大小',
  `read_flag` char(2) DEFAULT '1' COMMENT '已读标记（1：是；0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信消息';

/*Data for the table `wx_msg` */

/*Table structure for table `wx_user` */

DROP TABLE IF EXISTS `wx_user`;

CREATE TABLE `wx_user` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '用户备注',
  `del_flag` char(2) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `app_type` char(2) DEFAULT NULL COMMENT '应用类型(1:小程序，2:公众号)',
  `subscribe` char(2) DEFAULT NULL COMMENT '是否订阅（1：是；0：否；2：网页授权用户）',
  `subscribe_scene` varchar(50) DEFAULT NULL COMMENT '返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他',
  `subscribe_time` datetime DEFAULT NULL COMMENT '关注时间',
  `subscribe_num` int(11) DEFAULT NULL COMMENT '关注次数',
  `cancel_subscribe_time` datetime DEFAULT NULL COMMENT '取消关注时间',
  `open_id` varchar(64) NOT NULL COMMENT '用户标识',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `sex` char(2) DEFAULT NULL COMMENT '性别（1：男，2：女，0：未知）',
  `city` varchar(64) DEFAULT NULL COMMENT '所在城市',
  `country` varchar(64) DEFAULT NULL COMMENT '所在国家',
  `province` varchar(64) DEFAULT NULL COMMENT '所在省份',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `language` varchar(64) DEFAULT NULL COMMENT '用户语言',
  `headimg_url` varchar(1000) DEFAULT NULL COMMENT '头像',
  `union_id` varchar(64) DEFAULT NULL COMMENT 'union_id',
  `group_id` varchar(64) DEFAULT NULL COMMENT '用户组',
  `tagid_list` varchar(64) DEFAULT NULL COMMENT '标签列表',
  `qr_scene_str` varchar(64) DEFAULT NULL COMMENT '二维码扫码场景',
  `latitude` double DEFAULT NULL COMMENT '地理位置纬度',
  `longitude` double DEFAULT NULL COMMENT '地理位置经度',
  `precision` double DEFAULT NULL COMMENT '地理位置精度',
  `session_key` varchar(200) DEFAULT NULL COMMENT '会话密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_openid` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_user` */

insert  into `wx_user`(`id`,`create_id`,`create_time`,`update_id`,`update_time`,`remark`,`del_flag`,`app_type`,`subscribe`,`subscribe_scene`,`subscribe_time`,`subscribe_num`,`cancel_subscribe_time`,`open_id`,`nick_name`,`sex`,`city`,`country`,`province`,`phone`,`language`,`headimg_url`,`union_id`,`group_id`,`tagid_list`,`qr_scene_str`,`latitude`,`longitude`,`precision`,`session_key`) values 
('1352168072700571649',NULL,'2021-01-21 16:16:05',NULL,'2021-01-21 16:37:22',NULL,'0','1',NULL,NULL,NULL,NULL,NULL,'ol3ea5DyEplVd0B5lD9gLwCme8zw','JL','1','深圳','中国','广东',NULL,'zh_CN','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKRsdzV55M85n8DAsVhH7wrS05ficLFjQMLlZUdUichYqZKKCB2GyibRGJNZ3JvPzVWg5hVVRx9hACEw/132',NULL,NULL,'[]',NULL,NULL,NULL,NULL,'CNKq11a69WSezik2aobqsA=='),
('1352233320682930178',NULL,'2021-01-21 20:35:21',NULL,'2021-01-21 21:16:01',NULL,'0','1',NULL,NULL,NULL,NULL,NULL,'ol3ea5HBFdkSYTC4uzf9gvW3cutU','NULL','1','长沙','中国','湖南',NULL,'zh_CN','https://thirdwx.qlogo.cn/mmopen/vi_32/chMqczIChvg1AXBmBran0EzkD4f52jKEpRFmIweBDN1QpeC4JPN5HKE3fgUYFNAFN4warrIQhEj69SCkY2zyYA/132',NULL,NULL,'[]',NULL,NULL,NULL,NULL,'jSa/lKtJmYPVHZcTl7r5kw=='),
('1352572935968165889',NULL,'2021-01-22 19:04:52',NULL,'2021-01-22 19:05:20',NULL,'0','1',NULL,NULL,NULL,NULL,NULL,'ol3ea5HWkzS2_iL2nBoao-nsxlgI','Ethan.D','1','益阳','中国','湖南',NULL,'zh_CN','https://thirdwx.qlogo.cn/mmopen/vi_32/5DPIvtrqFPv2hcU09UmW3fGQXzIwmO8iciajsHNTzz1NrlwBeVm5ou8HCaO7kXIDmVwhoqnicIibI4BXf8GlKFN7YA/132',NULL,NULL,'[]',NULL,NULL,NULL,NULL,'G87A8PJ+HeqJzeVxW/tYpA=='),
('1354473059078176770',NULL,'2021-01-28 00:55:16',NULL,'2021-01-28 00:55:23',NULL,'0','1',NULL,NULL,NULL,NULL,NULL,'oJ-q55T2ZXs-p68eMcouJR7IFVQw','JL','1','深圳','中国','广东',NULL,'zh_CN','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJru7MZse3ErXMMsSSQ3rcrBoESJN5F9p7xibr1u54DaGv3NGb6Z9tSTsJ07VsYCBFW7GWkQhIJc2A/132',NULL,NULL,'[]',NULL,NULL,NULL,NULL,'ooeYfyhjXVSVndtbfWtLNQ=='),
('1355406809988345857',NULL,'2021-01-30 14:45:40',NULL,'2021-01-30 14:50:37',NULL,'0','1',NULL,NULL,NULL,NULL,NULL,'oJ-q55eVbz74-EiU2f-j1Rie_BwM','NULL','1','长沙','中国','湖南',NULL,'zh_CN','https://thirdwx.qlogo.cn/mmopen/vi_32/cuTB5LL4dia7CJLqAxV2ibE8OiawFCcF4yRduugIxZTnJBmye7wddrErqShW1JkmXgYibDSKgib2cicURicLaPPknGGjw/132',NULL,NULL,'[]',NULL,NULL,NULL,NULL,'YM7Jk6qAfQ3yr8jNNbj2ww=='),
('1356171782972882945',NULL,'2021-02-01 17:25:25',NULL,'2021-02-02 22:44:21',NULL,'0','1',NULL,NULL,NULL,NULL,NULL,'oJ-q55a_buCs7ozlJOBHYgm6b_ko','Ethan.D','1','益阳','中国','湖南',NULL,'zh_CN','https://thirdwx.qlogo.cn/mmopen/vi_32/XdqjFObB4mmxQMURhIr5XzUgicRic3qOuXhz74OQnmHg4wKf5NUSm11ib0rXBsaIsJxGjicz1AY3a2Pz46iacqibfNqg/132',NULL,NULL,'[]',NULL,NULL,NULL,NULL,'oknUXi+2mvSjisq3vyGrtw=='),
('1357673320701546498',NULL,'2021-02-05 20:51:57',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-01-06 14:14:44',1,NULL,'o3QwG1QnY-BOe4M724t0dvVQaUUo','魂散','0','','','',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/PiajxSqBRaEK4NgUCJLPziclZYMfTnaYFXvz1GajlxariavaOkbKsXzXMoVHO6E5LKUWaaxxQccLVaicYR2Zqv5ZnA/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320701546499',NULL,'2021-02-05 20:51:57',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-10-29 23:34:34',1,NULL,'o3QwG1YepdGeVJZv_2bfIEjwnb_I','愈辉','1','','亚美尼亚','',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/lV0d907m3OWXHibcSriareU9XpBCdBgkOd286EialAX0BtrWEdrhunepPEUq82E6wneLbtNttjKDMJSM7Y9HOnaRA/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320714129409',NULL,'2021-02-05 20:51:57',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-11-09 11:36:47',1,NULL,'o3QwG1ThD7gJ-qIXTDF88rly1VHg','八爪鱼','1','','中国','北京',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/lV0d907m3OW2BkZicF01PtUQera34FdW1Ga68DhZxQ7MlGMLDG3DZIBMm2Cibjueb6NMDvRMMRZFqjMVEogD9Oibw/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320722518017',NULL,'2021-02-05 20:51:58',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-12-05 16:04:40',1,NULL,'o3QwG1ZP0s_alsf-PuhDU7CmLQ24','十万伏特','1','成都','中国','四川',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/J6c32680OdZUtzqT9zvNO2QR8jG1jdPiaFFQVA91Szrnpke0ga7UCCXGTKqZIppyibuhv6NTRX3OXqPtSQey8Ww0qgzhqicUgGR/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320730906626',NULL,'2021-02-05 20:51:58',NULL,NULL,'备注','0','2','1','ADD_SCENE_QR_CODE','2021-01-23 11:54:59',1,NULL,'o3QwG1Z4EZBdLwtKbK9TozDunLZw','Allen','1','成都','中国','四川',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/OT05QvwvgZZ3KeIaQ25CrjHF9rQTpZhO4RM1szUEcUdfLjEcFoicD3snicPq8GIqiayc1Ned8CIY5Gk5kCInF4TrR07Isicn4gFS/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320739295234',NULL,'2021-02-05 20:51:58',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2021-01-18 14:27:13',1,NULL,'o3QwG1UuAz7VYM24e9rmihxyKJvg','JL','1','深圳','中国','广东',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/dMKNvxZfIaEco8NogUXngnPhXrEEzLoY69XP5ymS2RWFIyXpOGE8trxiaqydnIibicluloYMWO06qmmibuvZR6GEbYR1HmVCq41R/132',NULL,'{}','[107,2]','1',NULL,NULL,NULL,NULL),
('1357673320747683841',NULL,'2021-02-05 20:51:58',NULL,NULL,'99','0','2','1','ADD_SCENE_QR_CODE','2021-01-11 17:43:37',1,NULL,'o3QwG1XWOtVl_ifcXYbPuiaPPnMc','redis','1','','中国','',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/lV0d907m3OU18kicFJhIBibV0XlvEnWzKN09tvVz3wyryA2cysGibW8BarSLyia8HeuOx8YDibGE192BibXG1xTtfC2nXf0x3MZS1x/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320747683842',NULL,'2021-02-05 20:51:58',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-03-16 10:32:31',1,NULL,'o3QwG1ecy727RcaP3XyevHbPK33M','、','1','厦门','中国','福建',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/OT05QvwvgZYuck1R4BqYzwFzicuAicDHSeJTKI21VvxgrUxEWnVxiaEseEVLnM2tzibxTIfUiaZ1aSLn4hJ8FSgu7EBgeID2LCh9s/132',NULL,'{}','[2]','1',NULL,NULL,NULL,NULL),
('1357673320747683843',NULL,'2021-02-05 20:51:58',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-11-09 20:41:24',1,NULL,'o3QwG1RLqJDTP-KZfNxMrMOKpl1U','gameover!!!','1','武汉','中国','湖北',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/upjJ1bex0ocf0rsbPbSW6yorFpT2SicGibyia5bYRjqLpWDgnYR4icEtQ87TcDibO3qujm8wkhDib4CPQCldShq1FHovW9J2ibSsfFH/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320747683844',NULL,'2021-02-05 20:51:58',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-10-14 14:32:49',1,NULL,'o3QwG1f7sT5V_FV_EVj4kaQ09Zzs','壹杯淸茶。','1','青岛','中国','山东',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCYmmGPrvvXcib0iaiaGQba4yFtwt35zEUgOAzGwPcwG2GIqmejmo8fxRibwQzSDibejrXV4dia1uiaanvXrZ3SKZyZiaEo3G2K8WhDTjs/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320756072449',NULL,'2021-02-05 20:51:58',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-02-24 16:49:28',1,NULL,'o3QwG1eaqyTxxW4VisfbaKL0BcWY','.Llkoi','1','长沙','中国','湖南',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/TBfgdHR2VFWloL25J3r1DfDE3a5R3yctJD3wc5CSoe3xWmy4lZPzxRZpj2x14dl87ndzlRXAN1ZN2W7w1n8bYtKWOMxG8ahq/132',NULL,'{}','[2]','1',NULL,NULL,NULL,NULL),
('1357673320760266753',NULL,'2021-02-05 20:51:58',NULL,NULL,'','0','2','1','ADD_SCENE_QR_CODE','2020-06-17 22:14:41',1,NULL,'o3QwG1d4Bq8lg-NbUOOYdaaVWhnE','Quentin','1','南京','中国','江苏',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/ceebSkrkkFTBe1cSDicrLGq05uMsfRkzNWhKp3JY6eISxwCoiagt6q2L4RGcGh61jnWWTI3xeXsAmFCEpozdSIDQKBhNosic8TY/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL),
('1357673320760266754',NULL,'2021-02-05 20:51:58',NULL,NULL,'后来','0','2','1','ADD_SCENE_QR_CODE','2019-06-04 22:22:21',1,NULL,'o3QwG1aKxN5AMEaNSbDV-vHJHtvM','安安晨晨','2','益阳','中国','湖南',NULL,'zh_CN','http://thirdwx.qlogo.cn/mmopen/ceebSkrkkFTRWgtVgYzPOETJtkqz0TIOzpVber8ic5DlUTky6zpgTGJHic6gG4wH7B7iay12QHo7BF3Iv0r6vTfS2GkcdywCmN8/132',NULL,'{}','[]','1',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
