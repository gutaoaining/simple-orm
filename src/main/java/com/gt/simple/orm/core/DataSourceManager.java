package com.gt.simple.orm.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

import com.gt.simple.orm.model.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceManager {

	/**
	 * 数据源配置文件名称
	 */
	private static final String DATASOURCEFILENAME = "datasource.xml";
	
	/**
	 * 数据源缓存
	 */
	private static Map<String, HikariDataSource> DATASOURCE = new HashMap<String,HikariDataSource>(); 
	
	/**
	 * 
	* @Title: 初始化数据源 
	* @Description: TODO(初始化数据源 ) 
	* @return void    返回类型
	* @throws
	 */
	public static void initDataSource() {
		  List<DataSource> dataSources = new DatasourceXmlParser().XMLDataSourceConfigParser(DATASOURCEFILENAME);
		  if(dataSources != null && dataSources.size() > 0) {
			  for (DataSource dataSource : dataSources) {
				HikariDataSource hikariDataSource = new HikariDataSource(getHikariConfig(dataSource));
				DATASOURCE.put(dataSource.getDatasourceID(), hikariDataSource);
			}
		  }
	}
	
	/**
	 * 
	* @Title: getHikariConfig 
	* @Description: TODO(获取配置实例) 
	* @param @param dataSource
	* @param @return    设定文件 
	* @return HikariConfig    返回类型 
	* @throws
	 */
	private static HikariConfig getHikariConfig(DataSource dataSource) {
			HikariConfig hikariConfig = new HikariConfig();
		    hikariConfig.setJdbcUrl(dataSource.getUrl());
		    hikariConfig.setUsername(dataSource.getUser());
		    hikariConfig.setPassword(dataSource.getPassword());
		    hikariConfig.setDriverClassName(dataSource.getDriverName());
	        hikariConfig.setMinimumIdle(dataSource.getMinPoolSize());
	        hikariConfig.setMaximumPoolSize(dataSource.getMaxPoolSize());
	        hikariConfig.setIdleTimeout(dataSource.getIdleConnectionTestPeriod());
	        hikariConfig.setConnectionTimeout(dataSource.getCheckoutTimeout());
	        return hikariConfig;
	}
	
	/**
	 * @Title: getDataSourceById 
	 * @Description: TODO(通过id获取数据源) 
	 * @param @param datasourceId
	 * @param @return    设定文件 
	 * @return HikariDataSource    返回类型 
	 * @throws
	 */
	public static HikariDataSource getDataSourceById(String datasourceId) {
		   if(StringUtils.isNotBlank(datasourceId)) {
			   return DATASOURCE.get(datasourceId);
		   }else {
			   return DATASOURCE.get("default");
		   }
	}
	
    static {
    	   initDataSource();
    }
}
