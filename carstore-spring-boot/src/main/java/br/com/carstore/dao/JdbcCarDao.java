package br.com.carstore.dao;

import br.com.carstore.model.CarDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCarDao {

    private final JdbcTemplate jdbc;

    public JdbcCarDao(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private final RowMapper<CarDTO> rowMapper = (rs, rowNum) -> {
        CarDTO dto = new CarDTO();
        dto.setName(rs.getString("name"));
        dto.setColor(rs.getString("color"));
        return dto;
    };

    public void create(String name, String color) {
        jdbc.update("INSERT INTO car (name, color) VALUES (?, ?)", name, color);
    }

    public List<CarDTO> findAll() {
        return jdbc.query("SELECT name, color FROM car", rowMapper);
    }

    public void deleteAll() { jdbc.update("DELETE FROM car"); }
}
