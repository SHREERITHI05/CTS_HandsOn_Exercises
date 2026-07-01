package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

/**
 * BookService — Business Logic Layer.
 *
 * Updated to support BOTH injection types:
 *  ✔ Setter Injection     → setBookRepository() [this exercise]
 *  ✔ Constructor Injection → BookService(BookRepository) [Exercise 1]
 *
 * Spring IoC Container manages this bean's lifecycle
 * and injects BookRepository automatically.
 */
public class BookService {

    // Dependency managed by Spring IoC Container
    private BookRepository bookRepository;

    /**
     * Default no-arg constructor.
     * Required for Setter Injection —
     * Spring first creates object, then calls setter.
     */
    public BookService() {
        System.out.println("[BookService] No-arg constructor called " +
                "— ready for Setter Injection.");
    }

    /**
     * Constructor Injection support.
     * Spring uses this when <constructor-arg> is in XML config.
     */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] Constructor Injection — " +
                "BookRepository injected via constructor.");
    }

    /**
     * ── SETTER INJECTION ──
     * Spring calls this method automatically when
     * <property name="bookRepository" ref="bookRepository"/>
     * is defined in applicationContext.xml.
     *
     * Naming rule: setBookRepository()
     *   → property name must be "bookRepository" in XML
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] Setter Injection — " +
                "BookRepository injected via setBookRepository().");
    }

    // Getter — allows verification of injected dependency
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    // ── Business Methods ──

    public List<String> getAllBooks() {
        validateDependency();
        List<String> books = bookRepository.getAllBooks();
        System.out.println("[BookService] getAllBooks() — Total: "
                + books.size());
        return books;
    }

    public String findBookById(int id) {
        validateDependency();
        if (id <= 0) return "Invalid Book ID — must be greater than 0";
        return bookRepository.getBookById(id);
    }

    public String addBook(int id, String title) {
        validateDependency();
        if (title == null || title.trim().isEmpty())
            return "Book title cannot be empty";
        bookRepository.addBook(id, title);
        return "Book added successfully: " + title;
    }

    public String removeBook(int id) {
        validateDependency();
        boolean removed = bookRepository.removeBook(id);
        return removed
                ? "Book with ID " + id + " removed successfully"
                : "Book with ID " + id + " not found";
    }

    public int getTotalBooks() {
        validateDependency();
        return bookRepository.getTotalBooks();
    }

    /**
     * Guards against null dependency —
     * catches misconfigured Spring XML at runtime.
     */
    private void validateDependency() {
        if (bookRepository == null) {
            throw new IllegalStateException(
                    "[BookService] BookRepository is null — " +
                            "check Spring XML configuration!");
        }
    }
}