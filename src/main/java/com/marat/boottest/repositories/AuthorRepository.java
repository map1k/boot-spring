package com.marat.boottest.repositories;

import com.marat.boottest.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
