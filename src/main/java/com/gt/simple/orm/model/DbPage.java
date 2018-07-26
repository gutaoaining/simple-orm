package com.gt.simple.orm.model;

import java.util.List;
import java.util.Map;

public class DbPage {

	private int totalPage;
	
	private int totalRow;
	
	private int curPage;
	
	private int pageRow;
	
	private List<Map> curPageData;

	public DbPage(int totalRows , int pageRow) {
		this.totalRow = totalRows;
		if(pageRow > 0) {
			this.pageRow = pageRow;
		}else{
			this.pageRow = 100;
		}
		setDbPageField(totalRows,pageRow);
	}
	
	private void setDbPageField(int totalRows, int pageRow) {
          if (totalRows % pageRow == 0){
              this.totalPage = totalRows / pageRow;
          }else{
              this.totalPage = (totalRows / pageRow) + 1;
          }
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageRow() {
		return pageRow;
	}

	public List<Map> getCurPageData() {
		return curPageData;
	}

	public void setCurPageData(List<Map> curPageData) {
		this.curPageData = curPageData;
	}
	
	
	
}
