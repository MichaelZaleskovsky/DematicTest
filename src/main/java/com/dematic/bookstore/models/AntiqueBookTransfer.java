package com.dematic.bookstore.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AntiqueBookTransfer extends BookTransfer {
	@NotNull
	@Min(value = 0) @Max(value = 1900)
	private int releaseYear;

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
}
