package com.parisesoftware.infrastructure.persistence.mybatis;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * Mybatis Factory
 * <p>
 *     Manual Wiring of the {@link org.apache.ibatis.session.SqlSessionFactory}
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
@Factory
public class MybatisFactory {

    private final DataSource dataSource;

    public MybatisFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return {@link SqlSessionFactory} Bean
     */
    @Bean
    SqlSessionFactory sqlSessionFactory() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("com.parisesoftware.infrastructure.persistence.mybatis");

        return new SqlSessionFactoryBuilder().build(configuration);
    }

}
