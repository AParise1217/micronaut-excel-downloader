package com.parisesoftware.core.component.book.domain.book;

import java.util.Objects;

/**
 * Book
 * <p>
 *     Domain Representation of a Book
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public class Book {

    private String isbn;

    private String name;

    public Book() {}

    public Book(final String isbn, final String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getIsbn().equals(book.getIsbn()) &&
                getName().equals(book.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getName());
    }
}
