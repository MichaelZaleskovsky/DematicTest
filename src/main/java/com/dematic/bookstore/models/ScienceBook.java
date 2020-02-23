package com.dematic.bookstore.models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class ScienceBook extends Book {
	private int scienceIndex;

	public ScienceBook() {
		super();
	}

	@Override
	public double totalPrice() {
		return round(quantity * scienceIndex * pricePerUnit);
	}

	public int getScienceIndex() {
		return scienceIndex;
	}

	public void setScienceIndex(int scienceIndex) {
		this.scienceIndex = scienceIndex;
	}
	

}
