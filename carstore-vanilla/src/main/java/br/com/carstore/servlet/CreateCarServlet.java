package br.com.carstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String carName = httpServletRequest.getParameter("car-name");

        String color = httpServletRequest.getParameter("color");

        httpServletResponse.setContentType("application/json");

        httpServletResponse.setCharacterEncoding("UTF-8");

        PrintWriter out = httpServletResponse.getWriter();

        try {

            String json = "{\"name\": \"" + carName + "\",\"color\": \"" + color+ " }";

            httpServletResponse.getWriter().print(json);

        } catch (Exception e) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.getWriter().print("{\"error\": \"Failed to read JSON\"}");
        }

        out.flush();

    }

}
