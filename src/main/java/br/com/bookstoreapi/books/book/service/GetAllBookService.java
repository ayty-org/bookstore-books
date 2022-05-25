package br.com.bookstoreapi.books.book.service;


import br.com.bookstoreapi.books.book.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

@FunctionalInterface
public interface GetAllBookService {

    List<Book> findAll(Pageable pageable);
}
