package servlet.preparats_of_the_categ;

import db.CategDao;
import db.PreparatDao;
import db.PreparatsOfTheCategDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/preparats_of_the_categ")
public class ServletPreparatsOfTheCateg extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        request.setAttribute("name", CategDao.getCateg(id).getName());
        request.setAttribute("list", PreparatsOfTheCategDao.getPreparatsOfTheCateg(id));
        getServletContext().getRequestDispatcher("/pages/preparats_of_the_categ.jsp").forward(request, response);
    }
}
