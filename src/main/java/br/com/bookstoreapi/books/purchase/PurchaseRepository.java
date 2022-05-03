package br.com.bookstoreapi.books.purchase;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("purchases-api")
public interface PurchaseRepository {

    @GetMapping("/v1/purchases/existByBook/{uuid}")
    boolean existsByBooksUuid(@PathVariable UUID uuid);

}
