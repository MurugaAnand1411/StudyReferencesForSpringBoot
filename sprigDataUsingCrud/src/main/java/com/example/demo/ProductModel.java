package com.example.demo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT1")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId = -1;

	@Column(name = "name")
	private String productname;
	
	@Column(name = "quality_check")
	private String assuranceCheck;

	@Column(name = "description")
	private String des;

	@Column(name = "price")
	private double price;



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productname;
	}

	public void setProductName(String productName) {
		this.productname = productName;
	}

	public String getAssuranceCheck() {
		return assuranceCheck;
	}

	public void setAssuranceCheck(String assuranceCheck) {
		this.assuranceCheck = assuranceCheck;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductModel(long productId, String productName, String assuranceCheck, String des, double price) {
		super();
		this.productId = productId;
		this.productname = productName;
		this.assuranceCheck = assuranceCheck;
		this.des = des;
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductModel other = (ProductModel) obj;
		return productId == other.productId && Objects.equals(productname, other.productname);
	}

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productname + ", assuranceCheck="
				+ assuranceCheck + ", des=" + des + ", price=" + price + "]";
	}

	

}
