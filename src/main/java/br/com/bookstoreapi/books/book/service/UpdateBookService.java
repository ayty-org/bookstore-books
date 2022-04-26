package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.exception.CategoryNotFoundException;
import br.com.bookstoreapi.books.exception.EntityNotFoundException;

import java.util.UUID;

@FunctionalInterface
public interface UpdateBookService {

    Book update(UUID id, Book book) throws EntityNotFoundException, CategoryNotFoundException;
}
