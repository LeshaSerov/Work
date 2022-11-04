package servlet.preparats_of_the_pharm;

import db.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/preparats_of_the_pharm")
public class ServletPreparatsOfThePharm extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        request.setAttribute("address", PharmDao.getPharm(id).getAddress());
        request.setAttribute("list", PreparatsOfThePharmDao.getPreparatsOfThePharm(id));
        getServletContext().getRequestDispatcher("/pages/preparats_of_the_pharm.jsp").forward(request, response);
    }
}
