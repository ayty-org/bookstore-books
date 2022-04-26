package br.com.bookstoreapi.books.categories.service;

import br.com.bookstoreapi.books.categories.Category;
import br.com.bookstoreapi.books.exception.CategoryNotFoundException;

@FunctionalInterface
public interface GetCategoryService {

    Category findById(Long id) throws CategoryNotFoundException;
}
