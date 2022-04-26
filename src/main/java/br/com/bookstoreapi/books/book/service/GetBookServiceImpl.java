package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.book.BookRepository;
import br.com.bookstoreapi.books.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class GetBookServiceImpl implements GetBookService{

    private final BookRepository bookRepository;

    @Override
    public Book getByUuid(UUID uuid) throws EntityNotFoundException{
        return this.bookRepository.findByUuid(uuid)
                .orElseThrow(()-> new EntityNotFoundException(uuid, Book.class.getSimpleName()));
    }
}
