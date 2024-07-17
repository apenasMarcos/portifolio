package br.com.marcos.portifolios.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class DatabaseTestRunnerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testDatabaseConnection() {
        // Verifica se a conexão com o banco de dados pode ser estabelecida sem erros
        DatabaseTestRunner databaseTestRunner = new DatabaseTestRunner(jdbcTemplate);
        assertDoesNotThrow(() -> databaseTestRunner.run());
    }
}
