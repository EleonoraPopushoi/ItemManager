package ru.netology.manager.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Book;
import ru.netology.manager.domain.Product;
import ru.netology.manager.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank");
        boolean actual = book.matches(" Anne Frank");
        assertTrue(actual);

    }

    @Test
    void shouldNotMatchByAuthor() {
        Book book = new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank");
        boolean actual = book.matches("Tolstoy");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByName() {
        Book book =  new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank");
        boolean actual = book.matches("The Diary Of A Young Girl");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Book book = new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank");
        boolean actual = book.matches("Harry Potter");
        assertFalse(actual);
    }
}
