package com.dematic.bookstore.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dematic.bookstore.models.Book;

@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {


}
