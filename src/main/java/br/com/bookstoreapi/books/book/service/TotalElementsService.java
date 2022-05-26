package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TotalElementsService {

    private final BookRepository bookRepository;

    public Integer getTotalElements(){
        return this.bookRepository.findAll().size();
    }
}
