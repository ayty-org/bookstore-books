package br.com.bookstoreapi.books.book.v1;

import br.com.bookstoreapi.books.book.BookDTO;
import br.com.bookstoreapi.books.book.BookRecieveDTO;
import br.com.bookstoreapi.books.book.service.*;
import br.com.bookstoreapi.books.exception.CategoryNotFoundException;
import br.com.bookstoreapi.books.exception.DeleteException;
import br.com.bookstoreapi.books.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/v1/books")
@RestController
public class BookController {

    private final GetAllBookService getAllBookService;
    private final GetBookService getBookService;
    private final GetAllByCategoryNameBookService getAllByCategoryNameBookService;
    private final SaveBookService postBookService;
    private final UpdateBookService putBookService;
    private final DeleteBookService deleteBookService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> list(Pageable pageable){
        return BookDTO.fromAll(getAllBookService.findAll(pageable));
    }

    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO find(@PathVariable UUID bookId) throws EntityNotFoundException {
        return BookDTO.from(getBookService.getByUuid(bookId));
    }

    @GetMapping("/categories/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> findByCategory(@PathVariable String categoryName){
        return BookDTO.fromAll(getAllByCategoryNameBookService.findAllByCategoriesName(categoryName));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO save(@RequestBody @Valid BookRecieveDTO bookDTO) throws CategoryNotFoundException {
        return BookDTO.from(postBookService.save(BookRecieveDTO.to(bookDTO)));
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO update(@PathVariable UUID bookId,
                          @RequestBody @Valid BookRecieveDTO bookDTO)
            throws CategoryNotFoundException, EntityNotFoundException{
        return BookDTO.from(putBookService.update(bookId, BookRecieveDTO.to(bookDTO)));
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID bookId) throws DeleteException, EntityNotFoundException {
        deleteBookService.delete(bookId);
    }
}
