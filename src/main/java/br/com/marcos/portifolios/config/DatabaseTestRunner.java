package br.com.marcos.portifolios.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DatabaseTestRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseTestRunner.class);
    private final JdbcTemplate jdbcTemplate;

    public DatabaseTestRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        try {
            jdbcTemplate.execute("SELECT 1");
            logger.info("Database connection successful!");
        } catch (Exception e) {
            logger.error("Error connecting to the database.", e);
        }
    }
}