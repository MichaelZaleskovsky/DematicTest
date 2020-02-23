package com.dematic.bookstore.services.impl;

import java.lang.reflect.Field;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dematic.bookstore.models.AntiqueBook;
import com.dematic.bookstore.models.AntiqueBookTransfer;
import com.dematic.bookstore.models.ScienceBook;
import com.dematic.bookstore.models.ScienceBookTransfer;
import com.dematic.bookstore.models.Book;
import com.dematic.bookstore.models.BookTransfer;
import com.dematic.bookstore.models.BookUpdate;
import com.dematic.bookstore.repository.BookRepository;
import com.dematic.bookstore.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public BookTransfer addBook(BookTransfer bookTransfer) {
		if (repository.existsById(bookTransfer.getBarcode())) {
			return null;
		}
		Book book = mapper.map(bookTransfer, Book.class);
		Book persisted = repository.save(book);
		
		return mapper.map(persisted, BookTransfer.class);
	}

	@Override
	public AntiqueBookTransfer addAntiqueBook(AntiqueBookTransfer bookTransfer) {
		if (repository.existsById(bookTransfer.getBarcode())) {
			return null;
		}
		AntiqueBook book = mapper.map(bookTransfer, AntiqueBook.class);
		AntiqueBook persisted = repository.save(book);
		
		return mapper.map(persisted, AntiqueBookTransfer.class);
	}

	@Override
	public ScienceBookTransfer addScienceBook(ScienceBookTransfer bookTransfer) {
		if (repository.existsById(bookTransfer.getBarcode())) {
			return null;
		}
		ScienceBook book = mapper.map(bookTransfer, ScienceBook.class);
		ScienceBook persisted = repository.save(book);
		
		return mapper.map(persisted, ScienceBookTransfer.class);
	}

	@Override
	public Double getTotalPrice(long barcode) {
		Optional<Book> book = repository.findById(barcode);
		Double result = book.isEmpty() ? null : book.get().totalPrice();
		return result;
	}

	@Override
	public BookTransfer getBook(long barcode) {
		Optional<Book> book = repository.findById(barcode);
		if (book.isEmpty()) {
			return null;
		}
		Class cls = book.get().getClass();
		String className = cls.getName()+"Transfer";
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		BookTransfer result = (BookTransfer) mapper.map(book.get(), cls);
		return result;
	}

	@Override
	public BookTransfer updateBook(BookUpdate bookUpdate, long barcode) {
		Optional<Book> book = repository.findById(barcode);
		if (book.isEmpty()) {
			return null;
		}		
		
		Class cls = book.get().getClass();
		
		Field[] fields = cls.getDeclaredFields();
		
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				Field updatedField = bookUpdate.getClass().getDeclaredField(field.getName());
				updatedField.setAccessible(true);
				Object obj = updatedField.get(bookUpdate);
				if (obj != null) {
					field.set(book.get(), obj);
				}
			} catch (NoSuchFieldException e) {
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		Book persisted = repository.save(book.get());
		
		String className = cls.getName()+"Transfer";
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		BookTransfer result = (BookTransfer) mapper.map(persisted, cls);
		return result;
	}
}
