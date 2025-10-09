package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        CarDao carDao = new CarDao();

        String carId = req.getParameter("id");
        String carName = req.getParameter("car-name");

        Car car = new Car();

        car.setName(carName);

        if (null == carId || carId.isBlank()) {

            carDao.createCar(car);

        } else {
            car.setId(carId);
            carDao.updateCar(car);
        }


        resp.sendRedirect("/find-all-cars");

    }

}

