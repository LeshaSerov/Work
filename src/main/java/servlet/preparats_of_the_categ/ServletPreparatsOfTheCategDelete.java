package servlet.preparats_of_the_categ;

import db.PreparatDao;
import db.PreparatsOfTheCategDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/preparats_of_the_categ/delete")
public class ServletPreparatsOfTheCategDelete extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idPreparat = Integer.parseInt(request.getParameter("preparatsid"));
        Integer idCateg = Integer.parseInt(request.getParameter("categsid"));
        PreparatsOfTheCategDao.deletePreparat(idPreparat, idCateg);
        response.sendRedirect("/preparats_of_the_categ?id=" + idCateg);
    }

}
