package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllByCategoryNameBookServiceImpl implements GetAllByCategoryNameBookService{

    private final BookRepository bookRepository;


    @Override
    public List<Book> findAllByCategoriesName(String name){
        return bookRepository.findAllByCategoriesNameIgnoreCase(name);
    }
}
