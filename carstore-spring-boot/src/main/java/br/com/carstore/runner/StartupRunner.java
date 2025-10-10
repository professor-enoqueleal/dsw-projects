package br.com.carstore.runner;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.CarDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final CarDao carDao;

    public StartupRunner(CarDao carDao) {

        this.carDao = carDao;

    }

    @Override
    public void run(String... args) throws Exception {
        carDao.save(new CarDTO("Fusca", "Azul"));
        carDao.save(new CarDTO("Civic", "Preto"));
        System.out.println(carDao.findAll());
    }

}