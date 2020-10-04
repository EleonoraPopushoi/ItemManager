package ru.netology.manager.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Product;
import ru.netology.manager.domain.Book;
import ru.netology.manager.domain.Smartphone;
import ru.netology.manager.domain.BookTest;
import ru.netology.manager.domain.ProductTest;
import ru.netology.manager.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product item1 = new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank");
    private Product item2 = new Book(2, "The Book Thief", 120, "Markus Zusak");
    //  new Book(3, "The Lord of the Rings", 240, "J.R.R."),
    private Product item3 = new Smartphone(4, "3215", 1000, "LG");
    private Product item4 = new Smartphone(5, "Galaxy S9", 899, "Samsung");
    //  new Smartphone(6, "Galaxy S10", 999, "Samsung")

    private Product item5 = new Book(3, "The Lord of the Rings", 240, "J.R.R.");
    private Product item6 = new Smartphone(6, "Galaxy S10", 999, "Samsung");

    @BeforeEach
    @Test
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    void shouldSaveOneBook() {
        repository.save(item5);
        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                item5,



                //  new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank"),
                //  new Book(2, "The Book Thief", 120, "Markus Zusak"),
                //  new Book(3, "The Lord of the Rings", 240, "J.R.R."),
                //  new Smartphone(4, "3215", 1000, "LG"),
                //  new Smartphone(5, "Galaxy S9", 899, "Samsung"),
                //  new Smartphone(6, "Galaxy S10", 999, "Samsung")
        };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllBook() {
        repository.findAll();
        Product[] expected = {
                item1,
                item2,
                item3,
                item4
        };
        Product[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindByIdBook() {
        repository.findById(2);
        Product actual = repository.findById(2);
        Product expected = new Book(2, "The Book Thief", 120, "Markus Zusak");
        assertEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdBook() {
        repository.findAll();
        Product[] actual = repository.removeById(2);
        Product[] expected = {
                item1,
                item3,
                item4,
        };

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSaveOneSmartphone() {
        repository.save(item6);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                item6,
        };
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindAllSmartphone() {
        repository.findAll();
        Product[] actual = repository.findAll();
        Product[] expected = {
                item1,
                item2,
                item3,
                item4
        };
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindByIdSmartphone() {
        repository.findById(4);
        Product actual = repository.findById(4);
        Product expected = new Smartphone(4, "3215", 1000, "LG");

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdSmartphone() {
        repository.removeById(5);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item1,
                item2,
                item3

        };

        assertArrayEquals(actual, expected);
    }
}
