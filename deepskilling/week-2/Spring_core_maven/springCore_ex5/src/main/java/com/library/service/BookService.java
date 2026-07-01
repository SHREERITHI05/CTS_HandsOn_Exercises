package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

/**
 * BookService — Business Logic Layer.
 *
 * Managed by Spring IoC as a singleton bean.
 * BookRepository is injected via Setter Injection.
 *
 * IoC Principle:
 *   "Don't call us, we'll call you"
 *   Spring controls object creation and wiring —
 *   not the application code.
 */
public class BookService {

    // Injected by Spring IoC Container
    private BookRepository bookRepository;

    /**
     * No-arg constructor — required for Setter Injection.
     * Spring first creates the object using this,
     * then calls the setter to inject the dependency.
     */
    public BookService() {
        System.out.println("[BookService] Bean created by Spring IoC — "
                + "awaiting dependency injection.");
    }

    /**
     * ── SETTER INJECTION ──
     * Spring calls this automatically after bean creation.
     * Maps to: <property name="bookRepository" ref="bookRepository"/>
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] Setter Injection complete — "
                + "BookRepository wired successfully.");
    }

    // Getter — used to verify injection in main class
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    // ── Business Methods ──

    public List<String> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public String findBookById(int id) {
        if (id <= 0) return "Invalid ID — must be greater than 0";
        return bookRepository.getBookById(id);
    }

    public String addBook(int id, String title) {
        if (title == null || title.trim().isEmpty())
            return "Title cannot be empty";
        bookRepository.addBook(id, title);
        return "Added successfully: " + title;
    }

    public String removeBook(int id) {
        return bookRepository.removeBook(id)
                ? "Removed book with ID: " + id
                : "Book not found with ID: " + id;
    }

    public int getTotalBooks() {
        return bookRepository.getTotalBooks();
    }
}