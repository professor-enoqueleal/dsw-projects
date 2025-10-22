package br.com.carstore.dao;

import br.com.carstore.model.CarDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarDao {

    private final JdbcTemplate jdbc;

    public CarDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<CarDTO> rowMapper = new RowMapper<>() {

        @Override
        public CarDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CarDTO dto = new CarDTO();
            dto.setId(rs.getString("id"));
            dto.setName(rs.getString("name"));
            dto.setColor(rs.getString("color"));
            dto.setBrand(rs.getString("brand"));
            dto.setModel(rs.getString("model"));
            dto.setYearFabric(rs.getString("year_fabric"));
            dto.setYearModel(rs.getString("year_model"));
            return dto;
        }

    };

    public List<CarDTO> findAll() {

        String sql = "SELECT id, name, color, brand, model, year_fabric, year_model FROM car";

        return jdbc.query(sql, rowMapper);

    }

    public void save(CarDTO carDTO) {

        String sql = "INSERT INTO car (name, color, brand, model, year_fabric, year_model) VALUES (?, ?, ?, ?, ?, ?)";

        jdbc.update(sql, carDTO.getName(), carDTO.getColor(), carDTO.getBrand(), carDTO.getModel(), carDTO.getYearFabric(), carDTO.getYearModel());

    }

    public void deleteById(String id) {

        String sql = "DELETE FROM car WHERE id = ?";

        jdbc.update(sql, Long.valueOf(id));

    }

    public void update(String id, CarDTO carDTO) {

        String sql = "UPDATE car SET name = ?, color = ?, brand = ?, model = ?, year_fabric = ?, year_model = ? WHERE id = ?";

        jdbc.update(sql,
                carDTO.getName(),
                carDTO.getColor(),
                carDTO.getBrand(),
                carDTO.getModel(),
                carDTO.getYearFabric(),
                carDTO.getYearModel(),
                Long.valueOf(id));

    }

    public CarDTO findById(String id) {

        String sql = "SELECT id, name, color, brand, model, year_fabric, year_model FROM car WHERE id = ?";

        return jdbc.queryForObject(sql, rowMapper, Long.valueOf(id));

    }

}
