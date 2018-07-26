package com.gt.simple.orm.model;

import java.util.List;

import org.apache.ibatis.mapping.SqlSource;

/**
 * 
* @ClassName: SqlInfo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author gt 
* @date 2017年12月19日 下午1:36:42 
*
 */
public class SqlInfo {

	/**
	 * sql的ID
	 */
	private String sqlID;
	
	/**
	 * sql语句
	 */
	private String sql;
	
	/**
	 * 入参值的集合
	 */
	private List<Object> valueList;
	
	/**
	 * 入参的key
	 */
	private List<String> properies;
	
	private SqlSource sqlSource;
	
	public SqlInfo() {}
	
	public SqlInfo(String sqlID,String sql,List<Object> valueList,List<String> properies, SqlSource sqlsource) {
		this.sqlID = sqlID;
		this.sql = sql;
		this.valueList = valueList;
		this.properies = properies;
		this.sqlSource = sqlsource;
	}

	public String getSqlID() {
		return sqlID;
	}

	public void setSqlID(String sqlID) {
		this.sqlID = sqlID;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<Object> getValueList() {
		return valueList;
	}

	public void setValueList(List<Object> valueList) {
		this.valueList = valueList;
	}

	public List<String> getProperies() {
		return properies;
	}

	public void setProperies(List<String> properies) {
		this.properies = properies;
	}

	public SqlSource getSqlSource() {
		return sqlSource;
	}

	public void setSqlSource(SqlSource sqlSource) {
		this.sqlSource = sqlSource;
	}
	
}
