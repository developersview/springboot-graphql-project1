package com.developersview.springbootgraphqlproject1.controller;

import com.developersview.springbootgraphqlproject1.dto.Author;
import com.developersview.springbootgraphqlproject1.dto.Book;
import com.developersview.springbootgraphqlproject1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 09/05/2023
 */
@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> allBooks() {
        return bookRepository.allBooks();
    }

    @QueryMapping
    public Book getBookById(@Argument int id) {
        return bookRepository.findBookById(id);
    }

    @MutationMapping
    public Book updateBookTitle(@Argument int id, @Argument String title) {
        return bookRepository.updateBookTitle(id, title);
    }

    @MutationMapping
    public Book updateBookPages(@Argument int id, @Argument int pages) {
        return bookRepository.updateBookPages(id, pages);
    }

    @MutationMapping
    public List<Book> deleteBook(@Argument int id){
        return bookRepository.deleteBook(id);
    }
}