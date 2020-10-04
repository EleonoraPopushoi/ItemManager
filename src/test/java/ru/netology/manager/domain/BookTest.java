package ru.netology.manager.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Book;
import ru.netology.manager.domain.Product;
import ru.netology.manager.domain.Smartphone;

public class BookTest {

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
        }
    }


    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Smartphone();
        Smartphone smartphone = (Smartphone) product;
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();

        product.toString();
    }
}
