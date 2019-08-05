package com.parisesoftware.infrastructure.persistence.mybatis.book;

import com.parisesoftware.core.component.book.domain.book.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * <p>Book Repository Implementation for the Mybatis data source
 *
 * @version 1.0
 * @since 1.0
 */
@Singleton
public class BookMapperImpl implements BookMapper {

  private final SqlSessionFactory sqlSessionFactory;

  public BookMapperImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  private BookMapper getBookMapper(SqlSession sqlSession) {
    return sqlSession.getMapper(BookMapper.class);
  }

  @Override
  public List<Book> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return getBookMapper(sqlSession).findAll();
    }
  }

  @Override
  public Book findById(long id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return getBookMapper(sqlSession).findById(id);
    }
  }

  @Override
  public void deleteById(long id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      getBookMapper(sqlSession).deleteById(id);
      sqlSession.commit();
    }
  }

  @Override
  public void update(long id, String name, String isbn) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      getBookMapper(sqlSession).update(id, name, isbn);
      sqlSession.commit();
    }
  }

  @Override
  public void save(Book book) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      getBookMapper(sqlSession).save(book);
      sqlSession.commit();
    }
  }

  @Override
  public List<Book> findAllBySortAndOrder(
      @NotNull @Pattern(regexp = "id|name") String sort,
      @NotNull @Pattern(regexp = "asc|ASC|desc|DESC") String order) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return getBookMapper(sqlSession).findAllBySortAndOrder(sort, order);
    }
  }

  @Override
  public List<Book> findAllByOffsetAndMaxAndSortAndOrder(
      @NotNull @PositiveOrZero Integer offset,
      @Positive @NotNull Integer max,
      @NotNull @Pattern(regexp = "id|name") String sort,
      @NotNull @Pattern(regexp = "asc|ASC|desc|DESC") String order) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return getBookMapper(sqlSession)
          .findAllByOffsetAndMaxAndSortAndOrder(offset, max, sort, order);
    }
  }

  @Override
  public List<Book> findAllByOffsetAndMax(
      @NotNull @PositiveOrZero Integer offset, @Positive @NotNull Integer max) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return getBookMapper(sqlSession).findAllByOffsetAndMax(offset, max);
    }
  }
}
