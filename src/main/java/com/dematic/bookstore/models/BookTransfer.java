package com.dematic.bookstore.models;

import javax.validation.constraints.NotNull;

public class BookTransfer {
	@NotNull
	private long barcode;
	
	@NotNull
	private String name;
	
	@NotNull
	private String author;
	
	@NotNull
	private int quantity;
	
	@NotNull
	private double pricePerUnit;
	
	public BookTransfer() {}
	
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
