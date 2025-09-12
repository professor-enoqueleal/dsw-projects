package br.com.carstore.service;

import br.com.carstore.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService  {

    private List<CarDTO> cars;

    public CarServiceImpl(){
        cars = new ArrayList<>();
    }

    @Override
    public List<CarDTO> findAll() {

        return this.cars;

    }

    @Override
    public void save(CarDTO carDTO) {

        cars.add(carDTO);

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void update(String id, CarDTO carDTO) {

    }

}
