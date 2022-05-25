package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllBookServiceImpl implements GetAllBookService{

    private final BookRepository bookRepository;


    @Override
    public List<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).toList();

    }
}
