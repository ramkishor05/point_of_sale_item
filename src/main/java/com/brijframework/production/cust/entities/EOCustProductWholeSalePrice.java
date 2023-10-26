package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CURRENCY;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_WHOLE_SALE_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_RETAIL_SALE_PRICE;
import static com.brijframework.production.contants.Constants.PRICE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_RETAIL_SALE_PRICE)
public class EOCustProductWholeSalePrice extends EOCustObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// for purchase cost
	@Column(name = PRICE)
	private Double price;
	
	@JoinColumn(name = CURRENCY)
	@OneToOne
	private EOCustCurrencyItem currency;

	@ManyToOne
	@JoinColumn(name = CUST_PRODUCT_WHOLE_SALE_ID)
	public EOCustProductWholeSale custProductWholeSale;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public EOCustCurrencyItem getCurrency() {
		return currency;
	}

	public void setCurrency(EOCustCurrencyItem currency) {
		this.currency = currency;
	}

	public EOCustProductWholeSale getCustProductWholeSale() {
		return custProductWholeSale;
	}

	public void setCustProductWholeSale(EOCustProductWholeSale custProductWholeSale) {
		this.custProductWholeSale = custProductWholeSale;
	}
	
}
