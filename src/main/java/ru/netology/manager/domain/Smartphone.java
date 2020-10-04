package ru.netology.manager.domain;

import java.util.Objects;


public class Smartphone extends Product {
    private String manufacturer;

    //  Product[] smartphone = {
    //         new Smartphone(4, "3215", 1000, "LG"),
    //        new Smartphone(5, "Galaxy S9", 899, "Samsung"),

    // };

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String productName, int price, String manufacturer) {
        super(id, productName, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return manufacturer == smartphone.manufacturer &&
                Objects.equals(manufacturer, smartphone.manufacturer);
        //return getManufacturer().equals(that.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "producer='" + manufacturer + '\'' +
                "} " + super.toString();
    }
    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getManufacturer().equalsIgnoreCase(search);
    }
}
