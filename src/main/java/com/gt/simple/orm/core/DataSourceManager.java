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
	 * ����Դ�����ļ�����
	 */
	private static final String DATASOURCEFILENAME = "datasource.xml";
	
	/**
	 * ����Դ����
	 */
	private static Map<String, HikariDataSource> DATASOURCE = new HashMap<String,HikariDataSource>(); 
	
	/**
	 * 
	* @Title: ��ʼ������Դ 
	* @Description: TODO(��ʼ������Դ ) 
	* @return void    ��������
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
	* @Description: TODO(��ȡ����ʵ��) 
	* @param @param dataSource
	* @param @return    �趨�ļ� 
	* @return HikariConfig    �������� 
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
	 * @Description: TODO(ͨ��id��ȡ����Դ) 
	 * @param @param datasourceId
	 * @param @return    �趨�ļ� 
	 * @return HikariDataSource    �������� 
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
