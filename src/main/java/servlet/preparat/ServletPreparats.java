package servlet.preparat;

import db.PharmDao;
import db.PreparatDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/preparats")
public class ServletPreparats extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list", PreparatDao.getAllPreparats());
        getServletContext().getRequestDispatcher("/pages/preparats.jsp").forward(request, response);
    }
}
