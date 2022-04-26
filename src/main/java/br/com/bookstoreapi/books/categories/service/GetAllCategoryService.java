package br.com.bookstoreapi.books.categories.service;

import br.com.bookstoreapi.books.categories.Category;

import java.util.List;

@FunctionalInterface
public interface GetAllCategoryService {

    List<Category> findAll();
}
