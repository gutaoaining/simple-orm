package com.gt.simple.orm.core;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.scripting.xmltags.XMLScriptBuilder;
import org.apache.ibatis.session.Configuration;

import com.gt.simple.orm.config.DBSqlCatch;
import com.gt.simple.orm.exception.XmlException;
import com.gt.simple.orm.model.SqlInfo;

public class MapperXmlParser {

	public static void parseXMl(String XMLPath,Map params) {
		if(StringUtils.isNotBlank(XMLPath)){
			List<XNode> xNodes = getXNodeList(XMLPath);
	        Configuration configuration = new Configuration();
	        configuration.setDatabaseId("stock");
	        for (XNode xNode : xNodes) {
	        	StringBuffer sqlAbsolutePath = new StringBuffer(XMLPath.substring(0,XMLPath.lastIndexOf(".")));
	        	String sqlId = sqlAbsolutePath.append("."+xNode.getStringAttribute("id")).toString();
	        	if(StringUtils.isBlank(sqlId)){
	        		throw new XmlException("sqlÎÄ¼þ³ö´í");
	        	}
	        	XMLScriptBuilder builder = new XMLScriptBuilder(configuration,xNode);
	        	SqlSource sqlsource = builder.parseScriptNode();
	        	SqlInfo sqlInfo = new SqlInfo();
	            boundSqlParams(sqlInfo, params, sqlId, sqlsource);
			}
		}
	}

	public static void boundSqlParams(SqlInfo sqlInfo , Map params, String sqlId, SqlSource sqlSource) {
		BoundSql boundSql = sqlSource.getBoundSql(params);
		Map param = new HashMap<String,Object>();
		if ( boundSql != null ){
		    String sql = boundSql.getSql();
		    List argsList = new ArrayList();
		    List valueList = new ArrayList();
		    List<ParameterMapping> paramList = boundSql.getParameterMappings();
		    HashMap parameterObject = (HashMap) boundSql.getParameterObject();
		    for (ParameterMapping mapping : paramList){
		        String property = mapping.getProperty();
		        argsList.add(property);
		        if ( boundSql.hasAdditionalParameter(property) ){
		            Object value = boundSql.getAdditionalParameter(property);
		            valueList.add(value);
		            param.put(property, value);
		        }else if ( parameterObject != null && parameterObject.containsKey(property) ){
		            Object value = parameterObject.get(property);
		            valueList.add(value);
		            param.put(property, value);
		        }else{
		            valueList.add(null);
		        }
		    }
		    sqlInfo.setProperies(argsList);
		    sqlInfo.setValueList(valueList);
		    sqlInfo.setSql(sql);
		    sqlInfo.setSqlSource(sqlSource);
		    sqlInfo.setSqlID(sqlId);
		    DBSqlCatch.addSqlInfo(sqlInfo);
		}
	}

	public static List<XNode> getXNodeList(String XMLPath){
		StringBuffer path = new StringBuffer(XMLPath.substring(0, XMLPath.lastIndexOf(".")));
		XMLPath = path.toString().replace(".", "/");
		XMLPath = XMLPath + ".xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(XMLPath);
		} catch (IOException e) {
			throw new XmlException(e);
		}
        XPathParser parser = new XPathParser(reader, false, null, new XMLMapperEntityResolver());
        List<XNode> xNodeList = parser.evalNodes("/mapper/select|/mapper/update|/mapper/delete|/mapper/insert");
		return xNodeList;
	}
}
