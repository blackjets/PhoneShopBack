package shop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "main-pool")
public class ConnectionSettings {

    private static int DEFAULT_MAX_POOL_SIZE = 5;

    private String jdbcDriver = "org.postgresql.Driver";
    private String jdbcString = "jdbc:postgresql://localhost:5432/mobile";
    private String jdbcUser = "postgres";
    private String jdbcPassword = "password";
    private int jdbcMaxPoolSize = DEFAULT_MAX_POOL_SIZE;

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public String getJdbcString() {
        return jdbcString;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public int getJdbcMaxPoolSize() {
        return jdbcMaxPoolSize;
    }

   // public ConnectionSettings(){}

    public ConnectionSettings() {
        this.jdbcDriver = jdbcDriver;
        this.jdbcString = jdbcString;
        this.jdbcUser = jdbcUser;
        this.jdbcPassword = jdbcPassword;
    }
}