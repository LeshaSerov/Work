package servlet.pharms_of_the_preparat;

import db.PreparatsOfTheCategDao;
import db.PreparatsOfThePharmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/pharms_of_the_preparat/delete")
public class ServletPharmsOfThePreparatDelete extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idPharm = Integer.parseInt(request.getParameter("pharmssid"));
        Integer idPreparat = Integer.parseInt(request.getParameter("preparatsid"));
        PreparatsOfThePharmDao.deletePreparat(idPharm, idPreparat);
        response.sendRedirect("/pharms_of_the_preparat?id=" + idPreparat);
    }

}
