package br.com.carstore.runner;

import br.com.carstore.dao.CarJpaDao;
import br.com.carstore.model.CarDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final CarJpaDao carDao;

    public StartupRunner(CarJpaDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public void run(String... args) throws Exception {
        carDao.save(new CarDTO("Onix", "Vermelho", "Chevrolet", "LTZ", "2020", "2021"));
        carDao.save(new CarDTO("Celta", "Cinza", "Chevrolet", "LT", "2008", "2009"));
        System.out.println(carDao.findAll());
    }

}