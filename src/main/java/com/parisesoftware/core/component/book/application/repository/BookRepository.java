package com.parisesoftware.core.component.book.application.repository;

import com.parisesoftware.core.component.book.domain.book.Book;
import com.parisesoftware.core.paging.ListingArguments;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Book Repository
 * <p>
 *     Encapsulation of high level CRUD operations on {@link Book} entities exposed to the application
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public interface BookRepository {

    Optional<Book> findById(@NotNull Long id);

    Book save(@NotBlank String name, @NotBlank String isbn);

    void deleteById(@NotNull Long id);

    List<Book> findAll(@NotNull ListingArguments args);

    int update(@NotNull Long id, @NotBlank String name, @NotBlank String isbn);

}
