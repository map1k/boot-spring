package com.marat.boottest.bootstrap;

import com.marat.boottest.model.Author;
import com.marat.boottest.model.Book;
import com.marat.boottest.model.Publisher;
import com.marat.boottest.repositories.AuthorRepository;
import com.marat.boottest.repositories.BookRepository;
import com.marat.boottest.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher nextBooks = new Publisher("Next Books", "65000, Odessa");
        publisherRepository.save(nextBooks);
        Book ddd = new Book("Domain Driven Design", "1234", nextBooks);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wroxPub = new Publisher("Wrox", "10122. SA");
        publisherRepository.save(wroxPub);
        Book noEJB = new Book("J2EE Development without EJB", "23444", wroxPub );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
