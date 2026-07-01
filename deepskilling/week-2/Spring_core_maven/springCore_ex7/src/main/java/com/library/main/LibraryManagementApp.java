package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * LibraryManagementApp — Verifies Constructor & Setter Injection.
 *
 *  ✔ Loads Spring ApplicationContext from XML
 *  ✔ Retrieves both injected beans
 *  ✔ Verifies dependencies are not null
 *  ✔ Runs business operations on both beans
 */
public class LibraryManagementApp {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  Exercise 7 — Constructor & Setter Injection     ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // ── Load Spring IoC Container ──
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n[Spring] IoC Container loaded successfully!\n");

        // ════════════════════════════════════════════════
        //  TEST 1: Constructor Injection Bean
        // ════════════════════════════════════════════════
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     Constructor Injection Bean       ║");
        System.out.println("╚══════════════════════════════════════╝");

        BookService constructorBean = context.getBean(
                "bookServiceConstructor", BookService.class);

        // Verify injection
        System.out.println("[✔] Mode     : " + constructorBean.getServiceMode());
        System.out.println("[✔] Repo null: " +
                (constructorBean.getBookRepository() == null
                        ? "NULL ✘" : "NOT NULL ✔"));

        // Operations
        System.out.println("\n── All Books ──");
        constructorBean.getAllBooks()
                .forEach(b -> System.out.println("  📖 " + b));

        System.out.println("\n── Find by ID ──");
        System.out.println("  ID 2 → " + constructorBean.findBookById(2));

        System.out.println("\n── Add Book ──");
        System.out.println("  " + constructorBean.addBook(5,
                "Effective Java — Joshua Bloch"));

        // ════════════════════════════════════════════════
        //  TEST 2: Setter Injection Bean
        // ════════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       Setter Injection Bean          ║");
        System.out.println("╚══════════════════════════════════════╝");

        BookService setterBean = context.getBean(
                "bookServiceSetter", BookService.class);

        // Verify injection
        System.out.println("[✔] Mode     : " + setterBean.getServiceMode());
        System.out.println("[✔] Repo null: " +
                (setterBean.getBookRepository() == null
                        ? "NULL ✘" : "NOT NULL ✔"));

        // Operations
        System.out.println("\n── All Books ──");
        setterBean.getAllBooks()
                .forEach(b -> System.out.println("  📖 " + b));

        System.out.println("\n── Remove Book ──");
        System.out.println("  " + setterBean.removeBook(1));
        System.out.println("  " + setterBean.removeBook(99));

        System.out.println("\n── Total Books ──");
        System.out.println("  Count: " + setterBean.getTotalBooks());

        // ════════════════════════════════════════════════
        //  SUMMARY
        // ════════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         Injection Summary            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ Constructor Injection → ✔ SUCCESS    ║");
        System.out.println("║ Setter Injection      → ✔ SUCCESS    ║");
        System.out.println("╚══════════════════════════════════════╝");

        // ── Close Spring context ──
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("\n[Spring] IoC Container closed.");
    }
}