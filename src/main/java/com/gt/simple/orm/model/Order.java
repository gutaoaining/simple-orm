package com.gt.simple.orm.model;

/**
 * 
 * @Description: TODO(ί�е�ʵ����)
 * @author: gt
 * @create_date: 2017��9��12�� ����11:21:04
 * @version: V1.0
 *
 */
public class Order {
	/**
	 * ί�б��
	 */
	private Long serialnum;
	/**
	 * �г�id
	 */
	private String marketid;
	/**
	 * ��Ʊ����
	 */
	private String stockcode;
	/**
	 * �˻�id
	 */
	private String accountid;
	/**
	 * �������
	 */
	private String tradetype;
	/**
	 * ί�м۸�
	 */
	private double orderprice;
	/**
	 * ί������
	 */
	private int orderqty;
	/**
	 * ���������
	 */
	private int matchno;
	/**
	 * ί�н���״̬
	 */
	private String tradestatus;
	/**
	 * ί�����
	 */
	private String ordertype;
	/**
	 * �������
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
