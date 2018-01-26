/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.common;

/**
 * Constants
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see Constants
 */
public class Constants {

	public static final int RECORD_MAX = 250000;
	public static final String HOME_PATH = "D:\\CCM\\";
	public static final String FTP_HOME_PATH = "D:\\CCM_Data\\";
	public static final String CODE_SUCCESS = "success";
	public static final String CODE_FAIL = "fail";
	
	/**Data File */
	public static final String STOCK_DAILY_INFO="stock_daily_info";
	public static final String STOCK_RET="stock_ret";
	public static final String STOCK_RET_MONTH="stock_ret_m";
	public static final String STOCK_RET_YEAR="stock_ret_y";
	
	public static final String PORTFOLIO="portfolio";
	public static final String PORTFOLIO_MONTH="portfolio_m";
	public static final String PORTFOLIO_YEAR="portfolio_y";
	public static final String FACTOR="factor";
	public static final String FACTOR_MONTH="factor_m";
	public static final String FACTOR_YEAR="factor_y";
	
	public static final String ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static final long MESSAGE_SIZE = 100;
	public static final long EVENT_SIZE = 10;

	public static final int DEFAULT_PAGE_NUM = 0;
	public static final int DEFAULT_PAGE_SIZE = 25;
	public static final int MAXIMUM_PAGE_SIZE = 200; // Build in a max page size
														// so that we can't be
														// DoSed with someone
														// specifying a massive
														// page size
	public static final String INTERACTION_PREFIX = "interaction.";

	public static final String DEFAULT_SPRING_BEAN_PROFILE = "prod";

}
