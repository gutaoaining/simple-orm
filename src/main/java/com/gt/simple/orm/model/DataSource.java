package com.gt.simple.orm.model;

/**
 * 
* @ClassName: DataSource 
* @Description: TODO(数据源模型) 
* @author gt 
* @date 2017年12月21日 下午2:48:52 
*
 */
public class DataSource {
	
	private String datasourceID;

	/**
	 * 驱动类名
	 */
    private String driverName;
    
    /**
     * 数据链接url
     */
    private String url;
    
    /**
     * 用户名
     */
    private String user;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 初始化线程池大小
     */
    private int initialPoolSize;
    
    /**
     * 最小连接池值
     */
    private int minPoolSize;	
    
    /**
     * 最大连接池值
     */
    private int maxPoolSize;
    
    /**
     * 检查连接超时时间
     */
    private Long checkoutTimeout;
    
    /**
     * 最大句柄数
     */
    private int maxStatements;
    
    /**
     * 配置测试空闲连接的间隔时间
     */
    private int idleConnectionTestPeriod;
    
    /**
     * 连接池在无空闲连接可用时一次性创建的新数据库连接数
     */
    private String acquireIncrement;
    
    /**
     * 加密方式
     */
    private String encrypt;

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	public String getDatasourceID() {
		return datasourceID;
	}

	public void setDatasourceID(String datasourceID) {
		this.datasourceID = datasourceID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitialPoolSize() {
		return initialPoolSize;
	}

	public void setInitialPoolSize(int initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}

	public int getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public Long getCheckoutTimeout() {
		return checkoutTimeout;
	}

	public void setCheckoutTimeout(Long checkoutTimeout) {
		this.checkoutTimeout = checkoutTimeout;
	}

	public int getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(int maxStatements) {
		this.maxStatements = maxStatements;
	}

	public int getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}

	public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}

	public String getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(String acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	@Override
	public String toString() {
		return "DataSource [datasourceID=" + datasourceID + ", driverName=" + driverName + ", url=" + url + ", user="
				+ user + ", password=" + password + ", initialPoolSize=" + initialPoolSize + ", minPoolSize="
				+ minPoolSize + ", maxPoolSize=" + maxPoolSize + ", checkoutTimeout=" + checkoutTimeout
				+ ", maxStatements=" + maxStatements + ", idleConnectionTestPeriod=" + idleConnectionTestPeriod
				+ ", acquireIncrement=" + acquireIncrement + ", encrypt=" + encrypt + "]";
	}
    
}
