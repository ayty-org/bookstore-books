package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.exception.EntityNotFoundException;

import java.util.UUID;

@FunctionalInterface
public interface GetBookService {

    Book getByUuid(UUID id) throws EntityNotFoundException;
}
