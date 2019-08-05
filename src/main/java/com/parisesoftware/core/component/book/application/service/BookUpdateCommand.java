package com.parisesoftware.core.component.book.application.service;

import javax.validation.constraints.NotBlank;

/**
 * Book Update Command
 * <p>
 *     Encapsulation of an Operation to Update a Book
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public class BookUpdateCommand {

    @NotBlank
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String isbn;

    public BookUpdateCommand() {}

    public BookUpdateCommand(Long id, String name, String isbn) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
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
}
