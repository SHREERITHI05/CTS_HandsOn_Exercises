package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * LibraryManagementApp — Entry Point.
 *
 * Demonstrates Spring IoC Container:
 *  ✔ Loading ApplicationContext from XML
 *  ✔ Retrieving beans managed by IoC
 *  ✔ Verifying Setter Injection worked
 *  ✔ Testing all business operations
 */
public class LibraryManagementApp {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║    Spring IoC Container — Library System     ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // ── Step 1: Load Spring IoC Container from XML ──
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n[IoC] Container started — beans initialized!\n");

        // ── Step 2: Retrieve BookService bean from IoC ──
        BookService bookService =
                context.getBean("bookService", BookService.class);

        // ── Step 3: Verify Setter Injection ──
        System.out.println("══ Dependency Injection Verification ══");
        if (bookService.getBookRepository() != null) {
            System.out.println("[✔] BookRepository injected — NOT null");
            System.out.println("[✔] Setter Injection by Spring IoC — SUCCESS\n");
        } else {
            System.out.println("[✘] Injection FAILED — BookRepository is null\n");
        }

        // ── Step 4: Test all operations ──
        System.out.println("══ All Books in Library ══");
        List<String> books = bookService.getAllBooks();
        books.forEach(b -> System.out.println("  📖 " + b));

        System.out.println("\n══ Find Book by ID ══");
        System.out.println("  ID 1  → " + bookService.findBookById(1));
        System.out.println("  ID 10 → " + bookService.findBookById(10));
        System.out.println("  ID -1 → " + bookService.findBookById(-1));

        System.out.println("\n══ Add New Book ══");
        System.out.println("  " + bookService.addBook(5,
                "Effective Java — Joshua Bloch"));

        System.out.println("\n══ Remove Book ══");
        System.out.println("  " + bookService.removeBook(3));
        System.out.println("  " + bookService.removeBook(99));

        System.out.println("\n══ Final Stats ══");
        System.out.println("  Total Books: " + bookService.getTotalBooks());

        // ── Step 5: Close IoC Container ──
        ((ClassPathXmlApplicationContext) context).close();

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║       IoC Container Closed Successfully      ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}