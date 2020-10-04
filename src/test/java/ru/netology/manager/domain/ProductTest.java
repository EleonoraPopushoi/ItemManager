package ru.netology.manager.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 1000);
        assertEquals(first, second);
    }
}
