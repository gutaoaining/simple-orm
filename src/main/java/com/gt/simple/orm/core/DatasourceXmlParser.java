package com.gt.simple.orm.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;

import com.gt.simple.orm.model.DataSource;

/**
 * 
* @ClassName: XMLParserUtil 
* @Description: TODO(sql的xml解析) 
* @author gt 
* @date 2017年12月19日 下午1:28:28 
*
 */
public class DatasourceXmlParser extends AbstractXmlPaser<DataSource>{
	
	public List<DataSource> parserDocument(Element root) {
		List<DataSource> list = new ArrayList<DataSource>();
		List<Element> firstElementList = root.elements("datasource");
		for (Element firstElement : firstElementList) {
			Map params = parserChildElement(firstElement);
			list.add(packageDataSource(params));
		}
		return list;
	}
	
	public Map parserChildElement(Element firstElement) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(firstElement.getName(),firstElement.attributeValue("id"));
		List<Element> secondElementList = firstElement.elements("property");
		for (Element secondElement : secondElementList) {
			paramMap.put(secondElement.attributeValue("name"),secondElement.getTextTrim());
		}
		return paramMap;
	}
	
	public  DataSource packageDataSource(Map paramMap) {
		DataSource dataSource = new DataSource();
		dataSource.setDatasourceID((String)paramMap.get("datasource"));
		dataSource.setDriverName((String)paramMap.get("driver-name"));
		dataSource.setUrl((String)paramMap.get("url"));
		dataSource.setUser((String)paramMap.get("user"));
		dataSource.setPassword((String)paramMap.get("password"));
		dataSource.setInitialPoolSize(Integer.parseInt((String)paramMap.get("initialPoolSize")));
		dataSource.setMinPoolSize(Integer.parseInt((String)paramMap.get("minPoolSize")));
		dataSource.setMaxPoolSize(Integer.parseInt((String)paramMap.get("maxPoolSize")));
		dataSource.setCheckoutTimeout(Long.parseLong((String)paramMap.get("checkoutTimeout")));
		dataSource.setMaxStatements(Integer.parseInt((String)paramMap.get("maxStatements")));
		dataSource.setIdleConnectionTestPeriod(Integer.parseInt((String)paramMap.get("idleConnectionTestPeriod")));
		dataSource.setAcquireIncrement((String)paramMap.get("acquireIncrement"));
		dataSource.setEncrypt((String)paramMap.get("encrypt"));
		return dataSource;
	}
}
