package ru.netology.manager.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Book;
import ru.netology.manager.domain.Product;
import ru.netology.manager.domain.Smartphone;
import ru.netology.manager.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
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
    public void shouldSearchByAuthor() {
        manager.searchBy("Markus Zusak");
        Product[]expected = {
                item2
        };
        Product[] actual = manager.searchBy("Markus Zusak");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] expected = {
                item1
        };
        Product[] actual = manager.searchBy("The Diary Of A Young Girl");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchSmartphoneName() {
        Product[] expected = {
                item4
        };
        Product[] actual = manager.searchBy("Galaxy S9");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchManufacturer() {
        Product[] expected = {
                item3};
        Product[] actual = manager.searchBy("LG");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameNotExist() {
        Product actual = repository.findById(11);
        assertNull(actual);
    }

}
