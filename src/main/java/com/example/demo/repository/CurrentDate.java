package com.example.demo.repository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Properties;

@Repository
public class CurrentTime {
//    Properties props = new Properties();
//props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
//props.setProperty("dataSource.user", "test");
//props.setProperty("dataSource.password", "test");
//props.setProperty("dataSource.databaseName", "mydb");
//props.put("dataSource.logWriter", new PrintWriter(System.out));

//    HikariConfig config = new HikariConfig(props);
//    HikariDataSource ds = new HikariDataSource(config);

    public static CurrentTime fetchTime() throws SQLException {
        private static HikariConfig config = new HikariConfig(
                "datasource.properties" );
        String SQL_QUERY = "SELECT CURRENT_TIMESTAMP";
        LocalDateTime time = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement( SELECT_TIMESTAMP );
             ResultSet rs = pst.executeQuery();) {
            time = rs.getCurrent("current_time");

        }
        return time;
    }
}
