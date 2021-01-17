package com.example.demo.repository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;

public class DateRepository {
    // todo : won't work in windows, set directly or use typesafe config
    private HikariConfig config = new HikariConfig(
            "src/main/resources/datasource.properties");
    private HikariDataSource ds = new HikariDataSource(config);

    // todo
    // make construcor - inject Connection into constructor

//    Connection con;
    public DateRepository() {
//         con = ds.getConnection();
    }

    public Date fetchCurrentDate() throws SQLException {
        String SQL_QUERY = "SELECT CURRENT_DATE";
        Date date = null;
        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery()) {
            while ( rs.next() ) {
                date = rs.getDate(1);
            }
        }
        return date;
    }
}
