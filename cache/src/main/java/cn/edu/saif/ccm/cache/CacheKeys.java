/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.cache;

/**
 * Cache Keys
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see CacheKeys
 */
public class CacheKeys {

	/** 用户相关 */
	// 用户列表(KULH)
	public static final String KEY_USER_LIST_HASH = "KULH";

	// 用户手机列表
	public static final String KEY_USER_PHONE_HASH = "KUPH";

	// 临时用户(KTUP:{Phone})
	public static final String KEY_USER_TEMP_POINT = "KUTP:";
	public static final int KEY_USER_TEMP_POINT_EXPIRE = 1800;

	// 用户验证码(KUVP:{Phone})
	public static final String KEY_USER_VERIFY_POINT = "KUVP:";
	public static final int KEY_USER_VERIFY_POINT_EXPIRE = 900;

	// 用户会话AccessToken (KUSAP:{AccessToken})
	public static final String KEY_USER_SESSION_ACCESS_POINT = "KUSAP:";
	public static final int KEY_USER_SESSION_ACCESS_POINT_EXPIRE = 2592000;

	// 用户会话RefreshToken (KUSRP:{RefreshToken})
	public static final String KEY_USER_SESSION_REFRESH_POINT = "KUSRP:";
	public static final int KEY_USER_SESSION_REFRESH_POINT_EXPIRE = 2592000;

	// 用户消息(KUML:{用户号})
	public static final String KEY_USER_MESSAGE_LIST = "KUML:";
	public static final int KEY_USER_MESSAGE_POINT_EXPIRE = 2592000;

	/** 学校相关 */
	// 学校列表(KXLH)
	public static final String KEY_SCHOOL_LIST_HASH = "KXLH";

	/** 基础数据相关 */
	// 基础数据字典(KBDH)
	public static final String KEY_BASIC_DATA_HASH = "KBDH";

	// 基础数据明细列表(KBDLH)
	public static final String KEY_BASIC_DATA_LIST_HASH = "KBDLH";

	/** 地区相关 */
	// 地区列表(KALH)
	public static final String KEY_AREA_LIST_HASH = "KALH";

	/** Device相关 */
	// Device APP(KDAH)
	public static final String KEY_DEVICE_APP_HASH = "KDAH";

	/** 老师相关 */
	// 老师列表(KTLH)
	public static final String KEY_TEACHER_LIST_HASH = "KTLH";

	// 老师附件(KTAL)
	public static final String KEY_TEACHER_ATTACHMENT_LIST = "KTAL";

	// 老师事件(KTELP:{用户号})（保留最新）
	public static final String KEY_TEACHER_EVENT_POINT = "KTELP:";

	/** 学员相关 */
	// 学员列表(KSLH)
	public static final String KEY_STUDENT_LIST_HASH = "KSLH";

	/** 联系人相关 */
	// 联系人列表(KLLH)
	public static final String KEY_CONTACT_LIST_HASH = "KLLH";

	// 联系人事件(KLELP:{ContactID})（保留最新）
	public static final String KEY_CONTACT_EVENT_POINT = "KLELP:";

	/** 班级相关 */
	// 班级列表(KCLH)
	public static final String KEY_CLASS_LIST_HASH = "KCLH";

	// 班级编号列表(KCNLH)
	public static final String KEY_CLASS_NUMBER_LIST_HASH = "KCNLH";

	// 班级学员(KCSP:{ClassID})
	public static final String KEY_CLASS_STUDENT_POINT = "KCSP:";

	// 班级老师(KCTP:{ClassID})
	public static final String KEY_CLASS_TEACHER_POINT = "KCTP:";

	// 班级学员邀请 (KCSIP:{ClassInviteCode})
	public static final String KEY_CLASS_STUDENT_INVITE_POINT = "KCSIP:";

	// 班级学员注册提醒(KCSRP:{用户号})
	public static final String KEY_CLASS_STUDENT_REMAINDER_POINT = "KCSRP:";

	// 班级老师邀请 （KCTIP:{ClassID}）
	public static final String KEY_CLASS_TEACHER_INVITE_POINT = "KCTIP:";
	
	// 班级邀请老师 (KCITP:{TeacherInviteCode})
	public static final String KEY_CLASS_INVITE_TEACHER_POINT = "KCITP:";
	public static final int KEY_CLASS_TEACHER_INVITE_POINT_EXPIRE = 2592000;

	// 班级老师注册提醒(KCTRP:{ClassID})（保留最新）
	public static final String KEY_CLASS_TEACHER_REMAINDER_POINT = "KCTRP:";

	/** 教材相关 */
	// 教材列表(KJLH)
	public static final String KEY_MATERIAL_LIST_HASH = "KJLH";

	/** 事件相关 */
	// 事件(KELP:{EventID})（只处理学员，多个联系人只保存最新记录
	public static final String KEY_EVENT_LIST_POINT = "KELP:";
	public static final int KEY_EVENT_LIST_POINT_EXPIRE = 2592000;

	// 事件学员(KESP:{EventID})
	public static final String KEY_EVENT_STUDENT_POINT = "KESP:";
	public static final int KEY_EVENT_STUDENT_POINT_EXPIRE = 2592000;

	// 事件STAT(KESP:{EventID})
	public static final String KEY_EVENT_STAT_POINT = "KESTP:";
	public static final int KEY_EVENT_STAT_POINT_EXPIRE = 2592000;

}
