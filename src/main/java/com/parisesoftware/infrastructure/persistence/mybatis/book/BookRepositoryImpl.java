package com.parisesoftware.infrastructure.persistence.mybatis.book;

import com.parisesoftware.core.component.book.application.repository.BookRepository;
import com.parisesoftware.core.component.book.domain.book.Book;
import com.parisesoftware.core.paging.ListingArguments;
import io.micronaut.validation.Validated;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 * <p>
 *     Default implementation of {@link BookRepository}
 * </p>
 */
@Singleton
@Validated
public class BookRepositoryImpl implements BookRepository {

    private final static List<String> VALID_PROPERTY_NAMES = Arrays.asList("id", "name");

    private final BookMapper bookMapper;

    public BookRepositoryImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Optional<Book> findById(@NotNull Long id) {
        return Optional.ofNullable(this.bookMapper.findById(id));
    }

    @Override
    public Book save(@NotBlank String name, @NotBlank String isbn) {
        Book book = new Book(name, isbn);
        this.bookMapper.save(book);
        return book;
    }

    @Override
    public void deleteById(@NotNull Long id) {
        findById(id).ifPresent(book -> bookMapper.deleteById(id));
    }

    @Override
    public List<Book> findAll(@NotNull ListingArguments args) {
        if (args.getMax().isPresent() && args.getSort().isPresent() && args.getOffset().isPresent() && args.getSort().isPresent()) {
            return bookMapper.findAllByOffsetAndMaxAndSortAndOrder(args.getOffset().get(),
                    args.getMax().get(),
                    args.getSort().get(),
                    args.getOrder().get());
        }
        if (args.getMax().isPresent() && args.getOffset().isPresent() && (!args.getSort().isPresent() || !args.getOrder().isPresent())) {
            return bookMapper.findAllByOffsetAndMax(args.getOffset().get(),
                    args.getMax().get());
        }
        if ((!args.getMax().isPresent() || !args.getOffset().isPresent()) && args.getSort().isPresent() && args.getOrder().isPresent()) {
            return bookMapper.findAllBySortAndOrder(args.getSort().get(),
                    args.getOrder().get());
        }
        return bookMapper.findAll();
    }

    @Override
    public int update(@NotNull Long id, @NotBlank String name, @NotBlank String isbn) {
        this.bookMapper.update(id, name, isbn);
        return -1;
    }

}
