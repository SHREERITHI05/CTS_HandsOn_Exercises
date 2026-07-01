package com.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {

    private final Map<Integer, String> bookStore = new HashMap<>();

    public BookRepository() {
        bookStore.put(1, "Clean Code — Robert C. Martin");
        bookStore.put(2, "The Pragmatic Programmer — Andrew Hunt");
        bookStore.put(3, "Design Patterns — Gang of Four");
        bookStore.put(4, "Spring in Action — Craig Walls");
        System.out.println("[BookRepository] Bean initialized — " +
                bookStore.size() + " books loaded into store.");
    }

    public List<String> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    public String getBookById(int id) {
        return bookStore.getOrDefault(id, "Book not found for ID: " + id);
    }

    public void addBook(int id, String title) {
        bookStore.put(id, title);
        System.out.println("[BookRepository] Book added: " + title);
    }

    public boolean removeBook(int id) {
        if (bookStore.containsKey(id)) {
            String removed = bookStore.remove(id);
            System.out.println("[BookRepository] Book removed: " + removed);
            return true;
        }
        return false;
    }

    public int getTotalBooks() {
        return bookStore.size();
    }
}