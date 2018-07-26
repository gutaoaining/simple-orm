package com.gt.simple.orm.config;

import java.util.HashMap;
import java.util.Map;

import com.gt.simple.orm.core.MapperXmlParser;
import com.gt.simple.orm.model.SqlInfo;

public class DBSqlCatch {

	private static Map<String, SqlInfo> SQLCATCH = new HashMap<String,SqlInfo>();
	
	public static void addSqlInfo(SqlInfo sqlInfo) {
		 SQLCATCH.put(sqlInfo.getSqlID(), sqlInfo);
	}
	
	public static void clearSqlCatch(SqlInfo sqlInfo) {
		 SQLCATCH.clear();
	}
	
	public static SqlInfo getSqlInfo(String sqlId) {
		if(sqlId == null || "".equals(sqlId)) {
			return null;
		}else {
			SqlInfo sqlInfo  = SQLCATCH.get(sqlId);
			return sqlInfo;
		}
	}
	
	public static SqlInfo getSqlInfo(String sqlId , Map params) {
		SqlInfo sqlInfo = DBSqlCatch.getSqlInfo(sqlId);
		if(sqlInfo == null) {
			MapperXmlParser.parseXMl(sqlId, params);
			sqlInfo = DBSqlCatch.getSqlInfo(sqlId);
		}else {
			MapperXmlParser.boundSqlParams(sqlInfo, params, sqlId, sqlInfo.getSqlSource());
		}
		return sqlInfo;
	}
	
}
