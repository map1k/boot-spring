package com.marat.boottest.controllers;

import com.marat.boottest.repositories.AuthorRepository;
import com.marat.boottest.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getaAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
