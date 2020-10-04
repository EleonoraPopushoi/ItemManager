package ru.netology.manager.repository;

import ru.netology.manager.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];
    //   Product[] items = {
    //           new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank"),
    //           new Book(2, "The Book Thief", 120, "Markus Zusak"),

    //           new Smartphone(4, "3215", 1000, "LG"),
    //           new Smartphone(5, "Galaxy S9", 899, "Samsung"),

    //   };


    public Product[] findAll() {
        return items;

    }

    public void save(Product item) {
        int itemsLength = items.length;
        Product[] tmpArray = new Product[itemsLength + 1];
        System.arraycopy(items, 0, tmpArray, 0, items.length);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = item;
        items = tmpArray;

    }

    public Product[] removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }


    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

}
