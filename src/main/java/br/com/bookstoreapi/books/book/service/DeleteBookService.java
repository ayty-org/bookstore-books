package br.com.bookstoreapi.books.book.service;


import br.com.bookstoreapi.books.exception.DeleteException;
import br.com.bookstoreapi.books.exception.EntityNotFoundException;

import java.util.UUID;

@FunctionalInterface
public interface DeleteBookService {

    void delete(UUID id) throws EntityNotFoundException, DeleteException;
}
