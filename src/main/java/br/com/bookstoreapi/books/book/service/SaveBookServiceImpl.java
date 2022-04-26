package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.book.BookRepository;
import br.com.bookstoreapi.books.categories.Category;
import br.com.bookstoreapi.books.categories.CategoryRepository;
import br.com.bookstoreapi.books.exception.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SaveBookServiceImpl implements SaveBookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public Book save(Book book) throws CategoryNotFoundException {
        book.setCategories(this.getCategoriesByUuid(book.getCategories()));
        book.setUuid(UUID.randomUUID());
        return bookRepository.save(book);
    }

    private List<Category> getCategoriesByUuid(List<Category> categories) throws CategoryNotFoundException {
        List<Category> categoriesSaved = new ArrayList<>();
        for (Category category : categories) {
            categoriesSaved.add(categoryRepository.findById(category.getId())
                    .orElseThrow(() -> new CategoryNotFoundException(category.getId())));
        }
        return categoriesSaved;
    }
}
