package br.com.marcos.portifolios.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class DatabaseTestRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testDatabaseConnection() {
        // Verifica se a conexão com o banco de dados pode ser estabelecida sem erros
        try {
            jdbcTemplate.execute("SELECT 1");
        } catch (Exception e) {
            throw new AssertionError("Falha ao conectar com o banco de dados", e);
        }
    }
}
