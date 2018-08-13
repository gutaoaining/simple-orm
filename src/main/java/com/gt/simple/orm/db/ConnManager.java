package com.gt.simple.orm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.gt.simple.orm.core.DataSourceManager;
import com.gt.simple.orm.exception.JdbcException;
import com.gt.simple.orm.util.LoggerUtil;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
* @ClassName: ConnManager 
* @Description: TODO(数据库链接管理) 
* @author gt 
* @date 2018年2月6日 下午5:38:46 
*
 */
public class ConnManager {

    public static Connection getConnection(String datasourceId) {
    	HikariDataSource dataSource = DataSourceManager.getDataSourceById(datasourceId);
		try {
			Connection connection = dataSource.getConnection();
			return connection;
		} catch (SQLException e) {
			throw new JdbcException(e);
		}
    }
    
    public static void close(Connection connection) {
    	try {
    		if(connection != null) {
    			connection.close();
    		}
		} catch (Exception e) {
			LoggerUtil.loggerError(ConnManager.class, "关闭数据库连接出错，错误信息为:{}", e);
		}
    }
    
    public static void beginTrans(Connection connection) {
    	try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			LoggerUtil.loggerError(ConnManager.class, "开启数据库连接事务出错，错误信息为:{}", e);
		}
    }
    
    public static void commitTrans(Connection connection) {
    	try {
			connection.commit();
		} catch (SQLException e) {
			LoggerUtil.loggerError(ConnManager.class, "开启数据库连接事务出错，错误信息为:{}", e);
		}
    }

	public static void rollBack(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			LoggerUtil.loggerError(ConnManager.class, "数据库事务出错，错误信息为:{}", e);
		}
	}
	
	public static Statement createStatement(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			throw new JdbcException(e);
		}
	}
	
	public static PreparedStatement cretePreparedStatement(Connection connection ,String sql) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			return preparedStatement;
		} catch (SQLException e) {
			throw new JdbcException(e);
		}
	}
	
	public static PreparedStatement cretePreparedStatement(Connection connection ,String sql ,List params) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			return setPrepareStatementParams(params, preparedStatement);
		} catch (SQLException e) {
			throw new JdbcException(e);
		}
	}

	public static PreparedStatement setPrepareStatementParams(List params, PreparedStatement preparedStatement)
			throws SQLException {
		if(params != null && params.size() > 0) {
			for (int i = 1 ; i <= params.size() ; i++) {
				preparedStatement.setObject(i, params.get(i-1));
			}
		}
		return preparedStatement;
	}
	
}
