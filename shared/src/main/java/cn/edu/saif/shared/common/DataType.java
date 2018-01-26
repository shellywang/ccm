package cn.edu.saif.shared.common;

public class DataType {
	
	public static final int DATE_DAILY=0;
	public static final int DATE_MONTHLY=1;
	public static final int DATE_YEARLY=2;
	
	public static final String BOND_SHORT="001";
	public static final String BOND_INTER="002";
	public static final String BOND_LONG="003";
	
	public static final String SQL_STOCK_DAILY="INSERT INTO CCM_STOCK_DAILY_INFO(STOCKCODE,HEXCD,DATE,PRC,VOL,FASHR,TASHR,RET,CFACPR,CFACSHR,OPENPRC,RETX,EXCHTRD,STKTRD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SQL_STOCK_RET="INSERT INTO CCM_STOCK_RET VALUES(?,?,?,?,?,?,?)";
	public static final String SQL_PORTFOLIO="INSERT INTO CCM_PORTFOLIO_SIZE_RET VALUES(?,?,?,?,?,?,?)";
	public static final String SQL_FACTOR="INSERT INTO CCM_THREEFACTOR VALUES(?,?,?,?,?,?,?)";
	public static final String SQL_GBOND_DESC="INSERT INTO CCM_GBOND_DESC VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SQL_GBOND_PRC="INSERT INTO CCM_GBOND_PRICE VALUES(?,?,?,?,?,?,?,?,?)";
	public static final String SQL_GBOND_MAT="INSERT INTO CCM_GBOND_MATURITY VALUES(?,?,?,?,?,?)";
	
//	public static final String SQL_GBOND_RET="INSERT INTO CCM_GBOND_RET1 VALUES(?,?,?,?,?,?)";
//	public static final String SQL_GBOND_CAPAPP_RET="INSERT INTO CCM_GBOND_CAPAPP_RET1 VALUES(?,?,?,?,?,?)";
	
	public static final String SQL_GBOND_RET="INSERT INTO CCM_GBOND_RET VALUES(?,?,?,?,?,?)";
	public static final String SQL_GBOND_CAPAPP_RET="INSERT INTO CCM_GBOND_CAPAPP_RET VALUES(?,?,?,?,?,?)";
	
	public static final String SQL_CLBOND_CAPAPP_RET="INSERT INTO CCM_CLBOND_CAPAPP_RET VALUES(?,?,?,?)";
	public static final String SQL_CLBOND_RET="INSERT INTO CCM_CLBOND_RET VALUES(?,?,?,?)";
	public static final String SQL_CLBOND_YIELD="INSERT INTO CCM_CLBOND_YIELD VALUES(?,?,?,?)";
	
	public static final String FILE_STOCK_DAILY="stock_daily_info.csv";
	public static final String FILE_STOCK_RET="stock_ret.csv";
	public static final String FILE_STOCK_RET_MONTH="stock_ret_m.csv";
	public static final String FILE_STOCK_RET_YEAR="stock_ret_y.csv";
	
	public static final String FILE_PORTFOLIO="portfolio.csv";
	public static final String FILE_PORTFOLIO_MONTH="portfolio_m.csv";
	public static final String FILE_PORTFOLIO_YEAR="portfolio_y.csv";
	
	public static final String FILE_FACTOR="factor.csv";
	public static final String FILE_FACTOR_MONTH="factor_m.csv";
	
	public static final String FILE_GBOND_DESC="gbond_desc.csv";
	
	public static final String FILE_GBOND_PRC="gbond_price.csv";
	public static final String FILE_GBOND_PRC_SHORT="gbond_price_short.csv";
	public static final String FILE_GBOND_PRC_INTER="gbond_price_inter.csv";
	public static final String FILE_GBOND_PRC_LONG="gbond_price_long.csv";
	
	public static final String FILE_GBOND_MAT="gbond_mat.csv";
	public static final String FILE_GBOND_MAT_SHORT="gbond_mat_short.csv";
	public static final String FILE_GBOND_MAT_INTER="gbond_mat_inter.csv";
	public static final String FILE_GBOND_MAT_LONG="gbond_mat_long.csv";
	
	public static final String FILE_GBOND_RET="gbond_ret.csv";
	public static final String FILE_GBOND_RET_SHORT_DAY="gbond_ret_short_d.csv";
	public static final String FILE_GBOND_RET_SHORT_MONTH="gbond_ret_short_m.csv";
	public static final String FILE_GBOND_RET_SHORT_YEAR="gbond_ret_short_y.csv";
	public static final String FILE_GBOND_RET_INTER_DAY="gbond_ret_inter_d.csv";
	public static final String FILE_GBOND_RET_INTER_MONTH="gbond_ret_inter_m.csv";
	public static final String FILE_GBOND_RET_INTER_YEAR="gbond_ret_inter_y.csv";
	public static final String FILE_GBOND_RET_LONG_DAY="gbond_ret_long_d.csv";
	public static final String FILE_GBOND_RET_LONG_MONTH="gbond_ret_long_m.csv";
	public static final String FILE_GBOND_RET_LONG_YEAR="gbond_ret_long_y.csv";
	
	public static final String FILE_GBOND_CAPAPP_RET="gbond_capapp_ret.csv";
	public static final String FILE_GBOND_CAPAPP_RET_SHORT_DAY="gbond_capapp_ret_short_d.csv";
	public static final String FILE_GBOND_CAPAPP_RET_SHORT_MONTH="gbond_capapp_ret_short_m.csv";
	public static final String FILE_GBOND_CAPAPP_RET_SHORT_YEAR="gbond_capapp_ret_short_y.csv";
	public static final String FILE_GBOND_CAPAPP_RET_INTER_DAY="gbond_capapp_ret_inter_d.csv";
	public static final String FILE_GBOND_CAPAPP_RET_INTER_MONTH="gbond_capapp_ret_inter_m.csv";
	public static final String FILE_GBOND_CAPAPP_RET_INTER_YEAR="gbond_capapp_ret_inter_y.csv";
	public static final String FILE_GBOND_CAPAPP_RET_LONG_DAY="gbond_capapp_ret_long_d.csv";
	public static final String FILE_GBOND_CAPAPP_RET_LONG_MONTH="gbond_capapp_ret_long_m.csv";
	public static final String FILE_GBOND_CAPAPP_RET_LONG_YEAR="gbond_capapp_ret_long_y.csv";
	
	public static final String FILE_CLBOND_RET="clbond_ret.csv";
	public static final String FILE_CLBOND_RET_MONTH="clbond_ret_m.csv";
	public static final String FILE_CLBOND_RET_YEAR="clbond_ret_y.csv";
	
	public static final String FILE_CLBOND_CAPAPP_RET="clbond_capapp_ret.csv";
	public static final String FILE_CLBOND_CAPAPP_RET_MONTH="clbond_capapp_ret_m.csv";
	public static final String FILE_CLBOND_CAPAPP_RET_YEAR="clbond_capapp_ret_y.csv";
	
	public static final String FILE_CLBOND_YIELD="clbond_yield.csv";
	
	private DataType(){}
}
