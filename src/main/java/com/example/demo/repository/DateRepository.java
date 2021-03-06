package com.example.demo.repository;
import com.example.demo.resource.HelloResource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

public class DateRepository {
    // todo: inject Connection into constructor

    private static final Logger logger
            = LoggerFactory.getLogger(DateRepository.class);

    Connection connection;
    public DateRepository() throws SQLException {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:postgresql://postgres:5432/postgres");
//        config.setUsername("postgres");
//        config.setPassword("mysecretpassword");
//        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
//        HikariDataSource ds = new HikariDataSource(config);
//        connection = ds.getConnection();


        String url = "jdbc:postgresql://postgres:5432/postgres?user=postgres&password=mysecretpassword";
        connection = DriverManager.getConnection(url);

    }

    public Date fetchCurrentDate() throws SQLException {
        String SQL_QUERY = "SELECT CURRENT_DATE";
        Date date = null;
        try (PreparedStatement pst = connection.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery()) {
            while ( rs.next() ) {
                date = rs.getDate(1);
            }
        }
        return date;
    }
}
