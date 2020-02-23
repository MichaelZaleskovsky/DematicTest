package com.dematic.bookstore.models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class AntiqueBook extends Book {
	private int releaseYear;

	public AntiqueBook() {
		super();
	}
	
	@Override
	public double totalPrice() {
		LocalDate today = LocalDate.now();
		int currentYear = today.getYear();
		return round(quantity * pricePerUnit * (currentYear - releaseYear) / 10);
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

}
