package com.parisesoftware.infrastructure.persistence.mybatis.book;

import com.parisesoftware.core.component.book.domain.book.Book;
import org.apache.ibatis.annotations.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * Book Mapper
 * <p>
 *     Encapsulation of the Mapping of {@link Book} entities to the Mybatis data source
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public interface BookMapper {

    /**
     * @return {@code List} of {@link Book} domain models that are persisted in the database
     */
    @Select("select * from book")
    List<Book> findAll();

    /**
     * @return {@code Book} matching the given id
     */
    @Select("select * from book where id=#{id}")
    Book findById(long id);

    @Delete("delete from book where id=#{id}")
    void deleteById(long id);

    @Update("update book set name=#{name}, isbn=#{isbn} where id=#{id}")
    void update(@Param("id") long id, @Param("name") String name, @Param("isbn") String isbn);

    /**
     * Persist the given {@link Book} to the data source
     * @param book {@code Book} to be saved
     */
    @Insert("insert into book(isbn, name) values(#{isbn}, #{name})")
    @Options(useGeneratedKeys = true)
    void save(Book book);


    @Select("select * from book order by ${sort} ${order}")
    List<Book> findAllBySortAndOrder(@NotNull @Pattern(regexp = "id|name") String sort,
                                     @NotNull @Pattern(regexp = "asc|ASC|desc|DESC") String order);

    @Select("select * from book order by ${sort} ${order} limit ${offset}, ${max}")
    List<Book> findAllByOffsetAndMaxAndSortAndOrder(@NotNull @PositiveOrZero Integer offset,
                                                    @Positive @NotNull Integer max,
                                                    @NotNull @Pattern(regexp = "id|name") String sort,
                                                    @NotNull @Pattern(regexp = "asc|ASC|desc|DESC") String order);

    List<Book> findAllByOffsetAndMax(@NotNull @PositiveOrZero Integer offset, @Positive @NotNull Integer max);

}
