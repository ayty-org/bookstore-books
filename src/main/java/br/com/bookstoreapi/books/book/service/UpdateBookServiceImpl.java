package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.book.BookRepository;
import br.com.bookstoreapi.books.categories.Category;
import br.com.bookstoreapi.books.categories.CategoryRepository;
import br.com.bookstoreapi.books.exception.CategoryNotFoundException;
import br.com.bookstoreapi.books.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateBookServiceImpl implements UpdateBookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public Book update(UUID id, Book book) throws EntityNotFoundException, CategoryNotFoundException {
        Optional<Book> bookOptional = bookRepository.findByUuid(id);
        if (bookOptional.isPresent()) {
            book.setCategories(this.getCategoriesByUuid(book.getCategories()));
            book.setId(bookOptional.get().getId());
            book.setUuid(id);
            return bookRepository.save(book);
        }
        throw new EntityNotFoundException(id, Book.class.getSimpleName());
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
