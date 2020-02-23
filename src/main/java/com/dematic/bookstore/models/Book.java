package com.dematic.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Book {
	@Id
	private long barcode;
	private String name;
	private String author;
	protected int quantity;
	protected double pricePerUnit;
	
	public Book() {}
	
	protected double round(double value) {
		return Math.round(value * 100)/100d;
	}
	
	public double totalPrice() {
		return round(pricePerUnit*quantity);
	}
	
	public long getBarcode() {
		return barcode;
	}
	
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
