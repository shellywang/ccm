/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.common;

/**
 * Master Code
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see MasterCode
 */
public class MasterCode {

	// 邀请状态代码
	public static final String INVITE_STATE_CD = "S004";
	public static final String INVITE_STATE_MSG = "邀请状态代码";
	public static final String INVITE_STATE_WAIT_CD = "S004C001";
	public static final String INVITE_STATE_WAIT_MSG = "等待";
	public static final String INVITE_STATE_ACCEPT_CD = "S004C002";
	public static final String INVITE_STATE_ACCEPT_MSG = "接受";
	public static final String INVITE_STATE_REFUSE_CD = "S004C003";
	public static final String INVITE_STATE_REFUSE_MSG = "拒绝";
	
	//学科代码
	public static final String SUBJECT_CD = "S001";
	public static final String SUBJECT_MSG = "学科代码";
	public static final String SUBJECT_CHINESE_CD = "S001C001";
	public static final String SUBJECT_CHINESE_MSG = "语文";
	public static final String SUBJECT_MATHEMATIC_CD = "S001C002";
	public static final String SUBJECT_MATHEMATIC_MSG = "数学";
	public static final String SUBJECT_ENGLISH_CD = "S001C003";
	public static final String SUBJECT_ENGLISH_MSG = "英语";
	//联系关系代码
	public static final String RELATION_CD="S002";  //联系关系代码
	public static final String  RELATION_MSG = "学科代码";
	public static final String RELATION_DAD_CD = "S002C001";
	public static final String RELATION_DAD_MSG = "爸爸";
	public static final String RELATION_MOM_CD = "S002C002";
	public static final String RELATION_MOM_MSG = "妈妈";
	//学校年级代码
	public static final String GRADE_CD= "S003";
	public static final String GRADE_MSG= "学校年级代码";
	public static final String GRADE_U_ONE_CD  ="S003C001";	
	public static final String GRADE_U_ONE_MSG   ="一年级上";
	public static final String GRADE_D_ONE_CD     ="S003C002";	
	public static final String GRADE_D_ONE_MSG   ="一年级下";
	public static final String GRADE_U_TWO_CD   ="S003C003";	
	public static final String GRADE_U_TWO_MSG  ="二年级上";
	public static final String GRADE_D_TWO_CD   ="S003C004";	
	public static final String GRADE_D_TWO_MSG  ="二年级下";
	public static final String GRADE_U_THREE_CD   ="S003C005";	
	public static final String GRADE_U_THREE_MSG  ="三年级上";
	public static final String GRADE_D_THREE_CD   ="S003C006";	
	public static final String GRADE_D_THREE_MSG  ="三年级下";
	public static final String GRADE_U_FOUR_CD    ="S003C007";	
	public static final String GRADE_U_FOUR_MSG   ="四年级上";
	public static final String GRADE_D_FOUR_CD     ="S003C008";	
	public static final String GRADE_D_FOUR_MSG   ="四年级下";
	public static final String GRADE_U_FIVE_CD   ="S003C009";	
	public static final String GRADE_U_FIVE_MSG  ="五年级上";
	public static final String GRADE_D_FIVE_CD   ="S003C010";	
	public static final String GRADE_D_FIVE_MSG  ="五年级下";
	public static final String GRADE_U_SIX_CD  ="S003C011";	
	public static final String GRADE_U_SIX_MSG ="六年级上";
	public static final String GRADE_D_SIX_CD  ="S003C012";	
	public static final String GRADE_D_SIX_MSG ="六年级下";
    //教材分类代码
	public static final String MATERIAL_TYPE_CD= "S005"; 
	public static final String MATERIAL_TYPE_MSG= "教材分类代码";
	public static final String MATERIAL_TYPE_EDUCATION_CD= "S005C001"; 
	public static final String MATERIAL_TYPE_EDUCATION_MSG= "教育";
	public static final String MATERIAL_TYPE_TRAIN_CD= "S005C002"; 
	public static final String MATERIAL_TYPE_TRAIN_MSG= "培训";
	//出版类别代码
	public static final String PUBLIC_TYPE_CD= "S006";  
	public static final String PUBLIC_TYPE_MSG= "出版类别代码"; 
	public static final String PUBLIC_TYPE_PUBLIC_CD= "S006C001";  
	public static final String PUBLIC_TYPE_PUBLIC_MSG= "公立"; 
	public static final String PUBLIC_TYPE_PRIVATE_CD= "S006C002";  
	public static final String PUBLIC_TYPE_PRIVATE_MSG= "个人"; 
	//文件类型代码
	public static final String FILE_TYPE_CD= "S007";  
	public static final String FILE_TYPE_MSG= "文件类型代码";
	public static final String FILE_TYPE_PICTURE_CD= "S007C001";  
	public static final String FILE_TYPE_PICTURE_MSG= "图片";
	public static final String FILE_TYPE_FREQUENCY_CD= "S007C002";  
	public static final String FILE_TYPE_FREQUENCY_MSG= "音频";
	public static final String FILE_TYPE_VIDEO_CD= "S007C003";  
	public static final String FILE_TYPE_VIDEO_MSG= "视频";
	public static final String FILE_TYPE_DOCUMENT_CD= "S007C004";  
	public static final String FILE_TYPE_DOCUMENT_MSG= "文档";
	//事件类型代码
	public static final String EVENT_TYPE_CD= "S008";
	public static final String EVENT_TYPE_MSG= "事件类型代码";
	public static final String EVENT_TYPE_TASK_CD= "S008C001";
	public static final String EVENT_TYPE_TASK_MSG= "任务";
	public static final String EVENT_TYPE_NOTICE_CD= "S008C002";
	public static final String EVENT_TYPE_NOTICE_MSG= "通知";
	public static final String EVENT_TYPE_MOMENT_CD= "S008C003";
	public static final String EVENT_TYPE_MOMENT_MSG= "精彩瞬间";
	 //事件状态代码
	public static final String EVENT_STATUS_CD= "S009"; 
	public static final String EVENT_STATUS_MSG= "事件状态代码"; 
	public static final String EVENT_STATUS_DRAFT_CD= "S009C001"; 
	public static final String EVENT_STATUS_DRAFT_MSG= "草稿"; 
	public static final String EVENT_STATUS_ISSUE_CD= "S009C002"; 
	public static final String EVENT_STATUS_ISSUE_MSG= "发布"; 
	public static final String EVENT_STATUS_REMIND_CD= "S009C003"; 
	public static final String EVENT_STATUS_REMIND_MSG= "提醒"; 
	public static final String EVENT_STATUS_PAST_CD= "S009C004"; 
	public static final String EVENT_STATUS_PAST_MSG= "过期"; 
	//行动代码
	public static final String ACTION_CD= "S010";  
	public static final String ACTION_MSG= "行动代码"; 
	public static final String ACTION_READ_CD= "S010C001";  
	public static final String ACTION_READ_MSG= "阅读";
	public static final String ACTION_DEFAULT_CD= "S010C002";  
	public static final String ACTION_DEFAULT_MSG= "默认";
	public static final String ACTION_REVIEW_CD= "S010C003";  
	public static final String ACTION_REVIEW_MSG= "复习";
	//消息分类代码
	public static final String MESSAGE_TYPE_CD= "S011";  
	public static final String MESSAGE_TYPE_MSG= "消息分类代码";  
	public static final String MESSAGE_TYPE_INCIDENT_CD= "S011C001";  
	public static final String MESSAGE_TYPE_INCIDENT_MSG= "事件";  
	public static final String MESSAGE_TYPE_INFORMATION_CD= "S011C002";  
	public static final String MESSAGE_TYPE_INFORMATION_MSG= "消息";  
	public static final String MESSAGE_TYPE_STUDENT_CD= "S011C003";  
	public static final String MESSAGE_TYPE_STUDENT_MSG= "学员加入";  
	public static final String MESSAGE_TYPE_TEACHER_CD= "S011C004";  
	public static final String MESSAGE_TYPE_TEACHER_MSG= "任课老师加入";  
	//设备类型
	public static final String DEVICE_TYPE_CD= "S012";  
	public static final String DEVICE_TYPE_MSG= "设备类型";
	public static final String DEVICE_TYPE_IOS_CD= "S012C001";  
	public static final String DEVICE_TYPE_IOS_MSG= "IOS"; 
	public static final String DEVICE_TYPE_ANDROID_CD= "S012C002";  
	public static final String DEVICE_TYPE_ANDROID_MSG= "Android"; 
	public static final String DEVICE_TYPE_WINDOWSPHONE_CD= "S012C003";  
	public static final String DEVICE_TYPE_WINDOWSPHONE_MSG= "WindowsPhone"; 
	//App类型代码
	public static final String APP_TYPE_CD= "S013";
	public static final String APP_TYPE_MSG= "App类型代码";
	public static final String APP_TYPE_TEACHER_CD= "S013C001";
	public static final String APP_TYPE_TEACHER_MSG= "老师";
	public static final String APP_TYPE_CONTACT_CD= "S013C002";
	public static final String APP_TYPE_CONTACT_MSG= "联系人";
	//学员角色代码
	public static final String STUDENT_ROLE_CD= "S014";  
	public static final String STUDENT_ROLE_MSG= "学员角色代码"; 
	public static final String STUDENT_ROLE_MONITOR_CD= "S014C001";  
	public static final String STUDENT_ROLE_MONITOR_MSG= "班长"; 
	public static final String STUDENT_ROLE_COMMISSARY_CD= "S014C002";  
	public static final String STUDENT_ROLE_COMMISSARY_MSG= "学习委员"; 
	public static final String STUDENT_ROLE_LIFE_CD= "S014C003";  
	public static final String STUDENT_ROLE_LIFE_MSG= "生活委员"; 
	public static final String STUDENT_ROLE_HEADMAN_CD= "S014C004";  
	public static final String STUDENT_ROLE_HEADMAN_MSG= "组长"; 
	//班级老师角色代码		
	public static final String TEACHER_ROLE_CD= "S015";  
	public static final String TEACHER_ROLE_MSG= "班级老师角色代码";  
	public static final String TEACHER_ROLE_HTEACHER_CD= "S015C001";  
	public static final String TEACHER_ROLE_HTEACHER_MSG= "班主任";
	public static final String TEACHER_ROLE_INSTRUCTOR_CD= "S015C002";  
	public static final String TEACHER_ROLE_INSTRUCTOR_MSG= "任课老师";
	
	//语言代码
	public static final String LANGUAGE_CD= "S016";  
	public static final String LANGUAGE_MSG= "语言代码";
	public static final String LANGUAGE_CHINESE_CD= "S016C001";  
	public static final String LANGUAGE_CHINESE_MSG= "中文";
	public static final String LANGUAGE_ENGLISH_CD= "S016C002";  
	public static final String LANGUAGE_ENGLISH_MSG= "英文";
	
	
	
}
