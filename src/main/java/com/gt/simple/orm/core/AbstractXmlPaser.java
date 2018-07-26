package com.gt.simple.orm.core;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gt.simple.orm.util.LoggerUtil;

public abstract class AbstractXmlPaser<T> {
	
	public List<T> XMLDataSourceConfigParser(String fileName) {
	    try {
	    	Reader fileReader = Resources.getResourceAsReader(fileName);
		    SAXReader reader = new SAXReader();
			Document document = reader.read(fileReader);
			Element element = document.getRootElement();
			return parserDocument(element);
		} catch (DocumentException e) {
			LoggerUtil.getLogger(DatasourceXmlParser.class).error("解析数据源xml出错", e);
		} catch (IOException e) {
			LoggerUtil.getLogger(DatasourceXmlParser.class).error("文件读取异常");
		}
	    return null;
	}
	
	public abstract List<T> parserDocument(Element element);
	
	public abstract Map parserChildElement(Element firstElement);
	
	public abstract T packageDataSource(Map paramMap);
}
