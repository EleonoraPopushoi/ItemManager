package ru.netology.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartphoneTest {
    @Test
    void shouldMatchByManufacturer() {
        Smartphone smartphone =  new Smartphone(5, "Galaxy S9", 899, "Samsung");
        boolean actual = smartphone.matches("Samsung");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByManufacturer() {
        Smartphone smartphone = new Smartphone(5, "Galaxy S9", 899, "Samsung");
        boolean actual = smartphone.matches("Huawei");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByName() {
        Smartphone smartphone =  new Smartphone(5, "Galaxy S9", 899, "Samsung");
        boolean actual = smartphone.matches("Galaxy S9");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Smartphone smartphone = new Smartphone(5, "Galaxy S9", 899, "Samsung");;
        boolean actual = smartphone.matches("S10");
        assertFalse(actual);
    }
}
