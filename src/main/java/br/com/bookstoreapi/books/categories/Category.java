package br.com.bookstoreapi.books.categories;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
}
