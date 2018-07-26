package com.gt.simple.orm.model;

/**
 * 
* @ClassName: DataSource 
* @Description: TODO(����Դģ��) 
* @author gt 
* @date 2017��12��21�� ����2:48:52 
*
 */
public class DataSource {
	
	private String datasourceID;

	/**
	 * ��������
	 */
    private String driverName;
    
    /**
     * ��������url
     */
    private String url;
    
    /**
     * �û���
     */
    private String user;
    
    /**
     * ����
     */
    private String password;
    
    /**
     * ��ʼ���̳߳ش�С
     */
    private int initialPoolSize;
    
    /**
     * ��С���ӳ�ֵ
     */
    private int minPoolSize;	
    
    /**
     * ������ӳ�ֵ
     */
    private int maxPoolSize;
    
    /**
     * ������ӳ�ʱʱ��
     */
    private Long checkoutTimeout;
    
    /**
     * �������
     */
    private int maxStatements;
    
    /**
     * ���ò��Կ������ӵļ��ʱ��
     */
    private int idleConnectionTestPeriod;
    
    /**
     * ���ӳ����޿������ӿ���ʱһ���Դ����������ݿ�������
     */
    private String acquireIncrement;
    
    /**
     * ���ܷ�ʽ
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
