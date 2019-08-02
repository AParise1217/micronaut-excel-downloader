package com.parisesoftware.core.component.book.application.repository;

import com.parisesoftware.core.component.book.domain.book.Book;

import java.util.List;

/**
 * Book Repository
 * <p>
 *     Encapsulation of Book Retrieval
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public interface BookRepository {

    /**
     * @return {@code List} of {@link Book} domain models that are persisted in the database
     */
    List<Book> findAll();

}
