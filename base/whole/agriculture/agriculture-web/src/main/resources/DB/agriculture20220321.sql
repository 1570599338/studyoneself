/*
Navicat MySQL Data Transfer

Source Server         : localhost3306
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : agriculture

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2022-03-21 21:39:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shiro_user
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(32) DEFAULT NULL COMMENT '密码',
  `Author` varchar(200) DEFAULT NULL COMMENT '授权',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_user
-- ----------------------------
INSERT INTO `shiro_user` VALUES ('1', 'admin', '123', 'user:add');
INSERT INTO `shiro_user` VALUES ('2', 'tom', '123', 'user:update');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');
INSERT INTO `sys_config` VALUES ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '0', '0', 'xx科技', '0', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('101', '100', '0,100', '深圳总公司', '1', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('102', '100', '0,100', '长沙分公司', '2', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('103', '101', '0,100,101', '研发部门', '1', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('104', '101', '0,100,101', '市场部门', '2', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('105', '101', '0,100,101', '测试部门', '3', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('106', '101', '0,100,101', '财务部门', '4', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('107', '101', '0,100,101', '运维部门', '5', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('108', '102', '0,100,102', '市场部门', '1', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('109', '102', '0,100,102', '财务部门', '2', '', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知');
INSERT INTO `sys_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单');
INSERT INTO `sys_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认分组');
INSERT INTO `sys_dict_data` VALUES ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统分组');
INSERT INTO `sys_dict_data` VALUES ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是');
INSERT INTO `sys_dict_data` VALUES ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否');
INSERT INTO `sys_dict_data` VALUES ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知');
INSERT INTO `sys_dict_data` VALUES ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告');
INSERT INTO `sys_dict_data` VALUES ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态');
INSERT INTO `sys_dict_data` VALUES ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作');
INSERT INTO `sys_dict_data` VALUES ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作');
INSERT INTO `sys_dict_data` VALUES ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作');
INSERT INTO `sys_dict_data` VALUES ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作');
INSERT INTO `sys_dict_data` VALUES ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作');
INSERT INTO `sys_dict_data` VALUES ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作');
INSERT INTO `sys_dict_data` VALUES ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作');
INSERT INTO `sys_dict_data` VALUES ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作');
INSERT INTO `sys_dict_data` VALUES ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('29', '1', '计算机类', '0', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:14:42', 'admin', '2020-02-05 10:37:05', '');
INSERT INTO `sys_dict_data` VALUES ('30', '1', '文职类', '1', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:15:05', 'admin', '2020-02-05 10:37:16', '');
INSERT INTO `sys_dict_data` VALUES ('31', '2', '销售类', '2', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:15:18', 'admin', '2020-02-05 10:37:27', '');
INSERT INTO `sys_dict_data` VALUES ('32', '0', '1000以下', '0', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:18', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('33', '1', '1000~3000', '1', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:34', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('34', '2', '3001~8000', '2', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:51', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('35', '3', '8001~12000', '3', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:17:07', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('36', '0', '未发布', '0', 'job_resume_status', null, null, 'Y', '0', 'admin', '2020-02-05 10:26:54', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('37', '1', '发布', '1', 'job_resume_status', null, null, 'Y', '0', 'admin', '2020-02-05 10:27:06', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('38', '0', '北京市', '0', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:31', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('39', '1', '上海市', '1', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:40', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('40', '2', '广州市', '2', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:51', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('41', '3', '深圳市', '3', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:14:03', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('42', '0', '未处理', '0', 'job_operate_status', null, null, 'Y', '0', 'admin', '2020-02-05 18:18:19', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('43', '1', '已处理', '1', 'job_operate_status', null, null, 'Y', '0', 'admin', '2020-02-05 18:18:32', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('44', '0', '同意', '0', 'job_operate_result', null, null, 'Y', '0', 'admin', '2020-02-05 18:19:13', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('45', '1', '拒绝', '1', 'job_operate_result', null, null, 'Y', '0', 'admin', '2020-02-05 18:19:20', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('46', '1', '30天(10元)', '10', 'job_vip_level', '', '', 'Y', '0', 'admin', '2020-02-07 13:27:38', 'admin', '2020-02-07 13:29:08', '');
INSERT INTO `sys_dict_data` VALUES ('47', '2', '90天(25元)', '25', 'job_vip_level', '', '', 'Y', '0', 'admin', '2020-02-07 13:27:58', 'admin', '2020-02-07 13:29:01', '');
INSERT INTO `sys_dict_data` VALUES ('48', '3', '180天(45元)', '45', 'job_vip_level', null, null, 'Y', '0', 'admin', '2020-02-07 13:28:51', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('49', '4', '360天(80元)', '80', 'job_vip_level', null, null, 'Y', '0', 'admin', '2020-02-07 13:29:34', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('50', '1', '20人以下', '1', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:12', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('51', '2', '20~50人', '2', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:30', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('52', '3', '50~100人', '3', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:46', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('53', '4', '100~500人', '4', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:10:00', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('54', '5', '500人以上', '5', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:10:14', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('55', '1', '金融/投资/证券', '1', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:11:35', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('56', '2', '计算机软件', '2', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:11:51', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('57', '3', '汽车及零配件', '3', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:12:26', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('58', '4', '房地产/汽车', '4', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:12:40', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('59', '5', '快速消费品(食品、饮料、化妆品) 批发/零售', '5', 'job_enterprise_category', '', 'primary', 'Y', '0', 'admin', '2020-02-10 14:15:16', 'admin', '2022-02-11 16:53:06', '123');
INSERT INTO `sys_dict_data` VALUES ('60', '1', '未发布', '0', 'isPublish', null, null, 'Y', '0', 'admin', '2022-03-19 18:20:42', '', null, '未发布');
INSERT INTO `sys_dict_data` VALUES ('61', '2', '已发布', '1', 'isPublish', null, null, 'Y', '0', 'admin', '2022-03-19 18:21:02', '', null, '已发布');
INSERT INTO `sys_dict_data` VALUES ('62', '1', '首页轮播', '0', 'project_post', null, null, 'Y', '0', 'admin', '2022-03-19 18:22:07', '', null, '首页轮播');
INSERT INTO `sys_dict_data` VALUES ('63', '1', '其他位置', '1', 'project_post', null, null, 'Y', '0', 'admin', '2022-03-19 18:22:20', '', null, '其他位置');
INSERT INTO `sys_dict_data` VALUES ('64', '1', '资金类型', '0', 'project-type', null, null, 'Y', '0', 'admin', '2022-03-19 18:24:18', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('65', '2', '人力物力', '1', 'project-type', null, null, 'Y', '0', 'admin', '2022-03-19 18:24:34', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('66', '1', '线上捐款', '0', 'donate_type', null, null, 'Y', '0', 'admin', '2022-03-20 01:20:31', '', null, '线上捐款');
INSERT INTO `sys_dict_data` VALUES ('67', '2', '线下捐款', '1', 'donate_type', null, null, 'Y', '0', 'admin', '2022-03-20 01:20:49', '', null, '线下捐款');
INSERT INTO `sys_dict_data` VALUES ('68', '1', '支付宝', '0', 'pay_type', null, null, 'Y', '0', 'admin', '2022-03-20 01:21:46', '', null, '支付宝方式支付');
INSERT INTO `sys_dict_data` VALUES ('69', '2', '微信支付', '1', 'pay_type', null, null, 'Y', '0', 'admin', '2022-03-20 01:21:59', '', null, '微信支付');
INSERT INTO `sys_dict_data` VALUES ('70', '1', '初始状态', '0', 'system_project_audit', null, null, 'Y', '0', 'admin', '2022-03-20 03:55:53', '', null, '初始状态');
INSERT INTO `sys_dict_data` VALUES ('71', '2', '审核成功', '1', 'system_project_audit', null, null, 'Y', '0', 'admin', '2022-03-20 03:56:11', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('72', '3', '审核失败', '2', 'system_project_audit', null, null, 'Y', '0', 'admin', '2022-03-20 03:56:46', '', null, '审核失败');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES ('5', '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表');
INSERT INTO `sys_dict_type` VALUES ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES ('10', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES ('11', '职位类别', 'job_position_type', '0', 'admin', '2020-02-05 10:13:26', 'admin', '2020-02-05 10:25:47', '职位类别');
INSERT INTO `sys_dict_type` VALUES ('12', '薪资范围', 'job_salary', '0', 'admin', '2020-02-05 10:15:51', 'admin', '2020-02-05 10:25:40', '');
INSERT INTO `sys_dict_type` VALUES ('13', '简历状态', 'job_resume_status', '0', 'admin', '2020-02-05 10:26:28', '', null, null);
INSERT INTO `sys_dict_type` VALUES ('14', '地区', 'job_area', '0', 'admin', '2020-02-05 12:13:16', '', null, null);
INSERT INTO `sys_dict_type` VALUES ('15', '处理状态', 'job_operate_status', '0', 'admin', '2020-02-05 18:18:02', '', null, null);
INSERT INTO `sys_dict_type` VALUES ('16', '处理结果', 'job_operate_result', '0', 'admin', '2020-02-05 18:18:52', '', null, null);
INSERT INTO `sys_dict_type` VALUES ('17', 'VIP等级', 'job_vip_level', '0', 'admin', '2020-02-07 13:27:08', '', null, null);
INSERT INTO `sys_dict_type` VALUES ('18', '企业规模', 'job_enterprise_scale', '0', 'admin', '2020-02-10 13:08:24', '', null, null);
INSERT INTO `sys_dict_type` VALUES ('19', '企业性质', 'job_enterprise_category', '0', 'admin', '2020-02-10 13:10:54', '', null, null);
INSERT INTO `sys_dict_type` VALUES ('20', '发布状态', 'isPublish', '0', 'admin', '2022-03-19 18:19:51', '', null, '发布状态');
INSERT INTO `sys_dict_type` VALUES ('21', '项目位置', 'project_post', '0', 'admin', '2022-03-19 18:21:42', '', null, '项目位置');
INSERT INTO `sys_dict_type` VALUES ('22', '项目扶贫类型', 'project-type', '0', 'admin', '2022-03-19 18:23:40', '', null, '项目扶贫类型');
INSERT INTO `sys_dict_type` VALUES ('23', '捐款形式', 'donate_type', '0', 'admin', '2022-03-20 01:20:09', '', null, '捐款形式');
INSERT INTO `sys_dict_type` VALUES ('24', '支付方式', 'pay_type', '0', 'admin', '2022-03-20 01:21:23', '', null, '支付方式');
INSERT INTO `sys_dict_type` VALUES ('25', '审核状态', 'system_project_audit', '0', 'admin', '2022-03-20 03:55:09', '', null, null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1132 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', '#', '', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '志愿者', '0', '2', '#', 'menuItem', 'M', '0', '', 'fa fa-handshake-o', 'admin', '2018-03-16 11:33:00', 'admin', '2022-03-21 20:25:21', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '扶贫项目', '0', '3', '#', 'menuItem', 'M', '0', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00', 'admin', '2022-01-13 13:49:04', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('4', '扶贫项目申请', '0', '4', '#', 'menuItem', 'M', '0', '', 'fa fa-book', 'admin', '2018-03-16 11:33:00', 'admin', '2022-03-20 02:07:57', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('5', '关于我们', '0', '1', '#', 'menuItem', 'M', '0', null, 'fa fa-area-chart', 'admin', '2022-02-21 11:04:44', 'admin', '2022-02-21 14:45:21', '');
INSERT INTO `sys_menu` VALUES ('10', '惠农之路', '0', '1', '#', 'menuItem', 'M', '0', null, 'fa fa-area-chart', 'admin', '2022-02-21 11:04:44', 'admin', '2022-02-21 14:45:21', '');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', '/system/user', '', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', '/system/role', '', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', '/system/menu', '', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', '/system/dict', '', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', '/system/config', 'menuItem', 'C', '1', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2022-03-21 20:24:24', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('1000', '用户查询', '100', '1', '#', '', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1001', '用户新增', '100', '2', '#', '', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1002', '用户修改', '100', '3', '#', '', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1003', '用户删除', '100', '4', '#', '', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1004', '用户导出', '100', '5', '#', '', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导入', '100', '6', '#', '', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1006', '重置密码', '100', '7', '#', '', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1007', '角色查询', '101', '1', '#', '', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1008', '角色新增', '101', '2', '#', '', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1009', '角色修改', '101', '3', '#', '', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1010', '角色删除', '101', '4', '#', '', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1011', '角色导出', '101', '5', '#', '', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1012', '菜单查询', '102', '1', '#', '', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单新增', '102', '2', '#', '', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单修改', '102', '3', '#', '', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1015', '菜单删除', '102', '4', '#', '', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1025', '字典查询', '105', '1', '#', '', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1026', '字典新增', '105', '2', '#', '', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1027', '字典修改', '105', '3', '#', '', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1028', '字典删除', '105', '4', '#', '', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1029', '字典导出', '105', '5', '#', '', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1030', '参数查询', '106', '1', '#', '', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1031', '参数新增', '106', '2', '#', '', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1032', '参数修改', '106', '3', '#', '', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1033', '参数删除', '106', '4', '#', '', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1034', '参数导出', '106', '5', '#', '', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1076', '待审核志愿者', '1075', '1', '/system/audit', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-battery-4', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:16:41', '');
INSERT INTO `sys_menu` VALUES ('1077', '查询', '1076', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, '');
INSERT INTO `sys_menu` VALUES ('1078', '审核', '1076', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, '');
INSERT INTO `sys_menu` VALUES ('1079', '待审核求助者', '1075', '1', '/system/auditQ', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-battery-0', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:16:30', '');
INSERT INTO `sys_menu` VALUES ('1080', '查询', '1079', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, '');
INSERT INTO `sys_menu` VALUES ('1081', '审核', '1079', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, '');
INSERT INTO `sys_menu` VALUES ('1082', '待审失败', '1075', '1', '/system/auditF', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-certificate', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:13:44', '');
INSERT INTO `sys_menu` VALUES ('1083', '查询', '1082', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, '');
INSERT INTO `sys_menu` VALUES ('1084', '审核', '1082', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, '');
INSERT INTO `sys_menu` VALUES ('1085', '求助管理', '0', '5', '#', 'menuItem', 'M', '0', null, 'fa fa-heartbeat', 'admin', '2022-02-21 21:12:17', 'admin', '2022-02-21 21:14:00', '');
INSERT INTO `sys_menu` VALUES ('1086', '扶贫项目', '3', '1', '/system/project', '', 'C', '0', 'system:project:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '扶贫项目菜单');
INSERT INTO `sys_menu` VALUES ('1087', '扶贫项目查询', '1086', '1', '#', '', 'F', '0', 'system:project:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1088', '扶贫项目新增', '1086', '2', '#', '', 'F', '0', 'system:project:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1089', '扶贫项目修改', '1086', '3', '#', '', 'F', '0', 'system:project:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1090', '扶贫项目删除', '1086', '4', '#', '', 'F', '0', 'system:project:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1091', '扶贫项目导出', '1086', '5', '#', '', 'F', '0', 'system:project:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1092', '捐款', '3', '1', '/system/donate', '', 'C', '0', 'system:donate:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '捐款菜单');
INSERT INTO `sys_menu` VALUES ('1093', '捐款查询', '1092', '1', '#', '', 'F', '0', 'system:donate:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1094', '捐款新增', '1092', '2', '#', '', 'F', '0', 'system:donate:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1095', '捐款修改', '1092', '3', '#', '', 'F', '0', 'system:donate:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1096', '捐款删除', '1092', '4', '#', '', 'F', '0', 'system:donate:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1097', '捐款导出', '1092', '5', '#', '', 'F', '0', 'system:donate:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1098', '扶贫项目审核', '3', '1', '/system/projectaduit', '', 'C', '0', 'system:project:auditview', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '扶贫项目菜单');
INSERT INTO `sys_menu` VALUES ('1099', '扶贫项目查询', '1098', '1', '#', '', 'F', '0', 'system:project:auditlist', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1100', '审核', '1098', '2', '#', '', 'F', '0', 'system:project:auditpass', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1101', '失败', '1098', '3', '#', '', 'F', '0', 'system:project:auditfailed', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1102', '扶贫申请', '4', '1', '/system/projectApply', '', 'C', '0', 'system:project:applyview', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1103', '扶贫项目查询', '1102', '1', '#', '', 'F', '0', 'system:project:applylist', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1104', '申请', '1102', '2', '#', '', 'F', '0', 'system:project:applyedit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1105', '申请', '4', '1', '/system/apply', '', 'C', '0', 'system:apply:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '申请菜单');
INSERT INTO `sys_menu` VALUES ('1106', '申请查询', '1105', '1', '#', '', 'F', '0', 'system:apply:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1107', '申请新增', '1105', '2', '#', '', 'F', '0', 'system:apply:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1108', '申请修改', '1105', '3', '#', '', 'F', '0', 'system:apply:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1109', '申请删除', '1105', '4', '#', '', 'F', '0', 'system:apply:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1110', '申请导出', '1105', '5', '#', '', 'F', '0', 'system:apply:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1111', '审核申请', '4', '1', '/system/applyaudit', '', 'C', '0', 'system:apply:auditview', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '申请菜单');
INSERT INTO `sys_menu` VALUES ('1112', '申请查询', '1111', '1', '#', '', 'F', '0', 'system:apply:auditlist', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1113', '审核', '1111', '2', '#', '', 'F', '0', 'system:apply:auditedit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1114', '申请导出', '1111', '3', '#', '', 'F', '0', 'system:apply:auditexport', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1115', '关于我们', '5', '1', '/system/about', '', 'C', '0', 'system:about:view', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '关于我们菜单');
INSERT INTO `sys_menu` VALUES ('1116', '查询', '1115', '1', '#', '', 'F', '0', 'system:about:list', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1117', '新增', '1115', '2', '#', '', 'F', '0', 'system:about:add', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1118', '修改', '1115', '3', '#', '', 'F', '0', 'system:about:edit', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1119', '删除', '1115', '4', '#', '', 'F', '0', 'system:about:remove', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1120', '志愿者风采', '3', '1', '/system/style', '', 'C', '0', 'system:style:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '志愿者风采菜单');
INSERT INTO `sys_menu` VALUES ('1121', '志愿者风采查询', '1120', '1', '#', '', 'F', '0', 'system:style:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1122', '志愿者风采新增', '1120', '2', '#', '', 'F', '0', 'system:style:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1123', '志愿者风采修改', '1120', '3', '#', '', 'F', '0', 'system:style:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1124', '志愿者风采删除', '1120', '4', '#', '', 'F', '0', 'system:style:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1125', '志愿者风采导出', '1120', '5', '#', '', 'F', '0', 'system:style:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1126', '惠农之路', '10', '1', '/system/activity', '', 'C', '0', 'system:activity:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '惠农之路菜单');
INSERT INTO `sys_menu` VALUES ('1127', '惠农之路查询', '1126', '1', '#', '', 'F', '0', 'system:activity:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1128', '惠农之路新增', '1126', '2', '#', '', 'F', '0', 'system:activity:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1129', '惠农之路修改', '1126', '3', '#', '', 'F', '0', 'system:activity:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1130', '惠农之路删除', '1126', '4', '#', '', 'F', '0', 'system:activity:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('1131', '惠农之路导出', '1126', '5', '#', '', 'F', '0', 'system:activity:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('1', '温馨提醒：2018-07-01 xx新版本发布啦', '2', '新版本内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_notice` VALUES ('2', '维护通知：2018-07-01 xx系统凌晨维护', '1', '维护内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1', 'ceo', '董事长', '1', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('2', 'se', '项目经理', '2', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('3', 'hr', '人力资源', '3', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('4', 'user', '普通员工', '4', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-05 09:50:56', '普通角色');
INSERT INTO `sys_role` VALUES ('3', '求职者', 'job_wanted', '3', '1', '0', '0', 'admin', '2020-02-05 11:25:28', 'admin', '2020-02-08 13:47:12', '');
INSERT INTO `sys_role` VALUES ('4', '企业', 'enterprise', '4', '1', '0', '0', 'admin', '2020-02-05 11:25:48', 'admin', '2020-02-10 13:58:33', '');
INSERT INTO `sys_role` VALUES ('5', '游客', 'tourist', '5', '1', '0', '0', 'admin', '2020-02-05 11:26:13', 'admin', '2022-03-21 20:38:49', '');
INSERT INTO `sys_role` VALUES ('6', '项目专员', 'project', '3', '1', '0', '0', 'admin', '2022-03-21 20:27:01', '', null, null);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('2', '100');
INSERT INTO `sys_role_dept` VALUES ('2', '101');
INSERT INTO `sys_role_dept` VALUES ('2', '105');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '100');
INSERT INTO `sys_role_menu` VALUES ('2', '101');
INSERT INTO `sys_role_menu` VALUES ('2', '102');
INSERT INTO `sys_role_menu` VALUES ('2', '103');
INSERT INTO `sys_role_menu` VALUES ('2', '104');
INSERT INTO `sys_role_menu` VALUES ('2', '105');
INSERT INTO `sys_role_menu` VALUES ('2', '106');
INSERT INTO `sys_role_menu` VALUES ('2', '107');
INSERT INTO `sys_role_menu` VALUES ('2', '108');
INSERT INTO `sys_role_menu` VALUES ('2', '109');
INSERT INTO `sys_role_menu` VALUES ('2', '110');
INSERT INTO `sys_role_menu` VALUES ('2', '111');
INSERT INTO `sys_role_menu` VALUES ('2', '112');
INSERT INTO `sys_role_menu` VALUES ('2', '113');
INSERT INTO `sys_role_menu` VALUES ('2', '114');
INSERT INTO `sys_role_menu` VALUES ('2', '115');
INSERT INTO `sys_role_menu` VALUES ('2', '500');
INSERT INTO `sys_role_menu` VALUES ('2', '501');
INSERT INTO `sys_role_menu` VALUES ('2', '1000');
INSERT INTO `sys_role_menu` VALUES ('2', '1001');
INSERT INTO `sys_role_menu` VALUES ('2', '1002');
INSERT INTO `sys_role_menu` VALUES ('2', '1003');
INSERT INTO `sys_role_menu` VALUES ('2', '1004');
INSERT INTO `sys_role_menu` VALUES ('2', '1005');
INSERT INTO `sys_role_menu` VALUES ('2', '1006');
INSERT INTO `sys_role_menu` VALUES ('2', '1007');
INSERT INTO `sys_role_menu` VALUES ('2', '1008');
INSERT INTO `sys_role_menu` VALUES ('2', '1009');
INSERT INTO `sys_role_menu` VALUES ('2', '1010');
INSERT INTO `sys_role_menu` VALUES ('2', '1011');
INSERT INTO `sys_role_menu` VALUES ('2', '1012');
INSERT INTO `sys_role_menu` VALUES ('2', '1013');
INSERT INTO `sys_role_menu` VALUES ('2', '1014');
INSERT INTO `sys_role_menu` VALUES ('2', '1015');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '1017');
INSERT INTO `sys_role_menu` VALUES ('2', '1018');
INSERT INTO `sys_role_menu` VALUES ('2', '1019');
INSERT INTO `sys_role_menu` VALUES ('2', '1020');
INSERT INTO `sys_role_menu` VALUES ('2', '1021');
INSERT INTO `sys_role_menu` VALUES ('2', '1022');
INSERT INTO `sys_role_menu` VALUES ('2', '1023');
INSERT INTO `sys_role_menu` VALUES ('2', '1024');
INSERT INTO `sys_role_menu` VALUES ('2', '1025');
INSERT INTO `sys_role_menu` VALUES ('2', '1026');
INSERT INTO `sys_role_menu` VALUES ('2', '1027');
INSERT INTO `sys_role_menu` VALUES ('2', '1028');
INSERT INTO `sys_role_menu` VALUES ('2', '1029');
INSERT INTO `sys_role_menu` VALUES ('2', '1030');
INSERT INTO `sys_role_menu` VALUES ('2', '1031');
INSERT INTO `sys_role_menu` VALUES ('2', '1032');
INSERT INTO `sys_role_menu` VALUES ('2', '1033');
INSERT INTO `sys_role_menu` VALUES ('2', '1034');
INSERT INTO `sys_role_menu` VALUES ('2', '1035');
INSERT INTO `sys_role_menu` VALUES ('2', '1036');
INSERT INTO `sys_role_menu` VALUES ('2', '1037');
INSERT INTO `sys_role_menu` VALUES ('2', '1038');
INSERT INTO `sys_role_menu` VALUES ('2', '1039');
INSERT INTO `sys_role_menu` VALUES ('2', '1040');
INSERT INTO `sys_role_menu` VALUES ('2', '1041');
INSERT INTO `sys_role_menu` VALUES ('2', '1042');
INSERT INTO `sys_role_menu` VALUES ('2', '1043');
INSERT INTO `sys_role_menu` VALUES ('2', '1044');
INSERT INTO `sys_role_menu` VALUES ('2', '1045');
INSERT INTO `sys_role_menu` VALUES ('2', '1046');
INSERT INTO `sys_role_menu` VALUES ('2', '1047');
INSERT INTO `sys_role_menu` VALUES ('2', '1048');
INSERT INTO `sys_role_menu` VALUES ('2', '1049');
INSERT INTO `sys_role_menu` VALUES ('2', '1050');
INSERT INTO `sys_role_menu` VALUES ('2', '1051');
INSERT INTO `sys_role_menu` VALUES ('2', '1052');
INSERT INTO `sys_role_menu` VALUES ('2', '1053');
INSERT INTO `sys_role_menu` VALUES ('2', '1054');
INSERT INTO `sys_role_menu` VALUES ('2', '1055');
INSERT INTO `sys_role_menu` VALUES ('2', '1056');
INSERT INTO `sys_role_menu` VALUES ('2', '1057');
INSERT INTO `sys_role_menu` VALUES ('2', '1058');
INSERT INTO `sys_role_menu` VALUES ('2', '1059');
INSERT INTO `sys_role_menu` VALUES ('2', '1060');
INSERT INTO `sys_role_menu` VALUES ('2', '1061');
INSERT INTO `sys_role_menu` VALUES ('3', '1062');
INSERT INTO `sys_role_menu` VALUES ('3', '1063');
INSERT INTO `sys_role_menu` VALUES ('3', '1065');
INSERT INTO `sys_role_menu` VALUES ('3', '1066');
INSERT INTO `sys_role_menu` VALUES ('3', '1067');
INSERT INTO `sys_role_menu` VALUES ('3', '1068');
INSERT INTO `sys_role_menu` VALUES ('3', '1070');
INSERT INTO `sys_role_menu` VALUES ('4', '1062');
INSERT INTO `sys_role_menu` VALUES ('4', '1064');
INSERT INTO `sys_role_menu` VALUES ('4', '1069');
INSERT INTO `sys_role_menu` VALUES ('4', '1085');
INSERT INTO `sys_role_menu` VALUES ('6', '3');
INSERT INTO `sys_role_menu` VALUES ('6', '1086');
INSERT INTO `sys_role_menu` VALUES ('6', '1087');
INSERT INTO `sys_role_menu` VALUES ('6', '1088');
INSERT INTO `sys_role_menu` VALUES ('6', '1089');
INSERT INTO `sys_role_menu` VALUES ('6', '1090');
INSERT INTO `sys_role_menu` VALUES ('6', '1091');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `vip` tinyint(3) DEFAULT '0' COMMENT '是否是vip（0否1是）',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', '0', 'admin', '', '00', 'ry@163.com', '15888888888', '1', '', '29c67a30398638269fe600f73a054934', '111111', '0', '0', '127.0.0.1', '2022-02-22 15:20:26', 'admin', '2018-03-16 11:33:00', 'ry', '2022-02-22 15:20:25', '管理员');
INSERT INTO `sys_user` VALUES ('2', '105', '0', 'ry', '', '00', 'ry@qq.com', '15666666666', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '127.0.0.1', '2020-02-05 09:49:08', 'admin', '2018-03-16 11:33:00', 'ry', '2020-02-05 09:49:08', '测试员');
INSERT INTO `sys_user` VALUES ('3', '103', '0', 'qiye', 'qiye', '00', '111@qq.com', '15838772858', '0', '', '151a40eb7f763342c7a8823f4f5f58c1', 'bdff5e', '0', '0', '127.0.0.1', '2022-01-25 11:15:47', 'admin', '2020-02-05 12:47:04', '', '2022-01-25 11:15:47', null);
INSERT INTO `sys_user` VALUES ('4', '103', '1', 'qiuzhi', 'qiuzhi', '00', '1111@qq.com', '13012345678', '0', '', '788a097bfcd367bd86b872f43ad63a5b', '5bab55', '0', '0', '127.0.0.1', '2022-01-25 11:17:06', 'admin', '2020-02-06 09:51:08', 'qiuzhi', '2022-01-25 11:17:06', null);
INSERT INTO `sys_user` VALUES ('5', '104', '0', 'aa', '测试', '00', '11011@qq.com', '13212345678', '0', '', '29c67a30398638269fe600f73a054934', '228558', '0', '0', '127.0.0.1', '2020-02-10 16:45:00', 'admin', '2020-02-06 14:20:16', 'aa', '2020-02-10 16:44:59', '');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1', '1');
INSERT INTO `sys_user_post` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '4');
INSERT INTO `sys_user_role` VALUES ('4', '3');
INSERT INTO `sys_user_role` VALUES ('5', '3');
INSERT INTO `sys_user_role` VALUES ('6', '5');
INSERT INTO `sys_user_role` VALUES ('7', '5');
INSERT INTO `sys_user_role` VALUES ('8', '5');
INSERT INTO `sys_user_role` VALUES ('9', '5');
INSERT INTO `sys_user_role` VALUES ('10', '5');
INSERT INTO `sys_user_role` VALUES ('11', '5');
INSERT INTO `sys_user_role` VALUES ('12', '5');
INSERT INTO `sys_user_role` VALUES ('13', '5');
INSERT INTO `sys_user_role` VALUES ('14', '5');
INSERT INTO `sys_user_role` VALUES ('15', '5');

-- ----------------------------
-- Table structure for t_about
-- ----------------------------
DROP TABLE IF EXISTS `t_about`;
CREATE TABLE `t_about` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT '' COMMENT '名称',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片地址',
  `content` longtext COMMENT '内容',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='关于我们';

-- ----------------------------
-- Records of t_about
-- ----------------------------
INSERT INTO `t_about` VALUES ('1', '关于我们', '71ce7172c71eba55bb51bf70cb81da1f.jpg', '<p>我只想保持最初的那份单纯和善良。不带有任何一丝杂质。</p>', '0', 'zxj', '2022-03-20 20:08:00', 'admin', '2022-03-21 19:45:33', null);

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT '' COMMENT '标题',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片地址',
  `activity_short` varchar(1000) DEFAULT '' COMMENT '简介',
  `activity_info` longtext COMMENT '主要内容',
  `is_publish` int(2) DEFAULT '0' COMMENT '审核状态 0：带发布  1：发布',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='惠农之路';

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('1', '1234', '9c33fc4da8bf4871bbb25a828fe97ef1.jpg', '12342134', '去玩儿', '1', '0', '', '2022-03-21 16:43:34', '', '2022-03-21 19:06:16', null);

-- ----------------------------
-- Table structure for t_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '姓名',
  `tel` varchar(100) DEFAULT '' COMMENT '联系方式',
  `national_ID` varchar(100) DEFAULT '' COMMENT '身份证号',
  `email` varchar(100) DEFAULT '' COMMENT '邮箱',
  `adress` varchar(200) DEFAULT NULL COMMENT '地址',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片地址',
  `apply_short` varchar(200) DEFAULT '' COMMENT '受灾简述',
  `apply_info` longtext COMMENT '受灾情况简介',
  `apply_amount` varchar(100) DEFAULT NULL COMMENT '受灾申请金额',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `project_id` int(5) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL COMMENT '用户id',
  `audit_status` int(2) DEFAULT '0' COMMENT '审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望',
  `audit_id` int(5) DEFAULT NULL COMMENT '审核人员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='申请';

-- ----------------------------
-- Records of t_apply
-- ----------------------------
INSERT INTO `t_apply` VALUES ('1', '张三', '1581096', '54462123123', '12331', '北京', 'a4b0002bfefb021f7f9b440e5d0cc958.jpg', '五千二无群群无', null, '1000', '0', '', '2022-03-20 12:07:52', '', null, null, '2', null, '0', null);
INSERT INTO `t_apply` VALUES ('2', 'a120', '1581096', '245324523', '110@qq.com', '23吧发过火', '44e28c8941afbe7b9c611e9dff28c583.jpg', '234124', '事发地点国防生的轨道跌的上', '1000', '0', '', '2022-03-20 12:09:32', '', '2022-03-20 17:39:53', null, '1', null, '1', null);
INSERT INTO `t_apply` VALUES ('3', 'admin', '1581096', '1234', '110@qq.com', '电饭锅', '2ced260c475d63885cd08270f652aada.jpg', '卫生服务', '第三方哈根达斯股份的所得税', '111', '0', '', '2022-03-20 12:14:53', '', '2022-03-20 12:23:17', null, '2', null, '0', null);

-- ----------------------------
-- Table structure for t_donate
-- ----------------------------
DROP TABLE IF EXISTS `t_donate`;
CREATE TABLE `t_donate` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '姓名',
  `tel` varchar(100) DEFAULT '' COMMENT '联系方式',
  `email` varchar(100) DEFAULT '' COMMENT '邮箱',
  `adress` varchar(200) DEFAULT NULL COMMENT '地址',
  `note` varchar(200) DEFAULT NULL COMMENT '留言',
  `type` int(2) DEFAULT NULL COMMENT '捐款形式 0线上捐款 1线下捐款',
  `pay_Type` int(2) DEFAULT NULL COMMENT '付款方式 0支付宝 1是微信',
  `pay_amount` varchar(100) DEFAULT NULL COMMENT '金额',
  `order_no` varchar(200) DEFAULT NULL COMMENT '订单号',
  `trade_no` varchar(200) DEFAULT NULL COMMENT '交易号',
  `project_id` int(5) DEFAULT NULL COMMENT '审核人员id',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `user_id` int(5) DEFAULT NULL COMMENT '用户id',
  `audit_status` int(2) DEFAULT '0' COMMENT '审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望',
  `audit_id` int(5) DEFAULT NULL COMMENT '审核人员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='捐款';

-- ----------------------------
-- Records of t_donate
-- ----------------------------
INSERT INTO `t_donate` VALUES ('1', 'admin', '1581096', '110@qq.com', '北京', 'qwerqwre', '0', '0', '11', '202203200157435', '2022032022001484830503616138', null, '0', '', '2022-03-20 01:57:46', '', null, '0', null);
INSERT INTO `t_donate` VALUES ('2', 'tom', '1581096', '110@qq.com', '北京', 'dfgdfdggfdhfdg', '1', null, null, null, null, null, '0', '', '2022-03-20 01:59:22', '', null, '0', null);
INSERT INTO `t_donate` VALUES ('3', 'admin', '1581096', '110@qq.com', '北京', '123', '0', null, '111', '202203202128232', null, null, '0', '', '2022-03-20 21:28:20', '', null, '0', null);

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT '' COMMENT '名称',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片地址',
  `project_short` varchar(200) DEFAULT '' COMMENT '扶贫项目简介',
  `project_info` longtext COMMENT '扶贫项目简介',
  `project_type` int(2) DEFAULT NULL COMMENT '扶贫类型 0:代表金钱；1：人力物力',
  `project_fund` int(9) DEFAULT NULL COMMENT '扶贫资金',
  `isPublish` int(1) DEFAULT NULL COMMENT '发布状态 0:未发布；1：发布',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `project_post` int(5) DEFAULT NULL COMMENT '展示位置0：轮播图，1:其他位置',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_id` int(5) DEFAULT NULL COMMENT '用户id',
  `audit_status` int(2) DEFAULT '0' COMMENT '审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望',
  `audit_id` int(5) DEFAULT NULL COMMENT '审核人员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='扶贫项目';

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES ('1', ' <h2>旱灾需要 <span>水</span></h2>', '01ba3ca58729dc26555020732cdea25d.jpg', ' <p>因近期连日无降雨多低旱灾</p>\r\n <p>各地粮食颗粒物</p>', '驱蚊器翁人情味若翁人情味无群若无群二翁群去问问二群无若无群五千二群翁让我去若无群二二无群热群无热无群二群无热无群二去玩儿请问二千万二无群热情而我却无而我却去玩儿我确认群翁人情味我去而委屈人情味儿切换开播大吉还不够付认购或人物情感久违亲人', '0', '1111113', '1', '0', '0', '', '2022-03-19 19:33:21', 'admin', '2022-03-21 19:57:04', null, null, '1', '1');
INSERT INTO `t_project` VALUES ('2', ' <h2>请善待每个 <span>女孩</span></h2>', 'f748bcb11c07725afecc0a07f2b89894.jpg', '<p>请不要重男轻女</p>\r\n<p>人类自我的救赎</p>', ' <h2>Help the helpless who need you.</h2>\r\n                                <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now.</p>\r\n                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now.</p>\r\n                                <blockquote>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. </blockquote>\r\n                                <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now.</p>\r\n                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now.</p>\r\n                          ', '0', '111111', '1', '0', '0', '', '2022-03-19 20:49:34', 'admin', '2022-03-21 19:38:25', null, null, '1', null);
INSERT INTO `t_project` VALUES ('3', ' <h2>旱灾需要 <span>粮</span></h2>', '23029b40c22dfaf20741b716cf7358ea.jpg', ' <p>因近期连日无降雨多低旱灾</p>\r\n <p>各地粮食颗粒物</p>', '驱蚊器翁人情味若翁人情味无群若无群二翁群去问问二群无若无群五千二群翁让我去若无群二二无群热群无热无群二群无热无群二去玩儿请问二千万二无群热情而我却无而我却去玩儿我确认群翁人情味我去而委屈人情味儿切换开播大吉还不够付认购或人物情感久违亲人', '0', '1111113', '1', '0', '0', '', '2022-03-19 19:33:21', 'admin', '2022-03-21 19:59:22', null, null, '1', '1');
INSERT INTO `t_project` VALUES ('4', ' <h2>旱灾需要 <span>油</span></h2>', '9790473f2625c02d2cfd2a72d3943d8f.jpg', ' <p>因近期连日无降雨多低旱灾</p>\r\n <p>各地粮食颗粒物</p>', '驱蚊器翁人情味若翁人情味无群若无群二翁群去问问二群无若无群五千二群翁让我去若无群二二无群热群无热无群二群无热无群二去玩儿请问二千万二无群热情而我却无而我却去玩儿我确认群翁人情味我去而委屈人情味儿切换开播大吉还不够付认购或人物情感久违亲人', '0', '1111113', '1', '0', '0', '', '2022-03-19 19:33:21', 'admin', '2022-03-21 20:00:21', null, null, '1', '1');

-- ----------------------------
-- Table structure for t_volunteer_style
-- ----------------------------
DROP TABLE IF EXISTS `t_volunteer_style`;
CREATE TABLE `t_volunteer_style` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片',
  `isPublish` int(1) DEFAULT NULL COMMENT '发布状态 0:未发布；1：发布',
  `content` longtext COMMENT '内容',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='志愿者风采';

-- ----------------------------
-- Records of t_volunteer_style
-- ----------------------------
INSERT INTO `t_volunteer_style` VALUES ('1', '张三', '4327bed29535ef65d3c81bdb53bca422.jpg', '1', '潜伏期威锋网全方位废弃物为其发放额问问', '0', '', '2022-03-20 21:12:02', '', '2022-03-20 21:23:50', null);
INSERT INTO `t_volunteer_style` VALUES ('2', '李四', '8d367de54547b5b4e0063d89e4c9c7a2.jpg', '1', '<p>大黑胡子大黑胡子大黑胡子大黑胡子大黑胡子大黑胡子大黑胡子大黑胡子<br></p>', '0', '', '2022-03-20 21:25:21', '', '2022-03-20 21:26:35', null);
