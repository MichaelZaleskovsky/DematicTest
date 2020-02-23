package com.dematic.bookstore.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ScienceBookTransfer extends BookTransfer {
	@NotNull
	@Min(value = 0) @Max(value = 10)
	private int scienceIndex;

	public ScienceBookTransfer() {
		super();
	}

	public int getScienceIndex() {
		return scienceIndex;
	}

	public void setScienceIndex(int scienceIndex) {
		this.scienceIndex = scienceIndex;
	}

}
