package com.library.main;

import com.library.service.BookService;
import com.library.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * LibraryManagementApp — Demonstrates Spring Dependency Injection.
 *
 * Verifies:
 *  ✔ Setter Injection via <property> tag in XML
 *  ✔ Constructor Injection via <constructor-arg> tag in XML
 *  ✔ Injected dependency is not null
 *  ✔ Business methods work correctly after injection
 */
public class LibraryManagementApp {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   Library Management — Dependency Injection  ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // ── Load Spring ApplicationContext ──
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n[Spring] ApplicationContext loaded successfully!\n");

        // ════════════════════════════════════════════════
        //  VERIFY 1: Setter Injection
        // ════════════════════════════════════════════════
        System.out.println("══ Testing Setter Injection ══");
        BookService bookService = context.getBean("bookService",
                BookService.class);

        // Verify dependency was injected
        BookRepository injectedRepo = bookService.getBookRepository();
        if (injectedRepo != null) {
            System.out.println("[✔] Setter Injection SUCCESS — " +
                    "BookRepository is NOT null");
        } else {
            System.out.println("[✘] Setter Injection FAILED — " +
                    "BookRepository is null");
        }

        // ════════════════════════════════════════════════
        //  VERIFY 2: Constructor Injection
        // ════════════════════════════════════════════════
        System.out.println("\n══ Testing Constructor Injection ══");
        BookService bookServiceConstructor = context.getBean(
                "bookServiceConstructor", BookService.class);

        BookRepository injectedRepo2 = bookServiceConstructor.getBookRepository();
        if (injectedRepo2 != null) {
            System.out.println("[✔] Constructor Injection SUCCESS — " +
                    "BookRepository is NOT null");
        } else {
            System.out.println("[✘] Constructor Injection FAILED — " +
                    "BookRepository is null");
        }

        // ════════════════════════════════════════════════
        //  VERIFY 3: Business operations via Setter Injection
        // ════════════════════════════════════════════════
        System.out.println("\n══ Business Operations (Setter Injected Bean) ══");

        // Fetch all books
        System.out.println("\n── All Books ──");
        List<String> books = bookService.getAllBooks();
        books.forEach(book -> System.out.println("  📖 " + book));

        // Find specific book
        System.out.println("\n── Find Book by ID ──");
        System.out.println("  ID 1 → " + bookService.findBookById(1));
        System.out.println("  ID 5 → " + bookService.findBookById(5));

        // Add new book
        System.out.println("\n── Add Book ──");
        System.out.println("  " + bookService.addBook(5,
                "Effective Java — Joshua Bloch"));

        // Remove a book
        System.out.println("\n── Remove Book ──");
        System.out.println("  " + bookService.removeBook(2));

        // Final count
        System.out.println("\n── Final Stats ──");
        System.out.println("  Total Books: " + bookService.getTotalBooks());

        // ── Close Spring context ──
        ((ClassPathXmlApplicationContext) context).close();

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║        Application Closed Successfully       ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}