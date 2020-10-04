package ru.netology.manager.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Product;
import ru.netology.manager.domain.Book;
import ru.netology.manager.domain.Smartphone;
import ru.netology.manager.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product item1 = new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank");
    private Product item2 = new Book(2, "The Book Thief", 120, "Markus Zusak");
    private Product item3 = new Smartphone(4, "3215", 1000, "LG");
    private Product item4 = new Smartphone(5, "Galaxy S9", 899, "Samsung");

    private Product itemToSave = new Smartphone(6, "Galaxy S10", 999, "Samsung");

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
        repository.save(itemToSave);
        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                itemToSave,


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
    void shouldFindAll() {
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
    void shouldFindById() {
        //   repository.findById(4);
        Product actual = repository.findById(5);
        Product expected = item4;

        assertEquals(expected, actual);
    }


    @Test
    void shouldRemoveById() {
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
    void shouldRemoveByIdNotExisted() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(11));
    }

    @Test
    void shouldFindByIdNotExisted() {
        Product actual = repository.findById(15);
        assertEquals(null,actual);
    }
}
