package com.gt.simple.orm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gt.simple.orm.config.DBSqlCatch;
import com.gt.simple.orm.model.DbPage;
import com.gt.simple.orm.model.Order;
import com.gt.simple.orm.model.SqlInfo;

/**
 * 
* @ClassName: DataSession 
* @Description:数据访问会话实例
* @author gt 
* @date 2018年2月5日 下午6:03:11 
*
 */
public class DbSession{
	
	private Logger logger = LoggerFactory.getLogger(DbSession.class);
	
	private Connection connection;
	
	private int dbType;

	public DbSession() {
		this("");
	}
	
	private void setDbType(Connection connection2) {
		try {
			String datasourceType = connection.getMetaData().getDatabaseProductName();
			if("oracle".equalsIgnoreCase(datasourceType)) {
				dbType = DATASOURCETYPE.ORACLE;
			}else if("mysql".equalsIgnoreCase(datasourceType)) {
				dbType = DATASOURCETYPE.MYSQL;
			}
		} catch (SQLException e) {
			logger.error("设置数据库类别出错，错误信息为：" + e);
		}
	}

	public DbSession(String dataSourceId) {
		this.connection = ConnManager.getConnection(dataSourceId);
		setDbType(connection);
	}
	
	public void beginTrans() {
		ConnManager.beginTrans(connection);
	}
	
	public void commit() {
		ConnManager.commitTrans(connection);
	}
	
	public void close() {
		ConnManager.close(connection);
	}
	
	public void rollBack() {
		ConnManager.rollBack(connection);
	}
	
	public List queryList(String sqlId) throws SQLException {
		return queryList(sqlId, null);
	}

	public List<Order> queryList(String sqlId, Map map){
			SqlInfo sqlInfo = DBSqlCatch.getSqlInfo(sqlId , map);
			logger.debug("获取到的sql语句：" + sqlInfo.getSql());
			if(sqlInfo != null) {
				ResultSet resultSet = executeSql(sqlInfo.getSql() , sqlInfo.getValueList());
				return packageResultSetToList(resultSet);
			}else {
			    logger.error("没有配置该id的sql语句");
			}
			return null;
	}
	
	public List queryList(String sqlId , Map params , int count) {
		return queryList(sqlId , params , 0 , count);
	}

	public List queryList(String sqlId, Map params, int startIndex , int count){
		SqlInfo sqlInfo = DBSqlCatch.getSqlInfo(sqlId , params);
		StringBuilder sqlBuffer = new StringBuilder();
		if(dbType == DATASOURCETYPE.ORACLE) {
	        sqlBuffer.append(" select * from ( select row_.*, rownum rownum_ from (");
	        sqlBuffer.append(sqlInfo.getSql());
			sqlBuffer.append(") row_ where (rownum <= " + (startIndex + count) + " )) where rownum_ > " + startIndex);
		}else if(dbType == DATASOURCETYPE.MYSQL) {
			
		}
		System.out.println(sqlBuffer.toString()+","+sqlInfo.getValueList());
		return packageResultSetToList(executeSql(sqlBuffer.toString() , sqlInfo.getValueList()));
	}
	
	public DbPage queryDbPage(String sqlId , Map params , int pageNum , int rows) {
        int startIndex = (pageNum - 1) * rows;
		SqlInfo sqlInfo = DBSqlCatch.getSqlInfo(sqlId , params);

        StringBuilder sqlBuffer = new StringBuilder();
        sqlBuffer.append(" select count(1) from ( ");
        sqlBuffer.append(sqlInfo.getSql());
		sqlBuffer.append(" )");
        int totalRows = packageResultSetToInt(executeSql(sqlBuffer.toString() , sqlInfo.getValueList()));
        DbPage dbPage = new DbPage(totalRows, rows);
        List resultList = queryList(sqlId, params, startIndex, rows);
        dbPage.setCurPageData(resultList);
		return dbPage;
	}

	public int queryInt(String sqlId) {
			return queryInt(sqlId, null);
	}
	
	public int queryInt(String sqlId , Map params) {
			SqlInfo sqlInfo = DBSqlCatch.getSqlInfo(sqlId , params);
			ResultSet resultSet = executeSql(sqlInfo.getSql() , sqlInfo.getValueList());
			return packageResultSetToInt(resultSet);
	}

	private ResultSet executeSql(String sql , List params){
			try {
				PreparedStatement preparedStatement = ConnManager.cretePreparedStatement(connection, sql ,params);
				ResultSet resultSet = preparedStatement.executeQuery();
				return resultSet;
			} catch (Exception e) {
				logger.error("执行sql出错，出错信息：{}" , e);
			}
			return null;
	}

	private List packageResultSetToList(ResultSet resultSet) {
			if(resultSet != null) {
				List results = new ArrayList();
				try {
					while (resultSet.next()) {
						results.add(toMapObject(resultSet));
					}
				} catch (SQLException e) {
					logger.error("结果集解析出错，出错信息：{}" , e);
				}finally {
					close();
				}
				return results;
			}
			return null;
	}

	private Map toMapObject(ResultSet resultSet) throws SQLException {
		Map resultMap = new HashMap();
		int count = resultSet.getMetaData().getColumnCount();
		for (int i = 0 ; i < count ; i++) {
			String key = resultSet.getMetaData().getColumnName(i+1);
			resultMap.put(key.toLowerCase() , resultSet.getString(key));
		}
		return resultMap;
	}
	
	private int packageResultSetToInt(ResultSet resultSet){
			if(resultSet != null) {
				int count = 0;
				try {
					while (resultSet.next()) {
						  count = resultSet.getInt(1);
					}
				} catch (SQLException e) {
					 logger.error("计数结果集解析出错，出错信息：{}" , e);
				}
				return count;
			}
			return 0;
	}
	
	public void updateBatch(String sqlId ,List<Map<String,Object>> args){
			beginTrans();
			PreparedStatement preparedStatement = null;
			SqlInfo sqlInfo = DBSqlCatch.getSqlInfo(sqlId);
			preparedStatement = ConnManager.cretePreparedStatement(connection, sqlInfo.getSql());
		    try {
			     if(args.size() > 0) {
					for (int i = 0 ; i < args.size() ; i++) {
						Map<String,Object> params = args.get(i);
						SqlInfo sqlInfoTemp = DBSqlCatch.getSqlInfo(sqlId , params);
						ConnManager.setPrepareStatement(sqlInfoTemp.getValueList(), preparedStatement);
						preparedStatement.addBatch();
					}
			     }
				 preparedStatement.executeBatch();
				 commit();
		    } catch (SQLException e) {
			    rollBack();
			    logger.error("批量更新数据出错，出错信息为：{}" , e);
		    }
	}
}
