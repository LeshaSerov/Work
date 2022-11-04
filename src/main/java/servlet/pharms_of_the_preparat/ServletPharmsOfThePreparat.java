package servlet.pharms_of_the_preparat;

import db.PharmsOfThePreparatDao;
import db.PreparatDao;
import db.PreparatsOfTheCategDao;
import db.PreparatsOfThePharmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/pharms_of_the_preparat")
public class ServletPharmsOfThePreparat extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        request.setAttribute("name", PreparatDao.getPreparat(id).getName());
        request.setAttribute("list", PharmsOfThePreparatDao.getPharmsOfThePreparat(id));
        getServletContext().getRequestDispatcher("/pages/pharms_of_the_preparat.jsp").forward(request, response);
    }

}
