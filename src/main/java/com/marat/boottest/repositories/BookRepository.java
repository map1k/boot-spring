package com.marat.boottest.repositories;

import com.marat.boottest.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
