package com.gt.simple.orm.model;

/**
 * 
 * @Description: TODO(委托单实体类)
 * @author: gt
 * @create_date: 2017年9月12日 下午11:21:04
 * @version: V1.0
 *
 */
public class Order {
	/**
	 * 委托编号
	 */
	private Long serialnum;
	/**
	 * 市场id
	 */
	private String marketid;
	/**
	 * 股票代码
	 */
	private String stockcode;
	/**
	 * 账户id
	 */
	private String accountid;
	/**
	 * 交易类别
	 */
	private String tradetype;
	/**
	 * 委托价格
	 */
	private double orderprice;
	/**
	 * 委托数量
	 */
	private int orderqty;
	/**
	 * 处理机器号
	 */
	private int matchno;
	/**
	 * 委托交易状态
	 */
	private String tradestatus;
	/**
	 * 委托类别
	 */
	private String ordertype;
	/**
	 * 处理类别
	 */
	private String dealflag;

	public Long getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(Long serialnum) {
		this.serialnum = serialnum;
	}

	public String getMarketid() {
		return marketid;
	}

	public void setMarketid(String marketid) {
		this.marketid = marketid;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getTradetype() {
		return tradetype;
	}

	public void setTradetype(String tradetype) {
		this.tradetype = tradetype;
	}

	public double getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}

	public int getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}

	public int getMatchno() {
		return matchno;
	}

	public void setMatchno(int matchno) {
		this.matchno = matchno;
	}

	public String getTradestatus() {
		return tradestatus;
	}

	public void setTradestatus(String tradestatus) {
		this.tradestatus = tradestatus;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getDealflag() {
		return dealflag;
	}

	public void setDealflag(String dealflag) {
		this.dealflag = dealflag;
	}

	@Override
	public String toString() {
		return "Order [serialnum=" + serialnum + ", marketid=" + marketid + ", stockcode=" + stockcode + ", accountid="
				+ accountid + ", tradetype=" + tradetype + ", orderprice=" + orderprice + ", orderqty=" + orderqty
				+ ", matchno=" + matchno + ", tradestatus=" + tradestatus + ", ordertype=" + ordertype + ", dealflag="
				+ dealflag + "]";
	}

}
