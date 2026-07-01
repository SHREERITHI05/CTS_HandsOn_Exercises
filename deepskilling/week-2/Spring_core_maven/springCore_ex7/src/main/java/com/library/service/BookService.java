package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

/**
 * BookService — Business Logic Layer.
 *
 * Supports BOTH injection types:
 *
 *  ✔ Constructor Injection:
 *      Spring calls BookService(BookRepository, String)
 *      Dependency guaranteed at object creation time.
 *
 *  ✔ Setter Injection:
 *      Spring calls no-arg constructor first,
 *      then calls setBookRepository() and setServiceMode().
 *      Dependency injected after object creation.
 */
public class BookService {

    private BookRepository bookRepository;

    // Describes which injection type was used
    private String serviceMode;

    // ════════════════════════════════════════════════
    //  Constructor Injection
    //  Maps to: <constructor-arg> in XML
    // ════════════════════════════════════════════════

    /**
     * No-arg constructor — required for Setter Injection.
     * Spring uses this when <property> tags are defined.
     */
    public BookService() {
        System.out.println("[BookService] No-arg constructor called "
                + "— Setter Injection path.");
    }

    /**
     * Parameterized constructor — used for Constructor Injection.
     * Spring uses this when <constructor-arg> tags are defined.
     *
     * @param bookRepository injected by Spring via <constructor-arg>
     * @param serviceMode    injected by Spring via <constructor-arg value>
     */
    public BookService(BookRepository bookRepository, String serviceMode) {
        this.bookRepository = bookRepository;
        this.serviceMode    = serviceMode;
        System.out.println("[BookService] Constructor Injection — "
                + "BookRepository and serviceMode injected.");
    }

    // ════════════════════════════════════════════════
    //  Setter Injection
    //  Maps to: <property name="bookRepository"> in XML
    // ════════════════════════════════════════════════

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] setBookRepository() called "
                + "— Setter Injection complete.");
    }

    public void setServiceMode(String serviceMode) {
        this.serviceMode = serviceMode;
        System.out.println("[BookService] setServiceMode() called "
                + "— value: " + serviceMode);
    }

    // ── Getters for verification ──
    public BookRepository getBookRepository() { return bookRepository; }
    public String getServiceMode()            { return serviceMode;    }

    // ── Business Methods ──

    public List<String> getAllBooks() {
        validate();
        return bookRepository.getAllBooks();
    }

    public String findBookById(int id) {
        validate();
        if (id <= 0) return "Invalid ID — must be greater than 0";
        return bookRepository.getBookById(id);
    }

    public String addBook(int id, String title) {
        validate();
        if (title == null || title.trim().isEmpty())
            return "Title cannot be empty";
        bookRepository.addBook(id, title);
        return "Added successfully: " + title;
    }

    public String removeBook(int id) {
        validate();
        return bookRepository.removeBook(id)
                ? "Removed book with ID: " + id
                : "Book not found with ID: " + id;
    }

    public int getTotalBooks() {
        validate();
        return bookRepository.getTotalBooks();
    }

    // Guards against null dependency
    private void validate() {
        if (bookRepository == null)
            throw new IllegalStateException(
                    "[BookService] BookRepository is null — check XML config!");
    }
}