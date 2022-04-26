package br.com.bookstoreapi.books.book.service;


import br.com.bookstoreapi.books.book.Book;

import java.util.List;

@FunctionalInterface
public interface GetAllByCategoryNameBookService {

    List<Book> findAllByCategoriesName(String name);
}
