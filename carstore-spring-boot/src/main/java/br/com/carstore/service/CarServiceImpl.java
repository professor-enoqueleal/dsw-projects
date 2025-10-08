package br.com.carstore.service;

import br.com.carstore.entity.CarEntity;
import br.com.carstore.model.CarDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CarDTO> findAll() {
        TypedQuery<CarEntity> q = em.createQuery("select c from CarEntity c", CarEntity.class);
        return q.getResultList().stream().map(e -> {
            CarDTO dto = new CarDTO();
            dto.setName(e.getName());
            dto.setColor(e.getColor());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void save(CarDTO carDTO) {
        CarEntity e = new CarEntity(carDTO.getName(), carDTO.getColor());
        em.persist(e);
    }

    @Override
    public void deleteById(String id) {
        Long longId = Long.valueOf(id);
        CarEntity e = em.find(CarEntity.class, longId);
        if (e != null) {
            em.remove(e);
        }
    }

    @Override
    public void update(String id, CarDTO carDTO) {
        Long longId = Long.valueOf(id);
        CarEntity e = em.find(CarEntity.class, longId);
        if (e != null) {
            e.setName(carDTO.getName());
            e.setColor(carDTO.getColor());
            em.merge(e);
        }
    }

}
