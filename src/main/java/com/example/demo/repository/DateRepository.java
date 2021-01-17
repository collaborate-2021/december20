package com.example.demo.repository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;

public class DateRepository {
    private HikariConfig config = new HikariConfig(
            "D:\\December\\demo\\src\\main\\resources\\datasource.properties");
    private HikariDataSource ds = new HikariDataSource(config);

    public Date fetchCurrentDate() throws SQLException {
        String SQL_QUERY = "SELECT CURRENT_DATE";
        Date date;
        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery()) {
             date = rs.getDate(0);
        }
        return date;
    }
}
