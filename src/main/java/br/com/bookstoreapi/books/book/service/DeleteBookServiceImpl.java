package br.com.bookstoreapi.books.book.service;

import br.com.bookstoreapi.books.book.Book;
import br.com.bookstoreapi.books.book.BookRepository;
import br.com.bookstoreapi.books.exception.DeleteException;
import br.com.bookstoreapi.books.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeleteBookServiceImpl implements DeleteBookService {

    private final BookRepository bookRepository;
    //private final PurchaseRepository purchaseRepository;


    @Override
    public void delete(UUID id) throws EntityNotFoundException, DeleteException {
        Optional<Book> bookOptional = bookRepository.findByUuid(id);
        if(bookOptional.isPresent()){
//            if (purchaseRepository.existsByPurchasedBooksUuid(id)) {
//                throw new DeleteException(id, Book.class.getSimpleName());
//            }
            bookRepository.delete(bookOptional.get());
        }else{
            throw new EntityNotFoundException(id, Book.class.getSimpleName());
        }

    }

}
