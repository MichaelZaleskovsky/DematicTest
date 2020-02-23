package com.dematic.bookstore.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class BookUpdate {
	private String name;
	private String author;
	protected Integer quantity;
	protected Double pricePerUnit;
	
	@Min(value = 0) @Max(value = 1900)
	private Integer releaseYear;

	@Min(value = 0) @Max(value = 10)
	private Integer scienceIndex;
	
	public BookUpdate() {}

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getScienceIndex() {
		return scienceIndex;
	}

	public void setScienceIndex(Integer scienceIndex) {
		this.scienceIndex = scienceIndex;
	}

}
