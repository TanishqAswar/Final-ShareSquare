package com.example.food.entity;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table
public class User {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long  id;
	private String productType;
	private String productName;
	private int month;
	private Double rentingCost;
	private Double buyingCost;
	private double depositCost;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
    private byte[] image;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Double getRentingCost() {
		return rentingCost;
	}
	public void setRentingCost(Double rentingCost) {
		this.rentingCost = rentingCost;
	}
	public Double getBuyingCost() {
		return buyingCost;
	}
	public void setBuyingCost(Double buyingCost) {
		this.buyingCost = buyingCost;
	}
	public double getDepositCost() {
		return depositCost;
	}
	public void setDepositCost(double depositCost) {
		this.depositCost = 0.3*buyingCost;
	}
	public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
