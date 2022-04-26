package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.exception.CategoryNotFoundException;

@FunctionalInterface
public interface SaveBookService {

    Book save(Book book) throws CategoryNotFoundException;
}
