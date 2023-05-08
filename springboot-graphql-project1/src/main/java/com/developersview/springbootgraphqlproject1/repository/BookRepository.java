package com.developersview.springbootgraphqlproject1.repository;

import com.developersview.springbootgraphqlproject1.dto.Author;
import com.developersview.springbootgraphqlproject1.dto.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 09/05/2023
 */
@Component
public class BookRepository {
    private static final List<Book> bookList = new ArrayList<>();

    Book book1 = new Book(
            1,
            "GraphQL Overview",
            100,
            new Author("James Weber"));
    Book book2 = new Book(
            2,
            "SpringBoot Overview",
            100,
            new Author("Pranoy Chakraborty"));
    Book book3 = new Book(
            3,
            "MongoDB Overview",
            250,
            new Author("Tanmoy Roy Subhu"));


    public List<Book> allBooks() {
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        return bookList;
    }

    public Book findBookById(int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Book updateBookTitle(int id, String title) {
        Book book = findBookById(id);
        book.setTitle(title);
        return book;
    }

    public Book updateBookPages(int id, int pages) {
        Book book = findBookById(id);
        book.setPages(pages);
        return book;
    }

    public List<Book> deleteBook(int id) {
        bookList.remove(id - 1);
        return bookList;
    }
}
