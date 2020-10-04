package ru.netology.manager.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;

    //  Product[]book = {
    //          new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank"),
    //          new Book(2, "The Book Thief", 120, "Markus Zusak"),

    // };

    public Book() {
        super();
    }

    public Book(int id, String productName, int price, String author) {
        super(id, productName, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return author == book.author &&
                Objects.equals(author, book.author);
        //return getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getAuthor().equalsIgnoreCase(search);
    }
}
