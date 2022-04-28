package br.com.bookstoreapi.books.purchase;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "purchases", url = "http://localhost:8080/purchases")
public interface PurchaseRepository {

    @GetMapping("/existByBook/{uuid}")
    boolean existsByBooksUuid(@PathVariable UUID uuid);

}
