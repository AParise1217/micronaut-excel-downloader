package com.parisesoftware.core.component.book.application.service;

import javax.validation.constraints.NotBlank;

/**
 * Book Save Command
 * <p>
 *     Encapsulation of an Operation to Persist a Book
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public class BookSaveCommand {

    @NotBlank
    private String name;

    @NotBlank
    private String isbn;

    public BookSaveCommand() {}

    public BookSaveCommand(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
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
