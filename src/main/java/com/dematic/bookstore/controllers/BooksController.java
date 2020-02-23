package com.dematic.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dematic.bookstore.models.AntiqueBookTransfer;
import com.dematic.bookstore.models.BookTransfer;
import com.dematic.bookstore.models.BookUpdate;
import com.dematic.bookstore.models.ScienceBookTransfer;
import com.dematic.bookstore.services.BookService;

@RestController
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BooksController {
	
	String alreadyExist = "Book with given barcode already exist";
	String notExist = "Book with given barcode not exist";
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity addBook(@Validated @RequestBody BookTransfer book, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(errors.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        
		BookTransfer bookTransfer = bookService.addBook(book);
		
		ResponseEntity result = bookTransfer == null ? 
				new ResponseEntity(alreadyExist, HttpStatus.NOT_ACCEPTABLE) : new ResponseEntity(bookTransfer, HttpStatus.CREATED);
		return result;
	}

	@RequestMapping(value = "/books/{barcode}", method = RequestMethod.GET)
	public ResponseEntity getBook(@PathVariable long barcode) {
		BookTransfer bookTransfer = bookService.getBook(barcode);
		
		ResponseEntity result = bookTransfer == null ? 
				new ResponseEntity(notExist, HttpStatus.NOT_FOUND) : new ResponseEntity(bookTransfer, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/books/{barcode}", method = RequestMethod.PUT)
	public ResponseEntity updateBook(@Validated @RequestBody BookUpdate book, @PathVariable long barcode, Errors errors) {

        if (errors.hasErrors()) {
            return new ResponseEntity(errors.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        
		BookTransfer bookTransfer = bookService.updateBook(book, barcode);
		
		ResponseEntity result = bookTransfer == null ? 
				new ResponseEntity(notExist, HttpStatus.NOT_FOUND) : new ResponseEntity(bookTransfer, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/books/antique", method = RequestMethod.POST)
	public ResponseEntity addAntiqueBook(@Validated @RequestBody AntiqueBookTransfer book, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(errors.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        
        AntiqueBookTransfer bookTransfer = bookService.addAntiqueBook(book);
		
		ResponseEntity result = bookTransfer == null ? 
				new ResponseEntity(alreadyExist, HttpStatus.NOT_ACCEPTABLE) : new ResponseEntity(bookTransfer, HttpStatus.CREATED);
		return result;
	}

	@RequestMapping(value = "/books/science", method = RequestMethod.POST)
	public ResponseEntity addScienceBook(@Validated @RequestBody ScienceBookTransfer book, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(errors.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        
        ScienceBookTransfer bookTransfer = bookService.addScienceBook(book);
		
		ResponseEntity result = bookTransfer == null ? 
				new ResponseEntity(alreadyExist, HttpStatus.NOT_ACCEPTABLE) : new ResponseEntity(bookTransfer, HttpStatus.CREATED);
		return result;
	}

	@RequestMapping(value = "/totalprice/{barcode}", method = RequestMethod.GET)
	public ResponseEntity getTotalPrice(@PathVariable long barcode) {
        
		Double totalPrice = bookService.getTotalPrice(barcode);
		
		ResponseEntity result = totalPrice == null ? 
				new ResponseEntity(HttpStatus.NOT_FOUND) : new ResponseEntity(totalPrice, HttpStatus.OK);
		return result;
	}

}
