package com.parisesoftware.core.component.book.application.repository.stub;

import com.parisesoftware.core.component.book.domain.book.Book;
import com.parisesoftware.core.component.book.application.repository.BookRepository;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * <p>
 *     Default Implementation of {@link BookRepository}
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
@Singleton
public class BookRepositoryImpl implements BookRepository {

    /**
     * {@inheritDoc}
     * @version 1.0
     * @since 1.0
     */
    @Override
    public List<Book> findAll() {
        Book buildingMicroservices = new Book("1491950358", "Building Microservices");
        Book releaseIt = new Book("1680502395", "Release It!");
        Book cidelivery = new Book("0321601912", "Continuous Delivery:");
        return Arrays.asList(buildingMicroservices, releaseIt, cidelivery);
    }

}
