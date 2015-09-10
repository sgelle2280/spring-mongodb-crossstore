package com.hcc.riab.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Well_index")
public class WellIndex {

	@Id
	private BigDecimal APINo;
	private String countyName;
	private Integer fileNo;
	private String currentOperator;
	private String wellType;
	
	public WellIndex(){
		
	}
	
	public BigDecimal getAPINo() {
		return APINo;
	}

	public void setAPINo(BigDecimal aPINo) {
		APINo = aPINo;
	}

	public WellIndex(String countyName, Integer fileNo){
		this.countyName = countyName;
		this.fileNo = fileNo;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Integer getFileNo() {
		return fileNo;
	}

	public void setFileNo(Integer fileNo) {
		this.fileNo = fileNo;
	}

	public String getCurrentOperator() {
		return currentOperator;
	}

	public void setCurrentOperatoy(String currentOperator) {
		this.currentOperator = currentOperator;
	}

	public String getWellType() {
		return wellType;
	}

	public void setWellType(String wellType) {
		this.wellType = wellType;
	}	
	
}
