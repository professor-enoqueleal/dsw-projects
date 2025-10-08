package br.com.carstore;

import br.com.carstore.dao.JdbcCarDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final JdbcCarDao jdbcCarDao;

    public StartupRunner(JdbcCarDao jdbcCarDao) { this.jdbcCarDao = jdbcCarDao; }

    @Override
    public void run(String... args) throws Exception {
        // limpeza (caso haja dados) e inserção de teste
        try {
            jdbcCarDao.deleteAll();
        } catch (Exception ignored) {}

        jdbcCarDao.create("Fusca", "Azul");
        jdbcCarDao.create("Civic", "Preto");

        System.out.println("Inserted sample cars via JdbcCarDao:");
        jdbcCarDao.findAll().forEach(c -> System.out.println(c.getName() + " - " + c.getColor()));
    }
}
