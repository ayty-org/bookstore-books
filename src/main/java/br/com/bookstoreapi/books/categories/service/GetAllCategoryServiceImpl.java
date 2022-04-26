package br.com.bookstoreapi.books.categories.service;

import br.com.bookstoreapi.books.categories.Category;
import br.com.bookstoreapi.books.categories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllCategoryServiceImpl implements GetAllCategoryService{

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
