package br.com.bookstoreapi.books.categories.service;

import br.com.bookstoreapi.books.categories.Category;
import br.com.bookstoreapi.books.categories.CategoryRepository;
import br.com.bookstoreapi.books.exception.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetCategoryServiceImpl implements GetCategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
