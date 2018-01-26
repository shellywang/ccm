package cn.edu.saif.ccm.domain.stock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;


import javax.persistence.Table;

import cn.edu.saif.shared.query.Condition;
import cn.edu.saif.shared.query.DataField;
import cn.edu.saif.shared.query.QueryMeta;

public class Test {

	public static void  main(String args[]){
		QueryMeta meta=new QueryMeta();
		
	   	Field[] attr =DailyInfo.class.getDeclaredFields();
	   	Table table=DailyInfo.class.getAnnotation(Table.class);
	   	String tableName=table.name();
    	List<DataField> dataFields=meta.getFields();
    	DataField e=new DataField();
    	DataField e1=new DataField();
    	e.setName("stockCode");
    	e1.setName("hexCode");
    	dataFields.add(e);
    	dataFields.add(e1);
    	List<Condition> conditions=new ArrayList<Condition>();
    	Condition c1=new Condition();
    	c1.setFieldName("stockCode");
    	c1.setOperator("LIKE");
    	c1.setValue("000001");
    	Condition c2=new Condition();
    	c2.setFieldName("date");
    	c2.setOperator("BETWEEN");
    	c2.setValue("2012-09-12,2013-03-09");
    	conditions.add(c1);
    	conditions.add(c2);
    	meta.setDateType(2);
    	StringBuffer esql=new StringBuffer("SELECT ");
    	for(DataField datafield:dataFields){
    		for(Field field:attr){
        		if(field.getName().equals(datafield.getName())){
        			Column column=field.getAnnotation(Column.class);
        			if(column.name().equals("STARTDATE")){
        				switch (meta.getDateType()){
        				case 0:
        					esql.append("STARTDATE,");
        					break;
        				case 1:
        					esql.append("CONVERT(VARCHAR(7),STARTDATE,23),");
        					break;
        				case 2:
        					esql.append("YEAR(STARTDATE),");
        					break;
        				}
        			}else{
        				esql.append(column.name()+",");
        			}
        		}
        	}
    		
    	}
    	Test a=new Test();
    	esql.deleteCharAt(esql.length()-1).append(" FROM "+tableName);
    	if(conditions.size()>0){
    		esql.append(" WHERE ");
    	}
    	for(Condition condition:conditions){
    		for(Field field:attr){
    			if(field.getName().equals(condition.getFieldName())){
    				Column column=field.getAnnotation(Column.class);
    				esql.append(a.getConditionStr(column.name(), condition)+" AND ");
    			}
    		}
    	}
    	esql.delete(esql.lastIndexOf("AND")-1, esql.length());
    	System.out.println(esql.toString());
	}
	
	private String getConditionStr(String columnName,Condition condition){
    	String str="";
    	String operator=condition.getOperator();
    	String value=condition.getValue();
    	switch(operator){
    	case "IS NULL":
    	case "IS NOT NULL":
    		str=columnName+" "+operator;
    		break;
    	case "BETWEEN":
    		String[] val=value.split(",");
    		str="("+columnName+" BETWEEN '"+val[0]+"' AND '"+val[1]+"')";
    		break;
		default:
			str=columnName+" "+operator+" '"+value+"'";
			break;
    	}
    	return str;
    }
}
