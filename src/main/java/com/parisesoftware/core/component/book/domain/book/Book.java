package com.parisesoftware.core.component.book.domain.book;

import javax.validation.constraints.NotNull;
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

    /**
     * primary key
     */
    private Long id;

    @NotNull
    private String isbn;

    @NotNull
    private String name;

    public Book() {}

    public Book(@NotNull final String isbn, @NotNull final String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
