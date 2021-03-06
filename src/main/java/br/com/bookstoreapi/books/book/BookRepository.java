package br.com.bookstoreapi.books.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategoriesNameIgnoreCase(String name);

    Optional<Book> findByUuid(UUID uuid);
}
