package shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@SpringBootApplication(scanBasePackages = "shop")
public class ShopApplication {

    public static void main(String args[]) {
        SpringApplication.run(ShopApplication.class, args);
    }
}