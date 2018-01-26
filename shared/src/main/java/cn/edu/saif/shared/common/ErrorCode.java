/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.common;

/**
 * Error Code
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see ErrorCode
 */
public class ErrorCode {
	// E0000 – 成功
	public static final String SUCCEE_CODE = "E0000";
	public static final String SUCCEE_MSG = "成功";

	// E1001 – 会话错误
	public static final String SESSION_ERROR_CODE = "E1001";
	public static final String SESSION_ERROR_MSG = "会话错误";

	// E1001 – 用户名或密码错误
	public static final String SESSION_USER_PWD_ERROR_CODE = "E1002";
	public static final String SESSION_USER_PWD_ERROR_MSG = "用户名或密码错误";

	// E1002 – 会话过期
	public static final String SESSION_CONVERSATIOM_PAST_CODE = "E1003";
	public static final String SESSION_CONVERSATIOM_PAST_MSG = "会话过期";

	// E1003 – 会话过期需重新登陆
	public static final String SESSION_CONVERSATIOM_PAST_TOLOGIN_CODE = "E1004";
	public static final String SESSION_CONVERSATIOM_PAST_TOLOGIN_MSG = "会话过期需重新登陆";

	// E1005 -用户名已存在exists
	public static final String SESSION_PHONE_EXISTS_CODE = "E1005";
	public static final String SESSION_PHONE_EXISTS_MSG = "用户名已存在";

	// E1005 -用户名已存在exists
	public static final String SESSION_PWD_INCORRECT_CODE = "E1006";
	public static final String SESSION_PWD_INCORRECT_MSG = "密码错误";

	// E1006 -邀请用户信息不匹配
	public static final String SESSION_INVITE_INFO_MISMATCH_CODE = "E1007";
	public static final String SESSION_INVITE_INFO_MISMATCH_MSG = "邀请用户信息不匹配";

	// E2001 – 数据不合法
	public static final String DATA_ILLEGAL_CODE = "E2001";
	public static final String DATA_ILLEGAL_MSG = "数据不合法";

	// E2002 – 数据不存在
	public static final String DATA_NOT_EXIST_CODE = "E2002";
	public static final String DATA_NOT_EXIST_MSG = "数据不存在";

	// E2003 – 班级不存在
	public static final String DATA_CLASS_NOT_EXIST_CODE = "E2003";
	public static final String DATA_CLASS_NOT_EXIST_MSG = "班级不存在";

	// E2004 – 班级编号已存在
	public static final String DATA_CLASS_NUM_EXIST_CODE = "E2004";
	public static final String DATA_CLASS_NUM_EXIST_MSG = "班级编号已存在";

	// E2005 – 班级老师邀请码为空
	public static final String DATA_CLASS_INVITE_NUM_IS_NULL_CODE = "E2005";
	public static final String DATA_CLASS_INVITE_NUM_IS_NULL_MSG = "班级老师邀请码不能为空";

	// E3001 – 业务处理失败
	public static final String BUSINESS_FAIL_CODE = "E3001";
	public static final String BUSINESS_FAIL_MSG = "业务处理失败";

	// E3002 – 数据库处理失败
	public static final String DATABASE_FAIL_CODE = "E3002";
	public static final String DATABASE_FAIL_MSG = "数据库处理失败";

	// E3003 – 缓存处理失败
	public static final String CACHE_FAIL_CODE = "E3003";
	public static final String CACHE_FAIL_MSG = "缓存处理失败";

	// E3101 – 用户-手机号已存在
	public static final String USER_PHONE_EXISTS_CODE = "E3101";
	public static final String USER_PHONE_EXISTS_MSG = "手机号已存在";

	// E3102 – 用户-验证码不存在
	public static final String USER_VERIFYCODE_NOT_EXISTS_CODE = "E3102";
	public static final String USER_VERIFYCODE_NOT_EXISTS_MSG = "验证码不存在";

	// E3103 – 用户信息已过期， 请重新设置密码
	public static final String USER_TEMP_INFO_NOT_EXISTS_CODE = "E3103";
	public static final String USER_TEMP_INFO_NOT_EXISTS_MSG = "用户信息已过期， 请重新设置密码";

	// E3201 – 班级-班级邀请码不存在
	public static final String CLASS_INVITE_NUM_NOT_EXISTS_CODE = "E3201";
	public static final String CLASS_INVITE_NUM_NOT_EXISTS_MSG = "班级邀请码不存在";

	// E3202 – 班级-邀请信息不匹配
	public static final String CLASS_INVITE_NUM_NOT_MATCH_CODE = "E3202";
	public static final String CLASS_INVITE_NUM_NOT_MATCH_MSG = "邀请信息不匹配";

	// E3203 – 班级-检查老师邀请码-邀请码不存在
	public static final String CLASS_CHECK_INVITE_NUM_NOT_EXISTS_CODE = "E3203";
	public static final String CLASS_CHECK_INVITE_NUM_NOT_EXISTS_MSG = "检查老师邀请码-邀请码不存在";

	// E9001 – 服务不可用
	public static final String SERVER_UNUSED_CODE = "E9001";
	public static final String SERVER_UNUSED_MSG = "服务不可用";

	// E9101 –
	public static final String SERVER_FILE_CODE = "E9101";
	public static final String SERVER_FILE_MSG = "非法文件名";

	// E9102 – 服务不可用
	public static final String SERVER_FILE_WRITE_CODE = "E9102";
	public static final String SERVER_FILE_WRITE_MSG = "文件写入失败";

	// E9103 – Json 解析异常
	public static final String SYSTEM_JSON_PARSE_ERROR_CODE = "E9103";
	public static final String SYSTEM_JSON_PARSE_ERROR_MSG = "Json 解析异常";

	// E9999 – 系统异常
	public static final String SYSTEM_ANOMALY_CODE = "E9999";
	public static final String SYSTEM_ANOMALY_MSG = "系统异常";

}
