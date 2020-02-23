package com.dematic.bookstore.services;

import com.dematic.bookstore.models.AntiqueBookTransfer;
import com.dematic.bookstore.models.BookTransfer;
import com.dematic.bookstore.models.BookUpdate;
import com.dematic.bookstore.models.ScienceBookTransfer;

public interface BookService {
	public BookTransfer addBook(BookTransfer book);

	public Double getTotalPrice(long barcode);

	public AntiqueBookTransfer addAntiqueBook(AntiqueBookTransfer book);

	public BookTransfer getBook(long barcode);

	public BookTransfer updateBook(BookUpdate book, long barcode);

	public ScienceBookTransfer addScienceBook(ScienceBookTransfer book);

}
