package com.hcc.riab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.crossstore.RelatedDocument;

@Entity
public class Product {

	/**
	 * Id is store within JPA store
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Product info is store within MongoDB
	 */
	@RelatedDocument
	private ProductInfo productInfo;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the productInfo
	 */
	public ProductInfo getProductInfo() {
		return productInfo;
	}

	/**
	 * @param productInfo the productInfo to set
	 */
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}	
	
}